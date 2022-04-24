package com.example.studentsystem.pattern.strategy;

public class Context {
    private StrategyOnlineOffline strategyOnlineOffline;

    public Context(StrategyOnlineOffline strategyOnlineOffline){
        this.strategyOnlineOffline=strategyOnlineOffline;

    }

    public Integer executeStrategy(){
        return strategyOnlineOffline.OnlineOrOffline();
    }
}
