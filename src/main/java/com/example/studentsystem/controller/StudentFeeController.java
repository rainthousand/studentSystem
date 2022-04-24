package com.example.studentsystem.controller;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.pattern.strategy.Context;
import com.example.studentsystem.pattern.strategy.Offline;
import com.example.studentsystem.pattern.strategy.Online;
import com.example.studentsystem.service.impl.FeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping(value = "/student")
public class StudentFeeController {
    @Resource(name = "feeServiceImpl")
    private FeeServiceImpl FeeService;

    @RequestMapping(value = "/fee")
    public String toFee(Model model) throws Exception{
//        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
//                .getRequestAttributes())).getRequest().getSession();
//
//        Fee studentfee = FeeService.findFeeByUserName((String) session.getAttribute("username"));
//
        Fee studentfee = FeeService.findFeeByUserName(10001);

        Context contextOff = new Context(new Offline());
        Context contextOn = new Context(new Online());

        studentfee.setFeeonlineoroffline(contextOn.executeStrategy());

        model.addAttribute("student_fee",studentfee);
        return "student/studentfee";
    }
}
