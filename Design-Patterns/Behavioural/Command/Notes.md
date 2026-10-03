## Command Pattern

The Command Pattern is a behavioral design pattern that turns a request into a separate object, allowing you to decouple the code that issues the request from the code that performs it.

---
**Formal Definition:**

The Command Pattern is a behavioral design pattern that **encapsulates a request as an object**, allowing for parameterization of clients with different requests, queuing of requests, and logging of the requests. It **lets you add features like undo, redo, logging, and dynamic command execution** without changing the core business logic.

This allows you to execute commands at a later time, in a flexible manner, without having to interact directly with the request's execution details.

---
**Real-Life Analogy:**

Think of a remote control used to turn on or off the lights or an air conditioner (AC). When you press a button to turn on the lights or adjust the temperature, you don’t need to understand how the internal circuits work or how the AC receives the signal. You just press the "On" or "Off" button, and the remote control takes care of sending the command.

Similarly, the Command Pattern decouples the sender of a request (the remote control) from the receiver (the light or AC), providing flexibility and simplicity in handling commands.

---
**Four Key Components:**

- **Client:** Initiates the request and sets up the command object.
- **Invoker:** Asks the command to execute the request.
- **Command:** Defines a binding between a receiver object and an action.
- **Receiver:** Knows how to perform the actions to satisfy a request.

---
**Impact Without the Command Pattern:**

- **Tight Coupling Between Invoker and Receiver:**
  The invoker and receiver are directly linked, making future changes or additions to the system difficult without modifying both components.
- **Lack of Reusability:**
  No abstraction for actions limits the ability to reuse code for different functionalities or scenarios across various parts of the application.
- **Undo/Redo Operations Not Supported:**
  Implementing undo or redo functionality becomes complex and error-prone when operations are directly tied to specific actions.
- **Difficulty in Implementing Batch Actions:**
  Implementing batch operations, like night mode changes, becomes cumbersome as each action needs to be handled individually.
- **No Plug-and-Play Flexibility:**
  The system lacks the flexibility to add or modify commands dynamically without impacting other parts of the application.
- **Scalability Issues:**
  As the system grows, managing commands and handling new features becomes increasingly difficult without a structured approach like the Command Pattern.

---
**When to Use the Command Pattern:**

- **Decoupling Sender from Receiver:**
  Use the Command Pattern when there is a need to decouple the sender (Invoker) from the receiver (the object performing the action).
- **Undo/Redo Support:**
  The Command Pattern is useful when you require built-in support for undoing or redoing actions.
- **Batch Operations:**
  When multiple actions need to be executed as part of a batch (e.g., applying night mode), the Command Pattern allows easy implementation.
- **Plug-in Architecture:**
  It facilitates the creation of flexible, extensible systems where new commands can be added without affecting the core system.
- **Creating Macros or Composite Commands:**
  Use the pattern to group multiple commands together, enabling complex actions to be executed in sequence as a single macro.

---
**Pros and Cons of the Command Pattern:**

**Pros:**

- **Decouples Sender and Receiver:**
  The sender (Invoker) and receiver (the device or action) are decoupled, allowing for flexibility and easier maintenance.
- **Supports Undo/Redo Functionality:**
  The Command Pattern inherently supports undo and redo actions, allowing for easier management of state reversals.
- **Easily Extensible and Reusable:**
  New commands can be added without modifying existing code, and commands can be reused across different parts of the application.

**Cons:**

- **Increases the Number of Classes:**
  Implementing the Command Pattern can result in a large number of small classes for each command, potentially increasing the complexity.
- **Can Add Unnecessary Complexity for Simple Tasks:**
  For simple applications, the Command Pattern may introduce unnecessary complexity, making it harder to manage than simpler alternatives.
- **Requires Careful Design for Undo/Redo:**
  Implementing undo/redo functionality correctly requires careful design and additional effort, especially for complex command chains.

---
