package com.weatheralert.observer;

import com.weatheralert.model.WeatherData;

/**
 * @author Lizeth Gandarillas
 */
public interface PushObserver extends Observer {
    void update(WeatherData data);
}
