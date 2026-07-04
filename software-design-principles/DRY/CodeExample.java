import java.util.*;

/**
 * BAD Example - DRY: Don't Repeat Yourself
 */
class BadExample
{
    public static void main(String[] args)
    {
        int length1 = 10, width1 = 5;
        int area1 = length1 * width1;
        System.out.println("Area1: " + area1);

        int length2 = 8, width2 = 4;
        int area2 = length2 * width2;
        System.out.println("Area2: " + area2);
    }
}

/**
 * GOOD Example - DRY: Don't Repeat Yourself
 */
class GoodExample
{
    public static void main(String[] args)
    {
        int area1 = AreaCalculator.calculateArea(10, 5);
        int area2 = AreaCalculator.calculateArea(8, 4);

        System.out.println("Area1: " + area1);
        System.out.println("Area2: " + area2);
    }
}
class AreaCalculator
{
    public static int calculateArea(int length, int width)
    {
        return length * width;
    }
}
