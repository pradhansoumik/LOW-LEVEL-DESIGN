/**
 * In this refactor, the SupportHandler class acts as the base class, and each specific support type (General, Billing, Technical, Delivery) will extend the SupportHandler class.
 * This allows us to create a chain of responsibility, where each handler checks if it can process the request and, if not, passes it to the next handler in the chain.
 */
import java.util.*;

// Abstract class defining the SupportHandler
abstract class SupportHandler
{
    protected SupportHandler nextHandler;

    // Method to set the next handler in the chain
    public void setNextHandler(SupportHandler nextHandler)
    {
        this.nextHandler = nextHandler;
    }

    // Abstract method to handle the request
    public abstract void handleRequest(String requestType);
}

// Concrete Handler for General Support
class GeneralSupport extends SupportHandler
{
    public void handleRequest(String requestType)
    {
        if (requestType.equalsIgnoreCase("general")) {
            System.out.println("GeneralSupport: Handling general query");
        }
        else if (nextHandler != null) {
            nextHandler.handleRequest(requestType);
        }
    }
}

// Concrete Handler for Billing Support
class BillingSupport extends SupportHandler
{
    public void handleRequest(String requestType)
    {
        if (requestType.equalsIgnoreCase("refund")) {
            System.out.println("BillingSupport: Handling refund request");
        }
        else if (nextHandler != null) {
            nextHandler.handleRequest(requestType);
        }
    }
}

// Concrete Handler for Technical Support
class TechnicalSupport extends SupportHandler
{
    public void handleRequest(String requestType)
    {
        if (requestType.equalsIgnoreCase("technical")) {
            System.out.println("TechnicalSupport: Handling technical issue");
        }
        else if (nextHandler != null) {
            nextHandler.handleRequest(requestType);
        }
    }
}

// Concrete Handler for Delivery Support
class DeliverySupport extends SupportHandler
{
    public void handleRequest(String requestType)
    {
        if (requestType.equalsIgnoreCase("delivery")) {
            System.out.println("DeliverySupport: Handling delivery issue");
        }
        else if (nextHandler != null) {
            nextHandler.handleRequest(requestType);
        }
        else {
            System.out.println("DeliverySupport: No handler found for request");
        }
    }
}

// Client Code
class Main
{
    public static void main(String[] args)
    {
        SupportHandler general = new GeneralSupport();
        SupportHandler billing = new BillingSupport();
        SupportHandler technical = new TechnicalSupport();
        SupportHandler delivery = new DeliverySupport();

        // Setting up the chain: general -> billing -> technical -> delivery
        general.setNextHandler(billing);
        billing.setNextHandler(technical);
        technical.setNextHandler(delivery);

        // Testing the chain of responsibility with different request types
        general.handleRequest("refund");
        general.handleRequest("delivery");
        general.handleRequest("unknown");
    }
}
/**
  How Chain of Responsibility Fixes the Previously Discussed Issues

    Issue - Solution in Refactored Code

     * Violation of the Open-Closed Principle - Now, new types of requests can be handled by adding a new handler class without modifying the existing code. Each handler is open for extension and closed for modification.
     * Monolithic Code - The logic is now separated into individual handler classes, each responsible for one type of request, making the code more modular and easier to maintain.
     * Scalability and Flexibility - The chain of responsibility allows new handlers to be easily added without changing the existing logic. The order of handling can be changed by simply rearranging the chain.

 */