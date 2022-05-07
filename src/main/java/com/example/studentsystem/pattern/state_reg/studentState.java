package com.example.studentsystem.pattern.state_reg;

public abstract class studentState {
    protected Context state;
    public void doAction(Context state){
        this.state=state;
    }
    abstract void shiftRegistered();
    abstract void shiftPending();
    abstract void shiftNotRegistered();
    abstract String to_String();
    abstract Integer to_Int();
}