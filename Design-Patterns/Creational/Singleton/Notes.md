## Singleton Pattern

- Singleton controls the object creation process by returning an existing instance rather than creating a new one.
- class has only one instance and provides a global point of access to that instance.
- it restricts object creation and guarantees that all parts of your application use the same object.

---

**Points to remember:**

- Private constructor: Prevents instantiation from outside the class.
- Static variable: Holds the single instance of the class.
- Public static method: Provides a global access point to get the instance.

---

**Approaches to Implement Singleton Pattern:**

- Eager Loading (Early Initialization): Instance is created at the time of class loading.

  - Real-World Analogy: Fire Extinguisher in a Building
    - A fire extinguisher is always present, even if a fire never occurs. Similarly, eager loading creates the Singleton instance upfront, just in case it's needed.
  - pros:
    - Very simple to implement.
    - Thread-safe without any extra handling.
  - cons:
    - Wastes memory if the instance is never used.
    - Not suitable for heavy objects.

- Lazy Loading (On-Demand Initialization): Instance is created when it is needed/requested for the first time the getInstance() method is called.
  - Real-World Analogy: Coffee Machine
    - Imagine a coffee machine that only brews coffee when you press the button. It doesn't waste energy or resources until you actually want a cup.
  - pros:
    - Saves memory if the instance is never used.
    - Object creation is deferred until required.
  - cons:
    - Slightly more complex to implement. Lazy Loading is Not thread-safe by default. Thus, it requires synchronization in multi-threaded environments.

---

Let's say two threads simultaneously call getInstance() for the first time in a lazy-loaded Singleton. If the instance hasn't been created yet, both threads might pass the null check and end up creating two different instances - completely breaking the Singleton guarantee.

**Different Ways to Achieve Thread Safety**

- Synchronized Method: Synchronize the entire method to ensure that only one thread can access it at a time.
  
  - pros:
    - Simple to implement.
    - Thread-safe without needing complex logic.
    - no volatile keyword required.
  - cons:
    - Performance overhead: Every call to getInstance() is synchronized, even after the instance is created.
    - May slow down the application in high-concurrency scenarios.

- Double-Checked Locking: The idea is to check if the instance is null before acquiring the lock

  - pros:
    - Efficient: Synchronization only happens once, when the instance is created.
    - Safe and fast in concurrent environments.
  - cons:
    - Slightly more complex than the synchronized method.
    - Requires Java 1.5 or above due to reliance on volatile.

- Bill Pugh Singleton (Best Practice for Lazy Loading):
    
    - pros:
        - The Singleton instance is not created until getInstance() is called.
        - The static inner class (Holder) is not loaded until referenced, thanks to Java's class loading mechanism.
        - It ensures thread safety, lazy loading, and high performance without synchronization overhead.
        - Best of both worlds: Lazy + Thread-safe.
        - No need for synchronized or volatile
        - Clean and efficient.
    - cons:
        - It is slightly less intuitive for beginners due to the use of a nested static class.






