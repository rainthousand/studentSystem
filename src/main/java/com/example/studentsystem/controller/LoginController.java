package com.example.studentsystem.controller;

import com.example.studentsystem.entity.UserLogin;
import com.example.studentsystem.service.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Resource(name = "userloginServiceImpl")
    private UserLoginService userloginService;

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String toLogin() throws Exception {
        return "original/page-login";
    }

    // login request handling
    @RequestMapping(value = "/login")
    public String login(UserLogin userlogin) throws Exception {

        System.out.println("user::::::::::::::::::::::::::::::");
        System.out.println(userlogin);
        UserLogin currUser = userloginService.findByUserName(userlogin.getUsername());


        //different roles go to different paths and pages
        //需要修改为visitor模式，此处仅用于测试
        if (currUser.getRole().equals(0)) {
            return "redirect:/admin";
        } else if (currUser.getRole().equals(1)) {
            return "redirect:/teacher";
        } else if (currUser.getRole().equals(2)) {
            return "redirect:/student";
        }

        return "/page-login";
    }

}
