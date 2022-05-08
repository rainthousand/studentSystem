package com.example.studentsystem.pattern.composite_n_factorymethod;

import com.example.studentsystem.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class Schedule extends ScheduleEvent{
    List<ScheduleEvent> scheduleEventList=new ArrayList<>();
    @Override
    public Event toEvent(){
        return null;
    }
    public List<Event> toEventList() {
        List<Event> eventList = new ArrayList<>();
        for (ScheduleEvent event: scheduleEventList) {
            eventList.add(event.toEvent());
        }
        return eventList;
    }

    public void add(ScheduleEvent e) {
        this.scheduleEventList.add(e);
    }

    public void remove(String name) {
        scheduleEventList.removeIf(event -> event.getName().equals(name));
    }

    public ScheduleEvent get(int idx) {
        return this.scheduleEventList.get(idx);
    }
    public void clear(){
        scheduleEventList.clear();
    }
}
