## Mediator Pattern

---
**Formal Definition:**

The Mediator Pattern is a behavioral design pattern that centralizes complex communication between objects into a single mediation object. It promotes loose coupling and organizes the interaction between components.

Instead of objects communicating directly with each other, they interact through the mediator, which helps simplify and manage their communication.

> Note: Imagine a scenario where multiple components (e.g., buttons, text fields, and labels) within a user interface need to interact with each other.
> Instead of directly communicating with each other, the components rely on a central mediator that facilitates communication between them. This decouples the components, making the system more maintainable and flexible.
> This is the essence of the Mediator Pattern.

---
**Real-Life Analogy: Air Traffic Control (ATC):**

In an airport, multiple airplanes communicate with the air traffic control (ATC) tower instead of directly with each other. The ATC coordinates their movements, ensuring safe distances and smooth operations. This simplifies communication, as planes rely on the ATC to manage the flow of information, just like the Mediator Pattern centralizes communication between objects in a system.

---
**When to Use the Mediator Pattern:**

The Mediator Pattern is most useful in scenarios where multiple objects need to communicate with each other, but direct communication between them would lead to high complexity or tight coupling. Consider using the Mediator Pattern in the following situations:

- **Multiple Users or Services Interacting, but Should Remain Decoupled:**
  When you have several users or services that need to interact, but you want to avoid direct dependencies between them, the Mediator Pattern is ideal. By centralizing communication through a mediator, you ensure that the users can communicate without knowing the details of each other's existence or operations.
- **Managing Rules or Permissions Centrally:**
  If you need to manage rules or permissions (such as access control or user roles) across multiple components or users, the Mediator Pattern allows you to centralize the logic, making it easier to enforce consistent rules and permissions without modifying each component.
- **Flexible Broadcasting, Filtering, or Transformation of Messages:**
  The Mediator Pattern helps when you need to broadcast messages, filter messages, or transform them before they're delivered. By using a mediator, you can introduce flexibility, allowing for dynamic filtering or transformation without affecting the communicating components directly.

---
**Advantages and Disadvantages of Mediator Pattern:**

**Pros:**

- **Users Don’t Need to Know About Other Users:**
  The Mediator Pattern decouples the users or components, meaning that they only communicate with the mediator rather than directly with each other. This reduces dependencies and makes the system more flexible and maintainable.
- **Easy to Manage User Roles and Access Centrally:**
  Managing user roles (such as admin, editor, and viewer) and permissions becomes easier with the mediator. The mediator can handle access control centrally without modifying the individual users, ensuring a consistent rule enforcement across the system.
- **Easier to Test and Extend:**
  Since the communication between users is centralized in the mediator, testing and extending the system becomes simpler. You can modify or add new users or operations without affecting the entire system.
- **Clean Separation of Business Logic and Interaction:**
  The mediator centralizes the logic for interactions between components, which results in a clean separation of concerns. Business logic can be handled separately from the interaction logic, making the system easier to understand and maintain.

**Cons:**

- **Mediator Can Become Complex Over Time:**
  As the system grows and more components are added, the mediator may become complex and difficult to maintain. The mediator can end up managing too many responsibilities, making the system harder to scale and debug.
- **One Point of Failure:**
  Since the mediator is responsible for handling communication between all components, it becomes a single point of failure. If the mediator encounters issues, it can affect the entire system, leading to potential downtime or failure in communication.
- **Adds an Abstraction Layer:**
  Introducing the mediator adds an extra abstraction layer, which may make the system more difficult to understand for developers who are unfamiliar with the pattern. While this abstraction is useful for decoupling components, it can also add complexity to simpler systems.

---
**Real Life Use Cases:**

The Mediator Pattern is highly useful in systems where multiple components interact, but their communication needs to be centralized or streamlined. Here are two real-world examples of where this pattern can be applied effectively:

1. **Airline Management System:**
   In an airline management system, multiple services (such as booking, customer service, flight status, and payment) need to communicate with each other. Rather than each service directly interacting with the others, a mediator can handle the communication. The mediator ensures that services only communicate with it, reducing dependencies and making the system more maintainable. For instance, when a flight status is updated, the mediator ensures that the booking service, customer service, and payment service all receive the updated information without directly connecting these services.
2. **Auction System:**
   An auction system involves multiple users (bidders) and the auctioneer. Instead of each bidder interacting with every other bidder, the auctioneer can act as a mediator. When a bid is placed, the auctioneer broadcasts the update to all participants. The mediator ensures that all the participants are notified about the bid changes in real-time, ensuring smooth communication and coordination during the auction process.

These examples demonstrate how the Mediator Pattern can simplify complex interactions and centralize control, making the system more flexible and easier to maintain.