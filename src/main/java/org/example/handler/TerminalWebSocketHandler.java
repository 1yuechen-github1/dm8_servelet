package org.example.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.kubernetes.client.Exec;
import org.example.pojo.InitMessage;
import org.example.pojo.ResizeMessage;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.example.config.k8sConfig.K8sInfo;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TerminalWebSocketHandler extends TextWebSocketHandler {

    private String podName;
    private ExecutorService executorService;
    InputStream inputStream;
    OutputStream outputStream;
    OutputStream resizeStream = null;
    Exec.ExecProcess process;
    Gson gson;
    int rows;
    int cols;

    public TerminalWebSocketHandler() {
        this.gson = new GsonBuilder().create();
    }

    /**
     * 与前端连接后，向容器进行连接
     *
     * @param session socket连接会话
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        // 获取 Kubernetes Pod 和 Container 的信息
        podName = (String) session.getAttributes().get("podName");
        this.executorService = Executors.newScheduledThreadPool(1);
        long start = System.currentTimeMillis();
//        executorService.submit(() -> {
        try {
            Exec exec = new Exec();
            //该内部类暴露resizeStream get方法，可以设置tty终端大小
            process = (Exec.ExecProcess) exec.exec(K8sInfo.NAMESPACE, podName, new String[]{"bash"}, "app", true, true);

//              获取输入输出流
            resizeStream = process.getResizeStream();
            inputStream = process.getInputStream();
            outputStream = process.getOutputStream();

            System.out.println("获取到容器" + podName + "连接流");
//            process.waitFor();

            //发送容器端口信息
            Map<Integer, Integer> serviceMap = (HashMap)session.getAttributes().get("serviceMap");
            InitMessage<Map<Integer, Integer>> mapInitMessage = new InitMessage<>("service", serviceMap);
//            session.sendMessage(new TextMessage(gson.toJson(new InitMessage<>("init", "service", serviceMap))));
            //发送持久化路径
            ArrayList<String> mountList = (ArrayList<String>) session.getAttributes().get("mountList");
            InitMessage<ArrayList<String>> arrayListInitMessage = new InitMessage<>("mount", mountList);
//            session.sendMessage(new TextMessage(gson.toJson(new InitMessage<>("init", "mount", mountList))));
            ArrayList<InitMessage> initArray = new ArrayList<>();
            initArray.add(mapInitMessage);
            initArray.add(arrayListInitMessage);
            initArray.add(new InitMessage<>("podName", podName));


            session.sendMessage(new TextMessage(gson.toJson(new InitMessage<ArrayList<InitMessage>>("init", null, initArray))));


        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("无法获取" + podName + "连接流，关闭socket连接");
                session.close();
            } catch (IOException ex) {
                e.printStackTrace();
            }
        }
//        });

        executorService.submit(() -> {
            byte[] buffer = new byte[1024];
            int len;
            try {
                while (this.process.isAlive()) {
                    try {
                        while ((len = inputStream.read(buffer)) != -1) {
                            session.sendMessage(new BinaryMessage(ByteBuffer.wrap(buffer, 0, len)));
                        }
                    } catch (EOFException e) {
                        System.out.println("捕捉到空异常");
                    }
                }
            } catch (Exception e) {
                System.out.println("捕捉到异常1");
                e.printStackTrace();
            }  finally {
                System.out.println("捕捉到异常2");
                long end = System.currentTimeMillis();
                System.out.println("----------------------------------本次连接存活时间："+(end-start));
                this.process.destroy();
            }
        });
    }

    @Override
    protected void handleTextMessage(@NotNull WebSocketSession session, TextMessage message) throws Exception {
        // 处理来自前端的输入
//        System.out.println(message);
//        if (message.getPayload().equals("ping")) {
//            if (process.isAlive()) {
//                session.sendMessage(new BinaryMessage("pong".getBytes(StandardCharsets.UTF_8)));
//                return;
//            }
//        }
        byte[] bytes = message.asBytes();
        try {
            outputStream.write(bytes);
            outputStream.flush();
        } catch (Exception e) {
            session.close();
        }
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
        String s = new String(message.getPayload().array(), StandardCharsets.UTF_8);
        System.out.println(s);
        ResizeMessage resizeMessage = gson.fromJson(s, ResizeMessage.class);
//        System.out.println(resizeMessage.getCols()+" "+ resizeMessage.getRows());
        String type = resizeMessage.getType();
        try {
            if (type.equals("ping")) {
                if (process.isAlive()) {
                    session.sendMessage(new BinaryMessage("pong".getBytes(StandardCharsets.UTF_8)));
                }
            }
            else if (type.equals("resize")) {
                resizeStream.write(String.format("{\"Width\": %d, \"Height\": %d}\n", resizeMessage.getCols(), resizeMessage.getRows()).getBytes());
                resizeStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 前端连接断开后，同时断开容器连接，避免占用连接资源
     *
     * @param session
     * @param status
     */
    @Override
    public void afterConnectionClosed(@NotNull WebSocketSession session, @NotNull CloseStatus status) {
        System.out.println("连接已断开");
        if (this.process != null && this.process.isAlive()) {
            this.process.destroy();
        }
        if (this.executorService != null && !this.executorService.isShutdown()) {
            this.executorService.shutdown();
        }
    }

}
