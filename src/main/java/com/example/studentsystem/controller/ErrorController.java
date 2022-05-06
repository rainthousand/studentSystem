package com.example.studentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    /**
     * 400
     */
    @GetMapping(value = "/400")
    public String error_400() {
        return "common/page-error-400";
    }

    /**
     * 401
     */
    @GetMapping(value = "/401")
    public String error_401() {
        return "common/page-error-401";
    }

    /**
     * 403
     */
    @GetMapping(value = "/403")
    public String error_403() {
        return "common/page-error-403";
    }

    /**
     * 404
     */
    @GetMapping(value = "/404")
    public String error_404() {
        return "common/page-error-404";
    }

    /**
     * 405
     */
    @GetMapping(value = "/405")
    public String error_405() {
        return "common/page-error-405";
    }

    /**
     * 500
     */
    @GetMapping(value = "/500")
    public String error_500() {
        return "common/page-error-500";
    }

    /**
     * 503
     */
    @GetMapping(value = "/503")
    public String error_503() {
        return "common/page-error-503";
    }

}
