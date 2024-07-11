package org.example.config;


import org.example.common.R;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;


public class Base64Config {

    public Base64Config(String base64Image, String filePath) {
    }

    public static R decodeBase64Image(String base64Image, String filePath) {
//        data:image/jpeg;base64,
        if (base64Image.startsWith("data:image/image/jpeg;base64,")) {
            base64Image = base64Image.substring("data:image/image/jpeg;base64,".length());
        } else if (base64Image.startsWith("data:image/jpeg;base64,")){
            base64Image = base64Image.substring("data:image/jpeg;base64,".length());
        }else if (base64Image.startsWith("data:image/png;base64,")){
            base64Image = base64Image.substring("data:image/jpeg;base64,".length());}
        try {
            // 将 Base64 字符串解码为字节数组
//            byte[] decodedBytes = Base64.getDecoder().decode(base64Image);
            byte[] decodedBytes= Base64.getMimeDecoder().decode(base64Image);
            // 创建一个输出流，将字节数组写入到文件中
            try (OutputStream outputStream = new FileOutputStream(filePath)) {
                outputStream.write(decodedBytes);
            }

            return  R.success( "解码成功");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return R.error("图片Base64解码失败: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            return R.error("图片处理失败: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("未知错误: " + e.getMessage());
        }
    }

}
