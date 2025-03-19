package com.weatheralert.observable;

import com.weatheralert.model.WeatherData;
import com.weatheralert.observer.PullObserver;
import com.weatheralert.observer.PushObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lizeth Gandarillas
 */
public class WeatherStation implements PullObservable, PushObservable {
    private WeatherData weatherData;
    private List<PullObserver> pullObservers = new ArrayList<>();
    private List<PushObserver> pushObservers = new ArrayList<>();

    public WeatherStation() {
        this.weatherData = new WeatherData(0, 0, 0);
    }

    @Override
    public void registerObserver(Object observer) {
        if (observer instanceof PullObserver) {
            registerObserver((PullObserver) observer);
        }
        if (observer instanceof PushObserver) {
            registerObserver((PushObserver) observer);
        }
    }

    @Override
    public void registerObserver(PullObserver observer) {
        if (!pullObservers.contains(observer)) {
            pullObservers.add(observer);
            System.out.println("🔔 Nuevo observador PULL registrado");
        }
    }

    @Override
    public void registerObserver(PushObserver observer) {
        if (!pushObservers.contains(observer)) {
            pushObservers.add(observer);
            System.out.println("🔔 Nuevo observador PUSH registrado");
        }
    }

    @Override
    public void removeObserver(Object observer) {
        if (observer instanceof PullObserver) {
            removeObserver((PullObserver) observer);
        }
        if (observer instanceof PushObserver) {
            removeObserver((PushObserver) observer);
        }
    }

    @Override
    public void removeObserver(PullObserver observer) {
        pullObservers.remove(observer);
        System.out.println("🔕 Observador PULL eliminado");
    }

    @Override
    public void removeObserver(PushObserver observer) {
        pushObservers.remove(observer);
        System.out.println("🔕 Observador PUSH eliminado");
    }

    @Override
    public void notifyPullObservers() {
        System.out.println("\n📣 NOTIFICACIÓN MÉTODO FRÍO (PULL)");
        System.out.println("La estación meteorológica informa: 'Hay nuevos datos disponibles'");
        System.out.println("Los observadores deben solicitar los datos que necesitan");

        for (PullObserver observer : pullObservers) {
            observer.update();
        }
    }

    @Override
    public void notifyPushObservers() {
        System.out.println("\n📣 NOTIFICACIÓN MÉTODO CALIENTE (PUSH)");
        System.out.println("La estación meteorológica envía datos: " + weatherData);

        for (PushObserver observer : pushObservers) {
            observer.update(weatherData);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        System.out.println("\n🌡️ NUEVAS MEDICIONES: T=" + temperature + "°C, H=" + humidity + "%, P=" + pressure + " hPa");
        this.weatherData = new WeatherData(temperature, humidity, pressure);

        notifyPullObservers();
        notifyPushObservers();
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }
}
