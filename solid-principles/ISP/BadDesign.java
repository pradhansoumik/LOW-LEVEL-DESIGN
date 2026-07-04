interface UberUser {
    void bookRide();
    void acceptRide();
    void trackEarnings();
    void ratePassenger();
    void rateDriver();
}

/**
 * Using such an interface would force riders to implement methods they don't need, like acceptRide() and trackEarnings().
 * This is extremely messy. Rider is forced to implement stuff it never uses!
 */
class Rider implements UberUser {
    public void bookRide() { /* yes */ }
    public void acceptRide() { /* not needed */ }
    public void trackEarnings() { /* not needed */ }
    public void ratePassenger() { /* not needed */ }
    public void rateDriver() { /* yes */ }
}
