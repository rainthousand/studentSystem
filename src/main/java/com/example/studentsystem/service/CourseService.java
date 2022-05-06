package com.example.studentsystem.service;

import com.example.studentsystem.entity.Course;
import com.example.studentsystem.entity.SelectedCourse;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse();
    List<Course> findAllCourseByStudentid(Integer studentid);
    Integer deleteSelectedCourse(Integer studentid, Integer courseid);
    Integer addSelectedCourse(Integer studentid, Integer courseid);
    List<SelectedCourse> findAllSelectedCourse();
    Course findCourseByCourseID(Integer courseid);
    Integer indexNewCourse();
    Integer addNewCourse(Course course);
    Integer deleteACourse(Integer courseid);
}
