package O3_behavioral_design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

// ***** Subject (Observable) *****
// Subject (Observable) interface
interface WeatherStation {
    void attach(WeatherObserver observer);

    void detach(WeatherObserver observer);

    void setWeatherData(int temperature, int windSpeed);

    void notifyObservers();
}

// ***** Concrete Subject *****
class WeatherStationImpl implements WeatherStation {
    // Collection of observers
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;
    private int windSpeed;

    @Override
    public void attach(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void setWeatherData(int temperature, int windSpeed) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            // update each observer
            observer.update(temperature, windSpeed);
        }
    }
}

// ***** Observer interface *****
interface WeatherObserver {
    void update(int temperature, int windSpeed);
}

// ***** Concrete Observer *****
// Concrete Observer PhoneApp
class PhoneApp implements WeatherObserver {
    @Override
    public void update(int temperature, int windSpeed) {
        System.out.println("===== Phone App =========");
        System.out.println("Temperature : " + temperature);
        System.out.println("Wind Speed  : " + windSpeed);
    }
}

// Concrete Observer DisplayBoard
class DisplayBoard implements WeatherObserver {
    @Override
    public void update(int temperature, int windSpeed) {
        System.out.println("===== Display Board =====");
        System.out.println("Temperature : " + temperature);
        System.out.println("Wind Speed  : " + windSpeed);
    }
}

//////////////////////////////////////////////////
// Usage
class ObserverTest {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStationImpl();

        PhoneApp phoneApp = new PhoneApp();
        DisplayBoard displayBoard = new DisplayBoard();

        weatherStation.attach(phoneApp);
        weatherStation.attach(displayBoard);

        // Simulate weather changes
        weatherStation.setWeatherData(10, 20);
        System.out.println("#### weather change #####");
        weatherStation.setWeatherData(15, 25);
    }
}
