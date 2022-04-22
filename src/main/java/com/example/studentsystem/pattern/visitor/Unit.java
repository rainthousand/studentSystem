package com.example.studentsystem.pattern.visitor;

public interface Unit {
    String accept(UnitVisitor visitor);
}
