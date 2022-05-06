package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.Student;
import com.example.studentsystem.entity.StudentExample;
import com.example.studentsystem.mapper.CourseMapper;
import com.example.studentsystem.mapper.StudentMapper;
import com.example.studentsystem.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

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
}
