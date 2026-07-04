# Interface Segregation Principle (ISP)

## Definition:

- It says: "Don't force a class to depend on methods it does not use."
- One Interface should NOT Handle a lot of Responsibilities (Fat Interfaces).
- Multiple Interfaces should be handling Different Responsibilities.
- In other words, an interface should have only the methods that are relevant to the implementing class. If a class implements an interface, it should not be forced to implement methods that it does not need or use.

## Real-life Analogy:

Suppose you book a ride with Uber. You're just a **rider** - you only care about **booking rides**, **tracking the driver**, and **paying**. 
You don't care about picking up passengers, verifying driver's licenses, or managing earnings - that's for drivers!

But what if the app gave you one massive interface (fat interface) with everything - rider features and driver features? It would be confusing, right?

That's exactly what ISP helps prevent in software.

## Example: Violates ISP & Applying ISP

```java
    // Bad Interface Design
    // Fat interface with methods for both riders and drivers
    interface UberUser {
        void bookRide();
        void acceptRide();
        void trackEarnings();
        void ratePassenger();
        void rateDriver();
    }

```
Using such an interface would force riders to implement methods they don't need, like acceptRide() and trackEarnings(). For instance:

```java
    // Rider class implementing UberUser interface
    class Rider implements UberUser {
        public void bookRide() { /* yes */ }
        public void acceptRide() { /* not needed */ }
        public void trackEarnings() { /* not needed */ }
        public void ratePassenger() { /* not needed */ }
        public void rateDriver() { /* yes */ }
    }

```
This is extremely messy. Rider is forced to implement stuff it never uses!

**Good Interface Design (Follows ISP):**
A better interface design would separate the concerns:

```java
    interface RiderInterface 
    {
        void bookRide();
        void rateDriver();
    }

    interface DriverInterface 
    {
        void acceptRide();
        void trackEarnings();
        void ratePassenger();
    }


```
Now, each class only implements what it actually needs:

```java
    // Rider class implementing RiderInterface
    class Rider implements RiderInterface {
        public void bookRide() { /* yes */ }
        public void rateDriver() { /* yes */ }
    }

    // Driver class implementing DriverInterface
    class Driver implements DriverInterface {
        public void acceptRide() { /* yes */ }
        public void trackEarnings() { /* yes */ }
        public void ratePassenger() { /* yes */ }
    }

```
Now, each class has exactly what it needs - no more, no less. Thus, following the ISP keeps the code clean and easy to maintain.

## Benefits of using ISP

There are several benefits to using the Interface Segregation Principle (ISP) in software design. Here are some of the key advantages:

- **Cleaner Codebase:** Classes are not bloated with irrelevant methods.
- **Better Flexibility:** Easier to change one part without affecting others.
- **High Maintainability:** Smaller interfaces are easier to understand and test.
- **Fewer Bugs:** Less chance of someone accidentally using or overriding a method they don't need.
- **Scalability:** As your app grows, adding new roles (like delivery partners in Uber Eats) becomes easier.

## When to apply ISP

The Interface Segregation Principle (ISP) is a valuable guideline in software design, but it should be applied judiciously. Here are some scenarios where you should consider applying ISP:

- You see a class implementing methods it doesn't use.
- An interface starts to grow too big and is being used by multiple types of classes.
- Adding a new feature requires modifying several unrelated classes.
- You're working with APIs or plugins where exposing only relevant methods improves usability.

## Note

The Interface Segregation Principle is all about **designing interfaces that are tailored to the needs of each client** - just like Uber doesn't show driver options to passengers. This leads to **modular, understandable**, and **future-proof code**.

**Remember:** Fat interfaces are bad. Slim, purpose-specific interfaces are good.

