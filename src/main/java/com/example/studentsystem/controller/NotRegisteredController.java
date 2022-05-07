package com.example.studentsystem.controller;

import com.example.studentsystem.entity.Course;
import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.entity.Feeforshow;
import com.example.studentsystem.entity.NewsLetter;
import com.example.studentsystem.pattern.singleton.FileLogger;
import com.example.studentsystem.pattern.strategy.*;
import com.example.studentsystem.service.CourseService;
import com.example.studentsystem.service.NewsletterService;
import com.example.studentsystem.service.impl.FeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/notRegistered")
public class NotRegisteredController {

    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "feeServiceImpl")
    private FeeServiceImpl FeeService;

    @Resource(name = "newsletterServiceImpl")
    private NewsletterService newsletterService;

    @RequestMapping(value = "/course")
    public String studentAllCourse(Model model) throws Exception {
        List<Course> courseList = courseService.findAllCourse();
        model.addAttribute("courseList",courseList);
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);

        FileLogger obj=FileLogger.getFileLogger();
        obj.write("Not Registered student get all courses but can't modify. studentid:"+session.getAttribute("username"));
        obj.close();

        return "notRegistered/course";
    }

    @RequestMapping(value = "/selectedCourse")
    public String studentAllSelectedCourse(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<Course> selectedCourseList = courseService.findAllCourseByStudentid(Integer.valueOf((String) session.getAttribute("username")) );
        model.addAttribute("selectedCourseList",selectedCourseList);
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);

        FileLogger obj=FileLogger.getFileLogger();
        obj.write("Not Registered student get selected courses but can't modify. studentid:"+session.getAttribute("username"));
        obj.close();

        return "notRegistered/selectedcourse";
    }

    @RequestMapping(value = "/fee")
    public String toFee(Model model) throws Exception{
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);
        Fee studentfee_temp = FeeService.findFeeByUserName(Integer.valueOf((String) session.getAttribute("username")));

        String str="";
        if(studentfee_temp.getFeeonlineoroffline()==3) str+="Not Select";
        else if(studentfee_temp.getFeeonlineoroffline()==1) str+="Online";
        else if(studentfee_temp.getFeeonlineoroffline()==2) str+="Offline";

        String status="";
        if(studentfee_temp.getFeestatus()==1) status+="Registered";
        else if(studentfee_temp.getFeestatus()==2) status+="Pending";
        else if(studentfee_temp.getFeestatus()==3) status+="Not Registered";

        Context_payment visa_payment = new Context_payment(new Visa_Card());
        Context_payment master_payment = new Context_payment(new Master_Card());
        Context_payment alipay_payment = new Context_payment(new Alipay());
        Context_payment apple_payment = new Context_payment(new ApplePay());

        String payment="";
        if(studentfee_temp.getFeepaymentmethod()==1) payment=visa_payment.executeStrategy_payment();
        else if(studentfee_temp.getFeepaymentmethod()==2) payment=master_payment.executeStrategy_payment();
        else if(studentfee_temp.getFeepaymentmethod()==3) payment=alipay_payment.executeStrategy_payment();
        else payment=apple_payment.executeStrategy_payment();

        List<Feeforshow> newfee_list = new ArrayList<Feeforshow>();
        Feeforshow studentfee=new Feeforshow(studentfee_temp.getFeeid(),studentfee_temp.getFeeamount(),studentfee_temp.getFeepayerusername(),status,str,payment);

        model.addAttribute("student_fee",studentfee);

        FileLogger obj=FileLogger.getFileLogger();
        obj.write("Not Registered student get self fee information. studentid:"
                +session.getAttribute("username")+";feeid:"+studentfee.getFeeid());
        obj.close();

        return "notRegistered/studentfee-list";
    }

    @RequestMapping(value = "/subscribedNewsletter")
    public String studentAllSubscribedNewsletter(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));

        List<NewsLetter> subscribedNewsletterList = newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("subscribedNewsletterList", subscribedNewsletterList);
        model.addAttribute("notificationList", subscribedNewsletterList);

        FileLogger obj=FileLogger.getFileLogger();
        obj.write("Not Registered student get Reminder Newsletter. studentid:"
                +session.getAttribute("username"));
        obj.close();

        return "notRegistered/subscribedNewsletter";
    }
}
