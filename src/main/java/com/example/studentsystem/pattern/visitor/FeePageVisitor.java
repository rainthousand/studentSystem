package com.example.studentsystem.pattern.visitor;

import com.example.studentsystem.pattern.visitor.unitClasses.AdminUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.NotRegisteredUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.StudentUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.TeacherUnit;

public class FeePageVisitor implements UnitVisitor{
    @Override
    public String visit(AdminUnit adminUnit) {
        return adminUnit.adminFeeRoute();
    }

    @Override
    public String visit(StudentUnit studentUnit) {
        return studentUnit.studentFeeRoute();
    }

    @Override
    public String visit(TeacherUnit teacherUnit) {
        return teacherUnit.teacherFeeRoute();
    }

    @Override
    public String visit(NotRegisteredUnit notRegisteredUnit) {
        return notRegisteredUnit.notRegisteredFeeRoute();
    }
}
