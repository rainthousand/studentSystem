package com.example.studentsystem.entity;

public class SelectedCourseKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column selectedcourse.courseID
     *
     * @mbggenerated Sun Apr 24 21:11:13 BST 2022
     */
    private Integer courseid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column selectedcourse.studentID
     *
     * @mbggenerated Sun Apr 24 21:11:13 BST 2022
     */
    private Integer studentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column selectedcourse.courseID
     *
     * @return the value of selectedcourse.courseID
     *
     * @mbggenerated Sun Apr 24 21:11:13 BST 2022
     */
    public Integer getCourseid() {
        return courseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column selectedcourse.courseID
     *
     * @param courseid the value for selectedcourse.courseID
     *
     * @mbggenerated Sun Apr 24 21:11:13 BST 2022
     */
    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column selectedcourse.studentID
     *
     * @return the value of selectedcourse.studentID
     *
     * @mbggenerated Sun Apr 24 21:11:13 BST 2022
     */
    public Integer getStudentid() {
        return studentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column selectedcourse.studentID
     *
     * @param studentid the value for selectedcourse.studentID
     *
     * @mbggenerated Sun Apr 24 21:11:13 BST 2022
     */
    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }
}