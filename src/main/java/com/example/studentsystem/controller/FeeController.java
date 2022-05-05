package com.example.studentsystem.controller;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.entity.Feeforshow;
import com.example.studentsystem.pattern.strategy.*;
import com.example.studentsystem.service.impl.FeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/admin")
public class FeeController {
    @Resource(name = "feeServiceImpl")
    private FeeServiceImpl FeeService;

    @RequestMapping(value = "/fee-list")
    public String toFee(Model model) throws Exception{
        List<Fee> fee_list = FeeService.findAllFee();

        List<Feeforshow> newfee_list = new ArrayList<Feeforshow>();
        for(Fee fee:fee_list){

            String status="";
            if(fee.getFeestatus()==1) status+="Registered";
            else if(fee.getFeestatus()==2) status+="Pending";
            else if(fee.getFeestatus()==3) status+="Not Registered";
            String str="";
            String payment="";
            if(fee.getFeeonlineoroffline()==1) {
                str+="Online";
                Context_payment visa_payment = new Context_payment(new Visa_Card());
                Context_payment master_payment = new Context_payment(new Master_Card());
                Context_payment alipay_payment = new Context_payment(new Alipay());
                Context_payment apple_payment = new Context_payment(new ApplePay());
                if(fee.getFeepaymentmethod()==1) payment=visa_payment.executeStrategy_payment();
                else if(fee.getFeepaymentmethod()==2) payment=master_payment.executeStrategy_payment();
                else if(fee.getFeepaymentmethod()==3) payment=alipay_payment.executeStrategy_payment();
                else payment=apple_payment.executeStrategy_payment();
            }
            else if(fee.getFeeonlineoroffline()==2) str+="Offline";


            Feeforshow temp=new Feeforshow(fee.getFeeid(),fee.getFeeamount(),fee.getFeepayerusername(),status,str,payment);
            newfee_list.add(temp);

        }
        model.addAttribute("fee_list",newfee_list);

        return "admin/fee-list";
    }
    @RequestMapping("/confirmPending")
    public String confirmPending(@RequestParam("feeid") Integer feeid,@RequestParam("username") Integer feepayerusername,
                                 @RequestParam("amount") Integer feeamount,@RequestParam("status") String feestatus,
                                 @RequestParam("onOrOff") String feeonlineoroffline,
                                 @RequestParam("payment") String feepaymentmethod){
        System.out.println(feeid);
        System.out.println(feepayerusername);
        System.out.println(feeamount);
        System.out.println(feestatus);
        System.out.println(feeonlineoroffline);
        System.out.println(feepaymentmethod);



        if (Objects.equals(feestatus, "Pending")){
            System.out.println(feestatus);
            FeeService.confirmPending(feeid,feepayerusername,feeamount,feestatus,feeonlineoroffline,feepaymentmethod);
        }

        return "redirect:/admin/fee-list";
    }
}
