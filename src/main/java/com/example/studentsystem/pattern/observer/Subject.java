package com.example.studentsystem.pattern.observer;

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
     */
    public void notify(String message);

}
