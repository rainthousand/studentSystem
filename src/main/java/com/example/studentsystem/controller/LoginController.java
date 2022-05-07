package com.example.studentsystem.controller;

import com.example.studentsystem.entity.Teacher;
import com.example.studentsystem.entity.UserLogin;
import com.example.studentsystem.entity.UserSessionInfo;
import com.example.studentsystem.pattern.template.*;
import com.example.studentsystem.pattern.visitor.*;
import com.example.studentsystem.service.FeeService;
import com.example.studentsystem.service.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//import com.example.studentsystem.entity.NewsLetter;

import com.example.studentsystem.entity.Teacher;
import com.example.studentsystem.entity.Teacher;
import com.example.studentsystem.entity.UserLogin;
import com.example.studentsystem.entity.UserSessionInfo;
import com.example.studentsystem.pattern.template.AdminLogin;
import com.example.studentsystem.pattern.template.StudentLogin;
import com.example.studentsystem.pattern.template.TeacherLogin;
import com.example.studentsystem.pattern.visitor.*;
import com.example.studentsystem.service.FeeService;
import com.example.studentsystem.service.NewsletterService;
import com.example.studentsystem.service.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class LoginController {

    @Resource(name = "userloginServiceImpl")
    private UserLoginService userloginService;

    @Resource(name = "feeServiceImpl")
    private FeeService feeService;

    @Resource(name = "newsletterServiceImpl")
    private NewsletterService newsletterService;

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String toLogin() throws Exception {
        return "page-login";
    }

    @RequestMapping(value = "/toLogin", method = {RequestMethod.GET})
    public String LogouttoLogin() throws Exception {
        return "page-login";
    }

    // login request handling
    @RequestMapping(value = "/login")
    public String login(UserLogin userlogin) throws Exception {

//        System.out.println("user::::::::::::::::::::::::::::::");
//        System.out.println(userlogin.getUsername());
//        System.out.println(userlogin.getPassword());
        UnitVisitor baseVisitor = new BaseVisitor();
        UnitVisitor mainPageVisitor = new MainPageVisitor();
        Unit adminUnit = new AdminUnit();
        Unit studentUnit = new StudentUnit();
        Unit teacherUnit = new TeacherUnit();
        Unit notRegisteredUnit = new NotRegisteredUnit();
        ObjectStructure units = new ObjectStructure();
        units.add(adminUnit);
        units.add(teacherUnit);
        units.add(studentUnit);
        units.add(notRegisteredUnit);
        List<String> URLs = units.accept(mainPageVisitor);
//        System.out.println(URLs);

        UserLogin currUser = userloginService.findByUserName(userlogin.getUsername());

        //获取session
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();


        //different roles go to different paths and pages
        //√需要修改为visitor模式，此处仅用于测试
        //已使用visitor模式提取不同的URL
        switch (currUser.getRole()) {
            case 0: {
                // admin login
                AdminLogin admin = new AdminLogin();
                return admin.Login(currUser, session, URLs, 0);
            }
            case 1: {
                // teacher login
                TeacherLogin teacher = new TeacherLogin();
                return teacher.Login(currUser, session, URLs, 0);
            }
            case 2: {
                // student login
                Integer status = feeService.findFeeByUserName(Integer.valueOf(userlogin.getUsername())).getFeestatus();
                if(status == 1){
                    StudentLogin student = new StudentLogin();
                    return student.Login(currUser, session, URLs, status);
                }else{
                    NotRegisteredLogin notRegistered = new NotRegisteredLogin();
                    return notRegistered.Login(currUser, session, URLs, status);
                }
            }
        }

        return "/page-login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus){
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/toLogin";
    }
}
