package com.example.studentsystem.pattern.state_Role;


public class demo_role {
    public static void main(String[] args) {
        Context_Role context_role=new Context_Role();
        context_role.shiftAdmin();
        context_role.to_String();
//        context_role.getState_role();
        context_role.shiftNotReg();
        context_role.to_String();
    }
}
