/**
 * Solution
 * The previous code can be improved using the State Pattern. Below is the refactored code implementing the State Pattern:
 */

import java.util.*;

// OrderContext class manages the current state of the order
class OrderContext
{
    private OrderState currentState;

    // Constructor initializes the state to ORDER_PLACED
    public OrderContext()
    {
        this.currentState = new OrderPlacedState(); // default state
    }

    // Method to set a new state for the order
    public void setState(OrderState state)
    {
        this.currentState = state;
    }

    // Method to move the order to the next state
    public void next()
    {
        currentState.next(this);
    }

    // Method to cancel the order
    public void cancel()
    {
        currentState.cancel(this);
    }

    // Method to get the current state of the order
    public String getCurrentState()
    {
        return currentState.getStateName();
    }
}

// OrderState interface defines the behavior of the order states
interface OrderState
{
    void next(OrderContext context); // Move to the next state
    void cancel(OrderContext context); // Cancel the order
    String getStateName(); // Get the name of the state
}

// Concrete states for each stage of the order

// OrderPlacedState handles the behavior when the order is placed
class OrderPlacedState implements OrderState
{
    public void next(OrderContext context)
    {
        context.setState(new PreparingState());
        System.out.println("Order is now being prepared.");
    }

    public void cancel(OrderContext context)
    {
        context.setState(new CancelledState());
        System.out.println("Order has been cancelled.");
    }

    public String getStateName()
    {
        return "ORDER_PLACED";
    }
}

// PreparingState handles the behavior when the order is being prepared
class PreparingState implements OrderState
{
    public void next(OrderContext context)
    {
        context.setState(new OutForDeliveryState());
        System.out.println("Order is out for delivery.");
    }

    public void cancel(OrderContext context)
    {
        context.setState(new CancelledState());
        System.out.println("Order has been cancelled.");
    }

    public String getStateName()
    {
        return "PREPARING";
    }
}

// OutForDeliveryState handles the behavior when the order is out for delivery
class OutForDeliveryState implements OrderState
{
    public void next(OrderContext context)
    {
        context.setState(new DeliveredState());
        System.out.println("Order has been delivered.");
    }

    public void cancel(OrderContext context)
    {
        System.out.println("Cannot cancel. Order is out for delivery.");
    }

    public String getStateName()
    {
        return "OUT_FOR_DELIVERY";
    }
}

// DeliveredState handles the behavior when the order is delivered
class DeliveredState implements OrderState
{
    public void next(OrderContext context)
    {
        System.out.println("Order is already delivered.");
    }

    public void cancel(OrderContext context)
    {
        System.out.println("Cannot cancel a delivered order.");
    }

    public String getStateName()
    {
        return "DELIVERED";
    }
}

// CancelledState handles the behavior when the order is cancelled
class CancelledState implements OrderState
{
    public void next(OrderContext context) {
        System.out.println("Cancelled order cannot move to next state.");
    }

    public void cancel(OrderContext context)
    {
        System.out.println("Order is already cancelled.");
    }

    public String getStateName()
    {
        return "CANCELLED";
    }
}

public class Main
{
    public static void main(String[] args)
    {
        OrderContext order = new OrderContext();

        // Display initial state
        System.out.println("Current State: " + order.getCurrentState());

        // Moving through states
        order.next();  // ORDER_PLACED -> PREPARING
        order.next();  // PREPARING -> OUT_FOR_DELIVERY
        order.cancel(); // Should fail, as order is out for delivery
        order.next();  // OUT_FOR_DELIVERY -> DELIVERED
        order.cancel(); // Should fail, as order is delivered

        // Display final state
        System.out.println("Final State: " + order.getCurrentState());
    }
}
/**
 How This Solves The Issues:

     * Issue - Solution with State Pattern
     * State Transition Management - The transitions are now handled by the respective state classes, making it easy to add new states or modify transitions without altering the OrderContext class. Each state handles its own behavior.
     * Lack of Encapsulation - Each state is now encapsulated in its own class, adhering to the Single Responsibility Principle and ensuring better maintainability.
     * Code Duplication - The behavior for each state is encapsulated in the corresponding class, avoiding duplicate logic for state transitions and cancellations.
     * Flexibility for Future Changes - New states can be added easily by creating new classes implementing the OrderState interface, without modifying existing code. This follows the Open/Closed Principle.

 */