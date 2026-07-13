# Thread Starvation and Fairness

In multi-threaded systems, thread starvation and fairness are key concepts that ensure threads are scheduled properly without some being unfairly blocked or neglected.

### Thread Starvation
Thread starvation occurs when a thread is perpetually unable to access the resources it needs for execution due to high contention, often caused by prioritizing certain threads over others. As a result, low-priority threads or threads with resource dependencies may never get a chance to execute.

**Cause of Thread Starvation**:
* **High Thread Priority**: Higher-priority threads monopolize CPU time, blocking lower-priority threads.
* **Infinite Blocking**: Threads waiting for resources may never gain access due to constant contention.
* **Lack of Fair Scheduling**: Systems that don’t implement fairness may neglect certain threads, causing starvation.


### Fairness in Thread Scheduling

Fairness ensures that all threads get an opportunity to execute, preventing some threads from being permanently blocked. A fair scheduler allocates CPU time evenly across all threads, preventing starvation.

**Fixes for Thread Safety**:
* Adjusting Thread Priorities
* Implementing Fair Locks
* Using Time Slicing or Round Robin Scheduling
* Adopting Fair Scheduling Algorithms
* Leveraging Executor Services for Task Management