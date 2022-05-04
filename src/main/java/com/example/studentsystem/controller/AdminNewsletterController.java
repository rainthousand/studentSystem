package com.example.studentsystem.controller;

import com.example.studentsystem.entity.NewsLetter;
import com.example.studentsystem.pattern.observer.Newsletter;
import com.example.studentsystem.pattern.observer.Student;
import com.example.studentsystem.service.NewsletterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value = "/admin")
public class AdminNewsletterController {
    @Resource(name = "newsletterServiceImpl")
    private NewsletterService newsletterService;

    @RequestMapping(value = "/addnewsletter")
    public String adminAddNewsletter() throws Exception {
        return "admin/addnewsletter";
    }

    @RequestMapping(value = "/publish")
    public String adminPublishNewsletter(@RequestParam String newslettername, @RequestParam String publishertype,
                                         @RequestParam String subject, @RequestParam String newstype,
                                         @RequestParam String newsdetail) throws Exception {

        Random random = new Random();

        Integer newsid = random.nextInt(100000);
        System.out.println(newsid);
        Integer typeInt;
        switch (newstype) {
            case "Normal message":
                typeInt = 1;
            case "Fee message":
                typeInt = 2;
            default:
                typeInt = 1;
        }
        newsletterService.AddNewsletter(newsid, newslettername, publishertype, subject, newsdetail, new Date(), typeInt);
        List<Integer> subscribedStudentList = newsletterService.findAllStudentidBySubject(subject);
//
//        Newsletter newsletter=new Newsletter(newsid,subject);
        for (Integer studentid : subscribedStudentList) {
//            newsletter.attach(new Student(studentid));
            newsletterService.AddNewsletterKey(newsid, studentid);

        }
//        newsletter.notifySubscription();
        return "admin/addnewsletter";
    }
}
