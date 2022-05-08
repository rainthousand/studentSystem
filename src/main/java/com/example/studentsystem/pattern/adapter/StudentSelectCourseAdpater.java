package com.example.studentsystem.pattern.adapter;

//Class Adapter
public class StudentSelectCourseAdpater extends StudentCourseOperation implements AdminCourseOperation{
    public String studentToAdminAddSelectCourse(Integer sid, Integer cid, String judge){
        String studentid = "studentid="+sid;
        String courseid = "courseid="+cid;
        String judgeStr = "judge="+judge;
        return "redirect:/admin/addSelected?"+studentid+"&"+courseid+"&"+judgeStr;
    }

    public String studentToAdminDeleteSelectCourse(Integer sid, Integer cid, String judge){
        String studentid = "sid="+sid;
        String courseid = "cid="+cid;
        String judgeStr = "judge="+judge;
        return "redirect:/admin/deleteSelected?"+studentid+"&"+courseid+"&"+judgeStr;
    }
}
