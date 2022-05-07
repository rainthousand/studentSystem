package com.example.studentsystem.pattern.state_Role;

public class Student_State extends State_Role{
    @Override
    public void shiftAdmin(){
        super.context_role.setState_role(context_role.Admin);
        super.context_role.getState_role().shiftAdmin();
//        return "Admin";
    }
    @Override
    public void shiftNotReg(){
//        System.out.println("NotReg");
        super.context_role.setState_role(context_role.NotReg);
        super.context_role.getState_role().shiftNotReg();
//        return "NotReg";
    }
    @Override
    public void shiftTeacher(){
        super.context_role.setState_role(context_role.Teacher);
        super.context_role.getState_role().shiftTeacher();
//        return "Teacher";
    }
    @Override
    public void shiftStudent(){
        System.out.println("student");
//        return "Student";
    }

    public String to_String(){
        return "student";
    }
}
