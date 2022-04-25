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
        String URL = getURL(URLs);
        return "redirect:" + URL;
    }
}
