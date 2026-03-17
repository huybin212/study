package com.example.sms.dao;

import com.example.sms.entity.Student;

public interface StudentDao {
    void add(Student s);
    void delete(String student_no);
    void update(int Insertage,String Name,String Email,String student_no);

}