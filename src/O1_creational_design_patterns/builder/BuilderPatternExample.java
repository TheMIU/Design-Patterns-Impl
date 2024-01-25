package O1_creational_design_patterns.builder;

// Product class
class Car {
    String make;
    String model;
    int year;
    boolean isSportsCar;

    public Car(String make, String model, int year, boolean isSportsCar) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.isSportsCar = isSportsCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", isSportsCar=" + isSportsCar +
                '}';
    }
}

// Builder interface
interface CarBuilder {
    CarBuilder setMake(String make);

    CarBuilder setModel(String model);

    CarBuilder setYear(int year);

    CarBuilder setSportsCar(boolean isSportsCar);

    Car build();
}

// Concrete builder class
class CarBuilderImpl implements CarBuilder {
    private Car car;

    public CarBuilderImpl() {
        this.car = new Car("", "", 0, false);
    }

    @Override
    public CarBuilder setMake(String make) {
        car.make = make;
        return this;
    }

    @Override
    public CarBuilder setModel(String model) {
        car.model = model;
        return this;
    }

    @Override
    public CarBuilder setYear(int year) {
        car.year = year;
        return this;
    }

    @Override
    public CarBuilder setSportsCar(boolean isSportsCar) {
        car.isSportsCar = isSportsCar;
        return this;
    }

    @Override
    public Car build() {
        return car;
    }
}

// Example usage
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Using the builder directly
        Car car = new CarBuilderImpl()
                .setMake("Ford")
                .setModel("Mustang")
                .setYear(2024)
                .setSportsCar(true)
                .build();
        System.out.println(car);
        // Car{make='Ford', model='Mustang', year=2024, isSportsCar=true}
    }
}