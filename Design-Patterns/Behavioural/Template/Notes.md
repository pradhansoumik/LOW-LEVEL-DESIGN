## Template Pattern

---
**Formal Definition:**

The Template Pattern is a behavioral design pattern that provides a blueprint for executing an algorithm. It allows subclasses to override specific steps of the algorithm, but the overall structure remains the same. This ensures that the invariant parts of the algorithm are not changed, while enabling customization in the variable parts.

---
**Real Life Analogy:**

Imagine you are following a recipe to bake a cake. The overall process of baking a cake (preheat oven, mix ingredients, bake, and cool) is fixed, but the specific ingredients or flavors may vary (chocolate, vanilla, etc.).

The Template Pattern is like the recipe: it defines the basic structure of the process (steps), while allowing the specific ingredients (or steps) to be varied depending on the cake type.

---
**Key Steps in Template Pattern:**

The Template Pattern generally consists of four key steps:

- **Template Method (Final Method in Base Class):**
  This method defines the skeleton of the algorithm. It calls the various steps and determines their sequence. This method is final to prevent overriding in subclasses, ensuring that the algorithm’s structure stays consistent.
- **Primitive Operations (Abstract Methods):**
  These are abstract methods that subclasses must implement. These methods represent the variable parts of the algorithm that may change based on the subclass’s specific requirements.
- **Concrete Operations (Final or Concrete Methods):**
  These are methods that contain behavior common to all subclasses. They are defined in the base class and are shared by all subclasses.
- **Hooks (Optional Methods with Default Behavior):**
  Hooks are optional methods in the base class that provide default behavior. Subclasses can override these methods to modify the behavior when needed, but they are not mandatory for all subclasses to implement.

By using the Template Pattern, one can ensure that the common steps of an algorithm remain unchanged while allowing subclasses to modify the specific details of the algorithm.

---
**When to Use the Template Pattern:**

The Template Pattern is best suited in the following scenarios:

- **When multiple classes follow the same algorithm but differ in a few steps:**
  This pattern allows the core structure to remain the same while enabling flexibility in specific steps of the algorithm.
- **When you want to avoid code duplication of common steps:**
  The Template Pattern centralizes shared logic in the base class, promoting code reusability.
- **When you need to enforce a fixed order of steps:**
  This pattern ensures that the steps of an algorithm follow a specific sequence, which can be crucial in certain operations.
- **When you want to provide optional customizations:**
  Subclasses can override specific steps to customize the behavior while still maintaining the overall algorithm.
- **When you need a structured flow:**
  The Template Pattern ensures that subclasses follow a certain framework, with the flexibility to implement specific details.

---
**Advantages and Disadvantages of Template Method:**

**Pros:**

- **Promotes code reusability by sharing the same steps:**
  The Template Pattern helps in sharing common steps across different classes, ensuring that they follow the same algorithm without duplicating code.
- **Supports OCP (Open/Closed Principle):**
  New behaviors (custom steps) can be added by extending the base class without modifying its existing code, supporting the Open/Closed Principle.
- **Enforces a consistent flow:**
  The pattern ensures a fixed sequence of steps, making the flow predictable and consistent across all subclasses.
- **Allows optional customization via hook methods:**
  The use of hooks allows subclasses to modify or extend behavior when needed without changing the base structure.

**Cons:**

- **Inheritance-based, limits flexibility:**
  The Template Pattern uses inheritance, which can reduce flexibility as the behavior is tightly coupled with the base class.
- **Subclasses are tightly coupled with the base class:**
  Any changes in the base class may affect all subclasses, making it harder to modify or extend certain features independently.
- **Not ideal if the algorithm varies, switch to Strategy Pattern:**
  If the algorithm changes significantly, the Template Pattern becomes less suitable, and using the Strategy Pattern may be a better choice.
- **May result in too many subclasses:**
  If the number of steps to be customized grows, you might end up creating too many subclasses, making the codebase harder to maintain.

---
**Real World Products where Template Pattern is Used:**

The Template Pattern is commonly used in real-world applications where the overall structure of an operation is fixed, but specific steps need to be customizable. Here are some examples:

1. **TUF+ Payment Flow**
   In TUF+, the payment flow for both Indian and International transactions follows a predefined sequence. This sequence includes steps like validating the payment method, processing the payment, and updating the account. While these steps remain the same, the specifics (such as validating a UPI ID for Indian payments or a credit card for international payments) can vary between subclasses, providing flexibility and customization.
2. **Game Engines**
   Game engines like Unity or Unreal Engine use the Template Pattern in their game loop and rendering process. The framework for rendering a frame is common (input handling, physics update, rendering), but specific actions (e.g., rendering techniques or AI decision-making) can be customized in different games through subclassing.
3. **Frameworks**
   Many web frameworks, like Spring or Django, use the Template Pattern for handling requests. These frameworks define the common flow for handling HTTP requests (e.g., URL mapping, request handling, response formatting), but allow developers to override certain steps like request validation, database queries, or rendering logic.
