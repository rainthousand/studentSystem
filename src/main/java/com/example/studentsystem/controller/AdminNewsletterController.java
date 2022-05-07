package com.example.studentsystem.controller;

import com.example.studentsystem.pattern.observer.NewsSubject;
import com.example.studentsystem.pattern.observer.Student;
import com.example.studentsystem.pattern.singleton.FileLogger;
import com.example.studentsystem.service.NewsletterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.*;

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
        List<Integer> subscribedStudentList = newsletterService.findAllStudentidBySubject(subject);
        NewsSubject newsSubject=new NewsSubject();
        for (Integer studentid : subscribedStudentList){
            newsSubject.attach(new Student(studentid));
        }
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
        List<List<Integer>> KeyList=new ArrayList<>();
        KeyList=newsSubject.publishAndNotify(newsid);
        for (List<Integer> Key : KeyList) {
            newsletterService.AddNewsletterKey(Key.get(0), Key.get(1));
        }

//        for (Integer studentid : subscribedStudentList) {
////            newsletter.attach(new Student(studentid));
//            newsletterService.AddNewsletterKey(newsid, studentid);
//
//        }

        FileLogger obj=FileLogger.getFileLogger();
        obj.write("Admin published a newsletter. newsletterid:"+newsid);
        

        return "admin/addnewsletter";
    }
}
