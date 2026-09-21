
/**
 * Improved Design: Abstract Factory Pattern for CheckoutService
 * This version follows the Abstract Factory Pattern to cleanly separate the creation of PaymentGateway and Invoice objects from the business logic of CheckoutService.
 */

// ========== Interfaces ==========
interface PaymentGateway
{
    void processPayment(double amount);
}

interface Invoice
{
    void generateInvoice();
}

// ========== India Implementations ==========
class RazorpayGateway implements PaymentGateway
{
    public void processPayment(double amount)
    {
        System.out.println("Processing INR payment via Razorpay: " + amount);
    }
}

class PayUGateway implements PaymentGateway
{
    public void processPayment(double amount)
    {
        System.out.println("Processing INR payment via PayU: " + amount);
    }
}

class GSTInvoice implements Invoice
{
    public void generateInvoice() {
        System.out.println("Generating GST Invoice for India.");
    }
}

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++ //

// ========== US Implementations ==========
class PayPalGateway implements PaymentGateway
{
    public void processPayment(double amount)
    {
        System.out.println("Processing USD payment via PayPal: " + amount);
    }
}

class StripeGateway implements PaymentGateway
{
    public void processPayment(double amount)
    {
        System.out.println("Processing USD payment via Stripe: " + amount);
    }
}

class USInvoice implements Invoice
{
    public void generateInvoice()
    {
        System.out.println("Generating Invoice as per US norms.");
    }
}

// ========== Abstract Factory ==========
interface RegionFactory
{
    PaymentGateway createPaymentGateway(String gatewayType);
    Invoice createInvoice();
}

// ========== Concrete Factories ==========
class IndiaFactory implements RegionFactory
{
    public PaymentGateway createPaymentGateway(String gatewayType)
    {
        if (gatewayType.equalsIgnoreCase("razorpay"))
        {
            return new RazorpayGateway();
        }
        else if (gatewayType.equalsIgnoreCase("payu"))
        {
            return new PayUGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway for India: " + gatewayType);
    }

    public Invoice createInvoice()
    {
        return new GSTInvoice();
    }
}

class USFactory implements RegionFactory
{
    public PaymentGateway createPaymentGateway(String gatewayType)
    {
        if (gatewayType.equalsIgnoreCase("paypal"))
        {
            return new PayPalGateway();
        }
        else if (gatewayType.equalsIgnoreCase("stripe"))
        {
            return new StripeGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway for US: " + gatewayType);
    }

    public Invoice createInvoice()
    {
        return new USInvoice();
    }
}

// ========== Checkout Service ==========
class CheckoutService
{
    private PaymentGateway paymentGateway;
    private Invoice invoice;
    private String gatewayType;

    public CheckoutService(RegionFactory factory, String gatewayType)
    {
        this.gatewayType = gatewayType;
        this.paymentGateway = factory.createPaymentGateway(gatewayType);
        this.invoice = factory.createInvoice();
    }

    public void completeOrder(double amount)
    {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}

// ========== Main Method ==========
class Main
{
    public static void main(String[] args)
    {
        // Using Razorpay in India
        CheckoutService indiaCheckout = new CheckoutService(new IndiaFactory(), "razorpay");
        indiaCheckout.completeOrder(1999.0);

        System.out.println("---");

        // Using PayPal in US
        CheckoutService usCheckout = new CheckoutService(new USFactory(), "paypal");
        usCheckout.completeOrder(49.99);
    }
}
/**
 * Object creation logic was mixed with business logic:
 * Now moved to separate factory classes like IndiaFactory and USFactory.
 *
 * Concrete classes like Razorpay and PayU were hardcoded in the service: Replaced with abstractions (PaymentGateway, Invoice) and created via interfaces.
 * Adding a new gateway or invoice type required modifying CheckoutService: Now, new gateways or invoices can be added by updating/adding a new factory - no changes required in the service class.
 * The code was difficult to maintain and scale across regions: Now easy to maintain and scale by plugging in region-specific factories (e.g., USFactory, IndiaFactory, etc.).
 */