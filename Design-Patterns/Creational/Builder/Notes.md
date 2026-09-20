## Builder Pattern

The Builder Pattern is a creational design pattern that separates the construction of a complex object from its representation. This allows you to create different types and representations of an object using the same construction process.

**Formal Definition:**

- "Builder pattern builds a complex object step by step. It separates the construction of a complex object from its representation, so that the same construction process can create different representations."

In simpler terms:

- Imagine you're ordering a custom burger. You choose the bun, patty, toppings, sauces, and whether you want it grilled or toasted. The chef follows your instructions step by step to build your custom burger. This is what the Builder Pattern does - it lets you construct complex objects by specifying their parts one at a time, giving you flexibility and control over the object creation process.

---

**Real-life Analogy (Custom Pizza Order):**

- Think of ordering a pizza online. You select the crust type, size, toppings, cheese, and sauce - all step by step. The pizza shop then builds your pizza according to your selections. Different customers can use the same process to get entirely different pizzas. This is the essence of the Builder Pattern: a structured, step-wise approach to creating customized complex objects.

---

**Real World Products Using Builder Pattern:**

`Lombok's @Builder Annotation`

- Instead of writing the builder logic manually, you just annotate your class:
  ```java
    @Builder
    public class User 
    {
        private String name;
        private int age;
        private String address;
    }
  ```
- Now, you can build objects using a fluent API
  ```java
    User user = User.builder()
    .name("John")
    .age(30)
    .address("NYC")
    .build();
  ```

`Amazon Cart Configuration`

Think about Amazon's shopping cart system. When you add an item to your cart, you're not just storing an item ID. You're building a complex object with fields like:

- Quantity
- Size or color (for apparel)
- Delivery option
- Gift wrap
- Save for later status
- Discounted price or offer tag

Each user may customize these options differently. Internally, such cart items are likely created using a Builder Pattern to allow step-by-step configuration while ensuring data consistency and immutability.

---

**Pros:**

- Avoids constructor telescoping: You no longer need to write multiple overloaded constructors for different configurations.
- Ensures immutability: The final object can be made immutable once built, which improves safety and thread-safety.
- Clean, readable object creation: The fluent API makes object construction expressive and easy to follow.
- Great for complex configurations: If your object has many optional parameters or conditional setup, the builder pattern keeps it organized.

**Cons:**

- Slightly tough to set up: Initial setup requires writing a separate builder class, which adds to boilerplate.
- Overkill for small classes: If a class only has one or two fields, using a builder adds unnecessary complexity.
- Separate builder class needed: You need to maintain a second class or static inner class just to construct the main object, increasing maintenance.

---

**When to Use?**

You should consider using the Builder Pattern in the following scenarios:

- An object has multiple fields, especially when many of them are optional. Managing such objects using constructors becomes messy and error-prone.
- Immutability is preferred - Builder lets you construct an object step by step and then make it immutable once built.
- You want readable, maintainable object creation, especially when dealing with domain models or configuration objects. The fluent interface style improves clarity and flexibility.

**When to Avoid?**

The Builder Pattern can be overkill in simpler use cases. Avoid it when:

- Your class has only 1-2 fields: Using a constructor or setter methods is simpler and more concise.
- You don’t need object customization or immutability: If the object is small, mutable, or built only in one place, a builder adds unnecessary complexity.
