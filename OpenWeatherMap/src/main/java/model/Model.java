package model;

import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.Random;

public class Model {
    public List<WeatherData> getWeather(@NotNull String city) {
        // Generamos datos de prueba con valores aleatorios
        Random random = new Random();
        double tempMin = 15 + random.nextDouble() * 10; // Entre 15 y 25°C
        double tempMax = tempMin + random.nextDouble() * 5; // Siempre mayor que tempMin
        int pressure = 1000 + random.nextInt(50); // Entre 1000 y 1050 hPa
        int humidity = 50 + random.nextInt(50); // Entre 50% y 100%
        int seaLevel = 1013 + random.nextInt(20); // Entre 1013 y 1033 hPa

        return List.of(new WeatherData(tempMin, tempMax, pressure, humidity, seaLevel));
    }
}
