/**
 * Circuit Breaker = wait and retry later
 */
public class CircuitBreakerExample
{
/*
    @Service
    class PaymentService {

        @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
        public String charge(String userId, double amount)
        {
            // real payment logic
            return externalPaymentApi.charge(userId, amount);
        }

        // Fallback method in case of failure
        public String paymentFallback(String userId, double amount, Throwable t)
        {
            log.error("Payment Service Down. Fallback triggered.");
            return "PAYMENT_FAILED";
        }
    }
*/
}

/*
    // Configuration Class
    @Bean
    public Customizer<CircuitBreakerConfigCustomizer> paymentCircuitBreakerConfig() {
        return CircuitBreakerConfigCustomizer.of("paymentService", builder -> builder
                .slidingWindowSize(10)
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofSeconds(10))
                .permittedNumberOfCallsInHalfOpenState(2)
                .automaticTransitionFromOpenToHalfOpenEnabled(true));
    }

*/

/*

// Configuration via application.yml:

resilience4j:
  circuitbreaker:
    instances:
      paymentService:
        registerHealthIndicator: true
        slidingWindowSize: 10
        slidingWindowType: COUNT_BASED
        minimumNumberOfCalls: 5
        failureRateThreshold: 50
        waitDurationInOpenState: 10s
        permittedNumberOfCallsInHalfOpenState: 2
        automaticTransitionFromOpenToHalfOpenEnabled: true

*/

