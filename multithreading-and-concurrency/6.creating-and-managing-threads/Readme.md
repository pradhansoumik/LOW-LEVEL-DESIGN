# Creating and Managing Threads in Java

### Introduction

In many real-world applications, tasks are performed sequentially, where one task must be completed before the next one begins. While this approach is simple, it may not always be the most efficient, especially when tasks take a significant amount of time to complete.

By utilizing **multithreading**, we can optimize these scenarios by allowing multiple tasks to run concurrently, drastically improving overall efficiency.

---

### Problem Statement & Example Code Snippet

Let's explore a simple problem where multiple operations need to be executed sequentially, each taking a certain amount of time to complete.

Imagine you’ve placed an order, and the system needs to send three distinct notifications:
- **Send an SMS**: This takes 2 seconds.
- **Send an Email**: This takes 3 seconds.
- **Send ETA (Estimated Time of Arrival)**: This takes 5 seconds.

To simulate these real-world delays in Java, we will use the `Thread.sleep()` method from the `java.lang` package.

Below, we will look at the code that handles this problem in a traditional, sequential manner (without using Multithreading).

### Code Simulating Delays Sequentially Without Multithreading

```java

import java.util.*;

// OrderService class
class OrderService {

    // UberUseCase.Main method simulates placing an order and executing tasks sequentially
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Placing order...\n");

        // Send SMS and simulate the delay of 2 seconds
        sendSMS();
        System.out.println("Task 1 done.\n");

        // Send Email and simulate the delay of 3 seconds
        sendEmail();
        System.out.println("Task 2 done.\n");

        // Calculate ETA (Estimated Time of Arrival) with a delay of 5 seconds
        String eta = calculateETA();
        System.out.println("Order placed. Estimated Time of Arrival: " + eta);
        System.out.println("Task 3 done.\n");
    }

    // Method to simulate sending SMS with a 2-second delay
    private static void sendSMS() {
        try{
            Thread.sleep(2000); // Delay of 2 seconds
            System.out.println("SMS Sent!");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to simulate sending Email with a 3-second delay
    private static void sendEmail(){
        try{
            Thread.sleep(3000); // Delay of 3 seconds
            System.out.println("Email Sent!");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to simulate calculating the ETA with a 5-second delay
    private static String calculateETA() {
        try {
            Thread.sleep(5000); // Delay of 5 seconds
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "25 minutes"; // Returning the calculated ETA
    }
}

// Main class
class Main {

    public static void main(String[] args) {
        // Initiating the order processing by calling the OrderService main method
        try {
            OrderService.main(args); // Call the OrderService's main method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
**Understanding the Issue**

In real-world applications, executing tasks sequentially can lead to significant inefficiencies, especially when tasks involve waiting periods, such as sending SMS, emails, or calculating ETAs. In a purely sequential approach, each operation must complete before the next one begins, causing unnecessary delays and making the system slower than it needs to be.

For instance, while waiting for an SMS to be sent, the program is effectively "idle", unable to do anything else. This results in wasted time, especially in systems where responsiveness and speed are critical. By running tasks sequentially, we also limit the system's ability to handle multiple operations concurrently, which can lead to poor user experiences, slower processing times, and bottlenecks in performance.

This is where **multithreading** comes into play. By executing tasks concurrently, we can ensure that while one task is waiting (like sending an SMS), others can proceed without delay. Instead of idly waiting for each operation to finish, multithreading allows the system to be more responsive, efficiently utilizing time and resources.

---

# Implementing Multithreading - Different ways (Extending Thread Class, Runnable Interface, Callable Interface, ExecutorService)

## Implementing Multithreading by Extending the Thread Class

In Java, multithreading can be implemented using many different ways. One such way is by creating a subclass of the `Thread` class and overriding its `run()` method. Each thread will execute the code inside the `run()` method, allowing concurrent execution of tasks.

#### Key Concepts

- **Thread Class**: The `Thread` class is used to represent a thread in Java. By extending the `Thread` class, we can override its `run()` method to specify the operations or actions that the thread will perform. In other words, the `run()` method contains the code that defines what the thread will do when it is executed.
- **`start()` Method**: This method is used to spawn and start a new thread of execution. It internally handles the thread lifecycle allocation and calls the `run()` method asynchronously.
- **`join()` Method**: This method forces the calling thread (often the main thread) to pause and wait for the target thread to finish its execution before proceeding.


#### Code

```java
import java.util.*;

// Creating a subclass of Thread to send SMS
class SMSThread extends Thread {
    public void run() {
        try {
            Thread.sleep(2000); // 2-second delay for SMS
            System.out.println("SMS Sent using Thread.");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }    
}

// Creating a subclass of Thread to send Email
class EmailThread extends Thread {
    public void run() {
        try {
            Thread.sleep(3000); // 3-second delay for Email
            System.out.println("Email Sent using Thread.");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }    
}

// Creating a subclass of Thread to calculate ETA
class ETACalculationThread extends Thread {
    public void run() {
        try {
            Thread.sleep(5000); // 5-second delay for ETA calculation
            System.out.println("ETA Calculated using Thread. Estimated Time: 25 minutes.");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }    
}

class Main {
    public static void main(String[] args) {
        // Create thread objects for SMS, Email, and ETA Calculation
        SMSThread smsThread = new SMSThread();
        EmailThread emailThread = new EmailThread();
        ETACalculationThread etaThread = new ETACalculationThread();

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

The `SMSThread`, `EmailThread`, and `ETACalculationThread` classes extend `Thread` and override the `run()` method to simulate sending notifications with their respective delays.

- The `start()` method initiates the execution of each thread asynchronously.
- The `join()` method ensures the main thread pauses and waits for these tasks to finish before continuing.

The previous code demonstrates three concurrent tasks running on separate threads by extending the `Thread` class.

**Demerit: No Return Type in the `run()` Method**

A key limitation of the `Thread` class in Java is that the `run()` method has a `void` return type and **cannot return a value**. This means if your background task computes a result—such as an ETA string—you cannot directly pass that value back to the caller from the `run()` method.

> **Note**: Advanced techniques to retrieve a result from a running thread (such as using the `Callable` interface and `Future`) will be discussed in a later part of this article.