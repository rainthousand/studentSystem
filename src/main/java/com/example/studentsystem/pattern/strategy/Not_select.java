package com.example.studentsystem.pattern.strategy;

public class Not_select implements StrategyOnlineOffline{
    @Override
    public Integer OnlineOrOffline() {
        Integer strOnline = 0;
        strOnline = 3;
        return strOnline;
    }
}
