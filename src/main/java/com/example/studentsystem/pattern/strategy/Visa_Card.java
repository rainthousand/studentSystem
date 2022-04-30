package com.example.studentsystem.pattern.strategy;

public class Visa_Card implements StrategyPayment{
    @Override
    public String paymentMethod(){
//        Integer strvisa = 0;
//        strvisa =1;
        return "Visa card";
    }
}
