/**
 * Imagine you're developing a movie ticket booking application, like BookMyShow. Let's first take a look at a poorly structured approach to implementing the booking functionality.
 * The Bad Way (Without Using Facade pattern)
 */
// Service class responsible for handling payments
class PaymentService
{
    public void makePayment(String accountId, double amount)
    {
        System.out.println("Payment of ₹" + amount + " successful for account " + accountId);
    }
}

// Service class responsible for reserving seats
class SeatReservationService
{
    public void reserveSeat(String movieId, String seatNumber)
    {
        System.out.println("Seat " + seatNumber + " reserved for movie " + movieId);
    }
}

// Service class responsible for sending notifications
class NotificationService
{
    public void sendBookingConfirmation(String userEmail)
    {
        System.out.println("Booking confirmation sent to " + userEmail);
    }
}

// Service class for managing loyalty/reward points
class LoyaltyPointsService
{
    public void addPoints(String accountId, int points)
    {
        System.out.println(points + " loyalty points added to account " + accountId);
    }
}

// Service class for generating movie tickets
class TicketService
{
    public void generateTicket(String movieId, String seatNumber)
    {
        System.out.println("Ticket generated for movie " + movieId + ", Seat: " + seatNumber);
    }
}

// Client Code
class Main
{
    public static void main(String[] args)
    {
        // Booking a movie ticket manually (without a facade)

        // Step 1: Make payment
        PaymentService paymentService = new PaymentService();
        paymentService.makePayment("user123", 500);

        // Step 2: Reserve seat
        SeatReservationService seatReservationService = new SeatReservationService();
        seatReservationService.reserveSeat("movie456", "A10");

        // Step 3: Send booking confirmation via email
        NotificationService notificationService = new NotificationService();
        notificationService.sendBookingConfirmation("user@example.com");

        // Step 4: Add loyalty points to user's account
        LoyaltyPointsService loyaltyPointsService = new LoyaltyPointsService();
        loyaltyPointsService.addPoints("user123", 50);

        // Step 5: Generate the ticket
        TicketService ticketService = new TicketService();
        ticketService.generateTicket("movie456", "A10");
    }
}
/**
 * While this code works, it's tightly coupled. The Main class (or client code) is manually calling each subsystem service in the correct order and with the correct parameters.
 *
 * This leads to:
 *  High complexity for the client
 *  Duplicate code if you have to do this in multiple places
 *  Violation of the Single Responsibility Principle (the Main class knows too much)
 *
 * This sets the stage for the Facade Pattern, which will encapsulate all these steps in one high-level method like bookTicket() and make the client code clean and readable.
 */