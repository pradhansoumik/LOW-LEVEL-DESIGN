## Factory Pattern
The Factory Pattern is a creational design pattern that provides an interface for creating objects but allows subclasses to alter the type of objects that will be created.

In simpler terms:
- Rather than calling a constructor directly to create an object, we use a factory method to create that object based on some input or condition.

---

**Real-World Analogy:** Ordering Pizza

Imagine you walk into a pizza shop and say, “I'd like a pizza.” The shop doesn't ask you to go into the kitchen and make it yourself. Instead, it asks, “Which type? Margherita? Pepperoni? Veggie?” Based on your choice, the kitchen (factory) creates the specific pizza for you and hands it over.

You (the client), don't care how it's made or what specific class of ingredients is used. You just want your pizza. The factory (kitchen) handles the creation logic behind the scenes.

This is exactly what the Factory Pattern does in code: it creates an object based on some input without exposing the instantiation logic to the client.

---
**Basic Structure of Factory Pattern:**

The Factory Pattern typically consists of the following components:

- Product: It is an interface or abstract class that defines the methods the product must implement.
- Concrete Products: The concrete classes that implement the Product interface.
- Factory: A class with a method that returns different concrete products based on input.

---
**Pros of Factory Pattern:**

- Promotes Loose Coupling:
  - The client code is decoupled from the actual instantiation of classes.
  - You work with interfaces rather than concrete classes.
  
- Enhances Extensibility (`OCP - Open/Closed Principle`):
  - You can introduce new classes (e.g., new types of logistics like Ship) without modifying existing client code.
  - The system becomes easier to scale and extend.

- Centralizes Object Creation (`SRP - Single Responsibility Principle`):
  - The responsibility of object creation is moved to a dedicated factory class.
  - Business logic stays clean and focused only on "what to do" with the object.

- Increases Flexibility:
  - The decision of "which object to create" can be deferred to runtime based on input, config, or logic.
  - Makes your system adaptable to dynamic requirements.

- Improves Code Reusability:
  - Common instantiation logic can be reused from a single factory.
  - Avoids code duplication when creating similar objects in different parts of the system.

**Cons of Factory Pattern:**

- Increased Complexity: Introduces additional layers (factory classes/interfaces) which might be overkill for very small programs.
- More Code Overhead: Requires writing extra code like factory classes and interfaces, which might look unnecessary in simpler use-cases.