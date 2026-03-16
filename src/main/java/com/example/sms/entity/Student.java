package com.example.sms.entity;

public class Student {
    private Integer id;
    private String studentNo;
    private String name;
    private Integer age;
    private String email;

    public Student() {}
    public Student(String studentNo, String name, Integer age, String email) {
        this.studentNo = studentNo;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getter & Setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getStudentNo() { return studentNo; }
    public void setStudentNo(String studentNo) { this.studentNo = studentNo; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("ID: %d | 学号: %s | 姓名: %s | 年龄: %d | 邮箱: %s", id, studentNo, name, age, email);
    }
}