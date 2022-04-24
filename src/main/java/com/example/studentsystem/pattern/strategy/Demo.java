package com.example.studentsystem.pattern.strategy;

public class Demo {
    public static void main(String[] args){
        Context context = new Context(new Offline());
        System.out.println(context.executeStrategy());
    }
}
