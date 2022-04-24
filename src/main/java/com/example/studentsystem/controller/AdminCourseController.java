package com.example.studentsystem.controller;

import com.example.studentsystem.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/admin")
public class AdminCourseController {
    @Resource(name = "courseServiceImpl")
    private CourseService courseService;
}
