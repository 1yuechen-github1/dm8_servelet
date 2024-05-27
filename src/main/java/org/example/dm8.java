package org.example;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@SpringBootApplication


/***
 * 主程序启动类
 */
//DataSourceAutoConfiguration
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
//此为Mapper的对应需要扫描的包
//@MapperScan( basePackages = {"org.example.db_MySQL", "com.mapper.db_DM8"})
@Configuration
@EnableAsync    //添加启动类 @EnableAsy
public class dm8 {

    @RequestMapping("/")
    public String home(){
        return "helloworld";
    }

    public static void main(String[] args) {
        // 参数1：入口类示例；参数2：命令行参数
        SpringApplication.run(dm8.class, args);
    }

}
