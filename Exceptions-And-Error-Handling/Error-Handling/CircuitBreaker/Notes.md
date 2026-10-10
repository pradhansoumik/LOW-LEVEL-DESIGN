## Circuit Breaker Pattern

---
The Circuit Breaker Pattern is a design pattern used to protect a system from repeatedly calling a failing service. Instead of constantly trying to invoke a failing service, the circuit breaker “opens” after a certain number of failures, blocking further attempts and allowing the system to continue operating. This prevents the system from overloading the failing service and gives it time to recover.

---
### The Problem

What happens if a downstream service, such as a payment service, is constantly failing? If the system keeps calling the service, it can lead to wasted resources, further failure, and potentially impact the performance of other components. The Circuit Breaker Pattern addresses this by stopping the calls after a threshold is met, allowing the system to wait and retry later.

---
### The Solution

The solution is to implement a circuit breaker that stops sending requests to the failing service after a threshold of failures. Once the service has had time to recover, the circuit breaker enters a "half-open" state to test the service's availability before fully restoring normal operations.

---
### States of Circuit Breaker

- **Closed:** The service is working normally, and requests are being sent to the service.
- **Open:** The service is failing consistently, and the circuit breaker stops sending requests to the service.
- **Half-Open:** After a defined timeout, the system sends a limited number of test requests to see if the service has recovered. If these requests succeed, the circuit breaker returns to the "Closed" state.

---
### Code Implementation

Here’s how the Circuit Breaker pattern can be implemented using Spring Boot with Resilience4j.

#### 1. Annotation-based Circuit Breaker Setup

The circuit breaker is applied using the `@CircuitBreaker` annotation, which wraps the method with the defined circuit breaker and fallback mechanism.

```java
@Service
class PaymentService {
    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    public String charge(String userId, double amount) {
        // real payment logic
        return externalPaymentApi.charge(userId, amount);
    }

    // Fallback method in case of failure
    public String paymentFallback(String userId, double amount, Throwable t) {
        log.error("Payment Service Down. Fallback triggered.");
        return "PAYMENT_FAILED";
    }
}
```

- `@CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")`: This annotation applies the circuit breaker to the charge method. If it fails, it will trigger the fallback method paymentFallback().
- `paymentFallback()`: This method is invoked if the charge method fails, providing a default value and logging the failure.

#### 2. Java Config Customization

You can also configure the circuit breaker programmatically by using a `@Bean` method:

```java
@Bean
public Customizer<CircuitBreakerConfigCustomizer> paymentCircuitBreakerConfig() {
    return CircuitBreakerConfigCustomizer.of("paymentService", builder -> builder
        .slidingWindowSize(10)
        .failureRateThreshold(50)
        .waitDurationInOpenState(Duration.ofSeconds(10))
        .permittedNumberOfCallsInHalfOpenState(2)
        .automaticTransitionFromOpenToHalfOpenEnabled(true));
}
```

This allows you to configure the circuit breaker dynamically at runtime.

#### 3. Configuration via application.yml

You can configure the circuit breaker properties externally in the `application.yml` file as follows:

```yaml
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
```

- `slidingWindowSize`: Defines the number of calls to consider when determining whether the circuit should open.
- `failureRateThreshold`: Defines the failure rate (in percentage) above which the circuit will open.
- `waitDurationInOpenState`: The duration the circuit breaker stays open before transitioning to a half-open state.
- `permittedNumberOfCallsInHalfOpenState`: Number of allowed requests in half-open state before deciding whether to close the circuit.

---