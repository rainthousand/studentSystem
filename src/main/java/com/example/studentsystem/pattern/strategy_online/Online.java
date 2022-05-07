package com.example.studentsystem.pattern.strategy_online;

public class Online implements StrategyOnlineOffline {
    @Override
    public Integer OnlineOrOffline(){
        Integer strOnline = 0;
        strOnline =1;
        return strOnline;
    }

    @Override
    public Integer to_int() {
        return 1;
    }
    @Override
    public String to_String(){
        return "Online";
    }
}
