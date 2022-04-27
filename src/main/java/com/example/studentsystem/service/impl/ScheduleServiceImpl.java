package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.AttendActivityExample;
import com.example.studentsystem.entity.AttendActivityKey;
import com.example.studentsystem.entity.SchoolActivity;
import com.example.studentsystem.mapper.AttendActivityMapper;
import com.example.studentsystem.mapper.SchoolActivityMapper;
import com.example.studentsystem.service.ScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
}
