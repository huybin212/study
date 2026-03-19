package com.example.sms.service.impl;

import com.example.sms.dao.StudentDao;
import com.example.sms.dao.impl.StudentDaoImpl;
import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {


    private StudentDao studentDao = new StudentDaoImpl();


    @Override
    public void addStudent(Student student) {
        // 模拟业务校验：学号不能为空
        if (student.getStudentNo() == null || student.getStudentNo().isEmpty()) {
            throw new RuntimeException("学号是必填项！");
        }
        studentDao.add(student);
    }


    @Override
    public List<Student> listAll() {
        return studentDao.findAll();
    }
}
