package Synchronized;

class SafeCounter
{
    private int count = 0;

    // Entire method is protected by the instance’s monitor lock
    public synchronized void increment()
    {
        count++; // atomic under the lock
    }

    public synchronized int getCount()
    {
        return count;
    }
}
class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        SafeCounter safeCounter = new SafeCounter();

        Runnable task =
                () -> {
                    for(int i = 0; i<1000 ;i++){
                        safeCounter.increment();
                    }
                };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // Expect 2000, and always get it
        System.out.println("Final Count: " + safeCounter.getCount());
    }
}