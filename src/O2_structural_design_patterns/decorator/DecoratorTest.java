package O2_structural_design_patterns.decorator;

// Key Component 1: Shape Interface represents the component interface
interface Shape {
    void draw();
}

// Key Component 2: Concrete Component (Circle)
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Key Component 2: Concrete Component (Rectangle)
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Key Component 3: Decorator (abstract class) - ShapeDecorator
abstract class ShapeDecorator implements Shape {
    protected Shape decoratorShape;

    // Constructor to set the component to be decorated
    public ShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    // Delegating the draw operation to the component
    public void draw() {
        decoratorShape.draw();
    }
}

// Key Component 4: Concrete Decorator (RedShapeDecorator)
class RedShapeDecorator extends ShapeDecorator {
    // Constructor to set the component to be decorated
    public RedShapeDecorator(Shape decoratorShape) {
        super(decoratorShape);
    }

    // Overrides the draw method to add additional behavior (setting red border)
    @Override
    public void draw() {
        decoratorShape.draw(); // Delegating to the component
        setRedBorder(decoratorShape);
    }

    // Additional behavior specific to this decorator
    public void setRedBorder(Shape redBorder) {
        System.out.println("Border color: RED");
    }
}

// Test class
class DecoratorTest {
    public static void main(String[] args) {
        // Creating instances of Concrete Components
        Shape rectangle = new Rectangle();
        rectangle.draw();
        
        Shape circle = new Circle();
        circle.draw();

        System.out.println("=========================");

        // Creating instances of Concrete Decorators
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        redRectangle.draw();
        
        Shape redCircle = new RedShapeDecorator(new Circle());
        redCircle.draw();
    }
}