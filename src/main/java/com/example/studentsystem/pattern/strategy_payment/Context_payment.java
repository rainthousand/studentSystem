package com.example.studentsystem.pattern.strategy_payment;

public class Context_payment {
    private StrategyPayment strategyPayment;

    public Context_payment(StrategyPayment strategyPayment){
        this.strategyPayment = strategyPayment;
    }

    public String executeStrategy_payment(){return strategyPayment.paymentMethod();}
}
