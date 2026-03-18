package com.example.sms.dao.impl;

import com.example.sms.dao.StudentDao;
import com.example.sms.entity.Student;
import com.example.sms.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean add(Student s) {
        if(s==null||s.getStudentNo()==null){
            System.out.println("学生对象或学号不能为空！");
            return false;
        }

        String sql = "INSERT INTO tb_student(student_no, name, age, class_name) VALUES(?,?,?,?)";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getStudentNo());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getClass_name());
            int effectrows = ps.executeUpdate();
            if(effectrows>0){
                return true;
            }else {
                return false;
            }

        } catch (SQLIntegrityConstraintViolationException e){
            System.out.println("学号"+s.getStudentNo()+"已存在！");
            return false;
        }catch (SQLException e) {System.out.println("新增学生时发生数据库异常："+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void delete(String student_no){
        String sql = "DELETE FROM tb_student WHERE student_no = ?";
        try(Connection conn = DBUtil.getConnection();PreparedStatement ps =conn.prepareStatement(sql)){
            ps.setString(1,student_no);
            ps.executeUpdate();

        }catch ( SQLException e) { e.printStackTrace(); }
    }

    public void update(int Insertage,String Name,String class_name,String student_no) {
        String sql = "UPDATE tb_student SET age = ?,name = ?,class_name = ?  WHERE student_no = ?";
        try(Connection conn = DBUtil.getConnection();PreparedStatement ps =conn.prepareStatement(sql)){
            ps.setInt(1,Insertage);
            ps.setString(2,Name);
            ps.setString(3,class_name);
            ps.setString(4,student_no);
            ps.executeUpdate();

        }catch ( SQLException e) {

            e.printStackTrace();
        }
    }


}