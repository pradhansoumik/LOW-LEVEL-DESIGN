## Failover and Timeout Strategies

---
In a resilient system, it's not just about detecting failure, it's about how quickly and effectively the system recovers or reroutes around that failure. Two key techniques that play a major role in this are Timeouts and Failovers. These strategies help ensure that your system doesn't hang indefinitely and can automatically switch to backup options when necessary.

---
### 1. Timeout Strategy

A timeout is a mechanism used to prevent long waits or hangs when a service becomes unresponsive. Instead of waiting indefinitely for a response, a timeout defines a maximum amount of time to wait before the request is aborted.

**Why It Matters**

- Prevents resource blockage and thread exhaustion.
- Ensures the calling service doesn't get stuck.
- Allows for fallback or retry logic to kick in promptly.

**Example Use Case:**

Imagine your frontend service calls a backend API to fetch user details. If that backend service is hanging (maybe due to a DB lock), your frontend should timeout in 2 seconds rather than wait endlessly, ensuring your UI remains responsive or shows a graceful error.

---
### 2. Failover Strategy

Failover is the process of switching to a standby or alternative service when the primary one is unavailable or down. This is a proactive resilience strategy that ensures high availability and continued service delivery even when components fail.

**Why It Matters**

- Enables seamless experience even during service failures.
- Minimizes downtime and disruption.
- Useful in both service-to-service calls and infrastructure (like DB or servers).

**Example Use Case:**

If you have two payment gateways (say Razorpay and Stripe), and Razorpay is down, the system can automatically failover to Stripe to complete the transaction without the user even noticing.

By combining Timeouts (to avoid hanging) and Failovers (to reroute the request), systems can maintain a smooth and fault-tolerant user experience even in the face of partial or complete component failures.

---
### Summary: Engineering Checklist

To build a resilient and high-performing system, it's essential to apply various strategies that handle different types of failures, delays, and potential issues. Here’s a summary of key engineering strategies and solutions you can apply to ensure your system remains functional under different circumstances:

#### 1. Temporary Spike

- **Problem:** Sudden bursts in demand or traffic.
- **Solution:** Use retry with backoff to manage the load. This technique helps to handle spikes by spacing out retries with a growing delay, reducing the strain on the system and giving it time to recover.

#### 2. Persistent Failure

- **Problem:** A service or component that is consistently failing.
- **Solution:** Implement a Circuit Breaker to stop calling the failing service after a set threshold. This allows the system to stop wasting resources and enter a recovery mode.

#### 3. Third-party Delay

- **Problem:** Delays caused by external services (e.g., APIs, cloud services).
- **Solution:** Use Timeouts to avoid waiting too long for responses from third-party services. Setting an appropriate timeout ensures that your system doesn’t hang indefinitely and can proceed with a fallback.

#### 4. Degraded Experience

- **Problem:** System continues working, but with reduced functionality.
- **Solution:** Implement Fallback UI on Cache. When live data is unavailable, use cached data or show a degraded user interface to ensure users still have access to important information.

#### 5. Avoid Throttling

- **Problem:** Excessive load on the system or external services due to too many simultaneous requests.
- **Solution:** Use Own Rate Limiting to limit the number of requests your system can make to external services within a specific time frame, ensuring that it doesn't overwhelm any single service.

#### 6. Highly Critical Services

- **Problem:** Critical services must remain operational at all times.
- **Solution:** Implement Failover Setup to ensure that if one critical service goes down, another backup service takes over seamlessly, ensuring high availability and minimal disruption.

By following these strategies, you can ensure that your system is robust, resilient, and capable of handling various real-world challenges. Implementing these solutions will help protect your system from downtime, service failures, and poor user experiences, all while maintaining functionality even in the face of issues.