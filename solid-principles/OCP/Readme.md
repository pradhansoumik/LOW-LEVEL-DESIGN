# Open-Closed Principle (OCP)

## Definition

- Software entities (classes, modules, functions, etc.) should be **open for extension**, but **closed for modification**.
- The behavior of a module can be extended without modifying its source code.
- The goal is to reduce the risk of breaking existing functionality when requirements change.

## Real-life Analogy

Imagine you travel from India to the UK. Your Indian charger does not fit UK power sockets. Instead of buying a new charger, you use a **travel adapter**.

- The adapter **extends** your charger's usability (now works in the UK).
- You did **not modify** the charger itself.

Similarly, OCP encourages adding new functionality via extension rather than altering existing, stable code.

## When to Apply OCP?

OCP is especially useful when:

- **Evolving requirements:** A module is expected to change due to shifting business or technical needs.
- **Protecting stable code:** You need to extend functionality without modifying existing, tested code.
- **Extensible systems:** Building frameworks, plugins, or components like billing engines, tax calculators, or UI widgets.
- **Avoiding regression:** Safeguarding production-ready modules from bugs caused by direct changes.
- **God Class signals:** A class handles too many responsibilities or branching logic — extract behaviors into separate, extendable components.

> Apply OCP in response to real patterns of change, not preemptively. Over-applying it without clear extension needs can introduce unnecessary abstraction and complexity.

## Violation of OCP — Problem Examples

### Problem Example 1 — Responsive Website (Display)

**Current requirement:** A website supports 2 devices — Laptop and Mobile.

**Violation — modifying existing code:**

```java
class Display {
    if (device_type == laptop) {
        // ...
    } else if (device_type == mobile) {
        // ...
    }
}
```

**New requirement:** Support **Tablet**.

Adding another `else if` block modifies the existing `Display` class — this **violates OCP**.

**Solution 1 — Inheritance:**

```java
class Display {
    // Base class — CLOSED for modification
}

class Laptop extends Display {}

class Mobile extends Display {}

class Tablet extends Display {
    // OPEN for extension
}
```

**Solution 2 — Interface:**

```java
interface Display {
    // CLOSED for modification
}

class Laptop implements Display {}

class Mobile implements Display {}

class Tablet implements Display {
    // OPEN for extension
}
```

---

### Problem Example 2 — Vehicle Information

**Class:** `VehicleInfo`  
**Method:** `vehicleNumber()`

**Current requirement:** Car, Bike  
**New requirement:** Truck

**Violation — Way 1 (Bad Design):**

```java
class VehicleInfo {
    public String vehicleNumber(Vehicle v) {
        if (v instanceof Car)
            return v.getNumber();
        else if (v instanceof Bike)
            return v.getNumber();
    }
}
```

**Problem:**

To support Truck, you must add another `else if` in the existing code — **violates OCP**.

**Solution — Way 2 (Good Design):**

```java
class VehicleInfo {
    public String vehicleNumber(Vehicle v) {
        // ...
    }
}

class Car extends VehicleInfo {
    @Override
    public String vehicleNumber(Vehicle v) {
        return this.vehicleNumber();
    }
}

class Bike extends VehicleInfo {
    @Override
    public String vehicleNumber(Vehicle v) {
        return this.vehicleNumber();
    }
}

class Truck extends VehicleInfo {
    @Override
    public String vehicleNumber(Vehicle v) {
        return this.vehicleNumber();
    }
}
```

Add new vehicle types by creating more subclasses — the original `VehicleInfo` class stays **unchanged**, following OCP.

## Common Misconceptions about OCP

- **"Open/Closed means code should never be changed again."**  
  OCP avoids changes to **core logic** while allowing behavior to be extended safely — it does not forbid all modifications.

- **"OCP leads to too many classes, so it's overkill."**  
  More classes or interfaces is a trade-off that improves modularity, testability, and maintainability in evolving systems.

- **"OCP makes the code harder to read."**  
  In small, short-lived projects, extra abstraction can feel unnecessary. In complex or frequently changing systems, extensibility improves clarity by separating concerns and reducing conditional logic.

- **"OCP should always be applied upfront."**  
  Preemptive application often adds unnecessary complexity. Apply it when you see real patterns of change or a clear need for scalability.

- **"Refactoring contradicts OCP."**  
  Refactoring is not a violation — it is often a step **toward** OCP by improving structure and extensibility.

- **"OCP makes retesting legacy code unnecessary."**  
  Stable components need less modification and retesting, but **new extensions** still require thorough testing for correctness and integration.

## Note

OCP applies beyond classes — methods, modules, and entire systems can follow the same idea: extend behavior without touching stable, working code.

Balance is key. Use OCP when change is likely and the cost of modification is high; avoid over-engineering when requirements are simple and unlikely to grow.
