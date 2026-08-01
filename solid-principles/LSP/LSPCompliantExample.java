// ============================================
// LSP-COMPLIANT EXAMPLE: Payment Processing
// ============================================
// The key: Method accepts parent class, works correctly with ANY child class
// without breaking expectations or needing type checks.

// Base class - Payment
abstract class Payment
{
    protected double amount;
    
    public Payment(double amount) {
        this.amount = amount;
    }
    
    // Contract: Process the payment. Returns true if successful, false otherwise.
    abstract boolean processPayment();
    
    // Contract: Return the fee charged for this payment method
    abstract double getFee();
}

// Child class - CreditCardPayment
class CreditCardPayment extends Payment
{
    private String cardNumber;
    
    public CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }
    
    @Override
    boolean processPayment() {
        System.out.println("Processing credit card payment of $" + amount);
        return true; // Process and return expected boolean
    }
    
    @Override
    double getFee() {
        return amount * 0.02; // 2% fee
    }
}

// Child class - PayPalPayment
class PayPalPayment extends Payment
{
    private String email;
    
    public PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }
    
    @Override
    boolean processPayment() {
        System.out.println("Processing PayPal payment of $" + amount);
        return true; // Process and return expected boolean
    }
    
    @Override
    double getFee() {
        return amount * 0.03; // 3% fee
    }
}

// Child class - BankTransferPayment
class BankTransferPayment extends Payment
{
    private String accountNumber;
    
    public BankTransferPayment(double amount, String accountNumber) {
        super(amount);
        this.accountNumber = accountNumber;
    }
    
    @Override
    boolean processPayment() {
        System.out.println("Processing bank transfer of $" + amount);
        return true; // Process and return expected boolean
    }
    
    @Override
    double getFee() {
        return 0; // No fee for bank transfer
    }
}

// ============================================
// CLIENT CODE - Method accepts parent class
// ============================================
class PaymentProcessor
{
    
    // This method takes Payment (parent) but works with ANY child class
    // WITHOUT breaking LSP because all children honor the contract:
    // 1. processPayment() returns a boolean (true/false)
    // 2. getFee() returns a valid fee amount
    // 3. No unexpected behavior or special cases needed
    
    static void processTransaction(Payment payment) {
        System.out.println("\n--- Processing Transaction ---");
        
        if (payment.processPayment())
        {
            double fee = payment.getFee();
            System.out.println("Payment successful!");
            System.out.println("Fee charged: $" + fee);
            System.out.println("Total cost: $" + (payment.amount + fee));
        }
        else
        {
            System.out.println("Payment failed!");
        }
    }
    
    // Another method - calculates total cost for bulk payments
    // Again, NO type checking needed. Works with ANY Payment subclass!
    static double calculateTotalCost(Payment[] payments) {
        double total = 0;
        for (Payment p : payments) {
            total += p.amount + p.getFee(); // Each child honors this contract
        }
        return total;
    }
}

// ============================================
// MAIN - Demonstrates LSP Compliance
// ============================================
class LSPExample {
    public static void main(String[] args) {
        // Create different payment methods
        Payment creditCard = new CreditCardPayment(100, "1234-5678-9999");
        Payment paypal = new PayPalPayment(100, "user@paypal.com");
        Payment bankTransfer = new BankTransferPayment(100, "ACC-123456");
        
        // Each is passed to the SAME method
        // LSP is NOT violated because:
        // - processTransaction() expects parent class behavior
        // - All children provide that exact behavior (no surprises)
        // - No type checking or special cases needed
        
        PaymentProcessor.processTransaction(creditCard);
        PaymentProcessor.processTransaction(paypal);
        PaymentProcessor.processTransaction(bankTransfer);
        
        // Calculate total cost for all payments
        Payment[] allPayments = {creditCard, paypal, bankTransfer};
        double total = PaymentProcessor.calculateTotalCost(allPayments);
        System.out.println("\n--- Bulk Summary ---");
        System.out.println("Total cost for all payments: $" + total);
    }
}

/*
EXPECTED OUTPUT:

--- Processing Transaction ---
Processing credit card payment of $100.0
Payment successful!
Fee charged: $2.0
Total cost: $102.0

--- Processing Transaction ---
Processing PayPal payment of $100.0
Payment successful!
Fee charged: $3.0
Total cost: $103.0

--- Processing Transaction ---
Processing bank transfer of $100.0
Payment successful!
Fee charged: $0.0
Total cost: $100.0

--- Bulk Summary ---
Total cost for all payments: $305.0

WHY THIS IS LSP-COMPLIANT:
✅ processTransaction() takes a Payment parent class
✅ Works correctly with CreditCardPayment, PayPalPayment, BankTransferPayment
✅ No type checking (if, instanceof) needed
✅ All subclasses honor the contract:
   - processPayment() always returns boolean (true for success)
   - getFee() always returns a valid fee
✅ Behavior is PREDICTABLE - no surprises
✅ Can add new payment methods (CryptoCurrencyPayment, ApplePayment)
   without changing processTransaction() method

The method "substitutes" the parent with any child WITHOUT breaking!
*/
