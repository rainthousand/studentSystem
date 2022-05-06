package com.example.studentsystem.pattern.template;

import com.example.studentsystem.entity.UserLogin;
import com.example.studentsystem.entity.UserSessionInfo;

import javax.servlet.http.HttpSession;
import java.util.List;

public abstract class LoginProcess {
    public UserSessionInfo getUserSessInfo(UserLogin currUser, Integer status) {
        return new UserSessionInfo(currUser.getUsername(), currUser.getPassword(), status);
    }

    public abstract void setSessionAttribute(HttpSession session, UserSessionInfo userSessionInfo);

    public abstract String getURL(List<String> URLs);

    public String Login(UserLogin currUser, HttpSession session, List<String> URLs, Integer status) {
        UserSessionInfo userSessionInfo = getUserSessInfo(currUser, status);
        setSessionAttribute(session, userSessionInfo);
        String URL;
        System.out.println("LLLLLLLLLLLLLLLLLLLLLLL");
        System.out.println(status);
        URL = switch (status) {
            case 0 -> getURL(URLs);
            case 1 -> getURL(URLs);
            case 2 -> "/notRegistered/index";//TODO pending student URL
            case 3 -> "/notRegistered/index";//TODO not registered URL
            default -> getURL(URLs);
        };
        System.out.println(URL);
        System.out.println("LLLLLLLLLLLLLLLLLLLLLLL");
//        String URL = getURL(URLs);
        return "redirect:" + URL;
    }
}
