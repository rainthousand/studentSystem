package com.example.studentsystem.pattern.visitor.unitClasses;

import com.example.studentsystem.pattern.visitor.Unit;
import com.example.studentsystem.pattern.visitor.UnitVisitor;

public class TeacherUnit implements Unit {
    @Override
    public String accept(UnitVisitor visitor) {
        return visitor.visit(this);
    }

    public String teacherURL1(){
        return "/teacher/";
    }

    public String teacherURL2(){
        return "/teacher/index";
    }

    //course route
    public String teacherIndexRoute(){
        return "teacher/index";
    }

    //course route
    public String teacherCourseRoute(){
        return "teacher/course";
    }

    //selected course route
    public String teacherSelectedRoute(){
        return "teacher/selectedCourse";
    }

    //student fee route
    public String teacherFeeRoute(){
        return "teacher/fee";
    }
}
