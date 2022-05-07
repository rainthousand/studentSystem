package com.example.studentsystem.service;

import com.example.studentsystem.entity.SchoolActivity;

import java.util.List;

public interface ScheduleService {
    List<SchoolActivity> findAllActivityByStudentID(Integer studentid);

    Integer add(SchoolActivity schoolActivity);

    Integer IndexNewActivity();

    Integer addNewKey(Integer studentid, Integer activityid);
}
