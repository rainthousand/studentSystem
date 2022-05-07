package com.example.studentsystem.pattern.composite;

import com.example.studentsystem.entity.Event;
import com.example.studentsystem.entity.SchoolActivity;

import java.util.Date;

public class BasicEvent extends ScheduleEvent {
    private String name;
    private Date start;
    private Date end;
    private String color;
    private Boolean isAllDay;
    private String id;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Event toEvent() {
        Event event = new Event();
        event.setTitle(name);
        event.setStart(start);
        event.setEnd(end);
        event.setBackgroundColor(color);
        event.setBorderColor(color);
        event.setAllDay(isAllDay);
        event.setId(id);
        return event;
    }

    public SchoolActivity toSchoolActivity() {
        SchoolActivity schoolActivity = new SchoolActivity();
        schoolActivity.setActivityname(id);
        schoolActivity.setActivitystart(start);
        schoolActivity.setActivityend(end);
        schoolActivity.setActivitydescription(name);
        schoolActivity.setActivityday(1);
//    if (name.length()==1)
        Integer aid = Integer.valueOf(id.split("-")[1]);
        schoolActivity.setActivityid(aid);
        return schoolActivity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Boolean getAllDay() {
        return isAllDay;
    }

    public void setAllDay(Boolean allDay) {
        isAllDay = allDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
