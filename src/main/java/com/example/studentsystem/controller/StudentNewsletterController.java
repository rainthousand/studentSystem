package com.example.studentsystem.controller;

import com.example.studentsystem.entity.NewsLetter;
import com.example.studentsystem.entity.NewsSubject;
import com.example.studentsystem.pattern.singleton.FileLogger;
import com.example.studentsystem.service.NewsletterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/student")
public class StudentNewsletterController {
    @Resource(name = "newsletterServiceImpl")
    private NewsletterService newsletterService;

    @RequestMapping(value = "/tosubscribe")
    public String studentAllSubject(Model model) throws Exception {
        List<NewsSubject> newsSubjectList = newsletterService.findAllSubject();
        model.addAttribute("newsSubjectList", newsSubjectList);
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);

        FileLogger obj=FileLogger.getFileLogger();
        obj.write("student get subscription information. studentid:"
                +session.getAttribute("username"));
        obj.close();

        return "student/tosubscribe";
    }

    @RequestMapping(value = "/managesubscription")
    public String studentAllSubscribedSubject(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsSubject> subscribedSubjectList = newsletterService.findAllSubjectByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("subscribedSubjectList", subscribedSubjectList);
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);

        FileLogger obj=FileLogger.getFileLogger();
        obj.write("student all self subscription information. studentid:"
                +session.getAttribute("username"));
        obj.close();

        return "student/managesubscription";
    }

    @RequestMapping(value = "/subscribedNewsletter")
    public String studentAllSubscribedNewsletter(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> subscribedNewsletterList = newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("subscribedNewsletterList", subscribedNewsletterList);
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);

        FileLogger obj=FileLogger.getFileLogger();
        obj.write("student get all subscribed information. studentid:"
                +session.getAttribute("username"));
        obj.close();

        return "student/subscribedNewsletter";
    }

    @RequestMapping("/unsubscribe/{subject}")
    public String unsubscribeNewsletter(@PathVariable("subject") String subject) {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        Integer sid = Integer.valueOf((String) session.getAttribute("username"));
//        System.out.println("siddddddddddddddddddddddddddd");
//        System.out.println(sid);

        FileLogger obj=FileLogger.getFileLogger();
        obj.write("student unsubscribed a subject. studentid:"
                +session.getAttribute("username")+";subject:"+subject+".");
        obj.close();

        newsletterService.deleteSubscribedSubject(sid, subject);

        return "redirect:/student/managesubscription";
    }

    @RequestMapping("/subscribe/{subject}")
    public String subscribeNewsletter(@PathVariable("subject") String subject) {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        Integer sid = Integer.valueOf((String) session.getAttribute("username"));
        System.out.println("nid");
        System.out.println(subject);
        newsletterService.SubscribeNewsLetterSubject(sid, subject);

        FileLogger obj=FileLogger.getFileLogger();
        obj.write("student subscribed a subject. studentid:"
                +session.getAttribute("username")+";subject:"+subject+".");
        obj.close();

        return "redirect:/student/tosubscribe";
    }
}
