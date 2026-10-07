/**
 * Problems:
 * 1. Hardcoded Logic
 * 2. Difficult to Test
 * 3. Scalability Issues
 */
class OrderService
{

    private InventoryService inventory = new InventoryService();
    private PaymentService payment = new RazorpayPayment();
    private NotificationService notification = new NotificationService();

    public void checkout(Order order)
    {
        inventory.blockItems(order);
        payment.process(order);
        notification.sendConfirmation(order);
    }

}
/**

 While this code looks simple and functional at first, there are several issues that arise when we try to scale it or make changes:

     1. Hardcoded Logic:    The OrderService is tightly coupled with specific implementations of the InventoryService, PaymentService, and NotificationService. This makes the code rigid.
                            For example, if we want to switch from Razorpay to Stripe, we would need to manually change the code everywhere the RazorpayPayment class is used.
     2. Difficult to Test:  Since the dependencies (InventoryService, PaymentService, and NotificationService) are hardcoded within the OrderService class, it becomes extremely difficult to test the logic of OrderService in isolation.
                            For example, if we want to test the checkout method, we would need to hit real payment APIs, which is not ideal for unit testing.
     3. Scalability Issues: As the application grows, we may want to introduce more payment providers, different inventory systems, or notification services.
                            Each time we add a new dependency, we need to modify the OrderService class, which creates scalability issues in larger systems.

 */
