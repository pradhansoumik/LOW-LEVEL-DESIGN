## Strategy Pattern

The Strategy Pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one into a separate class, and makes them interchangeable at runtime depending on the context.

Imagine a navigation app that can switch between driving, walking, or cycling routes. The algorithm used to calculate the path depends on the selected mode of travel.
Instead of hardcoding all possible strategies inside one class, wouldn’t it be better if each strategy was defined separately and chosen dynamically?

That’s exactly what the Strategy Pattern enables. It allows a class to choose its behavior at runtime by encapsulating related algorithms into interchangeable objects. Let's explore the Strategy Pattern in detail in the upcoming sections.

---
**Formal Definition:**

The Strategy Pattern is a behavioral design pattern that enables selecting an algorithm's behavior at runtime by defining a set of strategies (algorithms), each encapsulated in its own class, and making them interchangeable via a common interface.

It is primarily focused on changing the behavior of an object dynamically, without modifying its class. This promotes better organization of related algorithms and enhances code flexibility and scalability.

---
**Real-Life Analogy:**

Consider how Uber matches a rider with a driver. The underlying algorithm may change depending on the context, like matching with the nearest driver, giving priority to surge zones, or choosing from an airport queue.

In this case:
- The ride-matching service is the context.
- The different matching algorithms (nearest, surge-priority, airport-queue) are the strategies.
- The strategy interface allows the system to switch between these algorithms seamlessly, depending on real-time conditions.

Similarly, in software, the Strategy Pattern allows a class to use different algorithms or behaviors at runtime, without altering its code structure, just like Uber switches matching strategies based on need.

---
**Suitable Scenarios for Strategy Pattern:**

The Strategy Pattern is an ideal choice in the following scenarios:

- **Multiple Interchangeable Algorithms:**
  When a system supports different algorithms or behaviors that can be swapped in and out based on context or configuration.
- **Compliance with Open/Closed Principle (OCP):**
  When new strategies need to be introduced without modifying the existing business logic, keeping the core code closed for modification and open for extension.
- **Elimination of Conditionals:**
  When large blocks of if-else or switch statements are used to select behavior, Strategy Pattern helps to cleanly separate these into dedicated classes.
- **Behavior-Specific Unit Testing:**
  When there's a need to test behaviors independently and isolate them from the context, Strategy Pattern offers clear test boundaries.
- **Runtime Behavior Selection:**
  When the behavior of a class needs to be selected dynamically during execution based on user input, configuration, or environment.

---
**Pros and Cons:**

**Pros:**

- **Supports the Open/Closed Principle (OCP):**
  New strategies can be added without modifying existing code, keeping the system extensible.
- **Easy to Add New Behaviors:**
  Each behavior is encapsulated in its own class, making it simple to plug in new logic.
- **Enables Runtime Behavior Changes:**
  Behavior can be changed dynamically at runtime by swapping strategy objects.
- **Encourages Composition Over Inheritance:**
  Promotes flexible design by favoring object composition rather than rigid class hierarchies.

**Cons:**

- **May Lead to Too Many Small Classes:**
  Each strategy is implemented in a separate class, which can increase code volume.
- **Requires Awareness of All Strategies:**
  The client needs to know which strategies exist and when to use each one.
- **Slight Overhead Due to Interfaces:**
  Involves extra structure around interfaces, which may be unnecessary for simple logic.
- **Slightly More Complex Than if-else:**
  For very simple cases, the Strategy Pattern may introduce more complexity than needed.