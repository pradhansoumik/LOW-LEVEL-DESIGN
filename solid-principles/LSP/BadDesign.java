// Rectangle class
class RectangleNew
{
    int width, height;

    void setWidth(int w) { width = w; }
    void setHeight(int h) { height = h; }
    int getArea() { return width * height; }
}

// Square class extending the Rectangle class
class Square extends RectangleNew
{
    @Override
    void setWidth(int w)
    {
        width = w;
        height = w; // makes it a square
    }

    @Override
    void setHeight(int h)
    {
        height = h;
        width = h; // makes it a square
    }
}

// Main class
class Main
{
    //  main method
    public static void main(String args[]) {
        // Replacing object of Rectangle class with Square class
        RectangleNew r = new Square();

        // Method call to print the area of the rectangle
        printArea(r);
    }

    // Method to print the area of the given rectangle object
    private static void printArea(RectangleNew r) {
        r.setWidth(5);
        r.setHeight(10);
        System.out.println(r.getArea()); // Expected: 50 but Actual: 100
    }
}

