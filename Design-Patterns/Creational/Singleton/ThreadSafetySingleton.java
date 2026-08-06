public class Singleton
{
    // Object declaration
    private static Singleton instance;

    // Private constructor
    private Singleton() {}

    // Synchronized keyword used
    public static synchronized Singleton getInstance()
    {
        if (instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}
