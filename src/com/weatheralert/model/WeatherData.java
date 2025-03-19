package com.weatheralert.model;

/**
 * @author Lizeth Gandarillas
 */
public class WeatherData {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    @Override
    public String toString() {
        return String.format("Temperatura: %.1f°C, Humedad: %.1f%%, Presión: %.1f hPa",
                temperature, humidity, pressure);
    }
}
