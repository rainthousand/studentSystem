package com.example.studentsystem.pattern.composite_n_factorymethod;

import java.util.Date;

public class SchoolActivityFactory implements EventFactory {
    private final String COLOR="rgb(158, 95, 255)";
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