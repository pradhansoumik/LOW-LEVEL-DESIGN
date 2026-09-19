// Interface
interface Shape {
    void draw();
}

// Class implementing the Shape Interface
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Class implementing the Shape Interface
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

// Factory Class
class ShapeFactory {
    /* Method that takes the type of shape as input
    and returns the cirresponding object */
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

// Driver code
class Main {
    public static void main(String[] args) {
        // Object of ShapeFactory is initialized
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get a Circle object and call its draw method
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        // Get a Square object and call its draw method
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
    }
}
