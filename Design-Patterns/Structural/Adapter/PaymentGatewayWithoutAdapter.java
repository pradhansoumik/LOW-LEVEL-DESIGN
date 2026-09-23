import java.util.*;

// Target Interface:
// Standard interface expected by the client (CheckoutService)
interface PaymentGateway
{
    void pay(String orderId, double amount);
}

// Concrete implementation of PaymentGateway for PayU
class PayUGateway implements PaymentGateway
{
    @Override
    public void pay(String orderId, double amount)
    {
        System.out.println("Paid Rs. " + amount + " using PayU for order: " + orderId);
    }
}

// Adaptee:
// An existing class with an incompatible interface
class RazorpayAPI
{
    public void makePayment(String invoiceId, double amountInRupees)
    {
        System.out.println("Paid Rs. " + amountInRupees + " using Razorpay for invoice: " + invoiceId);
    }
}

// Client Class:
// Uses PaymentGateway interface to process payments
class CheckoutService
{
    private PaymentGateway paymentGateway;

    // Constructor injection for dependency inversion
    public CheckoutService(PaymentGateway paymentGateway)
    {
        this.paymentGateway = paymentGateway;
    }

    // Business logic to perform checkout
    public void checkout(String orderId, double amount)
    {
        paymentGateway.pay(orderId, amount);
    }
}

class Main
{
    public static void main(String[] args)
    {
        // Using PayU payment gateway to process payment
        CheckoutService checkoutService = new CheckoutService(new PayUGateway());

        checkoutService.checkout("12", 1780);
    }
}
/**
 * Understanding the Issues
 *
 * - CheckoutService expects any payment provider to implement the PaymentGateway interface.
 * - PayUGateway fits this requirement and works correctly.
 * - RazorpayAPI, however, uses a different method (makePayment) and does not implement PaymentGateway.
 * - Due to this mismatch, RazorpayAPI cannot be used directly with CheckoutService.
 */