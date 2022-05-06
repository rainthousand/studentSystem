package com.example.studentsystem.pattern.iterator;

import com.example.studentsystem.entity.Course;

public interface Collection {
    public Iterator createIterator();
    public Object get(int index);
    public int size();
    public void addOne(Integer studentid);
    public void removeOne(Integer studentid);
}
