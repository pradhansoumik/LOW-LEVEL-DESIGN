/**
 * BAD Design
 */
class Rectangle1 {
    public double length;
    public double width;

    public Rectangle1(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double getArea() {
        return length * width;
    }
}
class Circle1 {
    public double radius;

    public Circle1(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
class OCPMain {
    public static void main(String[] args) {
        System.out.println("**************** Open Closed Principle ****************");

        Rectangle1 rec1 = new Rectangle1(8,5);
        Rectangle1 rec2 = new Rectangle1(10,6);
        System.out.println("Rectangle Area Comparison: " + compare(rec1, rec2));
        Circle1 cir1 = new Circle1(3);
        Circle1 cir2 = new Circle1(4);
        System.out.println("Circle Area Comparison: " + compare(cir1, cir2));
        //suppose I want to compare area of circle with area of rectangle then I need to define another compare function.
        //every time I want to compare between two different shapes I need to modify existing code by adding new compare function.
        //this will violate open closed principle as I need to modify existing code to add new functionality

        //System.out.println("*** OCP violation example ***");
        //System.out.println("New Functionality -> "+compare(rec1, cir1));
        System.out.println("************************* END ******************************");

    }
    public static double compare(Rectangle1 rec1, Rectangle1 rec2) {
        return rec2.getArea() - rec1.getArea();
    }
    public static double compare(Circle1 cir1, Circle1 cir2) {
        return cir2.getArea() - cir1.getArea();
    }

}
