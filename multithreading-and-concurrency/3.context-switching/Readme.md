# Context Switching and the Thread Scheduler

## Context Switching

Context Switching is the process of storing and restoring the state (or context) of a thread or process so that it can be resumed later. This allows the CPU to switch between different tasks or threads without interrupting their execution entirely, giving the illusion of parallelism, even on a single-core system.

### Real-life Analogy

Think of context switching like a **chef in a kitchen** who is working on multiple dishes:

- The chef is cooking a soup and suddenly needs to check on the roast in the oven.
- To do this, they stop stirring the soup (save its current state), go to check the roast, and then return to the soup (restore the saved state) once the roast is done.
- The chef switches between tasks, saving the current state of one dish while working on another, and then returns to the previous dish without losing progress.

### How Does Context Switching Happen?

For the context switch to execute, the following steps are executed in order:

1. **Interrupt:** A context switch happens when a running thread is interrupted by the operating system or when a higher-priority thread needs to be executed.
2. **Save State:** The state (such as registers, program counter, and other vital data) of the current thread is saved to memory, so that it can be resumed from the exact point it was paused.
3. **Load State:** The state of the next thread or process to be executed is loaded from memory, allowing the CPU to pick up where that thread left off.
4. **Switch Execution:** The CPU starts executing the new thread, continuing from where it was last stopped, and the process repeats when a new thread is scheduled.

### Importance of Context Switching

- **Multitasking:** Allows multiple threads or processes to run "concurrently" on a single core by switching between them rapidly.
- **Resource Management:** Ensures that no single task hogs the CPU, allowing better distribution of resources.
- **Efficiency:** Context switching enables the CPU to remain busy, optimizing performance even when handling multiple tasks.

## Thread Scheduler

- The thread scheduler is the part of the operating system that manages context switching. It decides when a thread should be paused and another should be run.

- The scheduler ensures efficient utilization of CPU resources, balancing the workload and giving the CPU time to execute multiple tasks.

- It uses **scheduling algorithms** (like round-robin, priority-based scheduling, etc.) to determine which thread should run next, triggering a context switch as necessary.

### Performance Considerations

- **Task Scheduler Overhead:** The task scheduler takes time to load and save the states of threads during context switching, which can add overhead to the system.
- **Decreased Performance:** As the number of threads increases, the time spent on context switching can grow significantly, leading to a performance degradation due to the extra CPU cycles spent on switching rather than executing tasks.