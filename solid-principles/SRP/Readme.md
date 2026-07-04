# Single Responsibility Principle (SRP)

## Definition

- "One Module Must perform a Single Functionality" - Curly Law
- Clean Code: "One Module Should be Changed/impacted/modified by Only 1 Actor in the System"
- 1 Module should have only 1 Responsibility
- If a class takes more than one responsibility, it becomes coupled. This means that if one responsibility changes, the other responsibilities may also be affected, leading to a ripple effect of changes throughout the codebase.

## Real-life Analogy

Imagine a chef who is responsible for cooking, cleaning, serving food and ordering groceries. If the chef is busy cleaning, they can't focus on cooking, and the quality of the food may suffer.

Instead, different people should handle each task: one person cooks (chef), another cleans (cleaner), third serves (waiter) and another orders groceries (manager). This way, each person can focus on their specific responsibility, leading to better results overall.

## Advantages of SRP

- **Improved Maintainability:** Changes in one part of the system won't affect other parts, making it easier to maintain and update.
- **Enhanced Readability:** Smaller, focused classes are easier to read and understand.
- **Better Reusability:** Classes with a single responsibility can be reused in different contexts without bringing unnecessary dependencies.
- **Facilitates Testing:** Smaller classes are easier to test, as they have fewer dependencies and responsibilities.
- **Lower Risk in Changes:** Since each class handles only one concern, changes made to it are less likely to cause unintended side effects in other parts of the system.

## Violation of SRP — Problem Examples

### Problem Example 1

**Actors (3):**

| Actor | Responsibility |
|-------|----------------|
| Account | `calculateSalary()` |
| HR | `calculateHours()` |
| Operations | `saveEmpData()` |

**Problem:**

1 Actor — **HR** wants to change `calculateHours()`.

Since `calculateHours()` is used in `calculateSalary()` and `saveEmpData()`, other actors — **Account** and **Operations** — would need to change at their places as well.

**Violation of SRP:**

> "One Module should be changed by 1 Actor ONLY"

**Code:**

```java
public int calculateSalary() {
    calculateHours();
}

public int calculateHours() {

}

public void saveEmpData() {
    calculateHours();
}
```

**Solution:**

1. **Facade Pattern**
2. **Break / Decompose the Classes**

---

### Problem Example 2

**Restaurant — 2 Major Classes:**

**Class 1: `MenuItem`**
- `itemName`
- `itemID`
- `amount`
- `discount`
- `expiry_date`

**Class 2: `Bill`**
- `order_id`
- `customer_id`
- `List<MenuItem>`
- `timestamp`
- `finalAmount()`
- `printBill()`
- `saveBill()`

**Problem:**

`Bill` class contains `saveBill()` — initially, bill is saved in a local server.

Due to increasing requests and multiple outlets, you decide to migrate it to a **common DB**.

Since `saveBill()` is contained in the `Bill` class, it will affect the functionalities of the `Bill` class.

**Violation of SRP**

**Solution:**

Decompose / break into **3 different classes:**

1. **Bill**
2. **Print**
3. **Store** → In Machine or In Cloud

## Common Mistakes When Violating SRP

There are a few common mistakes that developers make when violating the Single Responsibility Principle (SRP). Here are some examples:

- **Mixing Database Logic with Business Logic:** Putting both data access (e.g., SQL, JDBC) and core business rules in the same class. This makes it hard to change the database layer without affecting business logic.
- **Coupling UI Code with Business Logic:** Embedding application logic directly in the UI layer. This makes it tedious to change the UI without affecting the underlying logic.

## Note

An important question to ask is: "Is SRP just for classes?"

The answer is no. SRP can be applied to methods, modules, microservices and even entire systems. The key is to ensure that each component has a single responsibility and that changes in one area do not affect others unnecessarily.

Hence, SRP is not just for classes. It's a mindset you can apply from the smallest method to the largest system design.