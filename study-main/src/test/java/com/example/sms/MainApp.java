package com.example.sms;

import com.example.sms.dao.StudentDao;
import com.example.sms.dao.impl.StudentDaoImpl;
import com.example.sms.entity.Student;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        StudentDao dao = new StudentDaoImpl();

        //1. 新增
        System.out.println("--- 正在添加学生 ---");
        dao.add(new Student("S001", "张三", 20, "2601"));
        dao.add(new Student("S002", "李四", 22, "2603"));
        dao.add(new Student("S003", "李华", 21, "2605"));
        dao.add(new Student("S004", "王五", 23, "2609"));
        dao.add(new Student("S005", "赵六", 26, "2608"));
        
        //2.删除
    /*    System.out.println("--- 正在按学号删除学生 ---");
        dao.delete("S001");
        dao.delete("S002");
        dao.delete("S003");
        dao.delete("S004");
        dao.delete("S005");
        System.out.println("删除成功！");*/
        //3.修改
        /*System.out.println("--- 正在按学号修改学生 ---");

        int insert_age;
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入修改的年龄！");
        insert_age =  new Scanner(System.in).nextInt();

        System.out.println("请输入修改的名字");
        String insert_name =  new Scanner(System.in).next();

        System.out.println("请输入修改的邮箱");
        String insert_email =  new Scanner(System.in).next();

        dao.update(insert_age,insert_name,insert_email,"S001");*/

    }
}