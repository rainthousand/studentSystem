package com.example.studentsystem.pattern.visitor;

import com.example.studentsystem.pattern.visitor.unitClasses.AdminUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.NotRegisteredUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.StudentUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.TeacherUnit;

public class BaseVisitor implements UnitVisitor{
    @Override
    public String visit(AdminUnit adminUnit) {
        return adminUnit.adminURL1();
    }

    @Override
    public String visit(StudentUnit studentUnit) {
        return studentUnit.studentURL1();
    }

    @Override
    public String visit(TeacherUnit teacherUnit) {
        return teacherUnit.teacherURL1();
    }

    @Override
    public String visit(NotRegisteredUnit notRegisteredUnit) {
        return notRegisteredUnit.notRegisteredURL1();
    }
}
