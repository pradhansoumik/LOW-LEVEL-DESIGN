## Memento Pattern

---
**Formal Definition:**

The Memento Pattern is a behavioral design pattern that allows an object to capture its internal state and restore it later without violating encapsulation. It is especially useful when implementing features like undo/redo or rollback.

> Note:
> Imagine you're working in a document editing application. As you make changes to the text, you'd like the ability to undo your edits and revert to a previous version. Instead of exposing the internal structure of the document object, the system uses a memento to store its state at a given point in time. These mementos can later be used to restore the document to that state, all while keeping the implementation details hidden from the outside world.

---
**Key Components:**

- **Originator:** The object whose internal state we want to save and restore.
- **Memento:** A storage object that holds the snapshot of the originator’s state.
- **Caretaker:** The object responsible for requesting the memento and keeping track of it. It neither modifies nor examines the contents of the memento.

---
**Real-Life Analogy: Undo/Redo in Text Editors:**

Think of the Memento Pattern as an undo/redo mechanism. When you type or edit something in a text editor, the application captures snapshots of the document at different points. Each snapshot (memento) is stored by an external caretaker (like a history stack), and the editor (originator) can revert to these snapshots when needed, without exposing its internal logic.

A key strength of the pattern is that the originator alone is responsible for creating its snapshots, thus preserving encapsulation while still allowing state recovery.

---
**When to Use Memento Pattern:**

The Memento Pattern is most useful in scenarios where an object’s state needs to be saved and restored at various points in time, without exposing its internal structure. Consider using the Memento Pattern in the following situations:

- **You need to implement undo/redo functionality:**
  The Memento Pattern allows you to store and restore previous states, enabling seamless undo/redo operations.
- **You want to preserve the encapsulation of the object's state:**
  The pattern lets you save an object's internal state without exposing its private fields to the outside world.
- **You are handling non-trivial state history management:**
  For scenarios requiring multiple checkpoints or rollbacks, mementos offer a structured and maintainable solution.

---
**Advantages and Disadvantages of Memento Pattern:**

**Pros:**

- **Preserves encapsulation:**
  The originator can save and restore its own state without exposing its internal structure.
- **Simplifies undo/redo functionality:**
  By maintaining snapshots of state, the pattern provides a clean way to implement undo/redo features.
- **Cleaner separation of concerns:**
  The originator handles state, while the caretaker manages history—leading to modular and maintainable code.

**Cons:**

- **Can be memory-intensive if storing too many states:**
  Saving large or frequent snapshots can consume significant memory.
- **Might introduce caretaker complexity:**
  The caretaker must manage memento creation, storage, and retrieval carefully, especially when there are many states.
- **Needs careful management of old mementos:**
  Without proper pruning, the buildup of old mementos can lead to performance or memory issues.

---
**Real Life Use Cases:**

The Memento Pattern is highly useful in systems where object states need to be saved and restored over time without exposing their internal structure. Here are two real-world examples of where this pattern can be applied effectively:

1. **Text Editors (e.g., Notepad, Google Docs):**
   In text editors, users often rely on undo and redo functionalities to reverse or repeat changes. Every time the user makes an edit, the current state of the document can be stored as a memento. When the user presses undo, the editor restores the previous state from the most recent memento. This allows users to seamlessly navigate back and forth through changes without accessing or modifying the internal details of the document object.
2. **Graphic Design or Drawing Applications:**
   Applications like Photoshop or Figma allow users to apply changes step by step (e.g., drawing, coloring, transforming objects). With each significant operation, a snapshot (memento) of the canvas or component’s state is saved. Users can then use undo to revert to a specific state. This keeps the design process non-destructive and flexible while ensuring encapsulation of the canvas data.

These examples demonstrate how the Memento Pattern enables powerful undo/redo support and history management, all while preserving encapsulation and reducing system complexity.
