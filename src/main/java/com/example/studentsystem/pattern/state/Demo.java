package com.example.studentsystem.pattern.state;

public class Demo {
    public static void main(String[] args){
        Context context = new Context();
        Registered registered = new Registered();
        registered.doAction(context);
        System.out.println(context.getState().toString());
    }
}
