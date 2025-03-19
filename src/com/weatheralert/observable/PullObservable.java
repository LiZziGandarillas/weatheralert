package com.weatheralert.observable;

import com.weatheralert.observer.PullObserver;

/**
 * @author Lizeth Gandarillas
 */
public interface PullObservable extends Observable {
    void notifyPullObservers();

    void registerObserver(PullObserver observer);

    void removeObserver(PullObserver observer);
}
