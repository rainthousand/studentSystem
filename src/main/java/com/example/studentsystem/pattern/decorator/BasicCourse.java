package com.example.studentsystem.pattern.decorator;

import com.example.studentsystem.entity.Course;

public class BasicCourse implements CourseInterface{
    @Override
    public Course courseMajor(Course course) {
        course.setMajorid(0);
        return course;
    }
}
