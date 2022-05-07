package com.example.studentsystem.controller;

import com.example.studentsystem.entity.Course;
import com.example.studentsystem.entity.NewsLetter;
import com.example.studentsystem.pattern.adapter.StudentSelectCourseAdpater;
import com.example.studentsystem.pattern.singleton.FileLogger;
import com.example.studentsystem.service.CourseService;
import com.example.studentsystem.service.NewsletterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/student")
public class StudentCourseController {
    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

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
        obj.write("student get all courses. studentid:"
                +session.getAttribute("username")+".");
        obj.close();

        return "student/course";
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
        obj.write("student get all self selected courses. studentid:"
                +session.getAttribute("username")+".");
        obj.close();

        return "student/selectedcourse";
    }

    @RequestMapping("/deleteSelected/{cid}")
    public String deleteSelectedCourse(@PathVariable("cid") Integer cid){
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        Integer sid = Integer.valueOf((String) session.getAttribute("username"));
//        courseService.deleteSelectedCourse(sid,cid);
        StudentSelectCourseAdpater adapter = new StudentSelectCourseAdpater();
//        return "redirect:/student/selectedCourse";

        return adapter.studentToAdminDeleteSelectCourse(sid,cid,"student");
    }

    @RequestMapping("/addSelected/{cid}")
    public String addSelectedCourse(@PathVariable("cid") Integer cid){
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        Integer sid = Integer.valueOf((String) session.getAttribute("username"));
//        Integer status = (Integer) session.getAttribute("registerstatus");
        StudentSelectCourseAdpater adapter = new StudentSelectCourseAdpater();
        return adapter.studentToAdminAddSelectCourse(sid,cid,"student");
        //TODO Error Handling
//        if(status.equals(1)){
//            courseService.addSelectedCourse(sid,cid);
//
//        }else{
//            return "redirect:/student/course";
//        }
    }
}
