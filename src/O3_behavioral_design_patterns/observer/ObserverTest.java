package O3_behavioral_design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface WeatherObserver {
    void update(int temperature, int windSpeed);
}

// Subject (Observable)
class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;
    private int windSpeed;

    public void attach(WeatherObserver observer) {
        observers.add(observer);
    }

    public void setWeatherData(int temperature, int windSpeed) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, windSpeed);
        }
    }
}

// ConcreteObserver PhoneApp
class PhoneApp implements WeatherObserver {
    @Override
    public void update(int temperature, int windSpeed) {
        System.out.println("Phone App: Temperature is " + temperature + "°C, Wind Speed is " + windSpeed + " km/h");
    }
}

// ConcreteObserver DisplayBoard
class DisplayBoard implements WeatherObserver {
    @Override
    public void update(int temperature, int windSpeed) {
        System.out.println(
                "Display Board: Current Weather - Temp: " + temperature + "°C, Wind Speed: " + windSpeed + " km/h");
    }
}

// Usage
class ObserverTest {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        PhoneApp phoneApp = new PhoneApp();
        DisplayBoard displayBoard = new DisplayBoard();

        weatherStation.attach(phoneApp);
        weatherStation.attach(displayBoard);

        // Simulate weather changes
        weatherStation.setWeatherData(25, 10);
    }
}
