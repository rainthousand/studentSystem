package com.example.studentsystem.pattern.visitor;

import com.example.studentsystem.pattern.visitor.unitClasses.AdminUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.NotRegisteredUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.StudentUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.TeacherUnit;

public interface UnitVisitor {
    public String visit(AdminUnit adminUnit);
    public String visit(StudentUnit studentUnit);
    public String visit(TeacherUnit teacherUnit);
    public String visit(NotRegisteredUnit notRegisteredUnit);
}
