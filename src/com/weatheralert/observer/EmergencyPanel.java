package com.weatheralert.observer;

import com.weatheralert.model.WeatherData;
import com.weatheralert.observable.WeatherStation;

/**
 * @author Lizeth Gandarillas
 */
public class EmergencyPanel implements PushObserver {
    private String location;

    public EmergencyPanel(WeatherStation weatherStation, String location) {
        this.location = location;
        weatherStation.registerObserver(this);
    }

    @Override
    public void update(WeatherData data) {
        System.out.println("\n🚨 Panel de Emergencia (" + location + ")");
        System.out.println("▶️ MÉTODO CALIENTE (PUSH): Recibiendo datos automáticamente");

        System.out.println("Datos recibidos: " + data);

        boolean isEmergency = false;
        StringBuilder alertMessage = new StringBuilder("⚠️ ALERTA: ");

        if (data.getTemperature() > 35) {
            alertMessage.append("Temperatura extrema (" + data.getTemperature() + "°C) ");
            isEmergency = true;
        }

        if (data.getHumidity() > 90) {
            alertMessage.append("Humedad crítica (" + data.getHumidity() + "%) ");
            isEmergency = true;
        }

        if (data.getPressure() < 1000) {
            alertMessage.append("Presión baja (" + data.getPressure() + " hPa) ");
            isEmergency = true;
        }

        if (isEmergency) {
            System.out.println(alertMessage.toString());
            System.out.println("🚒 Activando protocolos de emergencia");
        } else {
            System.out.println("✅ Condiciones normales. No se requieren acciones.");
        }
    }
}
