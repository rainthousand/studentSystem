package com.example.studentsystem.pattern.state_reg;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.service.FeeService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Objects;

//
public class Demo {

    public void main(String[] args) {
        // 初始化上下文
        Context fanContext = new Context();
        // 调到高
        fanContext.shiftPending();
        System.out.println(fanContext.to_String());
        // 调到低挡
        fanContext.shiftNotRegistered();
        // 关闭
        fanContext.shiftPending();
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
//        Fee studentfee_temp = FeeService.findFeeByUserName(Integer.valueOf((String) session.getAttribute("username")));

    }
}