public class Example1
{

    /*
        // Backoff strategy
        public String getETAWithBackoff() throws InterruptedException {
            int retries = 3;
            int delay = 1000; // Initial delay is 1 second
            while (retries-- > 0) {
                try {
                    return etaService.getETA();  // Attempt to fetch ETA from service
                } catch (Exception e) {
                    Thread.sleep(delay);  // Wait before retrying
                    delay *= 2;  // Exponential backoff: double the delay each time
                }
            }
            return "ETA unavailable";  // Return message if all retries fail
        }

    */

}
