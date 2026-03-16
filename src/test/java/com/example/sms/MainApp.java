package com.example.sms;

import com.example.sms.dao.StudentDao;
import com.example.sms.dao.impl.StudentDaoImpl;
import com.example.sms.entity.Student;

public class MainApp {
    public static void main(String[] args) {
        StudentDao dao = new StudentDaoImpl();

        // 1. 新增
        System.out.println("--- 正在添加学生 ---");
        dao.add(new Student("S001", "张三", 20, "zhangsan@test.com"));
        dao.add(new Student("S002", "李四", 22, "lisi@test.com"));

    }
}