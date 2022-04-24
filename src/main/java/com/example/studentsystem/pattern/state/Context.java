package com.example.studentsystem.pattern.state;

public class Context {
    private studentState state;

    public Context(){
        state=null;
    }
    public void setState(studentState state){
        this.state = state;
    }

    public studentState getState(){
        return state;
    }
}
