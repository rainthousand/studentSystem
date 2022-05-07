package com.example.studentsystem.pattern.composite;

import com.example.studentsystem.entity.Event;

import java.util.Date;

public abstract class ScheduleEvent {
    private String name;
    public abstract Event toEvent();

    public String getName() {
        return name;
    }
}
