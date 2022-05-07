package com.example.studentsystem.pattern.visitor;

public class CoursePageVisitor implements UnitVisitor{
    @Override
    public String visit(AdminUnit adminUnit) {
        return adminUnit.adminCourseRoute();
    }

    @Override
    public String visit(StudentUnit studentUnit) {
        return studentUnit.studentCourseRoute();
    }

    @Override
    public String visit(TeacherUnit teacherUnit) {
        return teacherUnit.teacherCourseRoute();
    }

    @Override
    public String visit(NotRegisteredUnit notRegisteredUnit) {
        return notRegisteredUnit.notRegisteredCourseRoute();
    }
}
