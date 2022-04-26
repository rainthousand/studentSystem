package com.example.studentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class RedirectController {
    @RequestMapping(value = "/student/index", method = {RequestMethod.GET})
    public String studentToMainPage() throws Exception {
        return "student/index";
    }

    @RequestMapping(value = "/studentToCourse", method = {RequestMethod.GET})
    public String studentToCoursePage() throws Exception {
        return "redirect:student/course";
    }

    @RequestMapping(value = "/studentToSelectedCourse", method = {RequestMethod.GET})
    public String studentToSelectedCoursePage() throws Exception {
        return "redirect:student/selectedCourse";
    }

    @RequestMapping(value = "/studentToNewsletter", method = {RequestMethod.GET})
    public String studentToNewsletterPage() throws Exception {
        return "redirect:student/newsletter";
    }

    @RequestMapping(value = "/studentToSubscribedNewsletter", method = {RequestMethod.GET})
    public String studentToSubscribeNewsletterPage() throws Exception {
        return "redirect:student/subscribedNewsletter";
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
