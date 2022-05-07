package com.example.studentsystem.pattern.visitor;

import com.example.studentsystem.pattern.visitor.unitClasses.AdminUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.NotRegisteredUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.StudentUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.TeacherUnit;

public class IndexPageVisitor implements UnitVisitor{
    @Override
    public String visit(AdminUnit adminUnit) {
        return adminUnit.adminIndexRoute();
    }

    @Override
    public String visit(StudentUnit studentUnit) {
        return studentUnit.studentIndexRoute();
    }

    @Override
    public String visit(TeacherUnit teacherUnit) {
        return teacherUnit.teacherIndexRoute();
    }

    @Override
    public String visit(NotRegisteredUnit notRegisteredUnit) {
        return notRegisteredUnit.notRegisteredIndexRoute();
    }
}
