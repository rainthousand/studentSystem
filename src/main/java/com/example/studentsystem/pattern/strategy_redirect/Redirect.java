package com.example.studentsystem.pattern.strategy_redirect;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Objects;

public class Redirect implements StrategyRedirect{
    @Override
    public String RedirectMethod(String method){
//        String state="Student";
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        String state =(String) session.getAttribute("Role");
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
