package com.example.studentsystem.pattern.visitor;

public class AdminUnit implements Unit{
    @Override
    public String accept(UnitVisitor visitor) {
        return visitor.visit(this);
    }

    public String adminURL1(){
        return "/admin/";
    }

    public String adminURL2(){
        return "/admin/index";
    }

    //course route
    public String adminIndexRoute(){
        return "admin/index";
    }

    //course route
    public String adminCourseRoute(){
        return "redirect:admin/course";
    }

    //selected course route
    public String adminSelectedRoute(){
        return "redirect:admin/selectedCourse";
    }

    //student fee route
    public String adminFeeRoute(){
        return "redirect:admin/fee-list";
    }
}
