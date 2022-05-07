package com.example.studentsystem.pattern.factorymethod_visitor.UnitFactories;

import com.example.studentsystem.pattern.factorymethod_visitor.UnitFactory;
import com.example.studentsystem.pattern.visitor.Unit;
import com.example.studentsystem.pattern.visitor.unitClasses.NotRegisteredUnit;

public class NotRegisteredUnitFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new NotRegisteredUnit();
    }
}
