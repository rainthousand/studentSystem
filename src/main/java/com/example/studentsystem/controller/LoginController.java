package com.example.studentsystem.controller;

import com.example.studentsystem.entity.UserLogin;
import com.example.studentsystem.entity.UserSessionInfo;
import com.example.studentsystem.pattern.singleton.FileLogger;
import com.example.studentsystem.pattern.visitor.*;
import com.example.studentsystem.service.FeeService;
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

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String toLogin() throws Exception {
        return "page-login";
    }

    // login request handling
    @RequestMapping(value = "/login")
    public String login(UserLogin userlogin) throws Exception {
//        model.addAttribute("test","test");

//        System.out.println("user::::::::::::::::::::::::::::::");
//        System.out.println(userlogin.getUsername());
//        System.out.println(userlogin.getPassword());
        FileLogger obj=FileLogger.getFileLogger();
        obj.write("Login");
        UnitVisitor baseVisitor = new BaseVisitor();
        UnitVisitor mainPageVisitor = new MainPageVisitor();
        Unit adminUnit = new AdminUnit();
        Unit studentUnit = new StudentUnit();
        Unit teacherUnit = new TeacherUnit();
        ObjectStructure units = new ObjectStructure();
        units.add(adminUnit);
        units.add(teacherUnit);
        units.add(studentUnit);
        List<String> URLs = units.accept(mainPageVisitor);

        UserLogin currUser = userloginService.findByUserName(userlogin.getUsername());

        //获取session
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();



        //different roles go to different paths and pages
        //√需要修改为visitor模式，此处仅用于测试
        //已使用visitor模式提取不同的URL
        //TODO 修改为state模式存储状态done
        if (currUser.getRole().equals(0)) {
            Integer status = 0;

            UserSessionInfo userSessionInfo = new UserSessionInfo(currUser.getUsername(),currUser.getPassword(),status);
            System.out.println(session.getId());
            // 在sesssion 中存储用户信息
            session.setAttribute("username", userSessionInfo.getUsername());
            session.setAttribute("password", userSessionInfo.getPassword());
            session.setAttribute("registerstatus", 0);
            //设置session过期时间为7200s 默认是1800s，指的是在不进行任何操作的情况下，超时时间，（即若    处于操作时间期间的话，则自动延长超时时间）
            session.setMaxInactiveInterval(7200);
//            System.out.println(session.getAttribute("registerstatus"));
            String adminURL = URLs.get(0);
            return "redirect:"+adminURL;
        } else if (currUser.getRole().equals(1)) {
            Integer status = 0;

            UserSessionInfo userSessionInfo = new UserSessionInfo(currUser.getUsername(),currUser.getPassword(),status);

            // 在sesssion 中存储用户信息
            session.setAttribute("username", userSessionInfo.getUsername());
            session.setAttribute("password", userSessionInfo.getPassword());
            session.setAttribute("registerstatus", 0);
            System.out.println(session.getId());
            //设置session过期时间为7200s 默认是1800s，指的是在不进行任何操作的情况下，超时时间，（即若    处于操作时间期间的话，则自动延长超时时间）
            session.setMaxInactiveInterval(7200);
//            System.out.println(session.getAttribute("registerstatus"));
            String teacherURL = URLs.get(1);
            return "redirect:"+teacherURL;
        } else if (currUser.getRole().equals(2)) {
            Integer status = feeService.findFeeByUserName(Integer.valueOf(userlogin.getUsername())).getFeestatus();

            UserSessionInfo userSessionInfo = new UserSessionInfo(currUser.getUsername(),currUser.getPassword(),status);
            System.out.println(session.getId());
            // 在sesssion 中存储用户信息
            session.setAttribute("username", userSessionInfo.getUsername());
            session.setAttribute("password", userSessionInfo.getPassword());
            session.setAttribute("registerstatus", userSessionInfo.getRegisterStatus());
            System.out.println(session.getId());
            //设置session过期时间为7200s 默认是1800s，指的是在不进行任何操作的情况下，超时时间，（即若    处于操作时间期间的话，则自动延长超时时间）
            session.setMaxInactiveInterval(7200);
//            System.out.println(session.getAttribute("registerstatus"));
            String studentURL = URLs.get(2);
            return "redirect:"+studentURL;
        }

        return "/page-login";
    }

}
