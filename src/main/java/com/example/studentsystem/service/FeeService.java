package com.example.studentsystem.service;

import com.example.studentsystem.entity.Fee;
import com.sun.xml.bind.v2.TODO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FeeService {
    Fee findFeeByUserName(Integer name) throws Exception;
    List<Fee> findAllFee();
    int UpdateByUserName(Integer name, Integer feeAmount, String feePaymentMethod, String feeOnlineOrOffline) throws Exception;
//    TODO:创建更新接口
}