package com.example.studentsystem.controller;

import com.example.studentsystem.entity.Course;
import com.example.studentsystem.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminCourseController {
    @Resource(name = "courseServiceImpl")
    private CourseService courseService;


}
