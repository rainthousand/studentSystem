package com.example.studentsystem.pattern.decorator;

import com.example.studentsystem.entity.Course;

import java.util.Date;

public class BasicCourse implements CourseInterface{
    private Integer courseid;
    private String coursename;
    private Integer teacherid;
    private String coursetime;
    private String classroom;
    private Integer courseweek;
    private String coursetype;
    private Integer majorid;
    private Integer credit;
    private Date coursestart;
    private Date courseend;

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

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Integer getCourseweek() {
        return courseweek;
    }

    public void setCourseweek(Integer courseweek) {
        this.courseweek = courseweek;
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Date getCoursestart() {
        return coursestart;
    }

    public void setCoursestart(Date coursestart) {
        this.coursestart = coursestart;
    }

    public Date getCourseend() {
        return courseend;
    }

    public void setCourseend(Date courseend) {
        this.courseend = courseend;
    }

    @Override
    public Course courseMajor(Course course) {
        course.setMajorid(0);
        return course;
    }
}
