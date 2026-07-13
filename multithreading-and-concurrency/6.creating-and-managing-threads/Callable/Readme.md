# Implementing Multithreading by Using the Callable Interface and Future

In Java, the **`Callable` interface** provides an enhanced way to implement multithreading when you need tasks to return a result. Unlike the previously discussed methods, which do not return any result, `Callable` allows the thread to return a value once the task completes. However, since the `run()` method of `Runnable` cannot return a result (it’s `void`), the `Callable` interface provides a `call()` method, which can return any type of value.

In addition, **`Future`** is an interface that represents the result of an asynchronous computation. It provides methods to check the status of a task and retrieve the result once it’s available, thus allowing you to avoid the limitations of the `Thread` and `Runnable` approaches.

### Key Concepts

- **`Callable` Interface**: The `Callable` interface is similar to `Runnable`, but its `call()` method is designed to return a result, unlike `run()`. It also allows for throwing exceptions, which is useful for more complex tasks.
- **`call()` Method**: The `call()` method in the `Callable` interface contains the code for the task and can return any value (unlike `run()` in `Runnable`). It also allows the task to throw checked exceptions.
- **`ExecutorService`**: While you can directly use `Thread` with `Callable`, it's recommended to use `ExecutorService` for better thread management. The `ExecutorService` provides a method called `submit()` to submit a `Callable` task and returns a `Future` object that can be used to retrieve the result later.

---

### Code Example

```java
import java.util.concurrent.*;

// Implementing Callable to calculate ETA (only this task requires a return value)
class ETACalculationTask implements Callable<String> {
    public String call() throws InterruptedException {
        Thread.sleep(5000); // Simulate 5-second delay for ETA calculation
        System.out.println("Calculation ETA using Callable.");
        return "ETA: 25 minutes"; // Return the ETA result
    }
}

// Implementing Runnable to send SMS (no return value required)
class SMSTask implements Runnable {
    public void run() {
        try {
            Thread.sleep(2000); // Simulate 2-second delay for SMS
            System.out.println("SMS Sent using Runnable.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Implementing Runnable to send Email (no return value required)
class EmailTask implements Runnable {
    public void run() {
        try {
            Thread.sleep(3000); // Simulate 3-second delay for Email
            System.out.println("Email Sent using Runnable.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Create ExecutorService to manage threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Create Callable task for ETA calculation and Runnable tasks for SMS and Email
        SMSTask smsTask = new SMSTask();
        EmailTask emailTask = new EmailTask();
        ETACalculationTask etaTask = new ETACalculationTask();

        // Submit tasks and get Future objects for the ETA task
        Future<String> etaResult = executorService.submit(etaTask);

        // Submit the SMS and Email tasks (no result required)
        executorService.submit(smsTask);
        executorService.submit(emailTask);

        try {
            // Get the result from the Future object for ETA
            System.out.println(etaResult.get()); // Wait for ETA task to finish and print result
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown the ExecutorService
        executorService.shutdown();
    }
}
```
**Explanation**

- **Runnable and Callable Tasks**: In this example, the SMS and Email tasks implement the `Runnable` interface because they only perform an action and do not return any value. The ETA calculation task implements the `Callable` interface because it needs to return the calculated ETA result.
- **Thread Management with `ExecutorService`**: We create an `ExecutorService` using `Executors.newFixedThreadPool(3)`. This provisions a thread pool with 3 worker threads, allowing the SMS, Email, and ETA tasks to run concurrently.
- **Submitting Tasks**: The `submit()` method is used to submit both `Runnable` and `Callable` tasks to the executor. The SMS and Email tasks are submitted as `Runnable` tasks, while the ETA task is submitted as a `Callable` task.
- **Result Retrieval with `Future`**: Since the ETA task returns a value, `executorService.submit(etaTask)` returns a `Future<String>`. We use the `get()` method on this `Future` object to wait for the ETA task to complete and retrieve its result.
- **Blocking Nature of `get()`**: The `etaResult.get()` method blocks the main thread until the ETA calculation is completed. Once the ETA task finishes, the returned value is printed.
- **`shutdown()`**: Finally, we call `shutdown()` on the `ExecutorService`. This prevents new tasks from being submitted and allows already submitted tasks to complete before the executor terminates.

---
## Future and FutureTask

### Using Future to Retrieve Results

When you submit a task using `Callable`, the `ExecutorService` returns a `Future` object. The `Future` interface provides methods to check the status of a task and retrieve its result once it completes.

#### Key Concepts

**Future Interface**: The `Future` interface represents the result of an asynchronous computation. You can use it to:
    - **Retrieve the result**: The `get()` method blocks the main thread until the task completes and returns the result.
    - **Check the status**: Methods like `isDone()` and `isCancelled()` help you check if the task is completed or canceled.
    - **Cancel the task**: The `cancel()` method attempts to cancel the task before it finishes.

As shown in the code above, the result after the ETA Calculation is retrieved using the `Future` interface. Another method to retrieve results from `Callable` is to use `FutureTask`.

---

### Using FutureTask to Retrieve Results

`FutureTask` is a concrete implementation of the `Future` interface. It is used to wrap a `Callable` task and execute it asynchronously. The benefit of using `FutureTask` is that it can be executed like a `Runnable` (i.e., passed directly to a `Thread`), while still maintaining the ability to store and return the result of the task.

#### Key Concepts

- **`FutureTask` Class**: It implements both `Runnable` and `Future`, making it a versatile tool for concurrent tasks. You can submit a `FutureTask` to a thread pool or execute it directly via a standard `Thread`.
- **`get()` Method**: Just like `Future`, `FutureTask` allows you to retrieve the result of the task via `get()`.


#### Example Code: Using FutureTask for Retrieval

```java
import java.util.*;

// Implementing Callable to calculate ETA (only this task requires a return value)
class ETACalculationTask implements Callable<String> {
    public String call() throws InterruptedException {
        Thread.sleep(5000); // Simulate 5-second delay for ETA calculation
        System.out.println("ETA calculated using Callable.");
        return "ETA: 25 minutes"; // Return the ETA result
    }
}

// Implementing Runnable to send SMS (no return value required)
class SMSTask implements Runnable {
    public void run() {
        try {
            Thread.sleep(2000); // Simulate 2-second delay for SMS
            System.out.println("SMS Sent using Runnable.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Implementing Runnable to send Email (no return value required)
class EmailTask implements Runnable {
    public void run() {
        try {
            Thread.sleep(3000); // Simulate 3-second delay for Email
            System.out.println("Email Sent using Runnable.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Create FutureTask object for ETA calculation task (since it returns a result)
        FutureTask<String> etaTask = new FutureTask<>(new ETACalculationTask());

        // Create Runnable tasks for SMS and Email
        SMSTask smsTask = new SMSTask();
        EmailTask emailTask = new EmailTask();

        // Create Thread objects to run all tasks
        Thread etaThread = new Thread(etaTask);
        Thread smsThread = new Thread(smsTask);
        Thread emailThread = new Thread(emailTask);

        System.out.println("Task Started.\n");

        // Start all threads
        etaThread.start();
        System.out.println("Task 1 ongoing...");

        smsThread.start();
        System.out.println("Task 2 ongoing...");

        emailThread.start();
        System.out.println("Task 3 ongoing...");

        try {
            // Get the result from the FutureTask for ETA
            System.out.println((String)etaTask.get()); // Wait for ETA task to finish and print result

            // Wait for SMS and Email tasks to finish (no result needed)
            smsThread.join();
            emailThread.join();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed.");
    }
}

```
