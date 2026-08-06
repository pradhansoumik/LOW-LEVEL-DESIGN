public class Singleton
{
    // Volatile object declaration
    /**
     * volatile keyword ensures changes made by one thread are visible to others. Without volatile, one thread might create the Singleton instance, but other threads may not see the updated value due to caching.
     * volatile ensures that the instance is always read from the main memory, so all threads see the most up-to-date version.
     */
    private static volatile Singleton instance;

    // Private constructor
    private Singleton() {}

    // Thread-safe method using double-checked locking
    public static Singleton getInstance()
    {
        if (instance == null) // check avoids synchronization once the instance is created
        {
            synchronized (Singleton.class)
            {
                if (instance == null) // ensures that only one thread creates the instance.
                {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
