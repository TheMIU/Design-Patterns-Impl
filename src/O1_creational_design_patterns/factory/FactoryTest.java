package O1_creational_design_patterns.factory;

// Factory Interface (superclass)
interface Shape {
    void draw();
}

// Products (subclass Circle)
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Products (subclass Rectangle)
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Concrete Factories
class ShapeFactory {
    // Factory method to create object
    // Shape <- most super type
    public Shape createShape(String shapeType) {

        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }

        return null;
    }
}

//////////////////////////////////////////////////
class FactoryTest {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // create Circle
        Shape circle = shapeFactory.createShape("Circle");
        circle.draw();

        // create Rectangle
        Shape rectangle = shapeFactory.createShape("Rectangle");
        rectangle.draw();
    }
}