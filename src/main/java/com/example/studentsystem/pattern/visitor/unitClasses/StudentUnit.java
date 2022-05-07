package com.example.studentsystem.pattern.visitor.unitClasses;

import com.example.studentsystem.pattern.visitor.Unit;
import com.example.studentsystem.pattern.visitor.UnitVisitor;

public class StudentUnit implements Unit {
    @Override
    public String accept(UnitVisitor visitor) {
        return visitor.visit(this);
    }

    //base route
    public String studentURL1(){
        return "/student/";
    }

    //main page route
    public String studentURL2(){
        return "/student/index";
    }

    //Index route
    public String studentIndexRoute(){
        return "student/index";
    }

    //course route
    public String studentCourseRoute(){
        return "student/course";
    }

    //selected course route
    public String studentSelectedRoute(){
        return "student/selectedCourse";
    }

    //student fee route
    public String studentFeeRoute(){
        return "student/fee";
    }
}
