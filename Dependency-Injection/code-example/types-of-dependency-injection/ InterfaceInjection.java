/**
 * In Interface Injection, the dependency provides an injector method that will inject the dependency into the class.
 * This type is rarely used in practice and is typically only suitable for very specific cases.
 *
 * Key Points:
 *  Rarely Used: This type of DI is not as commonly used as constructor or setter injection. It requires changes to the interfaces themselves and may not always be suitable for all applications.
 *  Requires Interface Changes: Since the class must implement an interface that provides the injection method, it can require significant changes to existing interfaces.
 *  Unnecessary Method Implementation: A drawback of Interface Injection is that every class implementing the interface is required to implement the injectPayment method, even if the class does not need a payment service. This can lead to unnecessary method definitions and potential code bloat in some cases.
 */

// Interface to inject PaymentService dependency
interface PaymentInjectable
{
    // Method to inject PaymentService
    void injectPayment(PaymentService payment);
}

// Using Interface Injection
class OrderService5 implements PaymentInjectable
{
    private PaymentService payment;

    // Inject PaymentService through the method
    @Override
    public void injectPayment(PaymentService payment)
    {
        this.payment = payment; // Set the injected payment service
    }


    public void checkout(Order order)
    {
        payment.process(order);
    }
}
class PaymentService
{
    public void process(Order order){

    }
}
class Order{

}
