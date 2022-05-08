package com.example.studentsystem.controller;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.entity.Feeforshow;
//import com.example.studentsystem.pattern.strategy.Context;
import com.example.studentsystem.entity.NewsLetter;
import com.example.studentsystem.pattern.singleton.FileLogger;
import com.example.studentsystem.pattern.state_reg.Context;
import com.example.studentsystem.pattern.strategy_payment.*;
import com.example.studentsystem.pattern.strategy_online.Context_onlineOrOffline;
import com.example.studentsystem.pattern.strategy_online.Not_select;
import com.example.studentsystem.pattern.strategy_online.Offline;
import com.example.studentsystem.pattern.strategy_online.Online;
import com.example.studentsystem.service.NewsletterService;
import com.example.studentsystem.service.impl.FeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/student")
public class StudentFeeController {
    @Resource(name = "feeServiceImpl")
    private FeeServiceImpl FeeService;
    @Resource(name = "newsletterServiceImpl")
    private NewsletterService newsletterService;

    @RequestMapping(value = "/fee")
    public String toFee(Model model) throws Exception{
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
//
        Fee studentfee_temp = FeeService.findFeeByUserName(Integer.valueOf((String) session.getAttribute("username")));

        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);
//        studentfee_temp.setFeeonlineoroffline(contextNot.executeStrategy());

        String str="";
        if(studentfee_temp.getFeeonlineoroffline()==3) str+="Not Select";
        else if(studentfee_temp.getFeeonlineoroffline()==1) str+="Online";
        else if(studentfee_temp.getFeeonlineoroffline()==2) str+="Offline";



        String status="";
        Context fee_context = new Context();
        if(studentfee_temp.getFeestatus()==1) {
//            status+="Registered";
            fee_context.shiftRegistered();
            status+=fee_context.to_String();
        }
        else if(studentfee_temp.getFeestatus()==2){
//            status+="Pending";
            fee_context.shiftPending();
            status+=fee_context.to_String();
        }
        else if(studentfee_temp.getFeestatus()==3){
//            status+="Not Registered";
            fee_context.shiftNotRegistered();
            status+=fee_context.to_String();
        }
        System.out.println("status_update");
        System.out.println(status);
        Context_payment visa_payment = new Context_payment(new Visa_Card());
        Context_payment master_payment = new Context_payment(new Master_Card());
        Context_payment alipay_payment = new Context_payment(new Alipay());
        Context_payment apple_payment = new Context_payment(new ApplePay());
        Context_payment offline_no_method = new Context_payment(new offline_no_method());
        String payment="";
        if(studentfee_temp.getFeepaymentmethod()==1) payment=visa_payment.executeStrategy_payment();
        else if(studentfee_temp.getFeepaymentmethod()==2) payment=master_payment.executeStrategy_payment();
        else if(studentfee_temp.getFeepaymentmethod()==3) payment=alipay_payment.executeStrategy_payment();
        else if(studentfee_temp.getFeepaymentmethod()==4) payment=apple_payment.executeStrategy_payment();
        else if(studentfee_temp.getFeepaymentmethod()==0) payment=offline_no_method.executeStrategy_payment();
//        if(studentfee_temp.getFeepaymentmethod()==1) studentfee_temp.setFeepaymentmethod(visa_payment.executeStrategy_payment());

//        if(studentfee_temp.getFeepaymentmethod()==1)
        List<Feeforshow> newfee_list = new ArrayList<Feeforshow>();
        Feeforshow studentfee=new Feeforshow(studentfee_temp.getFeeid(),studentfee_temp.getFeeamount(),studentfee_temp.getFeepayerusername(),status,str,payment);

        //TODO:model种已经加入status更新状态
        model.addAttribute("student_fee",studentfee);
        System.out.println("Model add");
        System.out.println(studentfee.getFeestatus());

//        FileLogger obj=FileLogger.getFileLogger();
//        obj.write("student get fee information. studentid:"
//                +studentfee.getFeepayerusername());
//        

        return "student/studentfee-list";
    }
    @RequestMapping("updateByUsername")
    public String updataByUsername(Model model,@RequestParam Integer feeAmount,@RequestParam String feePaymentMethod,@RequestParam String feeOnlineOrOffline) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        Fee studentfee_temp = FeeService.findFeeByUserName(Integer.valueOf((String) session.getAttribute("username")));
        Context_onlineOrOffline contextOff = new Context_onlineOrOffline(new Offline());
        Context_onlineOrOffline contextOn = new Context_onlineOrOffline(new Online());
        Context_onlineOrOffline contextNot = new Context_onlineOrOffline(new Not_select());
        Context_payment visa_payment = new Context_payment(new Visa_Card());
        Context_payment master_payment = new Context_payment(new Master_Card());
        Context_payment alipay_payment = new Context_payment(new Alipay());
        Context_payment apple_payment = new Context_payment(new ApplePay());
        String payment="";
        switch (studentfee_temp.getFeepaymentmethod()){
            case(1)->{
                payment=visa_payment.executeStrategy_payment();
            }
            case(2)->{
                payment=master_payment.executeStrategy_payment();
            }
            case(3)->{
                payment=alipay_payment.executeStrategy_payment();
            }
            case(4)->{
                payment=apple_payment.executeStrategy_payment();
            }
        }
//        if(studentfee_temp.getFeepaymentmethod()==1) payment=visa_payment.executeStrategy_payment();
//        else if(studentfee_temp.getFeepaymentmethod()==2) payment=master_payment.executeStrategy_payment();
//        else if(studentfee_temp.getFeepaymentmethod()==3) payment=alipay_payment.executeStrategy_payment();
//        else payment=apple_payment.executeStrategy_payment();

        String str="";
        switch (studentfee_temp.getFeeonlineoroffline()){
            case(3)->{
                str+="Not Select";
            }
            case(2)->{
                str+="Offline";
            }
            case(1)->{
                str+="Online";
            }
        }
//        if(studentfee_temp.getFeeonlineoroffline()==3) str+="Not Select";
//        else if(studentfee_temp.getFeeonlineoroffline()==1) str+="Online";
//        else if(studentfee_temp.getFeeonlineoroffline()==2) str+="Offline";
        if(studentfee_temp.getFeeonlineoroffline()!=3){
            if(Objects.equals(feeOnlineOrOffline, "Online") & studentfee_temp.getFeeonlineoroffline()==1){
                if((studentfee_temp.getFeeamount()-feeAmount)>=0){
                    String status=FeeService.UpdateByUserName(session,studentfee_temp.getFeepayerusername(),
                            studentfee_temp.getFeeamount()-feeAmount,
                            feePaymentMethod,studentfee_temp.getFeeonlineoroffline(),
                            studentfee_temp.getFeestatus());
                }else{
                    return "student/Exception_fee";
                }
                return "redirect:fee";
            }
            else if(Objects.equals(feeOnlineOrOffline, "Offline") & studentfee_temp.getFeeonlineoroffline()==2){
                if((studentfee_temp.getFeeamount()-feeAmount)>=0){
                    String status=FeeService.UpdateByUserName(session,studentfee_temp.getFeepayerusername(),
                            studentfee_temp.getFeeamount()-feeAmount,feePaymentMethod,
                            studentfee_temp.getFeeonlineoroffline(),studentfee_temp.getFeestatus());
                    List<Feeforshow> newfee_list = new ArrayList<Feeforshow>();
                    Feeforshow studentfee=new Feeforshow(studentfee_temp.getFeeid(),studentfee_temp.getFeeamount(),
                            studentfee_temp.getFeepayerusername(),status,str,payment);

                    model.addAttribute("student_fee",studentfee);
                }else{
                    return "student/Exception_fee";
                }
                return "redirect:fee";
            }
            else{
                return "student/Exception_online";
            }

        }
        else{
            if(Objects.equals(feeOnlineOrOffline, "Online")){
                studentfee_temp.setFeeonlineoroffline(contextOn.executeStrategy());
            }
            else{
                studentfee_temp.setFeeonlineoroffline(contextOff.executeStrategy());
            }
            //TODO 费用削减失败时页面导航
            if((studentfee_temp.getFeeamount()-feeAmount)>=0){
                String status=FeeService.UpdateByUserName(session,studentfee_temp.getFeepayerusername(),
                        studentfee_temp.getFeeamount()-feeAmount,feePaymentMethod,
                        studentfee_temp.getFeeonlineoroffline(),studentfee_temp.getFeestatus());
                List<Feeforshow> newfee_list = new ArrayList<Feeforshow>();
                Feeforshow studentfee=new Feeforshow(studentfee_temp.getFeeid(),studentfee_temp.getFeeamount(),
                        studentfee_temp.getFeepayerusername(),status,str,payment);

                model.addAttribute("student_fee",studentfee);
            }else{
                return "student/Exception_fee";
            }

//            FileLogger obj=FileLogger.getFileLogger();
//            obj.write("student update self fee information. studentid:"
//                    +session.getAttribute("username"));
//            

            return "redirect:fee";
        }

    }
}
