package com.weatheralert;

import com.weatheralert.observable.WeatherStation;
import com.weatheralert.observer.EmergencyPanel;
import com.weatheralert.observer.MobileApp;
import com.weatheralert.observer.WeatherLogger;

/**
 * @author Lizeth Gandarillas
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE ALERTA METEOROLÓGICA ===");
        System.out.println("Demostración del patrón Observer\n");

        WeatherStation weatherStation = new WeatherStation();

        System.out.println("\n=> Registrando observadores:");
        MobileApp mobileApp = new MobileApp(weatherStation, "Liz");
        EmergencyPanel emergencyPanel = new EmergencyPanel(weatherStation, "Centro");
        WeatherLogger weatherLogger = new WeatherLogger(weatherStation);

        weatherStation.setMeasurements(25.5f, 65.0f, 1013.1f);

        pauseExecution(1);

        weatherStation.setMeasurements(38.7f, 92.5f, 998.3f);

        pauseExecution(1);

        System.out.println("\n=> Desuscribiendo la aplicación móvil:");
        weatherStation.removeObserver(mobileApp);

        weatherStation.setMeasurements(22.3f, 70.1f, 1011.5f);

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
        System.out.println("\nCOMPARACIÓN DE MÉTODOS:");
        System.out.println("✅ MÉTODO FRÍO (PULL):");
        System.out.println("  - El sujeto solo notifica que hay cambios");
        System.out.println("  - El observador solicita explícitamente los datos");
        System.out.println("  - Mayor autonomía del observador");
        System.out.println("  - Menor acoplamiento");
        System.out.println("  - Útil cuando solo se necesita una parte de los datos");

        System.out.println("\n✅ MÉTODO CALIENTE (PUSH):");
        System.out.println("  - El sujeto envía todos los datos directamente");
        System.out.println("  - El observador recibe pasivamente los datos");
        System.out.println("  - Mayor eficiencia en la transferencia de datos");
        System.out.println("  - Menor código en el observador");
        System.out.println("  - Útil cuando se necesitan todos los datos de inmediato");
    }

    private static void pauseExecution(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
