package com.example.studentsystem.service;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.entity.SubscribeNewsKey;
import com.sun.xml.bind.v2.TODO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface FeeService {
    Fee findFeeByUserName(Integer name) throws Exception;
    List<Fee> findAllFee();
    int UpdateByUserName(HttpSession session,Integer name, Integer feeAmount, String feePaymentMethod, String feeOnlineOrOffline) throws Exception;
    Integer confirmPending(Integer feeid, Integer feepayerusername, Integer feeamount, String feestatus, String feeonlineorline, String feepaymentmethod);
    int updateSubNews(Integer studentId);
}