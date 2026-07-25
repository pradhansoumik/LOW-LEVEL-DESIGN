package Volatile;

class SharedData
{
    volatile boolean flag = false;

    public void writer()
    {
        flag = true;
    }

    public void reader() {
        if (flag)
        {
            // guaranteed to see true if another thread wrote it
        }
    }
}
class Main
{
    public static void main(String[] args) {


    }
}
