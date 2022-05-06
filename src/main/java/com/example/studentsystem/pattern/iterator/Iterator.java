package com.example.studentsystem.pattern.iterator;

import com.example.studentsystem.entity.Course;

public interface Iterator {
    public Object previous();
    public Object next();
    public boolean hasNext();
    public Object first();
    public void add(Integer temp);
    public void remove(Integer temp);
    public Integer size();
}
