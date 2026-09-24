## Decorator Pattern

The Decorator Pattern is a structural design pattern that allows behavior to be added to individual objects, dynamically at runtime, without affecting the behavior of other objects from the same class.

It wraps an object inside another object that adds new behaviors or responsibilities at runtime, keeping the original object's interface intact.

---

**Real-Life Analogy**

Think of a coffee shop:
- You order a simple coffee.
- Then, you can add milk, add sugar, add whipped cream, etc.
- You don't need a whole new drink class for every combination.

**Problem It Solves**

It solves the problem of class explosion that occurs when you try to use inheritance to add combinations of behavior. For Example, imagine you have:

- A Pizza
- A CheesePizza
- A CheeseAndOlivePizza
- A CheeseAndOliveStuffedPizza

---

**Real-World Use Cases:**

The Decorator Pattern is widely used in real-life software products to enable dynamic behavior composition without bloating the class hierarchy. Below are practical examples where it plays a critical role:

1. `Food Delivery Applications (e.g., Swiggy, Zomato)`

   - Context: Customers can customize food items with add-ons like extra cheese, sauces, toppings, or side dishes.
   - Role of Decorator Pattern:
      - Each add-on modifies the base food item's description and price dynamically.
      - Instead of creating subclasses for every combination (e.g., PizzaWithCheeseAndOlives), decorators like CheeseDecorator, OliveDecorator, etc., can be stacked over a base Pizza.
      - This allows the system to stay open for extension (new add-ons) but closed for modification.

2. `Google Docs or Word Processors`

   - Context: Users can apply text formatting like bold, italic, or underline independently or in combination.
   - Role of Decorator Pattern:
      - Each text style is implemented as a decorator that wraps the plain text object.
      - Allows flexible layering of styles, e.g., UnderlineDecorator(BoldDecorator(ItalicDecorator(Text))).
      - Avoids subclassing for all combinations like BoldItalicUnderlineText, keeping the design clean and extensible.

---
**When Should You Use the Decorator Pattern?**

The Decorator Pattern is particularly useful in scenarios where flexibility, modularity, and extensibility are key. Consider using it when:

- `You need to add responsibilities to objects dynamically`: Instead of hardcoding behaviors into a class, decorators allow you to attach additional functionality at runtime, offering great flexibility.
- `You want to avoid an explosion of subclasses`: For every possible combination of features, creating separate subclasses leads to unmanageable and bloated class hierarchies. Decorators eliminate this by composing behaviors.
- `You want to follow the Open/Closed Principle (OCP)`: The pattern supports the OCP by allowing classes to be open for extension but closed for modification. You enhance behavior without altering existing code.
- `You want reusable and composable behaviors`: Decorators can be reused across different components and can be composed in various combinations to achieve desired functionality.
- `You need layered, step-by-step enhancements`: Decorators can be applied one after another, layering features gradually in a controlled and traceable way—much like wrapping layers around an object.
