package com.example.studentsystem.service;

import com.example.studentsystem.entity.Fee;

public interface FeeService {
    Fee findFeeByUserName(String name) throws Exception;
}
