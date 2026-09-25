Composite Pattern
The Composite Pattern is a structural design pattern that allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.
Problem It Solves
The Composite Pattern solves the problem of treating individual objects and groups of objects in the same way. The main problem arises when:
You want to work with a hierarchy of objects.
You want the client code to be agnostic to whether it's dealing with a single object or a collection of them.

Understanding Leaf and Composite in the Composite Pattern
In the Composite Design Pattern, we categorize components into two main roles:
Leaf (Individual Object): A Leaf is a simple, atomic object in the structure. It does not contain any child components. In our example:
Product is a Leaf.
It represents individual purchasable items like books, phones, pens, etc.
Implements CartItem and provides its own getPrice() and display() logic.
Composite (Container of Components): A Composite is a complex object that can hold multiple CartItem objects, including both Leaf and other Composite objects. In our example:
ProductBundle is a Composite.
It can contain Products (leaves) and even other ProductBundles (nested composites).
Implements CartItem and delegates actions (getPrice() and display()) to its children.

How it Solves the Issues
Uniform Treatment via Shared Interface (CartItem): Now, both Product and ProductBundle implement CartItem, so the cart can contain any of them without special handling.
This eliminates the need for type checking (instanceof).
Enables Polymorphism: All operations like getPrice() and display() are defined in the CartItem interface, so they can be called uniformly on both products and bundles.
This simplifies logic and improves code extensibility.
Recursive Composition Made Easy: Bundles can now include other bundles or products seamlessly. This supports deeply nested combos or kits which is a common real-world scenario.
No Code Duplication: The cart-handling logic like computing total and displaying items is written once and works for any CartItem.
This promotes cleaner, DRY (Don't Repeat Yourself) code.


When to Use Composite Pattern
The Composite Pattern is particularly useful when:
You have a hierarchical structure: Use the composite pattern when your objects form a tree-like structure (e.g., folders inside folders, or products inside bundles).
You want to treat individual and groups in the same way: When operations on single items and collections of items should be uniform (e.g., calculating total price, displaying structure).
You want to avoid client-side logic to differentiate leaf and composite: Let polymorphism handle the differences between simple and composite objects, keeping client code clean and maintainable.


Advantages and Disadvantages
Pros:
Uniformity: Treats individual and composite objects in the same way.
Extensible: Easy to add new item types or structures.
Cleaner client code: Reduces complexity for the user of the structure.
Supports OCP (Open/Closed Principle): Add new components without modifying existing code.

Cons:
Violates SRP on scale: Components manage both hierarchy and business logic.
Overkill for flat and simple structures: Adds unnecessary complexity.
Can hide important distinctions: In regulated or sensitive systems, uniform treatment might blur critical differences between types.
