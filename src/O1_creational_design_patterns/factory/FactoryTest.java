package O1_creational_design_patterns.factory;

//***** Products *****
// Abstract Product Interface
interface Shape {
    void draw();
}

// Concrete Product: Circle
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Concrete Product: Rectangle
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

//***** Factory Interface *****
interface ShapeFactory {
    Shape createShape(String shapeType);
}

//***** Concrete Factory *****
class ShapeFactoryImpl implements ShapeFactory {

    @Override
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
        ShapeFactoryImpl shapeFactory = new ShapeFactoryImpl();

        // create Circle
        Shape circle = shapeFactory.createShape("Circle");
        circle.draw();

        // create Rectangle
        Shape rectangle = shapeFactory.createShape("Rectangle");
        rectangle.draw();
    }
}