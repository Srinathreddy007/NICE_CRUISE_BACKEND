# NICE Cruise Booking Management System — Backend

A scalable Spring Boot backend service powering a cruise booking platform with secure authentication, 
real-time availability tracking, optimized database performance, and modular REST APIs for seamless frontend integration.
---

## Key Features

-  End-to-End Cruise Booking — passengers, payments & reservations management  
-  Secure Authentication — JWT-based authorization + Bcrypt password hashing  
-  RESTful APIs — standardized endpoints for frontend communication  
-  Optimized Performance — reduced data retrieval latency by 60%  
- SQL Injection + XSS protection through Spring Security  
-  MySQL relational database with optimized schema & indexing  
- Scalable microservice-ready modular architecture  

---

## 🏗️ Tech Stack

| Category | Technologies |
|---------|--------------|
| Backend | Java 17, Spring Boot, Spring Security |
| Database | MySQL, JPA/Hibernate |
| Authentication | JWT, Bcrypt |
| Dev Tools | Maven, Postman, JUnit |
| Architecture | REST APIs, Layered Design |


---
## Project Structure
```
src:
  main:
    java:
      com:
        nice:
          cruise:

            config: {}
            controller: {}
            service: {}
            repository: {}
            model: {}
            dto: {}
    resources:
      application.properties: ""
      schema.sql: ""
  test: {}

```
---

## API Endpoints (Sample)

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/register` | Register a new user |
| POST | `/auth/login` | Authenticate & receive JWT token |
| GET | `/cruises` | Fetch all cruise listings |
| POST | `/bookings` | Create new booking |
| GET | `/bookings/{id}` | Retrieve booking details |

📌 Postman collection coming soon


### 1️⃣ Clone the repository

```bash
git clone https://github.com/Srinathreddy007/NICE_CRUISE_BACKEND.git
cd NICE_CRUISE_BACKEND

