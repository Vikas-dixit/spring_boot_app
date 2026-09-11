# Journal App Complete

Original implementation inspired by the Engineering Digest Spring Boot Mastery code-along project.

## Features
- Registration/login with BCrypt + JWT
- Role-based Spring Security
- MongoDB journal CRUD with per-user ownership
- Mongo auditing
- Weather API integration
- Redis helper
- Kafka publisher
- Email service
- Scheduled task
- Swagger/OpenAPI
- Environment-variable based secrets

## Run
Use Java 21. Start MongoDB locally (`docker run -d --name journal-mongo -p 27017:27017 mongo:7`), set `JWT_SECRET`, then run `mvn spring-boot:run` from this folder. Optional services: Redis on 6379, Kafka on 9092, SMTP on 1025.

Swagger: http://localhost:8080/swagger-ui.html

## API
`POST /api/public/register`, `POST /api/public/login`, `GET|POST /api/journals`, `GET|PUT|DELETE /api/journals/{id}`, `GET /api/user`, `GET /api/weather?lat=...&lon=...`, `GET /api/admin/users`.

Protected routes require `Authorization: Bearer <token>`.
