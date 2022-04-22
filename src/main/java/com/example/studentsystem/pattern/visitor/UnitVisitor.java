package com.example.studentsystem.pattern.visitor;

public interface UnitVisitor {
    public String visit(AdminUnit adminUnit);
    public String visit(StudentUnit studentUnit);
    public String visit(TeacherUnit teacherUnit);
}
