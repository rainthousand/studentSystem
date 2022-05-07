package com.example.studentsystem.pattern.visitor;

public class StudentUnit implements Unit{
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

    //main page route
    public String studentURL3(){
        return "/student/course";
    }

    //main page route
    public String studentURL4(){
        return "/student/selectedcourse";
    }

    //main page route
    public String studentURL5(){
        return "student/studentfee-list";
    }
}
