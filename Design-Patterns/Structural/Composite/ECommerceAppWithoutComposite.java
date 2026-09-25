/**
 * Consider you are building the checkout service of an e-commerce application and you take the following approach as shown in the code below.
 */

import java.util.*;

// Represents a single product
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void display(String indent) {
        System.out.println(indent + "Product: " + name + " - ₹" + price);
    }
}

// Represents a bundle of products
class ProductBundle {
    private String bundleName;
    private List<Product> products = new ArrayList<>();

    public ProductBundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void display(String indent) {
        System.out.println(indent + "Bundle: " + bundleName);
        for (Product product : products) {
            product.display(indent + "  ");
        }
    }
}

// Main logic
class Main {
    public static void main(String[] args) {
        // Individual Items
        Product book = new Product("Book", 500);
        Product headphones = new Product("Headphones", 1500);
        Product charger = new Product("Charger", 800);
        Product pen = new Product("Pen", 20);
        Product notebook = new Product("Notebook", 60);

        // Bundle: Iphone Combo
        ProductBundle iphoneCombo = new ProductBundle("iPhone Combo Pack");
        iphoneCombo.addProduct(headphones);
        iphoneCombo.addProduct(charger);

        // Bundle: School Kit
        ProductBundle schoolKit = new ProductBundle("School Kit");
        schoolKit.addProduct(pen);
        schoolKit.addProduct(notebook);

        // Add to cart logic
        List<Object> cart = new ArrayList<>();
        cart.add(book);
        cart.add(iphoneCombo);
        cart.add(schoolKit);

        // Display Cart
        double total = 0;
        System.out.println("Cart Details:\n");

        for (Object item : cart) {
            if (item instanceof Product) {
                ((Product) item).display("  ");
                total += ((Product) item).getPrice();
            } else if (item instanceof ProductBundle) {
                ((ProductBundle) item).display("  ");
                total += ((ProductBundle) item).getPrice();
            }
        }

        System.out.println("\nTotal Price: ₹" + total);
    }
}

/**
 * Working of Code
 * Product class represents a simple item with name and price.
 * ProductBundle class represents a group of products bundled together.
 * Both classes have methods to display and return their prices.
 * In main(), individual products and bundles are created and added to the cart.
 * The cart is a List<Object> that holds both products and bundles.
 * During checkout, the code checks each item's type using instanceof.
 * Based on the type, it casts the object and calls its respective methods.
 * Finally, it displays all items and calculates the total price.
 * Problem in above code
 * In the above example, the code lacks the structure to treat individual and group items uniformly, i.e., In the current implementation, individual products (Product) and product bundles (ProductBundle) are completely separate types with no shared interface or superclass. This means we cannot write code that treats both uniformly and the logic always has to check which type we're working with.
 *
 * Other than these, there are some other problems as well:
 * instanceof is used repeatedly, breaking polymorphism.
 * Cart uses List<Object>, which is unsafe and violates abstraction.
 * ProductBundle cannot contain another ProductBundle (no recursive structure).
 * Display and price logic are duplicated instead of unified.
 */