import java.util.*;
/**
 * Implementing Dependency Injection:
 *
 * In the previous section, we discussed the issues in the OrderService class.
 * Now, let's see how we can fix these issues using Dependency Injection (DI).
 *
 * Here is the refactored code using Dependency Injection:
 */

/**
 * Solutions:
 * 1. Loose Coupling
 * 2. Testability
 * 3. Scalability
 */
class OrderService2
{

    private InventoryService inventory;
    private PaymentService payment;
    private NotificationService notification;

    // Constructor Injection - Dependencies are injected through the constructor
    public OrderService2(InventoryService inventory, 
                         PaymentService payment,
                         NotificationService notification) {
        this.inventory = inventory;
        this.payment = payment;
        this.notification = notification;
    }

    public void checkout(Order order) {
        inventory.blockItems(order);
        payment.process(order);
        notification.sendConfirmation(order);
    }

}

// Client-side code
class Client
{
    public static void main(String[] args)
    {

        // Injecting dependencies manually (Constructor Injection)
        OrderService2 orderService2 = new OrderService2(
            new InventoryService(), 
            new RazorpayPayment(), 
            new NotificationService()
        );
        
        // Now, we can use the orderService2 to perform operations
        orderService2.checkout(order);
    }
}
/**
 Let's understand how the above code fixes the earlier discussed issues.

 1. Loose Coupling: In the refactored code, the OrderService2 class no longer creates its dependencies internally. Instead, it receives the required services (InventoryService, PaymentService, and NotificationService) via its constructor.
                    This decouples the class from specific implementations, which makes it more flexible.
 2. Testability:    Since the dependencies are injected, we can now easily provide mock implementations of these services for testing.
                    For example, while testing, we could pass mock services instead of real ones, avoiding the need to hit actual payment gateways or databases.
 3. Scalability:    If we want to switch from Razorpay to Stripe (or any other payment provider), we only need to inject the new PaymentService implementation without touching the OrderService2 class.
                    This makes the system easier to extend and maintain.

 Client-side Dependency Injection:  In the client-side code (e.g., in the Main class), we create an instance of OrderService2 and inject its dependencies through the constructor.
                                    By doing this, we gain the flexibility to choose which implementations of the dependencies to use.

 For example, we can easily swap RazorpayPayment with another payment service, depending on the requirements.

 */