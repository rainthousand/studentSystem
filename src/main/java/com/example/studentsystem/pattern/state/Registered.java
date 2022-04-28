package com.example.studentsystem.pattern.state;

import com.example.studentsystem.pattern.state.Context;

import javax.servlet.http.HttpSession;
import javax.swing.*;

public class Registered extends studentState{
    @Override
    public void shiftNotRegistered(){
        super.state.setState(state.NotR);
        super.state.getState().shiftNotRegistered();
    }
    @Override
    public void shiftPending(){
        super.state.setState(state.Pen);
        super.state.getState().shiftPending();
    }
    @Override
    public void shiftRegistered(){
        System.out.println("Registered");
    }

}
