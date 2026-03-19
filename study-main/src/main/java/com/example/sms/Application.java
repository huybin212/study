package com.example.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 这一行会启动内嵌的 Tomcat，默认端口 8080
        SpringApplication.run(Application.class, args);
        System.out.println(">>> 学生管理系统启动成功！访问地址: http://localhost:8080/api/students/getAll");
    }
}