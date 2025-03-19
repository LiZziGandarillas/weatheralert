package com.weatheralert.observer;

import com.weatheralert.model.WeatherData;
import com.weatheralert.observable.WeatherStation;

/**
 * @author Lizeth Gandarillas
 */
public class WeatherLogger implements PullObserver, PushObserver {
    private WeatherStation weatherStation;

    public WeatherLogger(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.registerObserver((PullObserver) this);
        weatherStation.registerObserver((PushObserver) this);
    }

    @Override
    public void update() {
        System.out.println("\n📝 Sistema de Registro");
        System.out.println("▶️ MÉTODO FRÍO (PULL): Solicitando datos específicos...");

        WeatherData data = weatherStation.getWeatherData();

        System.out.println("[" + java.time.LocalDateTime.now() + "] REGISTRO-PULL: " +
                "T=" + data.getTemperature() + "°C");
    }

    @Override
    public void update(WeatherData data) {
        System.out.println("\n📝 Sistema de Registro");
        System.out.println("▶️ MÉTODO CALIENTE (PUSH): Recibiendo datos completos...");

        System.out.println("[" + java.time.LocalDateTime.now() + "] REGISTRO-PUSH: " +
                "T=" + data.getTemperature() + "°C, " +
                "H=" + data.getHumidity() + "%, " +
                "P=" + data.getPressure() + " hPa");
    }
}
