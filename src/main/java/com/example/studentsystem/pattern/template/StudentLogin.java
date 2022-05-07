package com.example.studentsystem.pattern.template;

import com.example.studentsystem.entity.UserSessionInfo;
import com.example.studentsystem.pattern.state_reg.Context;

import javax.servlet.http.HttpSession;
import java.util.List;

public class StudentLogin extends LoginProcess {
    @Override
    public void setSessionAttribute(HttpSession session, UserSessionInfo userSessionInfo) {
        session.setAttribute("username", userSessionInfo.getUsername());
        session.setAttribute("password", userSessionInfo.getPassword());
        Context context = new Context();
        context.shiftNotRegistered();
//        notRegistered.doAction(context,session);
//        session.setAttribute("registerstatus", userSessionInfo.getRegisterStatus());

        //设置session过期时间为7200s 默认是1800s，指的是在不进行任何操作的情况下，超时时间，（即若    处于操作时间期间的话，则自动延长超时时间）
        session.setMaxInactiveInterval(7200);
//            System.out.println(session.getAttribute("registerstatus"));
//        System.out.println("??????????????");
//        System.out.println(session.getAttribute("registerstatus"));
    }

    @Override
    public String getURL(List<String> URLs) {
        return URLs.get(2);
    }
}
