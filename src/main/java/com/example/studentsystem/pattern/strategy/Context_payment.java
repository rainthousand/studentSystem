package com.example.studentsystem.pattern.strategy;

public class Context_payment {
    private StrategyPayment strategyPayment;

    public Context_payment(StrategyPayment strategyPayment){
        this.strategyPayment = strategyPayment;
    }

    public Integer executeStrategy_payment(){return strategyPayment.paymentMethod();}
}
