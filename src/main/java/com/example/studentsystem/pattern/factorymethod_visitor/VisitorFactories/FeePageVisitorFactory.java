package com.example.studentsystem.pattern.factorymethod_visitor.VisitorFactories;

import com.example.studentsystem.pattern.factorymethod_visitor.VisitorFactory;
import com.example.studentsystem.pattern.visitor.FeePageVisitor;
import com.example.studentsystem.pattern.visitor.UnitVisitor;

public class FeePageVisitorFactory implements VisitorFactory {
    @Override
    public UnitVisitor createVisitor() {
        return new FeePageVisitor();
    }
}
