/**
 *  The instance is created only when the inner class is loaded, which happens only when getInstance() is called for the first time.
 */
public class Singleton
{
    // Private constructor
    private Singleton() {}

    // Static inner class to hold the Singleton instance
    private static class Holder
    {
        private static final Singleton INSTANCE = new Singleton();
    }

    // Public method to return the Singleton instance
    public static Singleton getInstance()
    {
        return Holder.INSTANCE;
    }
}
