package com.example.studentsystem.pattern.composite;

import com.example.studentsystem.entity.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schedule extends ScheduleEvent{
    List<ScheduleEvent> scheduleEventList=new ArrayList<>();
    @Override
    public Event toEvent() {
        return null;
    }
    public void show() {
        for (ScheduleEvent s: scheduleEventList) {
//            s.toEvent();
        }
    }

    public void add(ScheduleEvent b) {
        this.scheduleEventList.add(b);
    }

    public void remove(ScheduleEvent b) {
        this.scheduleEventList.remove(b);
    }

    public ScheduleEvent get(int idx) {
        return this.scheduleEventList.get(idx);
    }
}
