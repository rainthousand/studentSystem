package com.example.studentsystem.pattern.state_Role;

public class Teacher_State extends State_Role{
    @Override
    public void shiftAdmin(){
        super.context_role.setState_role(context_role.Admin);
        super.context_role.getState_role().shiftAdmin();
//        return "Admin";
    }
    @Override
    public void shiftNotReg(){
        super.context_role.setState_role(context_role.NotReg);
        super.context_role.getState_role().shiftNotReg();
//        return "NotReg";
    }
    @Override
    public void shiftTeacher(){
        System.out.println("Teacher");
//        return "Teacher";
    }
    @Override
    public void shiftStudent(){
        super.context_role.setState_role(context_role.Student);
        super.context_role.getState_role().shiftStudent();
//        return "Student";
    }
}
