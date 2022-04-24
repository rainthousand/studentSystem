package com.example.studentsystem.pattern.strategy;

public class demo_payment {
    public static void main(String[] args){
        Context_payment context_payment = new Context_payment(new Alipay());
        System.out.println(context_payment.executeStrategy_payment());
    }
}

