package com.example.sms.entity;

public class Student {
    private Integer id;
    private String student_no;
    private String name;
    private Integer age;
    //private String email;
    private String class_name;


    public Student() {}
    public Student(String student_no, String name, Integer age, String class_name) {
        this.student_no = student_no;
        this.name = name;
        this.age = age;
        this.class_name = class_name;
    }

    // Getter & Setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getStudentNo() { return student_no; }
    public void setStudentNo(String student_no) { this.student_no = student_no; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getClass_name() { return class_name; }
    public void setEmail(String class_name) { this.class_name = this.class_name; }

    @Override
    public String toString() {
        return String.format("ID: %d | 学号: %s | 姓名: %s | 年龄: %d | 班级名: %s", id, student_no, name, age, class_name);
    }
}