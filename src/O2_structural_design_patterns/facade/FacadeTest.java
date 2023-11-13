package O2_structural_design_patterns.facade;

//***** Subsystems *****
// Subsystem interface
interface Shape {
    void draw();
}

// Subsystem classes
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// ***** Facade *****
// Facade interface
interface ShapeMaker {
    void drawCircle();
    void drawRectangle();
}

// Facade class
class ShapeMakerImpl implements ShapeMaker {
    private Shape circle;
    private Shape rectangle;

    // Initialize subsystems in the constructor
    public ShapeMakerImpl() {
        circle = new Circle();
        rectangle = new Rectangle();
    }

    // Facade method to draw a circle
    @Override
    public void drawCircle() {
        circle.draw();
    }

    // Facade method to draw a rectangle
    @Override
    public void drawRectangle() {
        rectangle.draw();
    }

}

//////////////////////////////////////////////////
// ***** Client *****
public class FacadeTest {
    public static void main(String[] args) {
        // Create a Facade instance
        ShapeMaker shapeMaker = new ShapeMakerImpl();

        // Use the Facade to interact with the subsystems
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
    }
}
