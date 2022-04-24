package com.example.studentsystem.controller;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.entity.Feeforshow;
import com.example.studentsystem.pattern.strategy.Context;
import com.example.studentsystem.pattern.strategy.Offline;
import com.example.studentsystem.pattern.strategy.Online;
import com.example.studentsystem.service.impl.FeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class FeeController {
    @Resource(name = "feeServiceImpl")
    private FeeServiceImpl FeeService;

    @RequestMapping(value = "/fee")
    public String toFee(Model model) throws Exception{
        List<Fee> fee_list = FeeService.findAllFee();
//        Fee personfee=fee_list.get(0);
//        List<Feeforshow> newfee_list = new ArrayList(fee_list);
//        Online or Offline
//        Context contextOff = new Context(new Offline());
//        Context contextOn = new Context(new Online());
//        System.out.println(contextOff.executeStrategy());


        List<Feeforshow> newfee_list = new ArrayList<Feeforshow>();
        for(Fee fee:fee_list){
            String str="";
            if(fee.getFeeonlineoroffline()==1) str+="Online";
            else if(fee.getFeeonlineoroffline()==2) str+="Offline";
            String status="";
            if(fee.getFeestatus()==1) status+="Registered";
            else if(fee.getFeestatus()==2) status+="Pending";
            else if(fee.getFeestatus()==3) status+="Not Registered";
            Feeforshow temp=new Feeforshow(fee.getFeeid(),fee.getFeeamount(),fee.getFeepayerusername(),status,str,fee.getFeepaymentmethod());
            newfee_list.add(temp);

        }
        model.addAttribute("fee_list",newfee_list);
//        model.addAllAttributes("person",person);

//        model.addAttribute("personfee",personfee);
//        model.addAttribute("list",fee_list);
        return "admin/fee";
    }

}
