package com.example.studentsystem.pattern.observer;

import java.util.HashMap;
import java.util.List;

public interface Subject {
    /**
     * add new observer
     *
     * @param observer
     */
    public void attach(Observer observer);

    /**
     * delete a observer
     *
     * @param observer
     */
    public void detach(Observer observer);

    /**
     * notify observers their updates
     *
     * @return
     */

    List<List<Integer>> publishAndNotify(Integer newsid);
}
