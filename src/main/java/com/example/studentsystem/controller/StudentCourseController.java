package com.example.studentsystem.controller;

import com.example.studentsystem.entity.Course;
import com.example.studentsystem.service.CourseService;
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

    @RequestMapping(value = "/course")
    public String studentAllCourse(Model model) throws Exception {
        List<Course> courseList = courseService.findAllCourse();
        model.addAttribute("courseList",courseList);

        return "course";
    }

    @RequestMapping(value = "/selectedCourse")
    public String studentAllSelectedCourse(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        List<Course> selectedCourseList = courseService.findAllCourseByStudentid((Integer) session.getAttribute("username"));
        model.addAttribute("selectedCourseList",selectedCourseList);

        return "selectedCourse";
    }

    @RequestMapping("/deleteSelected")
    public String deleteSelectedCourse(@RequestParam("sid") Integer sid, @RequestParam("cid") Integer cid){
        courseService.deleteSelectedCourse(sid,cid);

        return "redirect:/selectedCourse";
    }

    @RequestMapping("/addSelected/{cid}")
    public String addSelectedCourse(Model model, @PathVariable("cid")Integer cid){
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        Integer sid = (Integer) session.getAttribute("username");
        courseService.addSelectedCourse(sid,cid);

        return "redirect:/selectedCourse";
    }
}
