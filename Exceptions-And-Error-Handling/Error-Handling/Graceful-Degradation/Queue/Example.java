/*
// Queue request's
public void placeOrder(Order order)
{
    try
    {
        // Attempt to charge the payment
        paymentService.charge(order);
    }
    catch (Exception e)
    {
        // If payment fails, queue the order for retry
        orderRetryQueue.enqueue(order);
        log.warn("Payment failed. Queued for retry.");
    }
}
*/
