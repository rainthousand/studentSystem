package com.example.studentsystem.pattern.decorator;

import com.example.studentsystem.entity.Course;

public class MathCourse extends decorator{

    public MathCourse(CourseInterface courseInterface) {
        super(courseInterface);
    }

    public Course courseMajor(Course course) {
        course.setMajorid(2);
        return course;
    }
}
