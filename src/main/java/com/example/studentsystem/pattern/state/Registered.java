package com.example.studentsystem.pattern.state;

import com.example.studentsystem.pattern.strategy.Context;

import javax.swing.*;

public class Registered implements studentState{
    public void doAction(Context context){
        context.setState(this);
    }

    public String toString(){
        return "Registered";
    }

}
