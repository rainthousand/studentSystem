package com.example.studentsystem.pattern.composite;

import com.example.studentsystem.entity.Event;

import java.util.Date;

public interface EventFactory {
    public BasicEvent newEvent(String name, String id, Date start, Date end, Boolean isAllDay);
}
