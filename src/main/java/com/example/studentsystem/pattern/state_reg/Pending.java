package com.example.studentsystem.pattern.state_reg;

public class Pending extends studentState{
    @Override
    public void shiftNotRegistered(){
        super.state.setState(state.NotR);
        super.state.getState().shiftNotRegistered();
    }
    @Override
    public void shiftRegistered(){
        super.state.setState(state.Res);
        super.state.getState().shiftRegistered();
    }
    @Override
    public void shiftPending(){
        System.out.println("Pending");
    }

//    public void doAction(Context context){
////        session.setAttribute("registerstatus",2);
//        context.setState(this);
//
//    }
//
    @Override
    public String to_String(){
        return "Pending";
    }
    @Override
    public Integer to_Int(){return 2;}
}
