package com.example.studentsystem.pattern.visitor;

public class NotRegisteredUnit implements Unit{
    @Override
    public String accept(UnitVisitor visitor) {
        return visitor.visit(this);
    }

    public String notRegisteredURL1(){
        return "/notRegistered/";
    }

    public String notRegisteredURL2(){
        return "/notRegistered/index";
    }

    //course route
    public String notRegisteredIndexRoute(){
        return "notRegistered/index";
    }

    //course route
    public String notRegisteredCourseRoute(){
        return "redirect:notRegistered/course";
    }

    //selected course route
    public String notRegisteredSelectedRoute(){
        return "redirect:notRegistered/selectedCourse";
    }

    //student fee route
    public String notRegisteredFeeRoute(){
        return "redirect:notRegistered/fee";
    }
}
