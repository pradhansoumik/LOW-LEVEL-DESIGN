// Logistics Interface
interface Logistics
{
    void send();
}

// Class implementing the Logistics Interface
class Road implements Logistics
{
    @Override
    public void send()
    {
        System.out.println("Sending by road logic");
    }
}

// Class implementing the Logistics Interface
class Air implements Logistics
{
    @Override
    public void send()
    {
        System.out.println("Sending by air logic");
    }
}

// Class implementing Logistics Service
class LogisticsService
{
    public void send(String mode)
    {
        if (mode.equals("Air"))
        {
            Logistics logistics = new Air();
            logistics.send();
        }
        else if (mode.equals("Road"))
        {
            Logistics logistics = new Road();
            logistics.send();
        }
    }
}

// Driver code
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
 * Understanding the Issue:
 *  In the LogisticsService class:
 *  The object of Air or Road is directly instantiated based on string comparison.
 *  The object creation logic is embedded inside the business logic (send method).
 *  This violates the Open/Closed Principle — if you want to add a new mode (e.g., Ship), you have to modify the send method.
 *
 * Problems:
 *  Tight Coupling: LogisticsService depends directly on Air and Road classes.
 *  Hard to Extend: Adding a new mode (e.g., Drone, Ship) requires modifying existing code.
 *  No Separation of Concerns: Object creation and business logic are mixed.
 *  Code Duplication: Repeated instantiation and send() logic.
 *  Testing & Maintenance Nightmare: Hard to test independently or mock logistics.
 */
