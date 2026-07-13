# Thread Lifecycle Flow

The lifecycle of a thread in Java follows a specific flow as shown in the diagram:

**Thread Lifecycle Flow** → [Thread Lifecycle Flow](/thread-lifecycle.png)

## States in Thread Lifecycle

A thread undergoes various states during its execution. These states represent different phases a thread can be in from its creation to termination.

### Key Thread States

- **New**: The thread is created but has not been started yet.
- **Runnable**: The thread is eligible to run but is not necessarily actively executing. It transitions to the *Running* state when the thread scheduler selects it (CPU picks it for execution).
- **Running**: The thread is actively executing its task on the CPU.
- **Blocked**: The thread is waiting to acquire a monitor lock or resource that is currently held by another thread.
- **Waiting**: The thread is waiting indefinitely for another thread to perform a specific action (triggered by methods like `wait()` or `join()`).
- **Timed Waiting**: The thread is waiting for a specific, predefined period of time (triggered by methods like `sleep(time)` or `join(time)`).
- **Terminated**: The thread has completed its execution or is stopped.The thread has completed its execution or is stopped.

---

### State Transitions

The lifecycle of a thread involves moving between these states based on system events or method calls:

* **New $\rightarrow$ Runnable**: Occurs when the `start()` method is called on the thread object.
* **Runnable $\rightarrow$ Running**: Occurs when the OS thread scheduler picks the thread for execution.
* **Running $\rightarrow$ Blocked**: Occurs when the thread attempts to access a synchronized block or resource currently locked by another thread.
* **Blocked $\rightarrow$ Runnable**: Occurs when the required lock or resource becomes available.
* **Running $\rightarrow$ Waiting**: Occurs when the thread explicitly calls methods like `wait()`, `join()`, or parks itself.
* **Waiting $\rightarrow$ Runnable**: Occurs when another thread issues a notification via `notify()` or `notifyAll()`, or the joining thread finishes.
* **Timed Waiting $\rightarrow$ Runnable**: Occurs automatically once the specified waiting time expires.
* **Runnable $\rightarrow$ Terminated**: Occurs immediately when the thread finishes its execution context.