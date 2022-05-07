package com.example.studentsystem.pattern.strategy_payment;

public class Alipay implements StrategyPayment{
    @Override
    public String paymentMethod(){
        return "Alipay";
    }
}
