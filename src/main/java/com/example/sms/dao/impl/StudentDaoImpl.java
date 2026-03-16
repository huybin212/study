package com.example.sms.dao.impl;

import com.example.sms.dao.StudentDao;
import com.example.sms.entity.Student;
import com.example.sms.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void add(Student s) {
        String sql = "INSERT INTO tb_student(student_no, name, age, email) VALUES(?,?,?,?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getStudentNo());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

}