package com.example.studentsystem.pattern.strategy;

public class Master_Card implements StrategyPayment{
    @Override
    public Integer paymentMethod(){
        Integer strmaster = 0;
        strmaster =2;
        return strmaster;
    }
}
