package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.entity.FeeExample;
import com.example.studentsystem.entity.Student;
import com.example.studentsystem.entity.StudentExample;
import com.example.studentsystem.mapper.FeeMapper;
import com.example.studentsystem.mapper.StudentMapper;
import com.example.studentsystem.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Resource
    private FeeMapper feeMapper;

    @Override
    public List<Student> findAllStudent() {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStudentidIsNotNull();

        return studentMapper.selectByExample(studentExample);
    }

    @Override
    public Student findStudentByStudentID(Integer studentid) {
        return studentMapper.selectByPrimaryKey(studentid);
    }

    @Override
    public List<Student> findAllRegisteredStudent() {
        FeeExample feeExample = new FeeExample();
        FeeExample.Criteria feeCriteria = feeExample.createCriteria();

        feeCriteria.andFeestatusEqualTo(1);
        List<Fee> registeredFeeList = feeMapper.selectByExample(feeExample);
        List<Integer> studentidList = new ArrayList<Integer>();
        for(Fee fee : registeredFeeList){
            studentidList.add(fee.getFeepayerusername());
        }

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria studentCriteria = studentExample.createCriteria();

        studentCriteria.andStudentidIn(studentidList);

        return studentMapper.selectByExample(studentExample);
    }
}
