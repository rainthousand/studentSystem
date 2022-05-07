package com.example.studentsystem.pattern.state_Role;

public class Context_Role {
    public final static State_Role Admin= new Admin_State();
    public final static State_Role Student = new Student_State();
    public final static State_Role NotReg = new NotReg_State();
    public final static State_Role Teacher = new Teacher_State();

    private State_Role state_role;
    public String Role="";

    public Context_Role(){
        state_role=NotReg;
        state_role.doAction(this);
    }
    public void setState_role(State_Role state_role){
        this.state_role=state_role;
        state_role.doAction(this);
    }
    public State_Role getState_role(){return state_role;}
    public void shiftAdmin(){state_role.shiftAdmin();}
    public void shiftNotReg(){state_role.shiftNotReg();}
    public void shiftTeacher(){state_role.shiftTeacher();}
    public void shiftStudent(){state_role.shiftStudent();}


}
