package com.example.studentsystem.pattern.strategy_redirect;

public class Demo_Redirect {
    public static void main(String[] args) {
        Context_Redirect context_redirect= new Context_Redirect(new Redirect());
        System.out.println(context_redirect.executeStrategy_Redirect("index"));
    }
}
