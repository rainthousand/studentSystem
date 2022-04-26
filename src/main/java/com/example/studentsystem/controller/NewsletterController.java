package com.example.studentsystem.controller;

import com.example.studentsystem.entity.NewsLetter;
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
public class NewsletterController {
    @Resource(name = "newsletterServiceImpl")
    private NewsletterService newsletterService;

    @RequestMapping(value = "/newsletter")
    public String studentAllCourse(Model model) throws Exception {
        List<NewsLetter> newsletterList = newsletterService.findAllNewsletter();
        model.addAttribute("newsletterList", newsletterList);

        return "student/newsletter";
    }

    @RequestMapping(value = "/subscribedNewsletter")
    public String studentAllSubscribedNewsletter(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> subscribedNewsletterList = newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("subscribedNewsletter", subscribedNewsletterList);

        return "student/subscribedNewsletter";
    }

    @RequestMapping("/unsubscribe/{nid}")
    public String unsubscribeNewsletter(@PathVariable("nid") Integer nid) {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        Integer sid = Integer.valueOf((String) session.getAttribute("username"));
//        System.out.println("siddddddddddddddddddddddddddd");
//        System.out.println(sid);
        newsletterService.deleteSubscribedNewsLetter(sid, nid);

        return "redirect:/student/subscribedNewsletter";
    }

    @RequestMapping("/subscribe/{nid}")
    public String subscribeNewsletter(@PathVariable("nid") Integer nid) {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        Integer sid = Integer.valueOf((String) session.getAttribute("username"));
        System.out.println("nid");
        System.out.println(nid);
        newsletterService.SubscribeNewsLetter(sid, nid);

        return "redirect:/student/newsletter";
    }
}
