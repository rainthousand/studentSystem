package com.example.studentsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.studentsystem.entity.Course;
import com.example.studentsystem.entity.Event;
import com.example.studentsystem.entity.SchoolActivity;
import com.example.studentsystem.service.CourseService;
import com.example.studentsystem.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
            //id设置为Course-(Courseid)
            events1.setId("Course-"+Integer.toString(course.getCourseid()));
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
            //id 设置为Activity-(ActivityId)
            events1.setId("Activity-"+Integer.toString(activity.getActivityid()));
            events.add(events1);
        }

        return events;
    }

    //当拖动事件的时候，用于更新的接口
    //TODO 将composite模式融合，更新数据库
    @RequestMapping(value = "/updateDragging")
    @ResponseBody
    public Event updateDraggingStartandEnd(@RequestBody JSONObject object){
//        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        Event event = new Event();
        event.setTitle(object.getString("Title"));
        event.setStart(object.getDate("Start"));
        event.setEnd(object.getDate("End"));
        event.setBackgroundColor(object.getString("backgroundColor"));
        event.setBorderColor(object.getString("borderColor"));
        event.setAllDay(object.getBoolean("AllDay"));
        event.setId(object.getString("id"));
//        System.out.println(event.getId());
//        System.out.println(object.getDate("Start"));
//        System.out.println(object.getDate("End"));
        return event;
    }

    //当重新设置事件size的时候，用于更新的接口
    //TODO 将composite模式融合，更新数据库
    @RequestMapping(value = "/updateResizing")
    @ResponseBody
    public Event updateResizingEnd(@RequestBody JSONObject object){
//        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        Event event = new Event();
        event.setTitle(object.getString("Title"));
        event.setStart(object.getDate("Start"));
        event.setEnd(object.getDate("End"));
        event.setBackgroundColor(object.getString("backgroundColor"));
        event.setBorderColor(object.getString("borderColor"));
        event.setAllDay(object.getBoolean("AllDay"));
        event.setId(object.getString("id"));
        //TODO 插入数据库时需要递增ID
//        System.out.println(event.getId());
        return event;
    }

    //当从左侧备选事件栏拖动一个新事件到日程表的时候，用于增加的接口
    //TODO 将composite模式融合，插入到数据库，并返回“Activity-”+"Activity数据库中的ID",用于前端回调更新当前新事件在前端的id
    @RequestMapping(value = "/addNewActivity")
    @ResponseBody
    public String addNewActivity(@RequestBody JSONObject object){
//        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        Event event = new Event();
        event.setTitle(object.getString("Title"));
        event.setStart(object.getDate("Start"));
        event.setEnd(object.getDate("End"));
        event.setBackgroundColor(object.getString("backgroundColor"));
        event.setBorderColor(object.getString("borderColor"));
        event.setAllDay(object.getBoolean("AllDay"));
        event.setId(object.getString("id"));
        System.out.println(JSON.toJSONString(event));

//        System.out.println(event.getId());
        return "newID";
    }

    //删除参加的事件的接口
    //TODO 将composite模式融合，删除数据库记录
    @RequestMapping(value = "/deleteAttend")
    @ResponseBody
    public Event deleteAttendedActivity(@RequestBody JSONObject object){
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(object);
        Event event = new Event();
        event.setTitle(object.getString("Title"));
        event.setStart(object.getDate("Start"));
        event.setEnd(object.getDate("End"));
        event.setBackgroundColor(object.getString("backgroundColor"));
        event.setBorderColor(object.getString("borderColor"));
        event.setAllDay(object.getBoolean("AllDay"));
        event.setId(object.getString("id"));
        System.out.println(JSON.toJSONString(event));

//        System.out.println(event.getId());
        return event;
    }

}