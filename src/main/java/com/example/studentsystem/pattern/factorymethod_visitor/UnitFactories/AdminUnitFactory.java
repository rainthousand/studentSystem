package com.example.studentsystem.pattern.factorymethod_visitor.UnitFactories;

import com.example.studentsystem.pattern.factorymethod_visitor.UnitFactory;
import com.example.studentsystem.pattern.visitor.Unit;
import com.example.studentsystem.pattern.visitor.unitClasses.AdminUnit;

public class AdminUnitFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new AdminUnit();
    }
}
