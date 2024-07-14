package org.example.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 哈希函数工具类
 */
public class MD5Util {
    public static final MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获得8字符hash值
     * @param input
     * @return
     */
    public static String hashString(String input) {
        byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString().substring(0, 8);  // 取前8个字符
    }

    public static String getPodName(String course, String className, String student, String task) {
        return hashString(course) +
                "-" +
                hashString(className) +
                "-" +
                hashString(student) +
                "-" +
                hashString(task) +
                "-pod";
    }

    public static String getServiceName(String podName) {
        return podName.substring(0, podName.length()-3)+"sv";
    }

    public static String getPVCName(String podName) {
        return podName.substring(0, podName.length()-3)+"pvc";
    }
}
