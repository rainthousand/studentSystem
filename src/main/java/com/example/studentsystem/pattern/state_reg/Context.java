package com.example.studentsystem.pattern.state_reg;

public class Context {
    public final static studentState NotR=new NotRegistered();
    public final static studentState Pen=new Pending();
    public final static studentState Res=new Registered();

    private studentState state;

    public Context(){
        state=NotR;
        state.doAction(this);
    }
    public void setState(studentState state){

        this.state = state;
        state.doAction(this);
    }

    public studentState getState(){
        return state;
    }
    public void shiftNotRegistered(){
        state.shiftNotRegistered();
    }
    public void shiftPending(){
        state.shiftPending();
    }
    public void shiftRegistered(){
        state.shiftRegistered();
    }
    public String to_String(){return state.to_String();}
    public Integer to_Int(){return state.to_Int();}
}