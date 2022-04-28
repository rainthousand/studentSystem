package com.example.studentsystem.pattern.state;

import com.example.studentsystem.pattern.state.Context;

import javax.servlet.http.HttpSession;

public abstract class studentState {
    protected Context state;
    public void doAction(Context state){
        this.state=state;
    }
    abstract void shiftRegistered();
    abstract void shiftPending();
    abstract void shiftNotRegistered();
}