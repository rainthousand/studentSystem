package com.example.studentsystem.pattern.composite;

import com.example.studentsystem.entity.Event;

import java.util.Date;

public class SchoolActivityFactory implements EventFactory {
    private final String COLOR="9e5fff";
    public BasicEvent newEvent(String name,String id, Date start, Date end, Boolean isAllDay) {
        BasicEvent basicEvent=new BasicEvent();
        basicEvent.setName(name);
        basicEvent.setStart(start);
        basicEvent.setEnd(end);
        basicEvent.setColor(COLOR);
        basicEvent.setAllDay(isAllDay);
        basicEvent.setId(id);
        return basicEvent;
    }
}