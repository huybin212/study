package com.example.sms.service;

import com.example.sms.entity.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);


    List<Student> listAll();
}
