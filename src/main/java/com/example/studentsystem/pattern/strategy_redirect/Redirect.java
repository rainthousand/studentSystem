package com.example.studentsystem.pattern.strategy_redirect;

public class Redirect implements StrategyRedirect{
    @Override
    public String RedirectMethod(String method){
        String state="Student";
        String visitor=method;
        return "redirect:"+state+"/"+visitor;
    }
//    @Override
//    public String RedirectIndex(){
//        String state="Student";
//        String visitor="index";
//        return visitor;
//    }
//    @Override
//    public String RedirectCourse(){
//        String state="Student";
//        String visitor="index";
//        return visitor;
//    }
//    @Override
//    public String RedirectSelectedCourse(){
//        String state="Student";
//        String visitor="index";
//        return visitor;
//    }
//    @Override
//    public String RedirectFee(){
//        String state="Student";
//        String visitor="index";
//        return visitor;
//    }
}
