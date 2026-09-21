// Interface representing any payment gateway
interface PaymentGateway
{
    void processPayment(double amount);
}

// Concrete implementation: Razorpay
class RazorpayGateway implements PaymentGateway
{
    public void processPayment(double amount)
    {
        System.out.println("Processing INR payment via Razorpay: " + amount);
    }
}

// Concrete implementation: PayU
class PayUGateway implements PaymentGateway
{
    public void processPayment(double amount)
    {
        System.out.println("Processing INR payment via PayU: " + amount);
    }
}

// Interface representing invoice generation
interface Invoice
{
    void generateInvoice();
}

// Concrete invoice implementation for India
class GSTInvoice implements Invoice
{
    public void generateInvoice()
    {
        System.out.println("Generating GST Invoice for India.");
    }
}

/**
 * CheckoutService that directly handles object creation (bad practice)
*/
class CheckoutService
{
    private String gatewayType;

    // Constructor accepts a string to determine which gateway to use
    public CheckoutService(String gatewayType)
    {
        this.gatewayType = gatewayType;
    }

    // Checkout process hardcodes logic for gateway and invoice creation
    public void checkOut(double amount)
    {
        PaymentGateway paymentGateway;

        // Hardcoded decision logic
        if (gatewayType.equals("razorpay"))
        {
            paymentGateway = new RazorpayGateway();
        }
        else
        {
            paymentGateway = new PayUGateway();
        }

        // Process payment using selected gateway
        paymentGateway.processPayment(amount);

        // Always uses GSTInvoice, even though more types may exist later
        Invoice invoice = new GSTInvoice();
        invoice.generateInvoice();
    }
}

// Main method
class Main
{
    public static void main(String[] args)
    {
        // Example: Using Razorpay
        CheckoutService razorpayService = new CheckoutService("razorpay");
        razorpayService.checkOut(1500.00);
    }
}

/**
 * Issues with this design
 *
 * Tight Coupling: The CheckoutService directly creates instances of RazorpayGateway, PayUGateway, and GSTInvoice, making it dependent on specific implementations.
 *
 * Violation of the Open/Closed Principle: Any addition of new payment gateways or invoice types will require modifying the CheckoutService class.
 *
 * Lack of Extensibility: Hardcoding limits the ability to support other countries or multiple combinations of payment methods and invoice formats.
 *
 * Now, let's refactor this code using the Abstract Factory Pattern to improve its design and flexibility.
 */