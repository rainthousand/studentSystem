package com.example.studentsystem.pattern.observer;

import java.util.HashMap;
import java.util.List;

public interface Subject {
    public void attach(Observer observer);
    public void detach(Observer observer);
    List<List<Integer>> publishAndNotify(Integer newsid);
}
