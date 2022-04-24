package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.Teacher;
import com.example.studentsystem.entity.TeacherExample;
import com.example.studentsystem.mapper.StudentMapper;
import com.example.studentsystem.mapper.TeacherMapper;
import com.example.studentsystem.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("teacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public List<Integer> findAllTeacherID() {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTeacheridIsNotNull();
        List<Teacher> templist = teacherMapper.selectByExample(teacherExample);
        List<Integer> teacheridList = new ArrayList<Integer>();
        for(Teacher tea : templist){
            teacheridList.add(tea.getTeacherid());
        }

        return teacheridList;
    }
}
