/**
 * Let’s say we are building a ride-matching service for a ride-hailing platform. The matching behavior changes depending on conditions such as proximity, surge areas, or airport queues.
 *
 * Here’s a naive implementation of this logic:
 */

import java.util.*;

// Class implementing Ride Matching Service
class RideMatchingService
{
    public void matchRider(String riderLocation, String matchingType)
    {
        // Match rider using different hardcoded strategies
        if (matchingType.equals("NEAREST"))
        {
            // Find nearest driver
            System.out.println("Matching rider at " + riderLocation + " with nearest driver.");
        }
        else if (matchingType.equals("SURGE_PRIORITY")) {
            // Match based on surge area logic
            System.out.println("Matching rider at " + riderLocation + " based on surge pricing priority.");
        }
        else if (matchingType.equals("AIRPORT_QUEUE")) {
            // Use FIFO-based airport queue logic
            System.out.println("Matching rider at " + riderLocation + " from airport queue.");
        }
        else
        {
            System.out.println("Invalid matching strategy provided.");
        }
    }
}

// Client Code
public class Main
{
    public static void main(String[] args)
    {
        RideMatchingService service = new RideMatchingService();

        // Try different strategies
        service.matchRider("Downtown", "NEAREST");
        service.matchRider("City Center", "SURGE_PRIORITY");
        service.matchRider("Airport Terminal 1", "AIRPORT_QUEUE");
    }
}
/**
 * Violation of Open/Closed Principle: Adding a new strategy (e.g., VIP rider matching) would require modifying the RideMatchingService class. This tightly couples strategy logic with the core class.
 * Code Becomes Messy: As more conditions are added, the number of if-else branches grows, making the code harder to maintain and read.
 * Difficult to Test or Reuse: Individual matching strategies are not reusable or testable in isolation. All logic is embedded inside a single method.
 * No Separation of Concerns: The class handles both coordination (service logic) and implementation (strategy logic), which reduces flexibility.
 */