package model;

public class WeatherData {
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

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getSeaLevel() {
        return seaLevel;
    }
}
