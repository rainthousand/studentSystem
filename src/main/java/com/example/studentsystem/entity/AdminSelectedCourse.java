package com.example.studentsystem.entity;

public class AdminSelectedCourse {

    private Integer courseid;
    private String coursename;
    private Integer studentid;
    private String studentname;
    private Integer mark;

    public AdminSelectedCourse(Integer courseid,String coursename,Integer studentid,String studentname,Integer mark){
        this.courseid = courseid;
        this.coursename = coursename;
        this.studentid = studentid;
        this.studentname = studentname;
        this.mark = mark;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
