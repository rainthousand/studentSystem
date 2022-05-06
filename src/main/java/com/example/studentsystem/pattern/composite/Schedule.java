package com.example.studentsystem.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Schedule implements Event {
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

    @Override
    public void show() {

    }
}
