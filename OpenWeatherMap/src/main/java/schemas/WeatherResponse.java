package schemas;

import java.util.List;

public class WeatherResponse {
    private String source;
    private int count;
    private List<WeatherData> weatherItems;

    public static class WeatherData {
        private double tempMin;
        private double tempMax;
        private int pressure;
        private int humidity;
        private int seaLevel;

        public WeatherData(double tempMin, double tempMax, int pressure, int humidity, int seaLevel) {
            this.tempMin = tempMin;
            this.tempMax = tempMax;
            this.pressure = pressure;
            this.humidity = humidity;
            this.seaLevel = seaLevel;
        }
    }

    public WeatherResponse(String source, int count, List<WeatherData> weatherItems) {
        this.source = source;
        this.count = count;
        this.weatherItems = weatherItems;
    }
}
