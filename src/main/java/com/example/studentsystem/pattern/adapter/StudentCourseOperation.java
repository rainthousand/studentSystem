package com.example.studentsystem.pattern.adapter;

public class StudentCourseOperation {
    public String studentAddSelectedCourse(Integer sid, Integer cid, String judge){
        String studentid = "studentid="+sid;
        String courseid = "courseid="+cid;
        String judgeStr = "judge="+judge;

        return "redirect:/student/addSelected?"+studentid+"&"+courseid+"&"+judgeStr;
    }

    public String studentDeleteSelectedCourse(Integer sid, Integer cid, String judge){
        String studentid = "sid="+sid;
        String courseid = "cid="+cid;
        String judgeStr = "judge="+judge;

        return "redirect:/student/deleteSelected?"+studentid+"&"+courseid+"&"+judgeStr;
    }
}
