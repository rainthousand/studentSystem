package com.example.studentsystem.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure
{
    private List<Unit> list = new ArrayList<>();
    public List<String> accept(UnitVisitor visitor)
    {
        List<String> res = new ArrayList<String>();
        list.forEach((e) -> {
            res.add(e.accept(visitor));
        });
//        list.forEach(t->t.accept(visitor));
        return res;
    }


    public void add(Unit element)
    {
        list.add(element);
    }
}