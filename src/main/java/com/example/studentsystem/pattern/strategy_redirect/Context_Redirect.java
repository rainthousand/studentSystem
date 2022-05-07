package com.example.studentsystem.pattern.strategy_redirect;

public class Context_Redirect {
    private StrategyRedirect strategyRedirect;

    public Context_Redirect(StrategyRedirect strategyRedirect){
        this.strategyRedirect=strategyRedirect;
    }
    public String executeStrategy_Redirect(String method){
        return strategyRedirect.RedirectMethod(method);
    }
//    public String executeStrategy_Index(){
//        return strategyRedirect.RedirectIndex();
//    }
//    public String executeStrategy_Course(){
//        return strategyRedirect.RedirectCourse();
//    }
//    public String executeStrategy_SelectedCourse(){
//        return strategyRedirect.RedirectSelectedCourse();
//    }
//    public String executeStrategy_Fee(){
//        return strategyRedirect.RedirectFee();
//    }
}
