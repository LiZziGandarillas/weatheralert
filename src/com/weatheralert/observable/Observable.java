package com.weatheralert.observable;

/**
 * @author Lizeth Gandarillas
 */
public interface Observable {
    void registerObserver(Object observer);
    void removeObserver(Object observer);
}
