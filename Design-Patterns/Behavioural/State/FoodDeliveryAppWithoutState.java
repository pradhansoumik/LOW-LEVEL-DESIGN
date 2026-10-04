/**
 * Understanding The Problem
 * Let's assume we are building a food delivery app, and we need to manage the different states of an order. The order can transition between multiple states, such as placed, preparing, out for delivery, and delivered.
 *
 * Below is a simplified version of how we might implement this without using the State Pattern:
 */
import java.util.*;

class Order
{
    private String state;

    // Constructor initializes the state to ORDER_PLACED
    public Order()
    {
        this.state = "ORDER_PLACED";
    }

    // Method to cancel the order
    // only allows cancellation if in ORDER_PLACED or PREPARING states
    public void cancelOrder()
    {
        if (state.equals("ORDER_PLACED") || state.equals("PREPARING")) {
            state = "CANCELLED";
            System.out.println("Order has been cancelled.");
        }
        else {
            System.out.println("Cannot cancel the order now.");
        }
    }

    // Method to move the order to the next state based on its current state
    public void nextState()
    {
        switch (state)
        {
            case "ORDER_PLACED":
                state = "PREPARING";
                break;
            case "PREPARING":
                state = "OUT_FOR_DELIVERY";
                break;
            case "OUT_FOR_DELIVERY":
                state = "DELIVERED";
                break;
            default:
                System.out.println("No next state from: " + state);
                return;
        }
        System.out.println("Order moved to: " + state);
    }

    // Getter for the state
    public String getState() {
        return state;
    }
}

class Main
{
    // Main method to test the order flow
    public static void main(String[] args)
    {
        Order order = new Order();

        // Display initial state
        System.out.println("Initial State: " + order.getState());

        // Moving through states
        order.nextState(); // ORDER_PLACED -> PREPARING
        order.nextState(); // PREPARING -> OUT_FOR_DELIVERY
        order.nextState(); // OUT_FOR_DELIVERY -> DELIVERED

        // Attempting to cancel an order after it is out for delivery
        order.cancelOrder(); // Should not allow cancellation

        // Display final state
        System.out.println("Final State: " + order.getState());
    }
}
/**
  :: Issues In The Code ::

     * State Transition Management: The state transitions are hardcoded in the nextState() method using a switch statement. This approach becomes cumbersome if new states need to be added.
     * Lack of Encapsulation: The state transition logic and cancel behavior are directly handled within the Order class. This violates the Single Responsibility Principle by combining multiple responsibilities within a single class.
     * Code Duplication: The logic for the cancelOrder() and nextState() methods could lead to duplicate logic if more states and actions are added.
     * Missing Flexibility for Future Changes: Adding new states or changing existing behaviors can be error-prone and cumbersome, as the Order class needs to be updated each time.

 */