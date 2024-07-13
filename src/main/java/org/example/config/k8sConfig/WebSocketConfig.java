package org.example.config.k8sConfig;

import io.kubernetes.client.openapi.models.*;
import org.example.handler.TerminalWebSocketHandler;
import org.example.resources.Container;
import org.example.utils.MD5Util;
import org.example.utils.Utils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private Container container;
    @Override
    public void registerWebSocketHandlers(@NotNull WebSocketHandlerRegistry registry) {
        registry.addHandler(new TerminalWebSocketHandler(), "/ws")
                .setAllowedOrigins("*")
                .addInterceptors(new MyWebSocketInterceptor());
    }

    /**
     * 拦截WebSocket请求
     */
    class MyWebSocketInterceptor implements HandshakeInterceptor {
        @Override
        public boolean beforeHandshake(@NotNull ServerHttpRequest request, @NotNull ServerHttpResponse response,
                                       @NotNull WebSocketHandler wsHandler, @NotNull Map<String, Object> attributes) throws Exception {
            System.out.println("前置拦截~~");
            if (!(request instanceof ServletServerHttpRequest)) return true;
            HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();

            String podName = MD5Util.getPodName(servletRequest.getParameter("course"),
                    servletRequest.getParameter("class"),
                    servletRequest.getParameter("student"),
                    servletRequest.getParameter("task"));

            System.out.println(podName);

            //返回容器端口暴露和持久化情况
            ArrayList<String> mountList = new ArrayList<>();
            V1Pod pod = Utils.existingPod(podName);
            for (V1Container v1Container : pod.getSpec().getContainers()) {
                if (v1Container.getName().equals("app")) {
                    for (V1VolumeMount volumeMount : Objects.requireNonNull(v1Container.getVolumeMounts())) {
                        mountList.add(volumeMount.getMountPath());
                    }
                }
            }

            HashMap<Integer, Integer> serviceMap = new HashMap<>();
            V1Service service = Utils.existingService(MD5Util.getServiceName(podName));
            if (service != null) {
                //获取暴露端口
                for (V1ServicePort port : service.getSpec().getPorts()) {
                    serviceMap.put(port.getTargetPort().getIntValue(), port.getNodePort());
                }
            }

            attributes.put("serviceMap", serviceMap);
            attributes.put("mountList", mountList);
            attributes.put("podName", podName);
            return true;
        }
        @Override
        public void afterHandshake(@NotNull ServerHttpRequest request, @NotNull ServerHttpResponse response,
                                   @NotNull WebSocketHandler wsHandler, Exception exception) {
            System.out.println("后置拦截~~");
        }

    }

}
