package com.example.sms.dao;

import com.example.sms.entity.Student;

public interface StudentDao {
    boolean add(Student s);
    void delete(String student_no);
    void update(int Insertage, String Name, String class_name, String student_no);
    Student findByStudentNo(String student_no);
}