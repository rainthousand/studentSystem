package com.example.studentsystem.pattern.iterator;

import com.example.studentsystem.entity.Course;

public class ListIterator implements Iterator {

    private Collection collection;
    private int pos = -1;
    public ListIterator(Collection collection) {
        this.collection = collection;
    }

    @Override
    public Object previous() {
        if(pos>0){
            pos--;
        }
        return collection.get(pos);
    }

    @Override
    public Object next() {
        if(pos<collection.size()-1){
            pos++;
        }
        return collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        if(pos<collection.size()-1){
            return true;
        }
        return false;
    }

    @Override
    public Object first() {
        pos = 0;
        return collection.get(pos);
    }

    @Override
    public void add(Integer temp) {
        collection.addOne(temp);
    }

    @Override
    public void remove(Integer temp){
        collection.removeOne(temp);
    }

    @Override
    public Integer size() {
        return collection.size();
    }

}