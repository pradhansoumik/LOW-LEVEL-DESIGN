**Why Double-Checked Locking uses volatile?**

Thread A starts creating the Singleton.

- Memory allocated.
- Reference assigned → instance != null.
- Constructor still running.

Thread B comes in right after the reference is assigned but before the constructor finishes.

- It checks if (instance == null) → false (because reference is already set).
- It skips the inner if and uses the object.
- But the object hasn’t finished initialization yet → it’s partially initialized.

> Note: volatile ensures that the assignment to instance (making it non-null) cannot happen before the constructor finishes.
So Thread B will only ever see a fully initialized object.
> volatile forces the JVM to complete all construction steps before publishing the reference. So Thread B can never see a “partially initialized” object.

---

**Why Method Synchronization doesn't use volatile?**

Synchronized keyword does two things:

- Mutual exclusion → only one thread can enter the method at a time.
- Memory visibility guarantee → when a thread exits a synchronized block/method, all changes made inside are flushed to main memory. When another thread enters, it sees those changes.

so,

- Thread A creates the object inside the synchronized method.
- When Thread A exits, the JVM guarantees that the fully constructed object is visible to other threads.
- Thread B enters later, sees the updated instance, and gets the fully initialized object.
- No chance of “partially initialized” because synchronization already prevents reordering and ensures visibility.

>Note: The outer check (if (instance == null)) is done without synchronization.
That means multiple threads can read instance without memory visibility guarantees.
Without volatile, one thread might see a stale or partially constructed object.
That’s why volatile is essential in DCL but not in synchronized method.

**Simplified Analogy:**

- Synchronized method: Like a guarded vault. Only one person enters at a time, and when they leave, everything inside is updated and visible to the next person.
- DCL without volatile: Like peeking through a window without entering the vault. You might see an object inside before it’s fully placed.

---

**DCL without volatile**

1. Half-baked object (partially initialized)

   - Thread A starts creating the object.
   - JVM reorders instructions: assigns instance (non-null) before constructor finishes.
   - Thread B sees instance != null → skips inner if → uses object.
   - But fields may still be default values → partially initialized object.

2. Stale read (null reference)

   - Thread A finishes creating the object, but without volatile, the write to instance may not be visible immediately to other threads.
   - Thread B checks if (instance == null) and still sees null (because of caching or lack of memory visibility).
   - Thread B enters synchronized block and creates another instance.
   - Result: multiple Singleton instances.

Key Insight:

- Without volatile → two risks:
    - Thread B sees a non-null but half-baked object (due to reordering).
    - Thread B sees null even after construction (due to stale cache), and creates another instance.

- With volatile → both problems are solved:
    - Prevents reordering (ensures constructor finishes before assignment).
    - Ensures visibility (all threads see the updated reference immediately).

---

**Object Creation Steps:**

```java
instance = new Singleton();
```

The JVM breaks it into three steps (problematic reordered sequence):

Step 1: Allocate memory

- Reserve heap space.
- Initialize fields to default values (0, null, false).

Step 2: Assign reference

- Set instance to point to that memory.
- At this point, instance != null.

Step 3: Run constructor

- Execute constructor logic.
- Initialize fields with actual values.

⚡ Without volatile

- Steps 2 and 3 can reorder.
- So the JVM might do: Step 1 → Step 2 → Step 3.
- Another thread sees instance != null after Step 2 but before Step 3 → uses a half-baked object.
- Or, due to caching, another thread might still see null even after construction → creates another instance.

⚡ With volatile

- Prevents reordering.
- Guarantees Step 3 (constructor) happens-before Step 2 (assignment).
- Ensures visibility: once Thread A sets instance, all other threads see the fully constructed object.

So the enforced order is:

- Allocate memory.
- Run constructor.
- Assign reference.
