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
class Motorcycle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a Motorcycle");
    }
}

//***** Factory Interface *****
interface VehicleFactory {
    Vehicle createVehicle(String vehicleType);
}

//***** Concrete Factory *****
class VehicleFactoryImpl implements VehicleFactory {
    @Override
    public Vehicle createVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("CAR")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("MOTORCYCLE")) {
            return new Motorcycle();
        }
        return null;
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
        Vehicle motorcycle = vehicleFactory.createVehicle("Motorcycle");
        motorcycle.drive();
    }
}