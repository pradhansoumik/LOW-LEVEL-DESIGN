/**
 * 1. Constructor Injection:
 *    Constructor Injection is the most commonly used form of Dependency Injection.
 *    In this approach, dependencies are passed to the class via the constructor.
 *    This ensures that the class is always instantiated with its required dependencies, which makes it easier to manage and test.
 * Key Points:
 *  Immutable Dependencies: Once the dependencies are injected through the constructor, they cannot be changed. This makes the object immutable, which ensures better reliability and predictability..
 *  Test-Friendly: Constructor injection makes testing easier since you can inject mock dependencies during unit testing, isolating the class under test.
 *  Ensures Required Dependencies: Since all required dependencies must be provided when the object is created, you are guaranteed that the class will always have everything it needs to function properly.
 */
// Using Constructor Injection
class OrderService3
{
    /*
    private final PaymentService payment;

    // Constructor
    public OrderService3(PaymentService payment)
    {
        this.payment = payment;
    }

    public void checkout(Order order)
    {
        payment.process(order);
    }

     */
}

/********************    **********************        ****************/

    // ── Contract: defines what the client needs, not how it is done
    interface NotificationService {
        void send(String message);
    }

    // ── Concrete implementation of the contract
    class EmailNotificationService implements NotificationService
    {
        @Override
        public void send(String message)
        {
            System.out.println("Email sent: " + message);
        }
    }

    // ── Client that depends on the abstraction, not the implementation
    class UserService
    {
        // Dependency held as an interface, promoting loose coupling
        private final NotificationService notificationService;

        // Constructor Injection: forces the caller to supply the dependency up-front
        public UserService(NotificationService notificationService)
        {
            this.notificationService = notificationService;
        }

        // Business logic uses the injected service
        public void register(String user)
        {
            System.out.println("User registered: " + user);
            notificationService.send("Welcome " + user);
        }
    }

    // ── Composition Root: the only place where “new” keywords appear
    class ClientClass
    {
        public static void main(String[] args) {
            // Create the concrete dependency
            NotificationService service = new EmailNotificationService();

            // Inject it into the client
            UserService userService = new UserService(service);

            // Execute business operation
            userService.register("raj");
        }
    }
