package org.example.config;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateConfig {

    // 注意这里的方法名不是 main，并且返回类型是 String
    public static String getCurrentTimeFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取系统当前时间
        Date date = new Date();
        // 使用SimpleDateFormat对象将时间格式化为指定格式
        String currentTime = sdf.format(date);
        return currentTime;
    }

    // main 方法（如果需要的话）应该是一个void方法，并且通常用于程序的启动
    public static void main(String[] args) {
        // 调用 getCurrentTimeFormatted 方法并打印结果
        System.out.println(getCurrentTimeFormatted());
    }
}
