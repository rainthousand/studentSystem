package com.example.studentsystem.pattern.strategy_online;

import com.example.studentsystem.pattern.strategy_online.Context_onlineOrOffline;
import com.example.studentsystem.pattern.strategy_online.Offline;

public class Demo {
    public static void main(String[] args){
        Context_onlineOrOffline context = new Context_onlineOrOffline(new Offline());
        System.out.println(context.executeStrategy());
    }
}
