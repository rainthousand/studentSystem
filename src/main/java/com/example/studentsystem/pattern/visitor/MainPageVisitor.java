package com.example.studentsystem.pattern.visitor;

public class MainPageVisitor implements UnitVisitor{
    @Override
    public String visit(AdminUnit adminUnit) {
        return adminUnit.adminURL2();
    }

    @Override
    public String visit(StudentUnit studentUnit) {
        return studentUnit.studentURL2();
    }

    @Override
    public String visit(TeacherUnit teacherUnit) {
        return teacherUnit.teacherURL2();
    }

    @Override
    public String visit(NotRegisteredUnit notRegisteredUnit) {
        return notRegisteredUnit.notRegisteredURL1();
    }
}
