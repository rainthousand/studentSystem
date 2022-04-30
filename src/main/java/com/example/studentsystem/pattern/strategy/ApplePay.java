package com.example.studentsystem.pattern.strategy;

public class ApplePay implements StrategyPayment{
    @Override
    public String paymentMethod(){
//        Integer strApple = 0;
//        strApple =4;
        return "ApplePay";
    }
}
