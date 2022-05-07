package com.example.studentsystem.entity;

public class EditableEvent extends Event{
    private boolean startEditable;
    private boolean durationEditable;

    public boolean isStartEditable() {
        return startEditable;
    }

    public void setStartEditable(boolean startEditable) {
        this.startEditable = startEditable;
    }

    public boolean isDurationEditable() {
        return durationEditable;
    }

    public void setDurationEditable(boolean durationEditable) {
        this.durationEditable = durationEditable;
    }

    public void transfer(Event event){
        this.setTitle(event.getTitle());
        this.setStart(event.getStart());
        this.setAllDay(event.isAllDay());
        this.setBackgroundColor(event.getBackgroundColor());
        this.setBorderColor(event.getBorderColor());
        this.setEnd(event.getEnd());
        this.setId(event.getId());
        if(event.getId().startsWith("Course")){
            this.setStartEditable(false);
            this.setDurationEditable(false);
        }else{
            this.setStartEditable(true);
            this.setDurationEditable(true);
        }
    }
}
