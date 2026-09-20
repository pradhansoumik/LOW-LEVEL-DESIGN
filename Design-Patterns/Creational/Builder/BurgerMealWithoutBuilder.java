import java.util.*;

// Represents a customizable Burger Meal
class BurgerMeal
{
    // Mandatory components
    private String bun;
    private String patty;

    // Optional components
    private String sides;
    private List<String> toppings;
    private boolean cheese;

    // Constructor trying to handle all combinations
    public BurgerMeal(String bun, String patty, String sides, List<String> toppings, boolean cheese) {
        this.bun = bun;
        this.patty = patty;
        this.sides = sides;
        this.toppings = toppings;
        this.cheese = cheese;
    }
}

class Main
{
    public static void main(String[] args)
    {
        // Constructing the object with only required details
        BurgerMeal burgerMeal = new BurgerMeal("wheat", "veg", null, null, false);
    }
}

/**
 * Issues in Code:
 * This constructor approach works, but it creates multiple problems:
 * Hard to Read and Maintain:
 * The user has to remember the order of parameters and their types. It becomes difficult to read when more optional parameters are added.
 * Unnecessary null values:
 * Even if the user doesn’t want toppings or sides, they still have to pass null explicitly. This clutters the object creation code.
 * Risk of NullPointerException:
 * If we forget to null-check before accessing optional values inside the class, it may lead to runtime exceptions.
 * Too Many Constructor Overloads:
 * To handle various combinations (e.g., with cheese, without sides, only toppings, etc.), you’d need to create multiple overloaded constructors - which is not scalable.
 * Tight Coupling Between Parameters and Construction:
 * There is no flexibility to set values step by step. The entire object must be built in one go, which doesn't match the natural way of ordering or customizing a burger.
 */
