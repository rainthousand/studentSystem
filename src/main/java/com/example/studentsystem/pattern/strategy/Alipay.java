package com.example.studentsystem.pattern.strategy;

public class Alipay implements StrategyPayment{
    @Override
    public String paymentMethod(){
        return "Alipay";
    }
}
