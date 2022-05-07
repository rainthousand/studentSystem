package com.example.studentsystem.pattern.strategy_online;

public class Context_onlineOrOffline {
    private StrategyOnlineOffline strategyOnlineOffline;

    public Context_onlineOrOffline(StrategyOnlineOffline strategyOnlineOffline){
        this.strategyOnlineOffline=strategyOnlineOffline;
    }
    public Integer executeStrategy(){
        return strategyOnlineOffline.OnlineOrOffline();
    }
    public Integer to_Int(){return strategyOnlineOffline.to_int();}
    public String to_String(){return strategyOnlineOffline.to_String();}
}
