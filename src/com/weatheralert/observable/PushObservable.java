package com.weatheralert.observable;

import com.weatheralert.observer.PushObserver;

/**
 * @author Lizeth Gandarillas
 */
public interface PushObservable extends Observable {
    void notifyPushObservers();

    void registerObserver(PushObserver observer);

    void removeObserver(PushObserver observer);
}
