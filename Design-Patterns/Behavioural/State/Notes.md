## State Pattern

---
**Formal Definition:**

The State Pattern is a behavioral design pattern that encapsulates state-specific behavior into separate classes and delegates the behavior to the appropriate state object. This allows the object to change its behavior without altering the underlying code.

This pattern makes it easy to manage state transitions by isolating state-specific behavior into distinct classes. It helps achieve loose coupling by ensuring that each state class is independent and can evolve without affecting others.

Imagine a vending machine that changes its behavior based on the coins inserted — when you insert enough money, the machine gives you a snack and when you haven’t inserted enough, it asks for more. This dynamic change in behavior depending on the machine's state is what the State Pattern addresses.

---
**Real-Life Analogy:**

Consider a food delivery app. As an order progresses, its state changes through multiple stages:
- The order is placed.
- The order is being prepared.
- A delivery partner is assigned.
- The order is picked up.
- The order is out for delivery.
- Finally, the order is delivered.

At each stage, the app behaves differently:
- In the "Order Placed" state, you can cancel the order.
- In the "Order Preparing" state, you can track the preparation status.
- In the "Delivery Partner Assigned" state, you can see the details of the assigned driver.
- And so on until the order is delivered.

Each of these states represents a distinct phase, and the app's behavior changes based on which state the order is in. The State Pattern manages these transitions seamlessly, with each state class controlling the behavior for that phase. It also follows Open Closed Principle (OCP), as states can be added without modifying the existing code.

---
**When to Use the State Pattern:**

Here are some scenarios where the State Pattern proves to be highly effective:

- **Object behavior depends on internal state:**
  When an object needs to change its behavior based on its internal condition or current phase.
- **Well-defined and finite state transitions:**
  When the states and their transitions are clearly structured and limited in number.
- **Avoiding complex if-else or switch-case blocks:**
  When you want to eliminate bulky conditional logic that checks for current state and executes accordingly.
- **Need for explicit state transitions:**
  When it’s important to have clear and maintainable transitions from one state to another.
- **Distinct behavior for each state:**
  When each state has its own behavior and rules, making it better to isolate them into separate classes.

---
**Differences Between State and Strategy Pattern:**

Some users might be confused between the Strategy Pattern and the State Pattern because both involve the idea of changing behaviors based on conditions. However, they have distinct purposes and use cases.

Below is a comparison to clarify the differences:

| Aspect | State Pattern | Strategy Pattern |
|---|---|---|
| Intent | Change behavior based on the object's internal state. | Select an algorithm or behavior at runtime based on content. |
| Dependency | States can be dependent as you can easily jump from one state to another. | Strategies are completely independent and unaware of each other. |
| Final Result | It’s about doing different things based on the state, hence the results may vary. | Strategies may end up having the same result, depending on the algorithm selected. |
| Usage | Workflow models, lifecycle processes, and state machines. | Algorithm selection, formatting, and dynamic behavior handling. |

---
**Advantages and Disadvantages of the State Pattern:**

The State Pattern offers several benefits, but also comes with a few trade-offs. Below is an overview of the pros and cons associated with this pattern:

**Pros:**

- **Clear Separation of State Behavior:**
  The State Pattern enables a clean separation of behaviors based on the object's state. Each state is encapsulated in its own class, making it easier to manage and modify individual behaviors without affecting the rest of the system.
- **Easy to Add New States:**
  Adding new states becomes straightforward, as you simply need to create a new class that implements the OrderState interface, and it can be integrated with the existing structure with minimal changes.
- **Follows Open/Closed Principle (OCP):**
  The pattern follows the Open/Closed Principle, meaning that it is open for extension but closed for modification. New states can be added without modifying existing code, promoting better maintainability and scalability.
- **Avoids Complex if-else or Switch-case Blocks:**
  With the State Pattern, you can avoid cluttering your code with large and difficult-to-manage conditional statements (such as if-else or switch-case). Each state class handles its own logic, improving readability and maintainability.

**Cons:**

- **Adds More Classes:**
  The introduction of new state classes can make the overall design more complex, as each state behavior requires a dedicated class. This can lead to an increase in the number of classes in the system.
- **Slightly More Complex Initial Setup:**
  The initial setup of the State Pattern requires defining multiple state classes and interfaces, which can make the implementation slightly more complex compared to other simpler alternatives.
- **Content Needs to Manage State Transitions:**
  The management of state transitions is typically handled by the context or the object holding the states. This introduces an additional layer of complexity in ensuring that state transitions are handled properly throughout the system.
- **Requires Familiarity:**
  Developers need to be familiar with the State Pattern, which could be a learning curve for teams or individuals not accustomed to this design. Proper understanding is necessary to implement the pattern effectively.

---
**Real Life Examples:**

The State Pattern is widely used in various real-life applications where an object's behavior changes depending on its state. Here are three examples of how the State Pattern is implemented in systems:

1. **Swiggy (Food Delivery App)**
   In Swiggy, the order lifecycle is a great example of the State Pattern. As a customer places an order, the order goes through several states:
   - Order Placed
   - Order Preparing
   - Out for Delivery
   - Order Delivered
   - Order Cancelled

   Each of these states has distinct behaviors. For instance, when the order is in the "Order Placed" state, the user can only cancel the order. When it’s "Out for Delivery", the order cannot be cancelled, and different actions such as live tracking become available. Each state is managed by its own class, implementing the OrderState interface. This approach allows easy transitions between states and simplifies managing order-related actions.
2. **Uber (Ride-Hailing App)**
   Uber also utilizes the State Pattern for managing the different stages of a ride. The ride can be in one of several states such as:
   - Ride Requested
   - Driver Assigned
   - Ride Accepted
   - Ride In Progress
   - Ride Completed
   - Ride Cancelled

   The behavior of the app varies based on the current state of the ride. For example, if the ride is in the "Ride Requested" state, the system allows the user to cancel the ride. Once the ride is "In Progress", cancellation is no longer allowed, and the interface changes to show real-time tracking. The state classes handle these transitions, ensuring that the app behaves appropriately at each stage of the ride lifecycle.
3. **ATM (Automated Teller Machine)**
   ATMs are another classic example of the State Pattern. The ATM machine can be in one of the following states:
   - Idle
   - Card Inserted
   - PIN Entered
   - Transaction In Progress
   - Transaction Completed
   - Out of Service

   Each state dictates the behavior of the machine. For instance, when the machine is in the "Card Inserted" state, the user can input their PIN.
   Once the correct PIN is entered, the machine transitions to the "Transaction In Progress" state, where the user can withdraw money or check the balance.
   The state transition logic ensures that the machine operates in a seamless manner and prevents the user from taking actions that are not allowed in the current state (e.g., entering a PIN after completing a transaction).
