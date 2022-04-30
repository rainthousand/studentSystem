package com.example.studentsystem.pattern.strategy;

public class Alipay implements StrategyPayment{
    @Override
    public String paymentMethod(){
//        Integer strAlipay = 0;
//        strAlipay =3;
        return "Alipay";
    }
}
