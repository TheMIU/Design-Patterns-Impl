package O1_creational_design_patterns.factory;

//***** Products *****
// Abstract Product Interface
interface Vehicle {
    void drive();
}

// Concrete Product: Car
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a Car");
    }
}

// Concrete Product: Motorcycle
class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a Bike");
    }
}

//***** Factory Interface *****
interface VehicleFactory {
    Vehicle createVehicle(String type);
}

//***** Concrete Factory *****
class VehicleFactoryImpl implements VehicleFactory {
    @Override
    public Vehicle createVehicle(String type) {
        switch (type) {
            case "Car":
                return new Car();
            case "Bike":
                return new Bike();
            default:
                return null;
        }
    }
}

//////////////////////////////////////////////////
// usage
class FactoryTest {
    public static void main(String[] args) {
        VehicleFactoryImpl vehicleFactory = new VehicleFactoryImpl();

        // create Car
        Vehicle car = vehicleFactory.createVehicle("Car");
        car.drive();

        // create Motorcycle
        Vehicle bike = vehicleFactory.createVehicle("Bike");
        bike.drive();
    }
}