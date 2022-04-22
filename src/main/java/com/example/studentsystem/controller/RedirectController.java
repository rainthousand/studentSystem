package com.example.studentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {
    @RequestMapping(value = "/student/index", method = {RequestMethod.GET})
    public String studentToMainPage() throws Exception {
        return "student/index";
    }

    @RequestMapping(value = "/teacher/index", method = {RequestMethod.GET})
    public String teacherToMainPage() throws Exception {
        return "teacher/index";
    }

    @RequestMapping(value = "/admin/index", method = {RequestMethod.GET})
    public String adminToMainPage() throws Exception {
        return "admin/index";
    }
}
