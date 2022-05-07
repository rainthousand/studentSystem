package com.example.studentsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.studentsystem.entity.Course;
import com.example.studentsystem.entity.Event;
import com.example.studentsystem.entity.NewsLetter;
import com.example.studentsystem.entity.SchoolActivity;
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
    @Resource(name = "newsletterServiceImpl")
    private NewsletterService newsletterService;

    private Schedule schedule=new Schedule();
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

        for (Course course : selectedCourseList) {
//            CourseEvent courseEvent=new CourseEvent(course.getCoursename(),course.getCoursestart(),course.getCourseend(),
//                    "#ff4040","#ff4040",false,"Course-"+Integer.toString(course.getCourseid()));
            Event events1 = new Event();
            events1.setTitle(course.getCoursename());
            events1.setStart(course.getCoursestart());
            events1.setEnd(course.getCourseend());
            events1.setAllDay(false);
            events1.setBackgroundColor("#ff4040");
            events1.setBorderColor("#ff4040");
            //id设置为Course-(Courseid)
            //"-"后是数据库里的ID
            events1.setId("Course-" + Integer.toString(course.getCourseid()));
            events.add(events1);
        }

        for (SchoolActivity activity : schoolActivityList) {
            Event events1 = new Event();
            //Event.Title对应Activity.name
            events1.setTitle(activity.getActivityname());
            //Event.Start对应Activity.start
            events1.setStart(activity.getActivitystart());
            //Event.End对应Activity.end
            events1.setEnd(activity.getActivityend());
            //Event.AllDay
            events1.setAllDay(false);
            //Event.BackgroundColor
            events1.setBackgroundColor("#9e5fff");
            //Event.BorderColor
            events1.setBorderColor("#9e5fff");
            //id 设置为Activity-(ActivityId)
            //"-"后是数据库里的ID
            events1.setId("Activity-" + Integer.toString(activity.getActivityid()));
            events.add(events1);
        }
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);
        return events;
    }

    //当拖动事件的时候，用于更新的接口
    //将composite模式融合，更新数据库
    @RequestMapping(value = "/updateDragging")
    @ResponseBody
    public Event updateDraggingStartandEnd(@RequestBody JSONObject object) {

        switch (object.getString("backgroundColor")) {
            case "#ff4040" -> {
                CourseEventFactory courseEventFactory = new CourseEventFactory();
                BasicEvent courseEvent=courseEventFactory.newEvent(object.getString("Title"), object.getString("id"),
                        object.getDate("Start"),object.getDate("End"),object.getBoolean("AllDay"));
                this.schedule.add(courseEvent);
                return courseEvent.toEvent();
            }
            case "#9e5fff" -> {
                SchoolActivityFactory schoolActivityFactory = new SchoolActivityFactory();
                BasicEvent schoolActivity=schoolActivityFactory.newEvent(object.getString("Title"), object.getString("id"),
                        object.getDate("Start"),object.getDate("End"),object.getBoolean("AllDay"));
                this.schedule.add(schoolActivity);
                return schoolActivity.toEvent();
            }
            default -> {
                Event event = new Event();
                event.setTitle(object.getString("Title"));
                event.setStart(object.getDate("Start"));
                event.setEnd(object.getDate("End"));
                event.setBackgroundColor(object.getString("backgroundColor"));
                event.setBorderColor(object.getString("borderColor"));
                event.setAllDay(object.getBoolean("AllDay"));
                event.setId(object.getString("id"));
                return event;
            }
        }
    }

    //当重新设置事件size的时候，用于更新的接口
    //TODO 将composite模式融合，更新数据库
    @RequestMapping(value = "/updateResizing")
    @ResponseBody
    public Event updateResizingEnd(@RequestBody JSONObject object) {
//        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//        Event event = new Event();
//        event.setTitle(object.getString("Title"));
//        event.setStart(object.getDate("Start"));
//        event.setEnd(object.getDate("End"));
//        event.setBackgroundColor(object.getString("backgroundColor"));
//        event.setBorderColor(object.getString("borderColor"));
//        event.setAllDay(object.getBoolean("AllDay"));
//        event.setId(object.getString("id"));
//
////        System.out.println(event.getId());
//        return event;
        switch (object.getString("backgroundColor")) {
            case "#ff4040" -> {
                CourseEventFactory courseEventFactory = new CourseEventFactory();
                BasicEvent courseEvent=courseEventFactory.newEvent(object.getString("Title"), object.getString("id"),
                        object.getDate("Start"),object.getDate("End"),object.getBoolean("AllDay"));
                this.schedule.add(courseEvent);
                return courseEvent.toEvent();
            }
            case "#9e5fff" -> {
                SchoolActivityFactory schoolActivityFactory = new SchoolActivityFactory();
                BasicEvent schoolActivity=schoolActivityFactory.newEvent(object.getString("Title"), object.getString("id"),
                        object.getDate("Start"),object.getDate("End"),object.getBoolean("AllDay"));
                this.schedule.add(schoolActivity);
                return schoolActivity.toEvent();
            }
            default -> {
                Event event = new Event();
                event.setTitle(object.getString("Title"));
                event.setStart(object.getDate("Start"));
                event.setEnd(object.getDate("End"));
                event.setBackgroundColor(object.getString("backgroundColor"));
                event.setBorderColor(object.getString("borderColor"));
                event.setAllDay(object.getBoolean("AllDay"));
                event.setId(object.getString("id"));
                return event;
            }
        }
    }

    //当从左侧备选事件栏拖动一个新事件到日程表的时候，用于增加的接口
    //将composite模式融合，插入到数据库，并返回“Activity-”+"Activity数据库中的ID",用于前端回调更新当前新事件在前端的id
    @RequestMapping(value = "/addNewActivity")
    @ResponseBody
    public JSONObject addNewActivity(@RequestBody JSONObject object) {
//        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//        Event event = new Event();
//        event.setTitle(object.getString("Title"));
//        event.setStart(object.getDate("Start"));
//        event.setEnd(object.getDate("End"));
//        event.setBackgroundColor(object.getString("backgroundColor"));
//        event.setBorderColor(object.getString("borderColor"));
//        event.setAllDay(object.getBoolean("AllDay"));
//        event.setId(object.getString("id"));
//        System.out.println(JSON.toJSONString(event));
        //todo get from session
        Integer currUsername = 10001;
        int tempID = -1;
        switch (object.getString("backgroundColor")) {
            case "#ff4040" -> {
                List<Course> selectedCourseList = courseService.findAllCourseByStudentid(currUsername);

                for (Course course : selectedCourseList) {
                    int courseID = course.getCourseid();
                    if (courseID > tempID) tempID = courseID;
                }
                CourseEventFactory courseEventFactory = new CourseEventFactory();
                BasicEvent courseEvent=courseEventFactory.newEvent(object.getString("Title"),  object.getString("Title") + "-" + String.valueOf(tempID + 1),
                        object.getDate("Start"),object.getDate("End"),object.getBoolean("AllDay"));
                this.schedule.add(courseEvent);
//                return object.getString("Title") + "-" + String.valueOf(tempID + 1);
                return null;
            }
            case "rgb(158, 95, 255)" -> {
//                List<SchoolActivity> schoolActivityList = scheduleService.findAllActivity();
//                for (SchoolActivity schoolActivity : schoolActivityList) {
//                    int schoolActivityID = schoolActivity.getActivityid();
//                    if (schoolActivityID > tempID) tempID = schoolActivityID;
//                }
                JSONObject jsonObject=new JSONObject();
                int newID=scheduleService.IndexNewActivity();
                SchoolActivityFactory schoolActivityFactory = new SchoolActivityFactory();
                BasicEvent schoolActivity=schoolActivityFactory.newEvent(object.getString("Title"), object.getString("Title") + "-" + String.valueOf(newID),
                        object.getDate("Start"),object.getDate("End"),object.getBoolean("AllDay"));
                this.schedule.add(schoolActivity);

                scheduleService.add(schoolActivity.toSchoolActivity());
                System.out.println(object.getString("Title") + "-" + String.valueOf(newID));
                String idToSet=object.getString("Title") + "-" + String.valueOf(newID);
                jsonObject.put("id",idToSet);
                System.out.println(jsonObject);
                return jsonObject;
            }
            default -> {
                System.out.println(object.getString("backgroundColor"));
                System.out.println("ttttttttttt");
                return null;
            }
        }
    }

    //删除参加的事件的接口
    //将composite模式融合，删除数据库记录
    @RequestMapping(value = "/deleteAttend")
    @ResponseBody
    public Event deleteAttendedActivity(@RequestBody JSONObject object) {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(object);
//        Event event = new Event();
//        event.setTitle(object.getString("Title"));
//        event.setStart(object.getDate("Start"));
//        event.setEnd(object.getDate("End"));
//        event.setBackgroundColor(object.getString("backgroundColor"));
//        event.setBorderColor(object.getString("borderColor"));
//        event.setAllDay(object.getBoolean("AllDay"));
//        event.setId(object.getString("id"));
//        System.out.println(JSON.toJSONString(event));
//        //TODO 删除数据库对应的参加记录
////        System.out.println(event.getId());
//        return event;
        switch (object.getString("backgroundColor")) {
            case "#ff4040" -> {
                CourseEventFactory courseEventFactory = new CourseEventFactory();
                BasicEvent courseEvent=courseEventFactory.newEvent(object.getString("Title"),object.getString("id"),
                        object.getDate("Start"),object.getDate("End"),object.getBoolean("AllDay"));
                this.schedule.add(courseEvent);
                return courseEvent.toEvent();
            }
            case "#9e5fff" -> {
                SchoolActivityFactory schoolActivityFactory = new SchoolActivityFactory();
                BasicEvent schoolActivity=schoolActivityFactory.newEvent(object.getString("Title"), object.getString("id"),
                        object.getDate("Start"),object.getDate("End"),object.getBoolean("AllDay"));
                this.schedule.add(schoolActivity);
                return schoolActivity.toEvent();
            }
            default -> {
                Event event = new Event();
                event.setTitle(object.getString("Title"));
                event.setStart(object.getDate("Start"));
                event.setEnd(object.getDate("End"));
                event.setBackgroundColor(object.getString("backgroundColor"));
                event.setBorderColor(object.getString("borderColor"));
                event.setAllDay(object.getBoolean("AllDay"));
                event.setId(object.getString("id"));
                return event;
            }
        }
    }

}