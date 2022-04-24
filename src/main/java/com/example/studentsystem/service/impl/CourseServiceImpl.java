package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.Course;
import com.example.studentsystem.entity.CourseExample;
import com.example.studentsystem.entity.SelectedCourse;
import com.example.studentsystem.entity.SelectedCourseExample;
import com.example.studentsystem.mapper.CourseMapper;
import com.example.studentsystem.mapper.SelectedCourseMapper;
import com.example.studentsystem.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    @Resource
    private SelectedCourseMapper selectedCourseMapper;

    @Override
    public List<Course> findAllCourse() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCourseidIsNotNull();

        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public List<Course> findAllCourseByStudentid(Integer studentid) {
        SelectedCourseExample selectedCourseExample = new SelectedCourseExample();
        SelectedCourseExample.Criteria criteria1 = selectedCourseExample.createCriteria();
        criteria1.andStudentidEqualTo(studentid);

        List<SelectedCourse> allSelected = selectedCourseMapper.selectByExample(selectedCourseExample);
        List<Integer> forCriteria2 = new ArrayList<Integer>();
        for(SelectedCourse selected : allSelected){
            forCriteria2.add(selected.getCourseid());
        }

        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria2 = courseExample.createCriteria();
        criteria2.andCourseidIn(forCriteria2);

        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public Integer deleteSelectedCourse(Integer studentid, Integer courseid) {
        SelectedCourseExample selectedCourseExample = new SelectedCourseExample();
        SelectedCourseExample.Criteria criteria = selectedCourseExample.createCriteria();
        criteria.andCourseidEqualTo(courseid);
        criteria.andStudentidEqualTo(studentid);

        return selectedCourseMapper.deleteByExample(selectedCourseExample);
    }

    @Override
    public Integer addSelectedCourse(Integer studentid, Integer courseid) {
        SelectedCourse selectedCourse = new SelectedCourse();
        selectedCourse.setStudentid(studentid);
        selectedCourse.setCourseid(courseid);
        selectedCourse.setMark(0);

        return selectedCourseMapper.insert(selectedCourse);
    }
}
