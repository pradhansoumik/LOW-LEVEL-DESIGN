
interface IShape {
    double getArea();
}
class Rectangle implements IShape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}
class Circle implements IShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class OCPDriver {
    public static void main(String[] args) {
        System.out.println("**************** Open Closed Principle ****************");

        Rectangle rec1 = new Rectangle(8,5);
        Rectangle rec2 = new Rectangle(10,6);
        System.out.println("Rectangle Area Comparison: " + compare(rec1, rec2));
        Circle cir1 = new Circle(3);
        Circle cir2 = new Circle(4);
        System.out.println("Circle Area Comparison: " + compare(cir1, cir2));
        //suppose I want to compare area of circle with area of rectangle then I need to define another compare function.
        //every time I want to compare between two different shapes I need to modify existing code by adding new compare function.
        //this will violate open closed principle as I need to modify existing code to add new functionality
        //System.out.println("*** OCP violation example ***");
        System.out.println("New Functionality -> "+compare(rec1, cir1));
        System.out.println("************************* END ******************************");

    }

    /**
     * after applying OCP
     */
    public static double compare(IShape s1, IShape s2) {
        return s2.getArea() - s1.getArea();
    }
}