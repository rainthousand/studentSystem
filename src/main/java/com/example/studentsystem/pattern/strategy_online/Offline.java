package com.example.studentsystem.pattern.strategy_online;

public class Offline implements StrategyOnlineOffline {
    @Override
    public Integer OnlineOrOffline() {
        Integer strOnline = 0;
        strOnline = 2;
        return strOnline;
    }
    @Override
    public Integer to_int() {
        return 2;
    }
    @Override
    public String to_String(){
        return "Offline";
    }
}
