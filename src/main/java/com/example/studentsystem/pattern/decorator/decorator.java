package com.example.studentsystem.pattern.decorator;

import com.example.studentsystem.entity.Course;

public class decorator implements CourseInterface{

    CourseInterface courseInterface;

    public decorator(CourseInterface courseInterface){
        this.courseInterface = courseInterface;
    }

    @Override
    public Course courseMajor(Course course) {
        return course;
    }
}
