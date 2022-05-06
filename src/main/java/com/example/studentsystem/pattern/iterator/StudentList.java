package com.example.studentsystem.pattern.iterator;

import com.example.studentsystem.entity.Course;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentList implements Collection{

    public ArrayList<Integer> data = new ArrayList<Integer>();
    @Override
    public Iterator createIterator() {
        return new ListIterator(this);
    }

    @Override
    public Object get(int index) {
        return data.get(index);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void addOne(Integer studentid){
        data.add(studentid);
    }

    @Override
    public void removeOne(Integer studentid) {
        data.remove(studentid);
    }
}