package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.*;
import com.example.studentsystem.mapper.AttendActivityMapper;
import com.example.studentsystem.mapper.SchoolActivityMapper;
import com.example.studentsystem.service.ScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("scheduleServiceImpl")
public class ScheduleServiceImpl implements ScheduleService {
    @Resource
    private SchoolActivityMapper schoolActivityMapper;

    @Resource
    private AttendActivityMapper attendActivityMapper;

    @Override
    public List<SchoolActivity> findAllActivityByStudentID(Integer studentid) {
        List<SchoolActivity> res = new ArrayList<SchoolActivity>();

        AttendActivityExample attendActivityExample = new AttendActivityExample();
        AttendActivityExample.Criteria criteria= attendActivityExample.createCriteria();
        criteria.andStudentidEqualTo(studentid);
        List<AttendActivityKey> attendActivityList = attendActivityMapper.selectByExample(attendActivityExample);

        for(AttendActivityKey attendActivityKey : attendActivityList){
            res.add(schoolActivityMapper.selectByPrimaryKey(attendActivityKey.getActivityid()));
        }

        return res;
    }

    @Override
    public Integer add(SchoolActivity schoolActivity){
        return schoolActivityMapper.insert(schoolActivity);

    }

    @Override
    public Integer IndexNewActivity(){
        SchoolActivityExample schoolActivityExample = new SchoolActivityExample();
        SchoolActivityExample.Criteria criteria = schoolActivityExample.createCriteria();
        criteria.andActivityidIsNotNull();
        List<Integer> templist = new ArrayList<>();
        List<SchoolActivity> clist = schoolActivityMapper.selectByExample(schoolActivityExample);
        for(SchoolActivity schoolActivity:clist){
            templist.add(schoolActivity.getActivityid());
        }

        return Collections.max(templist)+1;
    }

    @Override
    public Integer addNewKey(Integer studentid,Integer activityid){
        AttendActivityKey activityKey=new AttendActivityKey();
        activityKey.setStudentid(studentid);
        activityKey.setActivityid(activityid);
        return attendActivityMapper.insert(activityKey);

    }
}
