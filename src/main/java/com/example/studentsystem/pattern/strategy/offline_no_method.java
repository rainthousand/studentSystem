package com.example.studentsystem.pattern.strategy;

public class offline_no_method implements StrategyPayment{
    @Override
    public String paymentMethod(){
//        Integer strmaster = 0;
//        strmaster =2;
        return "No need";
    }
}
