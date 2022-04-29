package com.example.studentsystem.entity;


import java.util.Date;

public class Event {
    //id为区分是Course还是Activity,格式为Course-courseid或者Activity-acitivityid,如:Course-2,代表Course表的id为2的课程
    private String id;
    private String Title;
    //    private Integer Id;
    private String backgroundColor;
    private String borderColor;
    private Date Start;
    private Date End;
    private boolean AllDay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }


    public boolean isAllDay() {
        return AllDay;
    }

    public void setAllDay(boolean allDay) {
        AllDay = allDay;
    }



    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

//    public Integer getId() {
//        return Id;
//    }
//
//    public void setId(Integer id) {
//        Id = id;
//    }

    public Date getStart() {
        return Start;
    }

    public void setStart(Date start) {
        Start = start;
    }

    public Date getEnd() {
        return End;
    }

    public void setEnd(Date end) {
        End = end;
    }
}
