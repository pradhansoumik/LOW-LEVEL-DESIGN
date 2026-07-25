package Volatile;

class Counter
{
    volatile int count = 0;

    public void increment() {
        count++; // Still unsafe!
    }
}
