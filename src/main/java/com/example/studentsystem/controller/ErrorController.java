package com.example.studentsystem.controller;

import com.example.studentsystem.pattern.singleton.FileLogger;
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
        FileLogger obj=FileLogger.getFileLogger();
        obj.write("400 Error");
        obj.close();

        return "common/page-error-400";
    }

    /**
     * 401
     */
    @GetMapping(value = "/401")
    public String error_401() {
        FileLogger obj=FileLogger.getFileLogger();
        obj.write("401 Error");
        obj.close();

        return "common/page-error-401";
    }

    /**
     * 403
     */
    @GetMapping(value = "/403")
    public String error_403() {
        FileLogger obj=FileLogger.getFileLogger();
        obj.write("403 Error");
        obj.close();

        return "common/page-error-403";
    }

    /**
     * 404
     */
    @GetMapping(value = "/404")
    public String error_404() {
        FileLogger obj=FileLogger.getFileLogger();
        obj.write("404 Error");
        obj.close();

        return "common/page-error-404";
    }

    /**
     * 405
     */
    @GetMapping(value = "/405")
    public String error_405() {
        FileLogger obj=FileLogger.getFileLogger();
        obj.write("405 Error");
        obj.close();

        return "common/page-error-405";
    }

    /**
     * 500
     */
    @GetMapping(value = "/500")
    public String error_500() {
        FileLogger obj=FileLogger.getFileLogger();
        obj.write("500 Error");
        obj.close();

        return "common/page-error-500";
    }

    /**
     * 503
     */
    @GetMapping(value = "/503")
    public String error_503() {
        FileLogger obj=FileLogger.getFileLogger();
        obj.write("503 Error");
        obj.close();

        return "common/page-error-503";
    }

}
