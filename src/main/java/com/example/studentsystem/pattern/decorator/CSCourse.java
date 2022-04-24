package com.example.studentsystem.pattern.decorator;

import com.example.studentsystem.entity.Course;

public class CSCourse extends decorator{

    public CSCourse(CourseInterface courseInterface) {
        super(courseInterface);
    }

    public Course courseMajor(Course course) {
        course.setMajorid(1);
        return course;
    }
}
