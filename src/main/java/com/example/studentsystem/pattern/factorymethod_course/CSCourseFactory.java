package com.example.studentsystem.pattern.factorymethod_course;

import com.example.studentsystem.pattern.decorator.BasicCourse;
import com.example.studentsystem.pattern.decorator.CSCourse;
import com.example.studentsystem.pattern.decorator.CourseInterface;

import java.util.Date;

public class CSCourseFactory implements CourseFactory{
    @Override
    public CourseInterface createCourse(Integer courseid, String coursename, Integer teacherid,
                                        String coursetime, String classroom, Integer courseweek,
                                        String coursetype, Integer credit,
                                        Date coursestart, Date courseend) {
        BasicCourse basicCourse = new BasicCourse();
        CSCourse csCourse = new CSCourse(basicCourse);
        csCourse.setCourseid(courseid);
        csCourse.setCoursename(coursename);
        csCourse.setTeacherid(teacherid);
        csCourse.setCoursetime(coursetime);
        csCourse.setClassroom(classroom);
        csCourse.setCourseweek(courseweek);
        csCourse.setCredit(credit);
        csCourse.setCoursetype(coursetype);
        csCourse.setCoursestart(coursestart);
        csCourse.setCourseend(courseend);
        csCourse.setMajorid(1);

        return csCourse;
    }
}
