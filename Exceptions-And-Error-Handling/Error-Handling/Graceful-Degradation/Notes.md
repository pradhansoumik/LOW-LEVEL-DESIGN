Graceful Degradation Strategies
1. Return Cached Data
   When a live service or an external API fails, the system can fall back on cached data to provide a seamless experience to the user. This strategy ensures that even if the primary service is unavailable, the system continues functioning using stored, potentially outdated, data.
   Code
   In the provided code snippet, we have a RecommendationService class that fetches user recommendations. Here's how it works:
   class RecommendationService {
   public List<String> getRecommendedItems(String userId) {
   try {
   // Attempt to fetch live recommendations
   return recommendationService.fetchLiveRecommendations(userId);
   } catch (Exception ex) {
   // If the live service fails, log the error and fall back to cache
   log.warn("Live service failed, falling back to cache");
   return cacheService.getCachedRecommendations(userId);  // Fallback to cached data
   }
   }
   public List<String> fetchLiveRecommendations(String userId) {
   return List.of("movie-1", "movie-2");  // Simulated live recommendation data
   }
   }

In this example:
The getRecommendedItems method first tries to get the data from the live service by calling fetchLiveRecommendations.
If the live service fails (e.g., due to a network issue or server downtime), the system catches the exception and logs the failure.
It then returns the cached recommendations using the cacheService.getCachedRecommendations method, ensuring that the user still gets some content, albeit potentially out-of-date.

This method of graceful degradation keeps the user experience intact by providing fallback data when the system is unable to perform as expected.
This strategy works best when the data doesn’t need to be real-time and can tolerate being stale for short periods, such as user recommendations, product details, or news articles that don't change frequently.

2. Show Fallback UI
   When a system or service becomes unavailable, it’s crucial to ensure that users still have a meaningful experience. One of the ways to handle this is by showing a fallback UI.

This could be a message, a static version of the content, or a default view that informs the user of the issue and provides a way forward (e.g., "try again later").
Code
Here’s how the code for showing fallback UI works:
// Show fallback UI
public Menu getMenu(String restaurantId) {
try {
// Attempt to fetch the live menu
return menuService.fetchMenu(restaurantId);
} catch (Exception e) {
// If the live menu is unavailable, show a fallback message in the UI
return new Menu("Menu currently unavailable. Please try again later.");
}
}

In this example:
The getMenu method tries to fetch the live menu from the menuService.fetchMenu method.
If the service fails (e.g., the menu is unavailable due to a server issue), the system catches the exception and instead returns a fallback UI in the form of a Menu object with a message: "Menu currently unavailable. Please try again later."

This strategy ensures that users are not left staring at an empty screen or a broken interface. Instead, they are informed that the content they seek is temporarily unavailable, and they can try again later.
This approach is effective for user-facing applications where it’s essential to maintain a friendly and informative experience, even during downtime. Examples of fallback UI include error messages, loading spinners, or simplified versions of the content.

3. Queue Requests
   Another graceful degradation strategy is queuing requests. When a service is temporarily unavailable or experiences high traffic, it’s crucial to prevent the system from becoming overloaded or failing outright. By queuing requests, the system can defer the action until the service is ready to process it, ensuring that no requests are lost, and users are not impacted by service interruptions.
   Code
   // Queue request's
   public void placeOrder(Order order) {
   try {
   // Attempt to charge the payment
   paymentService.charge(order);
   } catch (Exception e) {
   // If payment fails, queue the order for retry
   orderRetryQueue.enqueue(order);
   log.warn("Payment failed. Queued for retry.");
   }
   }

In this example:
The placeOrder method attempts to charge the payment for an order.
If the payment service fails (e.g., due to network issues), the exception is caught, and the order is placed in a retry queue (orderRetryQueue.enqueue(order)).
A warning is logged to indicate that the payment has failed and the order has been queued for retry.

This ensures that, rather than rejecting the request immediately, the system can retry processing the payment later when the service is available again.
The queueing requests strategy is ideal for handling intermittent failures in high-demand systems. It allows for non-disruptive operations, ensuring that operations are completed when the system can handle them, without burdening the user with error messages or failed transactions.