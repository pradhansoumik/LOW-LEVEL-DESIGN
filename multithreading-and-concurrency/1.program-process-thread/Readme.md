# Multithreading and Concurrency (Program, Process and Thread)

## Program, Process and Thread

In software development, we often come across the terms program, process, and thread. While they may seem similar at first glance, they represent different concepts that are crucial to understanding how computers execute tasks. To make it easier to grasp, let’s first start with a real-world analogy.

## Real-World Analogy

Imagine you’re running a bakery. Here’s how we can relate the terms program, process, and thread:

- **Program:** Think of a recipe book. A recipe book is a collection of instructions, but it doesn’t do anything on its own. It's just a set of written plans for making different types of cakes, bread, etc. The recipe book is like a program: a static set of instructions to be followed.
- **Process:** Now, imagine you decide to bake a cake. You pick a recipe from the book and follow the instructions. The baking process is the process: it’s the execution of the recipe (the program) in action. A process is a running instance of a program, actively working in memory.
- **Thread:** Inside your bakery, there may be multiple bakers working at the same time. One might be mixing ingredients, another might be preheating the oven, and another might be icing the cake. Each baker represents a thread: a smaller task within the overall process. Multiple threads can run concurrently, each handling part of the job.

## Program

A program is a collection of instructions written in a programming language that is intended to perform a specific task or solve a particular problem. It’s like the recipe book mentioned earlier—static, not doing anything until it is run.

**Example:** If you download `chrome.exe` from the internet, `chrome.exe` is a program. It’s just a file sitting on your computer. It contains instructions on how to launch and interact with Google Chrome, but it’s not doing anything until you run it.

## Process

A process is an instance of a program that is being executed. When you launch a program (like opening `chrome.exe`), it gets loaded into memory and starts running. This running instance is called a process. A process includes the program code, current activity, and other resources like memory, CPU usage, and input/output.

**Example:** Continuing with the `chrome.exe` example, once you double-click on the Chrome icon to launch the browser, a process is created. The program code in `chrome.exe` is now running in memory as a process, using system resources like memory and CPU time.

**Keypoints**

- Each process has its own address space.
- Runs independently from other processes.
- Can execute without interfering unless allowed (e.g., inter-process communication).
- Managed by the operating system, ensuring it gets the necessary resources.

## Thread

A thread is the smallest unit of execution within a process. A process can contain multiple threads, which share the same resources but run independently. Each thread can perform a separate task within the same process. Threads allow for parallelism, where multiple tasks are executed simultaneously.

**Example:** Within the `chrome.exe` process, there might be several threads running concurrently. For instance, one thread might be responsible for rendering the UI (user interface), another for managing network requests, and another for handling user inputs like clicks or key presses. These threads all operate within the `chrome.exe` process but perform different tasks at the same time.

**Keypoints**

- Threads are referred to as "lightweight" processes.
- They share resources like memory and CPU time with other threads in the same process.
- Threads within the same process share memory, allowing them to communicate more easily than separate processes.

## Why Understanding These Concepts Matters

- **Program:** Understanding the program is essential for writing efficient code that can be turned into a process.
- **Process:** Processes allow us to execute programs, but they come with limitations like memory and resource allocation, which is why understanding how processes are managed is crucial for optimizing applications.
- **Thread:** Threads are at the heart of performance optimization. By breaking a process into multiple threads, we can perform tasks concurrently, speeding up execution and improving user experience.

## Program → Process → Thread Lifecycle

```text
+---------------------------------------------------+
|                     Program                       |
|---------------------------------------------------|
| Superset of Processes                             |
|                                                   |
|   +-------------------+    +-------------------+  |
|   |     Process 1     |    |     Process 2     |  |
|   |-------------------|    |-------------------|  |
|   | Superset of       |    | Superset of       |  |
|   | Threads           |    | Threads           |  |
|   |                   |    |                   |  |
|   |  +-----------+    |    |  +-----------+    |  |
|   |  | Thread 1  |    |    |  | Thread 1  |    |  |
|   |  +-----------+    |    |  +-----------+    |  |
|   |  | Thread 2  |    |    |  | Thread 2  |    |  |
|   |  +-----------+    |    |  +-----------+    |  |
|   |  | Thread 3  |    |    |  | Thread 3  |    |  |
|   |  +-----------+    |    |  +-----------+    |  |
|   +-------------------+    +-------------------+  |
|                                                   |
+---------------------------------------------------+
```
