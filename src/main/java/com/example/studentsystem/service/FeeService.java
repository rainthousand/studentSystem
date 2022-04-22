package com.example.studentsystem.service;

import com.example.studentsystem.entity.Fee;

import java.util.List;

public interface FeeService {
    Fee findFeeByUserName(String name) throws Exception;
    List<Fee> findAllFee();
}
