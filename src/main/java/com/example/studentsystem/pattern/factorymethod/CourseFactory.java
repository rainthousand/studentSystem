package com.example.studentsystem.pattern.factorymethod;

import com.example.studentsystem.entity.Course;
import com.example.studentsystem.pattern.decorator.CourseInterface;

import java.util.Date;

public interface CourseFactory {
    CourseInterface createCourse(Integer courseid, String coursename, Integer teacherid,
                        String coursetime, String classroom, Integer courseweek,
                        String coursetype, Integer credit, Date coursestart,
                        Date courseend);
}
