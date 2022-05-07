package com.example.studentsystem.pattern.state_reg;

public class NotRegistered extends studentState{
    @Override
    public void shiftNotRegistered(){
        System.out.println("Not Registered");
    }
    @Override
    public void shiftPending(){
        super.state.setState(state.Pen);
        super.state.getState().shiftPending();
    }
    @Override
    public void shiftRegistered(){
        super.state.setState(state.Res);
        super.state.getState().shiftRegistered();
    }
//    public void up(){
//        super.state.setState(Context.);
//    }
//    public void doAction(Context context, HttpSession session){
//        session.setAttribute("registerstatus",3);
//        context.setState(this);
//    }
//
    @Override
    public String to_String(){
        return "Not Registered";
    }
    @Override
    public Integer to_Int(){return 3;}
}
