# Fixed vs Cached vs Scheduled Thread Pools

Java’s `ExecutorService` provides different types of thread pools that help manage and execute tasks in a concurrent environment. The three most common types of thread pools are Fixed Thread Pool, Cached Thread Pool, and Scheduled Thread Pool. Each type has specific use cases, advantages, and disadvantages.

---

### 1. Fixed Thread Pool

A Fixed Thread Pool creates a pool with a fixed number of threads. Once a task is submitted, the executor assigns it to an available thread from the pool. If all threads are busy, new tasks are queued until a thread becomes available.

* **Use Case**: Applications where the number of tasks is known in advance, and the system should process a fixed number of concurrent tasks (e.g., handling a fixed number of user requests simultaneously).
* **Advantages**:
    * **Predictable resource usage**: The number of threads is fixed, so system resources are predictable.
    * **Better control**: You can control the maximum number of concurrent threads, avoiding system overload.
* **Disadvantages**:
    * **Limited scalability**: If all threads are busy and the task queue fills up, tasks must wait in the queue, potentially delaying execution.
    * **Underutilization**: If fewer tasks are available than the number of threads, some threads may remain idle, wasting system resources.

---

### 2. Cached Thread Pool

A Cached Thread Pool creates new threads as needed but reuses previously constructed threads when they are available. If a thread remains idle for more than 60 seconds, it is terminated and removed from the pool.

* **Use Case**: Short-lived tasks that are executed intermittently, such as handling burst traffic or processing small background tasks where thread usage is unpredictable.
* **Advantages**:
    * **Scalable**: Threads are created dynamically, and the pool can grow as needed to handle bursts of tasks.
    * **Efficient resource use**: Threads are reused whenever possible, reducing the cost of thread creation.
* **Disadvantages**:
    * **Potential for thread explosion**: If the system experiences a high volume of tasks at once, a large number of threads may be created, leading to resource exhaustion.
    * **Less predictable resource usage**: The number of threads can fluctuate significantly, making resource management more difficult.

---

### 3. Scheduled Thread Pools

A Scheduled Thread Pool allows you to schedule tasks with fixed-rate or fixed-delay execution policies. It supports delayed or periodic execution of tasks, making it useful for scheduling tasks at regular intervals or after a specific delay. Let's understand with the code given:

```java
class SessionCleaner {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Cleaning up expired sessions...");

        scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
    }
}
```

#### Explanation

In the above example, a session-cleaning task is scheduled to run every 5 seconds, starting immediately (`initialDelay = 0`). This is achieved using `scheduleAtFixedRate()`, which ensures periodic execution using a `ScheduledExecutorService`.


#### Use Case

Applications that need to perform tasks at fixed intervals or after a certain delay, such as periodic data synchronization, background maintenance tasks, or scheduled jobs.


#### Advantages

* **Task scheduling**: Allows scheduling tasks with a delay or periodic execution.
* **Flexible**: Provides methods for scheduling tasks at fixed-rate intervals or with a fixed delay between executions.


#### Disadvantages

* **Less efficient for short-lived tasks**: Not ideal for tasks that are short-lived or don’t need to be scheduled periodically.
* **Thread management overhead**: Managing scheduled tasks requires additional overhead for tracking execution times and intervals.