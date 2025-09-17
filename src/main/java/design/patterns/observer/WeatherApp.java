package design.patterns.observer;

// WeatherApp.java
public class WeatherApp {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        weatherStation.addObserver(currentDisplay);
        weatherStation.addObserver(forecastDisplay);

        System.out.println("Setting initial temperature to 25°C");
        weatherStation.setTemperature(25.0f);

        System.out.println("\nSetting temperature to 28°C");
        weatherStation.setTemperature(28.0f);

        System.out.println("\nRemoving CurrentConditionsDisplay observer");
        weatherStation.removeObserver(currentDisplay);

        System.out.println("\nSetting temperature to 27°C");
        weatherStation.setTemperature(27.0f);
    }
}