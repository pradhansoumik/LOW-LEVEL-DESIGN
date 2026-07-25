/**
 * In Setter Injection, dependencies are passed to the class via setter methods after the object has been created.
 * This allows for mutable dependencies, meaning you can change the dependencies of the class at runtime.
 *
 * Key Points:
 *  Mutable Dependencies: In Setter Injection, dependencies can be set or changed at any time after the object is created, which gives more flexibility in some scenarios. This contrasts with Constructor Injection, where dependencies are only set at the time of object creation and cannot be changed later.
 *  Less Strict: Unlike constructor injection, where all dependencies are required, setter injection allows for optional dependencies.
 *  Can Be Misused: One drawback is that the dependencies may not be properly set if the setter method is not called. This can lead to situations where a class is not fully initialized.
 */

// Using Setter Injection
class OrderService4
{
    /*

    private PaymentService payment;

    // Setter method to inject dependencies
    public void setPayment(PaymentService payment)
    {
        this.payment = payment;
    }

    public void checkout(Order order)
    {
        payment.process(order);
    }

     */
}

