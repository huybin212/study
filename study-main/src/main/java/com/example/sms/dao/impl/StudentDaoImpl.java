package com.example.sms.dao.impl;

import com.example.sms.dao.StudentDao;
import com.example.sms.entity.Student;
import com.example.sms.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    // 根据学号查询单个学生
    public Student findByStudentNo(String studentNo) {
        String sql = "SELECT student_no, name, age, class_name FROM tb_student WHERE student_no = ?";
        Student student = null; // 初始化返回对象
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, studentNo);
            // 执行查询，返回结果集
            try (ResultSet rs = ps.executeQuery()) {
                // 如果查询到结果，封装为Student对象

                if (rs.next()) {
                    student = new Student();
                    student.setStudentNo(rs.getString("student_no"));
                    student.setName(rs.getString("name"));
                    student.setAge(rs.getInt("age"));
                    student.setClass_name(rs.getString("class_name"));
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return student; // 未查到则返回null
    }
    // 查询所有学生
    public List<Student> findAll() {
        String sql = "SELECT student_no, name, age, class_name FROM tb_student";
        List<Student> studentList = new ArrayList<>(); // 初始化结果列表
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) { // 执行查询并获取结果集
            // 遍历结果集，封装每个学生对象到列表
            while (rs.next()) {
                Student student = new Student();
                student.setStudentNo(rs.getString("student_no"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setClass_name(rs.getString("class_name"));
                studentList.add(student);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return studentList; // 返回所有学生列表（无数据则返回空列表）
    }


}