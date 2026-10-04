/**
 * The issues in the previous code can be effectively addressed using the Visitor Pattern. The Visitor Pattern allows you to decouple operations from the objects on which they operate. It introduces two key components:
     * Element: This represents the objects on which operations (such as calculating shipping costs or generating invoices) will be performed. Each concrete element class (like PhysicalProduct, DigitalProduct, GiftCard) will implement an interface (such as Item) that defines an accept() method.
     * Visitor: The visitor is responsible for implementing the operations on the elements. It defines a visit method for each concrete element type, allowing new operations to be added without modifying the element classes themselves.

 * By using the Visitor Pattern, we can easily add new operations (like printing invoices or calculating shipping costs) without changing the classes of the products.
 * We only need to implement a new visitor class.
 *
 * Here's the updated code implementing the Visitor Pattern:
 */
import java.util.*;

// ======= Element Interface ==========
interface Item
{
    void accept(ItemVisitor visitor);
}

// ======= Concrete elements ===========
class PhysicalProduct implements Item
{
    String name;
    double weight;

    public PhysicalProduct(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}

// ======= Concrete elements ===========
class DigitalProduct implements Item
{
    String name;
    int downloadSizeInMB;

    public DigitalProduct(String name, int downloadSizeInMB) {
        this.name = name;
        this.downloadSizeInMB = downloadSizeInMB;
    }

    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}

// ======= Concrete elements ===========
class GiftCard implements Item
{
    String code;
    double amount;

    public GiftCard(String code, double amount) {
        this.code = code;
        this.amount = amount;
    }

    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}

// ======== Visitor Interface ============
interface ItemVisitor
{
    void visit(PhysicalProduct item);
    void visit(DigitalProduct item);
    void visit(GiftCard item);
}

// ============ Concrete Visitors ==============
class InvoiceVisitor implements ItemVisitor
{
    public void visit(PhysicalProduct item) {
        System.out.println("Invoice: " + item.name + " - Shipping to customer");
    }

    public void visit(DigitalProduct item) {
        System.out.println("Invoice: " + item.name + " - Email with download link");
    }

    public void visit(GiftCard item) {
        System.out.println("Invoice: Gift Card - Code: " + item.code);
    }
}

// ============ Concrete Visitors ==============
class ShippingCostVisitor implements ItemVisitor
{
    public void visit(PhysicalProduct item) {
        System.out.println("Shipping cost for " + item.name + ": Rs. " + (item.weight * 10));
    }

    public void visit(DigitalProduct item) {
        System.out.println(item.name + " is digital -- No shipping cost.");
    }

    public void visit(GiftCard item) {
        System.out.println("GiftCard delivery via email -- No shipping cost.");
    }
}

// Client Code
public class Main
{
    public static void main(String[] args)
    {
        List<Item> items = new ArrayList<>();
        items.add(new PhysicalProduct("Shoes", 1.2));
        items.add(new DigitalProduct("Ebook", 100));
        items.add(new GiftCard("TUF500", 500));

        ItemVisitor invoiceGenerator = new InvoiceVisitor();
        ItemVisitor shippingCalculator = new ShippingCostVisitor();

        for (Item item : items)
        {
            item.accept(invoiceGenerator);
            item.accept(shippingCalculator);

            System.out.println("");
        }
    }
}
/**
 * Issue: How it is Solved

     * Doesn't Follow Single Responsibility Principle (SRP): Each element class (PhysicalProduct, DigitalProduct, GiftCard) now only handles the representation of the product, delegating operations like printing invoices and calculating shipping costs to separate visitor classes.
     * Product Type Checking in Client Code: The client code (in Main) no longer needs to check the type of product with instanceof. Instead, it delegates the operation to the appropriate visitor via the accept method, which eliminates the need for explicit type checks.
     * Lack of Flexibility:	New operations (like printing invoices or calculating shipping costs) can now be added by simply creating a new visitor (e.g., InvoiceVisitor or ShippingCostVisitor). This adheres to the Open-Closed Principle (OCP), as the product classes don’t need to be modified to add new functionality.
     * Tight Coupling: The coupling between operations (like invoice generation and shipping cost calculation) and product classes is eliminated. The operations are isolated in the visitor classes, which can be added or modified without affecting the product classes.

 */