package com.example.studentsystem.controller;

import com.example.studentsystem.entity.AttendActivityKey;
import com.example.studentsystem.entity.Course;
import com.example.studentsystem.entity.Event;
import com.example.studentsystem.entity.SchoolActivity;
import com.example.studentsystem.service.CourseService;
import com.example.studentsystem.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/student")
public class StudentScheduleController {
    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "scheduleServiceImpl")
    private ScheduleService scheduleService;

    @RequestMapping(value = "/scheduleData")
    @ResponseBody
    public List<Event> studentAllCourse(Model model) throws Exception {
//        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
//                .getRequestAttributes())).getRequest().getSession();
//        Integer currUsername = Integer.valueOf((String) session.getAttribute("username"));
        Integer currUsername = 10001;
        //查询所有已选的课程
        List<Course> selectedCourseList = courseService.findAllCourseByStudentid(currUsername);
        //获取日历类
        Calendar now = Calendar.getInstance();
        //查询所有已参加的活动
        List<SchoolActivity> schoolActivityList = scheduleService.findAllActivityByStudentID(currUsername);
        //新的Event列表
        List<Event> events = new ArrayList<Event>();

        for(Course course : selectedCourseList){
            Event events1 = new Event();
            events1.setTitle(course.getCoursename());
            events1.setStart(course.getCoursestart());
            events1.setEnd(course.getCourseend());
            events1.setAllDay(false);
            events1.setBackgroundColor("#ff4040");
            events1.setBorderColor("#ff4040");
            events.add(events1);
        }

        for(SchoolActivity activity : schoolActivityList){
            Event events1 = new Event();
            events1.setTitle(activity.getActivityname());
            events1.setStart(activity.getActivitystart());
            events1.setEnd(activity.getActivityend());
            events1.setAllDay(false);
            events1.setBackgroundColor("#9e5fff");
            events1.setBorderColor("#9e5fff");
            events.add(events1);
        }

        return events;
    }

}