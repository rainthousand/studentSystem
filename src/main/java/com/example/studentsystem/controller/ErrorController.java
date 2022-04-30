package com.example.studentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    /**
     * 404
     */
    @GetMapping(value = "/404")
    public String error_404() {
        return "common/page-error-404";
    }

    /**
     * 500
     */
    @GetMapping(value = "/500")
    public String error_500() {
        return "common/page-error-500";
    }

}
