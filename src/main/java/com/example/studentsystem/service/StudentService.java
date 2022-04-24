package com.example.studentsystem.service;

import com.example.studentsystem.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    Student findStudentByStudentID(Integer studentid);
}
