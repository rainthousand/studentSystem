package com.example.studentsystem.pattern.factorymethod_visitor;

import com.example.studentsystem.pattern.visitor.UnitVisitor;

public interface VisitorFactory {
    public UnitVisitor createVisitor();
}
