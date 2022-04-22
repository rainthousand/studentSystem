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
}
