package O2_structural_design_patterns.decorator;

// ***** Component Interface *****
interface Shape {
    void draw();
}

// ***** Concrete Components *****
// Concrete Component (Circle)
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Concrete Component (Rectangle)
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// ***** Decorator *****
abstract class ShapeDecorator implements Shape {
    protected Shape decoratorShape;

    // set the component to be decorated
    public ShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    // Delegating(පැවරීම) the draw operation to the component
    public void draw() {
        decoratorShape.draw();
    }
}

// ***** Concrete Decorator *****
// Concrete Decorator (RedShapeDecorator)
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

//////////////////////////////////////////////////
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