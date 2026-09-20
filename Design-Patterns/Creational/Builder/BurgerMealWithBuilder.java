import java.util.*;

// Represents a customizable Burger Meal
class BurgerMeal
{
    // Required components
    private final String bunType;
    private final String patty;

    // Optional components
    private final boolean hasCheese;
    private final List<String> toppings;
    private final String side;
    private final String drink;

    // Private constructor to force use of Builder
    private BurgerMeal(BurgerBuilder builder)
    {
        this.bunType = builder.bunType;
        this.patty = builder.patty;
        this.hasCheese = builder.hasCheese;
        this.toppings = builder.toppings;
        this.side = builder.side;
        this.drink = builder.drink;
    }

    // Static nested Builder class
    public static class BurgerBuilder
    {
        // Required
        private final String bunType;
        private final String patty;

        // Optional
        private boolean hasCheese;
        private List<String> toppings;
        private String side;
        private String drink;

        // Builder constructor with required fields
        public BurgerBuilder(String bunType, String patty) {
            this.bunType = bunType;
            this.patty = patty;
        }

        // Method to set cheese
        public BurgerBuilder withCheese(boolean hasCheese) {
            this.hasCheese = hasCheese;
            return this;
        }

        // Method to set toppings
        public BurgerBuilder withToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        // Method to set side
        public BurgerBuilder withSide(String side) {
            this.side = side;
            return this;
        }

        // Method to set drink
        public BurgerBuilder withDrink(String drink) {
            this.drink = drink;
            return this;
        }

        // Final build method
        public BurgerMeal build()
        {
            return new BurgerMeal(this);
        }
    }
}

class Main
{
    public static void main(String[] args)
    {
        // Creating burger with only required fields
        BurgerMeal plainBurger = new BurgerMeal.BurgerBuilder("wheat", "veg")
                .build();

        // Burger with cheese only
        BurgerMeal burgerWithCheese = new BurgerMeal.BurgerBuilder("wheat", "veg")
                .withCheese(true)
                .build();

        // Fully loaded burger
        List<String> toppings = Arrays.asList("lettuce", "onion", "jalapeno");
        BurgerMeal loadedBurger = new BurgerMeal.BurgerBuilder("multigrain", "chicken")
                .withCheese(true)
                .withToppings(toppings)
                .withSide("fries")
                .withDrink("coke")
                .build();
    }
}
/**
 * Understanding the Code:
 *
 * Private Constructor: The constructor of BurgerMeal is made private so that object creation is restricted to the Builder only.
 *
 * Nested Static BurgerBuilder Class:
 * This builder class holds the same fields as BurgerMeal. It ensures immutability and keeps construction controlled.
 *
 * Fluent API Style:
 * Each method (like withCheese, withSide) returns the builder itself, enabling method chaining in a fluent and readable manner.
 *
 * Selective Configuration:
 * Only required fields (bunType, patty) are passed to the builder's constructor. Everything else is optional and set via withXYZ() methods.
 *
 * Final Step: build()
 * Once all desired fields are set, calling .build() finalizes the object construction and returns the BurgerMeal instance.
 */