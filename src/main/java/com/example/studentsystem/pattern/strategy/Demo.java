package com.example.studentsystem.pattern.strategy;

public class Demo {
    public static void main(String[] args){
        Context_onlineOrOffline context = new Context_onlineOrOffline(new Offline());
        System.out.println(context.executeStrategy());
    }
}
