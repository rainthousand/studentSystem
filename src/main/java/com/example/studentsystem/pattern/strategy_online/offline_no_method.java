package com.example.studentsystem.pattern.strategy_online;

import com.example.studentsystem.pattern.strategy_payment.StrategyPayment;

public class offline_no_method implements StrategyPayment {
    @Override
    public String paymentMethod(){
//        Integer strmaster = 0;
//        strmaster =2;
        return "No need";
    }
}
