package com.example.studentsystem.pattern.visitor;

public class StudentUnit implements Unit{
    @Override
    public String accept(UnitVisitor visitor) {
        return visitor.visit(this);
    }

    public String studentURL1(){
        return "/student/";
    }

    public String studentURL2(){
        return "/student/index";
    }
}
