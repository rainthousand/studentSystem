package com.example.studentsystem.pattern.strategy_online;

import com.example.studentsystem.pattern.strategy_online.StrategyOnlineOffline;

public class Not_select implements StrategyOnlineOffline {
    @Override
    public Integer OnlineOrOffline() {
        Integer strOnline = 0;
        strOnline = 3;
        return strOnline;
    }
    @Override
    public Integer to_int() {
        return 3;
    }
    @Override
    public String to_String(){
        return "Not Select";
    }
}
