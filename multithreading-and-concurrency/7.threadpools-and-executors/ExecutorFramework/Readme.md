# Executor Framework

The Executor Framework in Java is a high-level API that provides a simple and flexible mechanism for managing and controlling thread execution. It decouples:
* **Task Submission**: What you want to do.
* **Task Execution**: How and when it runs.

allowing you to manage threads more efficiently. This framework is part of Java’s `java.util.concurrent` package and simplifies the process of handling threads. Let's us understand the key concepts of Executor Frameworks first.

### 1. Executor Interface

The `Executor` interface is the foundation of the Executor Framework. It defines a single method:
* `void execute(Runnable command)`: The `execute` method takes a `Runnable` task and runs it asynchronously in a thread. It doesn’t return any result, and you can’t track the execution outcome directly.

### 2. ExecutorService Interface

`ExecutorService` extends the `Executor` interface and adds methods for managing and controlling the lifecycle of threads.

**Key Methods**:
* `submit(Callable task)`: Returns a `Future` object which allows you to track the progress of the task.
* `shutdown()`: Initiates an orderly shutdown of the executor, rejecting any new tasks but processing the already submitted ones.
* `shutdownNow()`: Tries to stop all actively executing tasks and halts the processing of waiting tasks.

### 3. ThreadPoolExecutor Class

`ThreadPoolExecutor` is a concrete implementation of `ExecutorService` and is one of the most commonly used classes. It allows you to define a pool of threads to execute tasks.

**Key Parameters**:
* `corePoolSize`: The number of threads to keep in the pool.
* `maximumPoolSize`: The maximum number of threads allowed in the pool.
* `keepAliveTime`: Time for which idle threads will be kept alive before being terminated.
* `workQueue`: A queue used to hold tasks before they are executed.

### 4. Executors Class

`Executors` is a utility class that provides factory methods to create predefined types of executor services.

**Common Methods**:
* `newFixedThreadPool(int nThreads)`: Creates a thread pool with a fixed number of threads.
* `newCachedThreadPool()`: Creates a thread pool that can dynamically grow and shrink.
* `newSingleThreadExecutor()`: Creates a single-threaded executor.


### Code - execute()

Here’s a code snippet using the Executor Framework to handle email sending tasks efficiently.

```java
import java.util.concurrent.*;

// Using the newFixedThreadPool to manage threads
class EmailService {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10); // Thread pool with 10 threads

    // Method to send email
    public static void sendEmail(String recipient) {
        executor.execute(() -> {
            System.out.println("Sending email to " + recipient + " on " + Thread.currentThread().getName());
            try {
                // Simulate dummy work (sending an email)
                Thread.sleep(1000);  // Simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();  // Handle interruption
            }
            System.out.println("Email sent to " + recipient);
        });
    }

    // Main method to simulate sending multiple emails
    public static void main(String[] args) {
        for (int i = 1; i <= 25; i++) {
            sendEmail("user" + i + "@gmail.com");  // Send email to 1000 users
        }
        executor.shutdown();  // Gracefully shut down the executor
    }
}
```
#### Understanding the Code:

* `ExecutorService executor = Executors.newFixedThreadPool(10);`
  This creates a thread pool with a fixed size of 10 threads. It means the system can process a maximum of 10 email sending tasks concurrently. If more tasks are submitted, they will wait in a queue until a thread becomes available.
* `executor.execute(() -> { ... });`
  This method is used to submit a task to the executor. The task here is a Runnable that sends an email. The task is executed by one of the threads from the thread pool.
* `Thread.sleep(1000);`
  This simulates some dummy work (like sending an email). The thread sleeps for 1 second to simulate the time it takes to send an email.
* `executor.shutdown();`
  This initiates an orderly shutdown of the executor. It ensures that all submitted tasks are completed before the program terminates.

### Why Use Executor Frameworks?

- **Simplified Thread Management**: The framework handles thread creation, task execution, and management for you, reducing boilerplate code.
- **Efficient Resource Management**: By using thread pools, you avoid the overhead of creating new threads for every task, leading to better performance.
- **Graceful Shutdown**: Executor services allow for a clean shutdown, ensuring that all tasks complete before the system terminates.

---

### Methods to Submit Tasks

In Java’s Executor Framework, submitting tasks is a fundamental operation that determines how tasks are executed asynchronously. The `ExecutorService` provides several methods to submit tasks for execution. Let's understand them one by one.


#### 1. `execute()` Method
* **Purpose**: It is used to submit `Runnable` tasks (tasks that do not return any result).
* **Return Type**: It does not return a result (`void`). This method simply submits the task for execution and doesn't provide a way to track the result or catch exceptions directly in the invoking thread.
* **Usage**: It's ideal for "fire-and-forget" tasks where you don't need a result back from the task (e.g., logging, sending a background email, etc.).

> **Note**: This method is part of the core `Executor` interface and was covered in the previous section.

#### 2. `submit()` Method
* **Purpose**: It is used to submit both `Runnable` and `Callable` tasks (tasks that can return a result).
* **Return Type**: It returns a `Future` object, which allows you to track the progress of the task, retrieve the final result, and handle any exceptions thrown during execution.
* **Usage**: It’s ideal for tasks where you need to capture and process the computed outcome (e.g., performing mathematical calculations or fetching external data).

Let's understand the `submit()` method through a detailed example in the next section.

---

### Summary: When to Use Each

* **Use `execute()`** for **fire-and-forget** tasks where you don't need a result back and don't need to track task completion status.
* **Use `submit()`** when you need to **retrieve a result**, track progress, or handle potential exceptions with the help of a `Future` object.

---

### Code - submit() method

In this section, we’ll break down how the submit() method works and how it interacts with the Future object to manage task results. Let's understand this better through the below code:

```java
import java.util.concurrent.*;

// Future and Submit example
class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(1000);
            return 77;
        });

        System.out.println("Doing other work...");

        Integer result = future.get(); // blocks until result is ready
        System.out.println("Result: " + result);

        executor.shutdown();
    }
}
```
### Key Concepts to Understand:

#### 1. `submit()` Method
The `submit()` method is a versatile way to submit tasks to an executor. It accepts both `Runnable` and `Callable` tasks:
* **Runnable**: A task that doesn’t return a result.
* **Callable**: A task that can return a result (like our example where `77` is returned).

The method returns a `Future` object, which can be used to monitor the task's progress and retrieve the result once it completes.

#### 2. `Future` Object
The `Future` object represents the result of an asynchronous computation. It allows you to:
* Track the completion of the task.
* Get the result using `get()`, which blocks the calling thread until the task finishes.
* Cancel the task if it hasn’t started yet.

#### 3. `get()` Method
The `get()` method of the `Future` object is blocking, meaning it will pause the calling thread until the task has finished executing and the result is ready.

If the task has already completed, `get()` will return the result immediately. Otherwise, it will wait for the task to finish.

#### 4. Graceful Shutdown
The `shutdown()` method is used to stop the executor service after all submitted tasks have been completed. It’s important to always call `shutdown()` to release resources and properly shut down the thread pool.

---

## Why Use `submit()` and `Future`?

* **Asynchronous Task Execution**: `submit()` allows tasks to run asynchronously, meaning they won’t block the main thread. This is useful for performing background tasks such as handling user requests, processing data, etc.
* **Result Handling**: The `Future` object provides a way to handle the result of the task, including retrieving the outcome once it's ready.
* **Control and Flexibility**: You can monitor the progress of the task, cancel it if necessary, and manage its lifecycle effectively.

---

### Shutdown Methods in Executor Class

The `ExecutorService` in Java provides two important methods for shutting down an executor: `shutdown()` and `shutdownNow()`. These methods are essential for gracefully terminating the execution of tasks and releasing resources when they are no longer needed.

#### 1. shutdown() method

```java
    executor.shutdown();
```
* **Purpose**: Initiates an orderly shutdown of the executor service. Once this method is called, the executor will stop accepting new tasks but will continue to process the tasks that have already been submitted.
* **Return Type**: `void` (No return value)
* **Usage**:
    * `shutdown()` is typically used when you want to allow the executor to finish executing all tasks in the queue before shutting down.
    * It ensures that the executor doesn't accept any new tasks but still processes the tasks that have already been submitted.

#### 2. shutdownNow() method

```java
    List<Runnable> pendingTasks = executor.shutdownNow();
```
* **Purpose**: Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were waiting to be executed.
* **Return Type**: `List<Runnable>` — Returns a list of the tasks that were in the executor’s queue but were not executed.
* **Usage**:
    * `shutdownNow()` tries to immediately stop all tasks, including those that are currently running.
    * It does not guarantee that all tasks will be stopped; it may just attempt to interrupt them.
    * It returns a list of tasks that have not yet started executing, so you can handle those tasks or retry them later if needed.
