package com.example.studentsystem.pattern.composite_n_factorymethod;

import com.example.studentsystem.entity.Event;

public abstract class ScheduleEvent {
    private String name;
    public abstract Event toEvent();

    public String getName() {
        return name;
    }
}
