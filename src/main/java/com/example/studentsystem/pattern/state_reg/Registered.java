package com.example.studentsystem.pattern.state_reg;

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
    @Override
    public String to_String(){
        return "Registered";
    }
    @Override
    public Integer to_Int(){return 1;}

}
