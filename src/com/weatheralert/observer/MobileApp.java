package com.weatheralert.observer;

import com.weatheralert.model.WeatherData;
import com.weatheralert.observable.WeatherStation;

/**
 * @author Lizeth Gandarillas
 */
public class MobileApp implements PullObserver {
    private WeatherStation weatherStation;
    private String userId;

    public MobileApp(WeatherStation weatherStation, String userId) {
        this.weatherStation = weatherStation;
        this.userId = userId;
        weatherStation.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("\n📱 App Móvil (Usuario: " + userId + ")");
        System.out.println("▶️ MÉTODO FRÍO (PULL): Solicitando datos a la estación...");

        WeatherData data = weatherStation.getWeatherData();

        System.out.println("Temperatura actual: " + data.getTemperature() + "°C");

        if (data.getTemperature() > 30) {
            System.out.println("⚠️ Alerta: Temperatura elevada");
        }
    }
}
