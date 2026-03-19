package com.example.sms.web;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;
import com.example.sms.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService = new StudentServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.addStudent(student);
        return "添加成功";
    }


    @GetMapping("/getAll")
    public List<Student> getAll() {
        return studentService.listAll();
    }

}