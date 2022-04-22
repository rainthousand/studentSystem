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
}
