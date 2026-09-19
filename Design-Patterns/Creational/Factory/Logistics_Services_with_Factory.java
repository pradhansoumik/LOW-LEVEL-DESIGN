// Logistic Interface
interface Logistics
{
    void send();
}

// Class implementing the Logistics Interface
class Road implements Logistics
{
    @Override
    public void send() {
        System.out.println("Sending by road logic");
    }
}

// Class implementing the Logistics Interface
class Air implements Logistics
{
    @Override
    public void send() {
        System.out.println("Sending by air logic");
    }
}

// Factory Class taking care of Logistics
class LogisticsFactory
{
    public static Logistics getLogistics(String mode)
    {
        if (mode.equalsIgnoreCase("Air"))
        {
            return new Air();
        }
        else if (mode.equalsIgnoreCase("Road"))
        {
            return new Road();
        }
        throw new IllegalArgumentException("Unknown logistics mode: " + mode);
    }
}

// Class implementing the Logistics Services
class LogisticsService
{
    public void send(String mode)
    {
        /* Using the Logistics Factory to get the
        desired object based on the mode */
        Logistics logistics = LogisticsFactory.getLogistics(mode);
        logistics.send();
    }
}

// Driver Code
class Main
{
    public static void main(String[] args)
    {
        LogisticsService service = new LogisticsService();
        service.send("Air");
        service.send("Road");
    }
}

/**
 * Understanding the Improvement:
 *
 * In this refactored code:
     * The object creation logic is moved to the LogisticsFactory.
     * The LogisticsService class now only focuses on business logic.
     * Adding a new mode (e.g., Ship) only requires modifying the factory, not the service.
     *
 *
 * Benefits:
     * Loose Coupling: The service is decoupled from specific logistics classes.
     * Open/Closed Principle: New modes can be added without modifying existing code.
     * Separation of Concerns: Object creation and business logic are separated.
     * No Code Duplication: Instantiation logic is centralized in the factory.
     * Easier Testing & Maintenance: Each component can be tested independently.
*/
