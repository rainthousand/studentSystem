package com.example.studentsystem.pattern.factorymethod_visitor.VisitorFactories;

import com.example.studentsystem.pattern.factorymethod_visitor.VisitorFactory;
import com.example.studentsystem.pattern.visitor.SelectedCoursePageVisitor;
import com.example.studentsystem.pattern.visitor.UnitVisitor;

public class SelectedCoursePageVisitorFactory implements VisitorFactory {
    @Override
    public UnitVisitor createVisitor() {
        return new SelectedCoursePageVisitor();
    }
}
