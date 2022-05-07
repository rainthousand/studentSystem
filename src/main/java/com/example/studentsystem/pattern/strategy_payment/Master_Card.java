package com.example.studentsystem.pattern.strategy_payment;

public class Master_Card implements StrategyPayment{
    @Override
    public String paymentMethod(){
//        Integer strmaster = 0;
//        strmaster =2;
        return "Master card";
    }
}
