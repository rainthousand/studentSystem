package com.example.studentsystem.pattern.visitor;

public class TeacherUnit implements Unit{
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
        return "redirect:teacher/course";
    }

    //selected course route
    public String teacherSelectedRoute(){
        return "redirect:teacher/selectedCourse";
    }

    //student fee route
    public String teacherFeeRoute(){
        return "redirect:teacher/fee";
    }
}
