/**
 * Good Interface Design (Follows ISP): A better interface design would separate the concerns:
 *
 * Now, each class has exactly what it needs - no more, no less. Thus, following the ISP keeps the code clean and easy to maintain.
 */
interface RiderInterface
{
    void bookRide();
    void rateDriver();
}

interface DriverInterface
{
    void acceptRide();
    void trackEarnings();
    void ratePassenger();
}

/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */

// Rider class implementing RiderInterface
class RiderClass implements RiderInterface {
    public void bookRide() { /* yes */ }
    public void rateDriver() { /* yes */ }
}

// Driver class implementing DriverInterface
class DriverClass implements DriverInterface {
    public void acceptRide() { /* yes */ }
    public void trackEarnings() { /* yes */ }
    public void ratePassenger() { /* yes */ }
}
