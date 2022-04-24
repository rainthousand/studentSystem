package com.example.studentsystem.pattern.strategy;

public class ApplePay implements StrategyPayment{
    @Override
    public Integer paymentMethod(){
        Integer strApple = 0;
        strApple =4;
        return strApple;
    }
}
