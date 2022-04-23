package com.example.studentsystem.controller;

import com.example.studentsystem.entity.Course;
import com.example.studentsystem.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentCourseController {
    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @RequestMapping(value = "/Course")
    public String studentAllCourse(Model model) throws Exception {
        List<Course> courseList = courseService.findAllCourse();
        model.addAttribute("courseList",courseList);

        return "student/course";
    }

}
