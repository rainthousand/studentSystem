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

    //TODO Strategy Pattern to Redirect
    @RequestMapping(value = "/student/index", method = {RequestMethod.GET})
    public String studentToMainPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("name",session.getAttribute("username"));
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

    @RequestMapping(value = "/teacher/index", method = {RequestMethod.GET})
    public String teacherToMainPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        model.addAttribute("name",session.getAttribute("username"));
        return "teacher/index";
    }

    @RequestMapping(value = "/admin/index", method = {RequestMethod.GET})
    public String adminToMainPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        model.addAttribute("name",session.getAttribute("username"));
        return "admin/index";
    }

    @RequestMapping(value = "/adminToCourse", method = {RequestMethod.GET})
    public String adminToCoursePage() throws Exception {
        return "redirect:admin/course";
    }

    @RequestMapping(value = "/adminToSelectedCourse", method = {RequestMethod.GET})
    public String adminToSelectedCoursePage() throws Exception {
        return "redirect:admin/selectedCourse";
    }

    @RequestMapping(value = "/adminToAddCourse", method = {RequestMethod.GET})
    public String adminToAddCoursePage() throws Exception {
        return "redirect:admin/toAddCoursePage";
    }

    @RequestMapping(value = "/studentToCalendar", method = {RequestMethod.GET})
    public String studentToCalendarPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);
        return "student/calendar";
    }

    @RequestMapping(value = "/studentToFeePage",method = {RequestMethod.GET})
    public String studentToFeePage() throws Exception{
        return "redirect:student/fee";
    }

    @RequestMapping(value = "/adminToFeePage",method = {RequestMethod.GET})
    public String adminToFeePage() throws Exception{
        return "redirect:admin/fee-list";
    }

    @RequestMapping(value = "/studentToSubscribedNewsletter", method = {RequestMethod.GET})
    public String studentToSubscribeNewsletterPage() throws Exception {
        return "redirect:student/subscribedNewsletter";
    }

    @RequestMapping(value = "/studentToSubscribe", method = {RequestMethod.GET})
    public String studentToSubscribePage() throws Exception {
        return "redirect:student/tosubscribe";
    }

    @RequestMapping(value = "/studentToManageSubscription", method = {RequestMethod.GET})
    public String studentToManageSubscriptionPage() throws Exception {
        return "redirect:student/managesubscription";
    }

    @RequestMapping(value = "/adminToNewsletter", method = {RequestMethod.GET})
    public String adminToNewsletter() throws Exception {
        return "redirect:admin/addnewsletter";
    }

    @RequestMapping(value = "/adminToIndex", method = {RequestMethod.GET})
    public String adminToIndex(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        model.addAttribute("name",session.getAttribute("username"));
        return "admin/index";
    }

    @RequestMapping(value = "/studentToIndex", method = {RequestMethod.GET})
    public String studentToIndex(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("name",session.getAttribute("username"));
        model.addAttribute("notificationList", notificationList);
        return "student/index";
    }

    //Not Registered
    @RequestMapping(value = "/notRegisteredToIndex", method = {RequestMethod.GET})
    public String notRegitsteredToMainPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("name",session.getAttribute("username"));
        model.addAttribute("notificationList", notificationList);
        return "notRegistered/index";
    }

    @RequestMapping(value = "/notRegisteredToSelectedCourse", method = {RequestMethod.GET})
    public String notRegitsteredToSelectedCourse() throws Exception {
        return "redirect:notRegistered/selectedCourse";
    }

    @RequestMapping(value = "/notRegisteredToCourse", method = {RequestMethod.GET})
    public String notRegitsteredToCourse() throws Exception {
        return "redirect:notRegistered/course";
    }

    @RequestMapping(value = "/notRegisteredToFeePage", method = {RequestMethod.GET})
    public String notRegitsteredToFeePage() throws Exception {
        return "redirect:notRegistered/fee";
    }

    @RequestMapping(value = "/notRegisteredToSubscribedNewsletter", method = {RequestMethod.GET})
    public String notRegitsteredToSubscribedNewsletter() throws Exception {
        return "redirect:notRegistered/subscribedNewsletter";
    }
}
