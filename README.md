# 🧪 RideShare Backend Service (Kotlin/Java Hybrid)
### Duration: 6 months
### Role: Lead Backend Engineer

## Overview:
Designed and implemented a scalable, fault-tolerant backend for a ride-sharing platform that supports user registration, real-time driver–rider matching, and persistent trip history. Leveraged a hybrid Kotlin/Java codebase to modernize existing services while ensuring high throughput and stability for core components.

⸻

## Core Responsibilities

### Architecture & Design

* Defined microservice boundaries: separated high-throughput matching engine (Java/Spring Boot) from asynchronous API and event-driven modules (Kotlin/Spring WebFlux).
* Designed RESTful endpoints for user authentication, trip lifecycle management, and metrics reporting.

### Legacy Integration

* Incrementally introduced Kotlin modules into a mature Java codebase: established a shared Gradle multi-project build, standardized on Spring Boot 2.x, and enforced consistent coding conventions via Spotless.
* Created interoperability layers using Kotlin’s @JvmStatic and Java’s KotlinPoet to enable seamless service-to-service calls.

### High-Throughput Components (Java)

* Built the ride-matching engine in Java to maximize thread-pool utilization and GC predictability under load (10,000+ concurrent match requests per second).
* Tuned JVM parameters and implemented connection pooling for PostgreSQL to sustain 3× peak day-of-week traffic.

### Asynchronous & Reactive Modules (Kotlin)

* Developed new event-driven features—such as push notifications (WebSocket) and location updates—using Kotlin coroutines and Spring WebFlux to achieve non-blocking I/O.
* Implemented Redis-backed caching for geospatial queries, reducing average driver lookup latency from 250 ms to 40 ms.

### Data Persistence & Caching

* Modeled relational schemas in PostgreSQL with optimized indexes for frequent queries (trip history, earnings reports).
* Employed Redis for session management and proximity-based driver matchmaking, achieving 99.9% cache hit rate.

### Testing & CI/CD

* Introduced Spek (Kotlin) and JUnit 5 (Java) test suites, covering >85% of code paths.
* Automated builds and deployments with GitHub Actions: parallelized Kotlin and Java builds, executed integration tests against ephemeral Docker Compose stacks.

⸻

# Key Achievements
## Seamless Kotlin Adoption:
 Reduced on-boarding time for new developers by 40% through clear Kotlin/Java interop patterns and shared module templates.
## Performance Gains:
 Achieved a 3× reduction in end-to-end trip request processing time by moving to reactive Kotlin services and Redis caching.
## Reliability Improvements:
 Maintained 99.99% uptime in production across multiple availability zones, even during peak holiday demand.
## Scalable Foundation:
 Laid groundwork for future features (dynamic pricing, surge notifications) by establishing a reactive, event-driven architecture that can scale horizontally.

⸻

# Tech Stack: 
* Kotlin
* Java
* Spring Boot
* Spring WebFlux
* PostgreSQL
* Redis
* Gradle
* Docker
* GitHub Actions
* Spek
* JUnit 5.