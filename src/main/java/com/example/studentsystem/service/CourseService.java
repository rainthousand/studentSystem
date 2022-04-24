package com.example.studentsystem.service;

import com.example.studentsystem.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse();
    List<Course> findAllCourseByStudentid(Integer studentid);
    Integer deleteSelectedCourse(Integer studentid, Integer courseid);
    Integer addSelectedCourse(Integer studentid, Integer courseid);
}
