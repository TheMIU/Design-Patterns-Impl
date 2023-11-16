package O2_structural_design_patterns.facade;

//***** Subsystems *****
// Subsystem interface
interface Lights {
    void turnOn();
    void turnOff();
}

// Subsystem classes
class LivingRoomLights implements Lights {
    @Override
    public void turnOn() {
        System.out.println("Living room lights turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Living room lights turned off");
    }
}

// ***** Facade *****
// Facade interface
interface HomeAutomation {
    void turnOnLights();
    void turnOffLights();
}


// Facade class
class HomeAutomationFacade implements HomeAutomation {
    private Lights livingRoomLights;

    // Initialize subsystems in the constructor
    public HomeAutomationFacade() {
        livingRoomLights = new LivingRoomLights();
    }

    // Facade method to turn on lights
    @Override
    public void turnOnLights() {
        livingRoomLights.turnOn();
    }

    // Facade method to turn off lights
    @Override
    public void turnOffLights() {
        livingRoomLights.turnOff();
    }
}

//////////////////////////////////////////////////
// ***** Client *****
public class FacadeTest {
    public static void main(String[] args) {
        // Create a HomeAutomation instance
        HomeAutomation homeAutomation = new HomeAutomationFacade();

        // Use the HomeAutomation to interact with the smart home subsystems
        homeAutomation.turnOnLights();
        homeAutomation.turnOffLights();
    }
}
