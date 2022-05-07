package com.example.studentsystem.pattern.strategy_redirect;

public class Direct implements StrategyRedirect{
    @Override
    public String RedirectMethod(String method){

        String state="Student";
        return state+"/"+method;
    }
//    @Override
//    public String RedirectIndex(){
//        String state="Student";
//        return state+"/index";
//    }
//    @Override
//    public String RedirectCourse(){
//        String state="Student";
//        return state+"/course";
//    }
//    @Override
//    public String RedirectSelectedCourse(){
//        String state="Student";
//        return state+"/course";
//    }
//    @Override
//    public String RedirectFee(){
//        String state="Student";
//        return state+"/course";
//    }
}
