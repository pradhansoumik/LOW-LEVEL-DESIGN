## Flyweight Pattern

The Flyweight Pattern is a structural design pattern used to minimize memory usage by sharing as much data as possible with similar objects.

It separates the intrinsic (shared) state from the extrinsic (unique) state, so that shared parts of objects are stored only once and reused wherever needed.

**Real-Life Analogy**

Think of trees in a video game. In an open-world video game, you might see thousands of trees:

- All oak trees have the same texture, shape, and behavior (shared/intrinsic).
- But their location, size, or health status may differ (extrinsic).

Rather than loading the same tree model thousands of times, the game engine uses a single shared tree model and passes different parameters when rendering.

---

**Problem It Solves**

It solves the problem of high memory usage when a large number of similar objects are created. For example, imagine a system rendering:

- Thousands of tree objects in a forest
- Each with the same shape and texture but a different location

Instead of creating thousands of identical objects, the Flyweight Pattern lets you share the common parts (shape, texture) and store the unique parts (location) externally, dramatically reducing memory consumption.

---

**Core Concepts**

- **Intrinsic State:** The immutable, shared data stored inside the flyweight. It is independent of context.
- **Extrinsic State:** The context-specific data passed from the client and not stored in the flyweight.

---

**When to Use Flyweight Pattern?**

The flyweight pattern can be used when:

- When you need to create a large number of similar objects.
- When memory and performance optimization is crucial.
- When the object's intrinsic properties could be shared independently of its extrinsic properties.

---

**Advantages**

A few advantages of using the Flyweight Pattern are:

- Greatly reduces memory usage when there are a lot of similar objects.
- Improves performance in resource-constrained environments.
- Enables faster object creation.

**Disadvantages**

A few disadvantages of using the Flyweight Pattern are:

- Adds complexity (especially around factory and object management).
- Harder to debug due to shared state.
- Can lead to tight coupling between flyweight and client code if not designed carefully.

---

**Real-World Applications of Flyweight Pattern**

The Flyweight pattern is widely used in large-scale applications where rendering or managing many similar objects efficiently is essential. Here are some real-world examples:

1. **Google Maps**
   - When displaying millions of trees or similar visual landmarks, Google Maps avoids creating separate objects for each tree. Instead, it shares the same data (like tree type, color, texture) across all trees and only varies extrinsic properties like position — a classic use of the Flyweight pattern.

2. **Uber App**
   - Uber renders many nearby cars on the map, but most of them are visually identical (same icon, color, etc.). Instead of creating a new object for each car from scratch, Uber reuses a common flyweight object and just changes the coordinates — reducing memory and improving performance.

3. **Web Browsers (Chrome, Firefox, etc.)**
   - When rendering complex webpages with thousands of similar DOM elements (like repeated icons, buttons, text styles), modern browsers internally use the Flyweight pattern to optimize memory. For instance:
   - A webpage might have hundreds of `<div>` or `<button>` elements styled identically.
   - Instead of allocating separate memory for each element's styling and behavior, browsers reuse the same shared style object (like CSS rules or rendering data) across all similar components.
   - This allows browsers to load and display large webpages faster and with less RAM usage.