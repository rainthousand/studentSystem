package com.example.studentsystem.controller;

import com.example.studentsystem.entity.NewsLetter;
import com.example.studentsystem.service.NewsletterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class RedirectController {

    @Resource(name = "newsletterServiceImpl")
    private NewsletterService newsletterService;

    @RequestMapping(value = "/student/index", method = {RequestMethod.GET})
    public String studentToMainPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);
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

    @RequestMapping(value = "/studentToSubscribedSubject", method = {RequestMethod.GET})
    public String studentToSubscribedSubjectPage() throws Exception {
        return "redirect:student/subscribesubject";
    }

    @RequestMapping(value = "/teacher/index", method = {RequestMethod.GET})
    public String teacherToMainPage() throws Exception {
        return "teacher/index";
    }

    @RequestMapping(value = "/admin/index", method = {RequestMethod.GET})
    public String adminToMainPage() throws Exception {
        return "admin/index";
    }

    @RequestMapping(value = "/adminToNewsletter", method = {RequestMethod.GET})
    public String adminToNewsletter() throws Exception {
        return "redirect:admin/addnewsletter";
    }
}
