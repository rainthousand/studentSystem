package com.example.studentsystem.pattern.composite_n_factorymethod;

import java.util.Date;

public interface EventFactory {
    public BasicEvent newEvent(String name, String id, Date start, Date end, Boolean isAllDay);
}
