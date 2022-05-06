package com.example.studentsystem.pattern.factorymethod;

import com.example.studentsystem.entity.Course;
import com.example.studentsystem.pattern.decorator.BasicCourse;
import com.example.studentsystem.pattern.decorator.CSCourse;
import com.example.studentsystem.pattern.decorator.CourseInterface;
import com.example.studentsystem.pattern.decorator.MathCourse;

import java.util.Date;

public class MathCourseFactory implements CourseFactory{
    @Override
    public CourseInterface createCourse(Integer courseid, String coursename, Integer teacherid,
                                        String coursetime, String classroom, Integer courseweek,
                                        String coursetype, Integer credit,
                                        Date coursestart, Date courseend) {
        BasicCourse basicCourse = new BasicCourse();
        MathCourse mathCourse = new MathCourse(basicCourse);
        mathCourse.setCourseid(courseid);
        mathCourse.setCoursename(coursename);
        mathCourse.setTeacherid(teacherid);
        mathCourse.setCoursetime(coursetime);
        mathCourse.setClassroom(classroom);
        mathCourse.setCourseweek(courseweek);
        mathCourse.setCredit(credit);
        mathCourse.setCoursetype(coursetype);
        mathCourse.setCoursestart(coursestart);
        mathCourse.setCourseend(courseend);
        mathCourse.setMajorid(2);

        return mathCourse;
    }
}
