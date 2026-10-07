/**
 * 1. Constructor Injection:
 *    Constructor Injection is the most commonly used form of Dependency Injection.
 *    In this approach, dependencies are passed to the class via the constructor.
 *    This ensures that the class is always instantiated with its required dependencies, which makes it easier to manage and test.
 * Key Points:
 *  Immutable Dependencies: Once the dependencies are injected through the constructor, they cannot be changed. This makes the object immutable, which ensures better reliability and predictability..
 *  Test-Friendly: Constructor injection makes testing easier since you can inject mock dependencies during unit testing, isolating the class under test.
 *  Ensures Required Dependencies: Since all required dependencies must be provided when the object is created, you are guaranteed that the class will always have everything it needs to function properly.
 */
// Using Constructor Injection
class OrderService
{

    private final PaymentService payment;

    // Constructor
    public OrderService(PaymentService payment)
    {
        this.payment = payment;
    }

    public void checkout(Order order)
    {
        payment.process(order);
    }
}