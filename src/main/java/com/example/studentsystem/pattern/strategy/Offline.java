package com.example.studentsystem.pattern.strategy;

public class Offline implements StrategyOnlineOffline {
    @Override
    public Integer OnlineOrOffline() {
        Integer strOnline = 0;
        strOnline = 2;
        return strOnline;
    }
}
