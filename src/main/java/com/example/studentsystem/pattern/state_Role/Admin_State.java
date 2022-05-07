package com.example.studentsystem.pattern.state_Role;

public class Admin_State extends State_Role{
//    public void doAction(Context_Role context_role){
//        System.out.println("Admin");
//        context_role.setState_role(this);
//    }
//    public String to

    @Override
    public void shiftAdmin(){
        System.out.println("Admin");
//        return "Admin";
    }
    @Override
    public void shiftNotReg(){
        System.out.println("NotReg");
//        super.context_role.setState_role(context_role.NotReg);
//        super.context_role.getState_role().shiftNotReg();
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
        super.context_role.setState_role(context_role.Student);
        super.context_role.getState_role().shiftStudent();
//        return "Student";
    }
}
