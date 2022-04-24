package com.example.studentsystem.pattern.strategy;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.entity.FeeExample;

public class Online implements StrategyOnlineOffline {
    @Override
    public Integer OnlineOrOffline(){
        Integer strOnline = 0;
        strOnline =1;
        return strOnline;

    }
}
