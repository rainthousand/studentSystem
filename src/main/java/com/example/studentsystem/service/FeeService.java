package com.example.studentsystem.service;

import com.example.studentsystem.entity.Fee;
import com.sun.xml.bind.v2.TODO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface FeeService {
    Fee findFeeByUserName(Integer name) throws Exception;
    List<Fee> findAllFee();
    int UpdateByUserName(HttpSession session,Integer name, Integer feeAmount, String feePaymentMethod, String feeOnlineOrOffline) throws Exception;
//    Integer confirmPending(Integer feeid,Integer feepayerusername,Integer feeamount,Integer feestatus,Integer feeonlineorline,String feepaymentmethod);

    //    @Override
    //    public Fee findFeeById(Integer id) throws Exception{
    //        FeeExample feeExample = new FeeExample();
    //        FeeExample.Criteria criteria = feeExample.createCriteria();
    //        criteria.andFeeidEqualTo(id);
    //
    //        return feeMapper.selectByExample(feeExample).get(0);
    //    }
    Integer confirmPending(Integer feeid, Integer feepayerusername, Integer feeamount, String feestatus, String feeonlineorline, String feepaymentmethod);
}