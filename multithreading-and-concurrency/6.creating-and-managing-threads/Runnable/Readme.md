# Implementing Multithreading by Using the Runnable Interface

In Java, another common way to implement multithreading is by using the **`Runnable` interface**.

Unlike extending the `Thread` class, implementing `Runnable` decouples the task definition from the actual thread execution mechanism. The `Runnable` interface represents a task designed to be executed concurrently, but it does not manage the thread lifecycle itself. To run the task, we must pass the `Runnable` object into a `Thread` instance.

### Key Concepts

- **`Runnable` Interface**: A functional interface that contains a single abstract method, `run()`. By implementing this interface, you isolate the task's logic from the thread infrastructure.
- **`run()` Method**: You provide the task's specific execution code inside this method, which is invoked when the thread starts.
- **`Thread` Class**: While `Runnable` defines *what* the task is, the `Thread` class is responsible for *how* it executes. It handles the low-level operating system thread allocation.
- **`start()` Method**: This method spins up the thread and internally calls the `Runnable` object's `run()` method.
- **`join()` Method**: Similar to the previous approach, `join()` forces the calling thread to wait until the target thread completely finishes its execution.

---

### Code Example

```java
import java.util.*;

// Implementing the Runnable interface for sending SMS
class SMSTask implements Runnable {
    public void run() {
        try {
            Thread.sleep(2000); // 2-second delay for SMS
            System.out.println("SMS Sent using Runnable.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Implementing the Runnable interface for sending Email
class EmailTask implements Runnable {
    public void run() {
        try {
            Thread.sleep(3000); // 3-second delay for Email
            System.out.println("Email Sent using Runnable.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Implementing the Runnable interface for calculating ETA
class ETATask implements Runnable {
    public void run() {
        try {
            Thread.sleep(5000); // 5-second delay for ETA calculation
            System.out.println("ETA Calculated using Runnable. Estimated Time: 25 minutes.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Create Runnable objects for SMS, Email, and ETA calculation
        SMSTask smsTask = new SMSTask();
        EmailTask emailTask = new EmailTask();
        ETATask etaTask = new ETATask();

        // Create Thread objects and pass the Runnable tasks to them
        Thread smsThread = new Thread(smsTask);
        Thread emailThread = new Thread(emailTask);
        Thread etaThread = new Thread(etaTask);

        System.out.println("Task Started.\n");

        // Start all threads
        smsThread.start();
        System.out.println("Task 1 ongoing...");

        emailThread.start();
        System.out.println("Task 2 ongoing...");

        etaThread.start();
        System.out.println("Task 3 ongoing...");

        // Wait for all threads to finish
        try {
            smsThread.join();
            emailThread.join();
            etaThread.join();
            System.out.println("All tasks completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
**Explanation**

- **Runnable Interface**: Each task (`SMS`, `Email`, `ETA calculation`) is represented by a class implementing the `Runnable` interface. The `run()` method defines the task's specific behavior.
- **Thread Creation**: Instead of subclassing `Thread`, we create instances of `Thread` and pass a `Runnable` object to the constructor. The `Thread` class remains responsible for managing and executing the task defined in the `run()` method.
- **Thread Execution**: The `start()` method begins the execution of the thread, invoking the `run()` method in a separate thread of execution. The `join()` method ensures the main thread waits for all tasks to finish before printing *"All tasks completed."*

The above code demonstrates three concurrent tasks running on separate threads by implementing the `Runnable` interface.

---

**Advantages of Using Runnable**

- **Separation of Concerns**: By using `Runnable`, we separate the core task logic from thread management. This makes it significantly easier to reuse or share the same task across multiple threads.
- **Flexibility**: Since a `Runnable` can be passed to any `Thread` object, it provides more structural flexibility compared to extending the `Thread` class. Furthermore, Java only allows single class inheritance; by implementing an interface, your class is still free to extend another parent class while supporting multiple interfaces.

---

**Demerit: No Return Type in the `run()` Method**

Just like extending the `Thread` class, a primary limitation of the `Runnable` interface in Java is that the `run()` method has a `void` return type and **cannot return a value**. If your task computes a necessary result—like generating an ETA string—you cannot directly pass that value back to the caller from the `run()` method.

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
---

## Other Ways to Implement Multithreading in Java

In addition to the methods we've discussed so far, there are other ways to implement multithreading in Java. These methods offer different levels of simplicity and flexibility, depending on the task at hand.


### 1. Directly Defining a Runnable Instance

In Java, you don’t always need to create a separate class to implement the `Runnable` interface. You can define a `Runnable` instance directly using an anonymous class or a simple lambda expression. This is a concise and efficient way to handle simple tasks without needing an entire class structure.

Here's how you can define a `Runnable` directly:

```java

class Main {
    public static void main(String[] args) {
        // Define Runnable directly as an anonymous class
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000); // Simulate delay
                    System.out.println("Task completed using direct Runnable.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Create and start the thread
        Thread thread = new Thread(task);
        thread.start();
    }
}
```
In this example:
- The `Runnable` interface is implemented directly within the `main` method using an anonymous class.
- The `run()` method defines the task to be executed in the new thread.

This approach is particularly useful for short-lived tasks where you don’t need to create a separate class.

### 2. Using Lambda Expressions (Java 8 and Above)

With Java 8, the introduction of lambda expressions made it easier to write concise, functional-style code. Lambda expressions provide a cleaner and more readable way to define `Runnable` tasks without the boilerplate code of an anonymous class.

Here's how you can use a lambda expression to define a `Runnable`:

```java
class Main {
    public static void main(String[] args) {
        // Define Runnable using a lambda expression
        Runnable task = () -> {
            try {
                Thread.sleep(2000); // Simulate delay
                System.out.println("Task completed using Lambda expression.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Create and start the thread
        Thread thread = new Thread(task);
        thread.start();
    }
}
```
In this example:
- The `Runnable` interface is implemented using a lambda expression, making the code significantly shorter and easier to read.
- The task (implicitly defining the `run()` method) is executed in a new thread when `start()` is called.

#### Advantages of Lambda Expressions

- **Conciseness**: Lambda expressions eliminate the need for boilerplate code (e.g., you no longer need to write `new Runnable()` or explicitly type out the method overrides).
- **Readability**: The code is cleaner, more elegant, and focuses directly on the core task logic rather than structural syntax.

Lambda expressions are especially helpful when you need to pass short, temporary tasks to a thread and want to minimize the verbosity of your codebase.

---

## Fire and Forget: A Pattern in Multithreading

Both the `Runnable` interface and the `Thread` class naturally follow the **Fire and Forget** architectural pattern.

In this pattern, tasks are initiated (*fired*), but the system doesn't wait for a result or confirmation of their completion. Instead, the tasks are executed independently in the background, and the caller doesn't need to know when or how they finish.

This approach works exceptionally well when:
- The result of the background task is not critical to the immediate next steps of the application.
- The background tasks do not need to communicate their results back to the main invoking thread (e.g., logging, background cleanup, sending basic notifications).
- For instance, sending SMS, emails, or calculating an ETA can be handled using the Runnable method without waiting for confirmation of completion.

However, while the `Runnable` method is great for these decoupled scenarios, it hits a wall when a computed outcome is required by the main thread. This is where the `Callable` interface comes into play. In the next section, we will explore how to use `Callable` to handle tasks that require returning results.
