package com.example.studentsystem.pattern.observer;

public class Student implements Observer {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }

}


//            Integer status = feeService.findFeeByUserName(Integer.valueOf(userlogin.getUsername())).getFeestatus();
//
//            UserSessionInfo userSessionInfo = new UserSessionInfo(currUser.getUsername(),currUser.getPassword(),status);
//            // 在sesssion 中存储用户信息
//            session.setAttribute("username", userSessionInfo.getUsername());
//            session.setAttribute("password", userSessionInfo.getPassword());
//            session.setAttribute("registerstatus", userSessionInfo.getRegisterStatus());
//            //设置session过期时间为7200s 默认是1800s，指的是在不进行任何操作的情况下，超时时间，（即若    处于操作时间期间的话，则自动延长超时时间）
//            session.setMaxInactiveInterval(7200);
////            System.out.println(session.getAttribute("registerstatus"));
//            String studentURL = URLs.get(2);
//            return "redirect:"+studentURL;