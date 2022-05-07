package com.example.studentsystem.pattern.visitor;

public class SelectedCoursePageVisitor implements UnitVisitor{
    @Override
    public String visit(AdminUnit adminUnit) {
        return adminUnit.adminSelectedRoute();
    }

    @Override
    public String visit(StudentUnit studentUnit) {
        return studentUnit.studentSelectedRoute();
    }

    @Override
    public String visit(TeacherUnit teacherUnit) {
        return teacherUnit.teacherSelectedRoute();
    }

    @Override
    public String visit(NotRegisteredUnit notRegisteredUnit) {
        return notRegisteredUnit.notRegisteredSelectedRoute();
    }
}
