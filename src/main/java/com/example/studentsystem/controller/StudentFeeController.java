package com.example.studentsystem.controller;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.entity.Feeforshow;
import com.example.studentsystem.mapper.FeeMapper;
//import com.example.studentsystem.pattern.strategy.Context;
import com.example.studentsystem.pattern.strategy.*;
import com.example.studentsystem.service.impl.FeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/student")
public class StudentFeeController {
    @Resource(name = "feeServiceImpl")
    private FeeServiceImpl FeeService;

    @RequestMapping(value = "/fee")
    public String toFee(Model model) throws Exception{
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
//
        Fee studentfee_temp = FeeService.findFeeByUserName(Integer.valueOf((String) session.getAttribute("username")));

        Context_onlineOrOffline contextOff = new Context_onlineOrOffline(new Offline());
        Context_onlineOrOffline contextOn = new Context_onlineOrOffline(new Online());

        studentfee_temp.setFeeonlineoroffline(contextOn.executeStrategy());

        String str="";
        if(studentfee_temp.getFeeonlineoroffline()==1) str+="Online";
        else if(studentfee_temp.getFeeonlineoroffline()==2) str+="Offline";
        String status="";
        if(studentfee_temp.getFeestatus()==1) status+="Registered";
        else if(studentfee_temp.getFeestatus()==2) status+="Pending";
        else if(studentfee_temp.getFeestatus()==3) status+="Not Registered";
        Context_payment visa_payment = new Context_payment(new Visa_Card());
        Context_payment master_payment = new Context_payment(new Master_Card());
        Context_payment alipay_payment = new Context_payment(new Alipay());
        Context_payment apple_payment = new Context_payment(new ApplePay());
        String payment="";
        if(studentfee_temp.getFeepaymentmethod()==1) payment=visa_payment.executeStrategy_payment();
        else if(studentfee_temp.getFeepaymentmethod()==2) payment=master_payment.executeStrategy_payment();
        else if(studentfee_temp.getFeepaymentmethod()==3) payment=alipay_payment.executeStrategy_payment();
        else payment=apple_payment.executeStrategy_payment();
//        if(studentfee_temp.getFeepaymentmethod()==1) studentfee_temp.setFeepaymentmethod(visa_payment.executeStrategy_payment());


//        if(studentfee_temp.getFeepaymentmethod()==1)
        List<Feeforshow> newfee_list = new ArrayList<Feeforshow>();
        Feeforshow studentfee=new Feeforshow(studentfee_temp.getFeeid(),studentfee_temp.getFeeamount(),studentfee_temp.getFeepayerusername(),status,str,payment);


        model.addAttribute("student_fee",studentfee);
        return "student/studentfee-list";
    }
    @RequestMapping("updateByUsername")
    public String updataByUsername(@RequestParam Integer feeAmount,@RequestParam String feePaymentMethod,@RequestParam String feeOnlineOrOffline) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        Fee studentfee_temp = FeeService.findFeeByUserName(Integer.valueOf((String) session.getAttribute("username")));
        //TODO 费用削减失败时页面导航
        if((studentfee_temp.getFeeamount()-feeAmount)>=0){
            FeeService.UpdateByUserName(session,studentfee_temp.getFeepayerusername(),studentfee_temp.getFeeamount()-feeAmount,feePaymentMethod,feeOnlineOrOffline);
        }else{
        }
        return "redirect:fee";
    }
}
