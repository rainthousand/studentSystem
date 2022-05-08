package com.example.studentsystem.pattern.adapter;

public interface AdminCourseOperation {
    String studentToAdminAddSelectCourse(Integer sid, Integer cid, String judge);
    String studentToAdminDeleteSelectCourse(Integer sid, Integer cid, String judge);
}
