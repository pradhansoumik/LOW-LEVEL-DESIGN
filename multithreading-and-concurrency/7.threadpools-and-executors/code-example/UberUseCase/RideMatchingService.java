package UberUseCase;

// Ride Matching Service Class

/**
 * Manual Execution - Without Executor Framework
 * Thread -> Runnable Task
 */
class RideMatchingService {

    // Method handling ride request
    public void requestRide(String riderId) {

        // Creating a new thread for the ride
        Thread matchThread = new Thread(() -> {
            System.out.println("Matching rider " + riderId + " to a driver..."+" using thread: "+Thread.currentThread().getName());
            // Simulate some processing
            try
            {
                Thread.sleep(2000); // Simulate a 1-second matching process
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println("Ride matched for rider " + riderId + " using thread: " + Thread.currentThread().getName());
        });
        matchThread.start();
    }
}

class Main {
    public static void main(String[] args) {
        RideMatchingService rideService1 = new RideMatchingService();
        RideMatchingService rideService2 = new RideMatchingService();

        rideService1.requestRide("Raj");//part of new thread
        System.out.println("task1 running..."+" using thread: "+Thread.currentThread().getName());//part of main thread

        rideService2.requestRide("John Doe"); //part of another new thread
        System.out.println("task2 running..."+" using thread: "+Thread.currentThread().getName()); //part of main thread
    }
}