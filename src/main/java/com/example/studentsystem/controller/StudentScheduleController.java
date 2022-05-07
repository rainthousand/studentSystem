package com.example.studentsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.studentsystem.entity.*;
import com.example.studentsystem.pattern.composite.BasicEvent;
import com.example.studentsystem.pattern.composite.CourseEventFactory;
import com.example.studentsystem.pattern.composite.Schedule;
import com.example.studentsystem.pattern.composite.SchoolActivityFactory;
import com.example.studentsystem.service.CourseService;
import com.example.studentsystem.service.NewsletterService;
import com.example.studentsystem.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping(value = "/student")
public class StudentScheduleController {
    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "scheduleServiceImpl")
    private ScheduleService scheduleService;
    @Resource(name = "newsletterServiceImpl")
    private NewsletterService newsletterService;

    Schedule schedule = new Schedule();
    CourseEventFactory courseEventFactory = new CourseEventFactory();
    SchoolActivityFactory schoolActivityFactory = new SchoolActivityFactory();
    @RequestMapping(value = "/scheduleData")
    @ResponseBody
    public List<EditableEvent> studentAllCourse(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        Integer currUsername = Integer.valueOf((String) session.getAttribute("username"));
        schedule.clear();
        //查询所有已选的课程
        List<Course> selectedCourseList = courseService.findAllCourseByStudentid(currUsername);
        //获取日历类
        Calendar now = Calendar.getInstance();
        //查询所有已参加的活动
        List<SchoolActivity> schoolActivityList = scheduleService.findAllActivityByStudentID(currUsername);

        for (Course course : selectedCourseList) {
            BasicEvent courseEvent = courseEventFactory.newEvent(course.getCoursename(), "Course-" + course.getCourseid(),
                    new Date(course.getCoursestart().getTime()+3600*1000),
                    new Date(course.getCourseend().getTime()+3600*1000), false);
            schedule.add(courseEvent);
        }

//        System.out.println("tttttttttttttttttttttt");
        for (SchoolActivity activity : schoolActivityList) {
            BasicEvent schoolActivityEvent = schoolActivityFactory.newEvent(activity.getActivityname(), activity.getActivityname(),
                    new Date(activity.getActivitystart().getTime()+3600*1000),
                    new Date(activity.getActivityend().getTime()+3600*1000), false);
//            System.out.println(activity.getActivityname());
            schedule.add(schoolActivityEvent);
        }

        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);

        List<Event> scheduleEventList = schedule.toEventList();
        List<EditableEvent> demostrationList = new ArrayList<>();
        for(Event event:scheduleEventList){
            EditableEvent newevent = new EditableEvent();
            newevent.transfer(event);
            demostrationList.add(newevent);
        }

        return demostrationList;
    }

    //当拖动事件的时候，用于更新的接口
    @RequestMapping(value = "/updateDragging")
    @ResponseBody
    public Event updateDraggingStartandEnd(@RequestBody JSONObject object) {
        switch (object.getString("backgroundColor")) {
            case "#ff4040" -> {
                BasicEvent courseEvent = this.courseEventFactory.newEvent(object.getString("Title"), object.getString("id"),
                        object.getDate("Start"), object.getDate("End"), object.getBoolean("AllDay"));
                this.schedule.remove(object.getString("id"));
                this.schedule.add(courseEvent);
                return courseEvent.toEvent();
            }
            default -> {
                BasicEvent schoolActivity = this.schoolActivityFactory.newEvent(object.getString("Title"), object.getString("id"),
                        object.getDate("Start"), object.getDate("End"), object.getBoolean("AllDay"));
                schoolActivity.setColor(object.getString("backgroundColor"));
                System.out.println(object.getString("id"));
                scheduleService.updateByName(object.getString("id"),schoolActivity.toSchoolActivity());
                this.schedule.remove(object.getString("id"));
                this.schedule.add(schoolActivity);
                return schoolActivity.toEvent();
            }
        }
    }

    //当重新设置事件size的时候，用于更新的接口
    @RequestMapping(value = "/updateResizing")
    @ResponseBody
    public Event updateResizingEnd(@RequestBody JSONObject object) {
        System.out.println("testtttttttttttttttt");
        System.out.println(object.getString("id"));
        switch (object.getString("backgroundColor")) {
            case "#ff4040" -> {
                CourseEventFactory courseEventFactory = new CourseEventFactory();
                BasicEvent courseEvent = courseEventFactory.newEvent(object.getString("Title"), object.getString("id"),
                        object.getDate("Start"), object.getDate("End"), object.getBoolean("AllDay"));
                this.schedule.remove(object.getString("id"));
                this.schedule.add(courseEvent);
                return courseEvent.toEvent();
            }
            default -> {
                BasicEvent schoolActivity = this.schoolActivityFactory.newEvent(object.getString("Title"), object.getString("id"),
                        object.getDate("Start"), object.getDate("End"), object.getBoolean("AllDay"));
                schoolActivity.setColor(object.getString("backgroundColor"));
                scheduleService.updateByName(object.getString("id"),schoolActivity.toSchoolActivity());
                this.schedule.remove(object.getString("id"));
                this.schedule.add(schoolActivity);
                return schoolActivity.toEvent();
            }
        }
    }

    //当从左侧备选事件栏拖动一个新事件到日程表的时候，用于增加的接口
    //插入到数据库，并返回“Activity-”+"Activity数据库中的ID",用于前端回调更新当前新事件在前端的id
    @RequestMapping(value = "/addNewActivity")
    @ResponseBody
    public JSONObject addNewActivity(@RequestBody JSONObject object) {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        JSONObject jsonObject = new JSONObject();
//        switch (object.getString("backgroundColor")) {
//            case "#ff4040" -> {
//                System.out.println(object.getString("backgroundColor"));
//                int newID=courseService.indexNewCourse();
//                CourseEventFactory courseEventFactory = new CourseEventFactory();
//                BasicEvent courseEvent = courseEventFactory.newEvent(object.getString("Title"), object.getString("Title") + "-" + String.valueOf(newID),
//                        object.getDate("Start"), object.getDate("End"), object.getBoolean("AllDay"));
//                this.schedule.add(courseEvent);
////                courseService.addNewCourse(courseEvent.toCourse());
//                return null;
//            }
//            default -> {
        int newID = scheduleService.IndexNewActivity();
        BasicEvent schoolActivity = schoolActivityFactory.newEvent(object.getString("Title"), object.getString("Title") + "-" + String.valueOf(newID),
                object.getDate("Start"), object.getDate("End"), object.getBoolean("AllDay"));
        schoolActivity.setColor(object.getString("backgroundColor"));
        System.out.println(schedule.get(0));
        this.schedule.add(schoolActivity);
        System.out.println(schedule.get(0));
        scheduleService.add(schoolActivity.toSchoolActivity());
        scheduleService.addNewKey(Integer.valueOf((String) session.getAttribute("username")), newID);
        String idToSet = object.getString("Title") + "-" + String.valueOf(newID);
        jsonObject.put("id", idToSet);
        System.out.println(jsonObject);
        return jsonObject;
    }
//        }
//}

    //删除参加的事件的接口
    @RequestMapping(value = "/deleteAttend")
    @ResponseBody
    public Event deleteAttendedActivity(@RequestBody JSONObject object) {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(object.getString("backgroundColor"));
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        switch (object.getString("backgroundColor")) {
            case "#ff4040" -> {
                CourseEventFactory courseEventFactory = new CourseEventFactory();
                BasicEvent courseEvent = courseEventFactory.newEvent(object.getString("Title"), object.getString("id"),
                        object.getDate("Start"), object.getDate("End"), object.getBoolean("AllDay"));
                return courseEvent.toEvent();
            }
            default -> {
                BasicEvent schoolActivity = this.schoolActivityFactory.newEvent(object.getString("Title"), object.getString("id"),
                        object.getDate("Start"), object.getDate("End"), object.getBoolean("AllDay"));
                schoolActivity.setColor(object.getString("backgroundColor"));
                this.schedule.remove(object.getString("id"));
//                this.schedule.remove(schoolActivity);
                Integer sid = Integer.valueOf(object.getString("id").split("-")[1]);
                scheduleService.deleteKey(Integer.valueOf((String) session.getAttribute("username")), sid);
                return schoolActivity.toEvent();
            }
        }
    }

}