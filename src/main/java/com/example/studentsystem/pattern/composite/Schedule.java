package com.example.studentsystem.pattern.composite;

import com.example.studentsystem.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class Schedule extends Event {
    private String name;
    private List<Event> eventList = new ArrayList<Event>();

    Schedule(String name) {
        this.name = name;
    }

    public void addEvent(Event event) {

    }

    public void removeEvent(Event event) {

    }

    public void clear() {

    }

}
