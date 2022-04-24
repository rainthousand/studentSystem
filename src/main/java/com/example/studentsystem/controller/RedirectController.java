package com.example.studentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/teacher/index", method = {RequestMethod.GET})
    public String teacherToMainPage() throws Exception {
        return "teacher/index";
    }

    @RequestMapping(value = "/admin/index", method = {RequestMethod.GET})
    public String adminToMainPage() throws Exception {
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
}
