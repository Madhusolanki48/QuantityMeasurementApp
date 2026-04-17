# Quantity Measurement Microservices

This repository has been converted from a single Spring Boot monolith into a microservices workspace.

## Services

- `eureka-server` on `:8761`
- `api-gateway` on `:8080`
- `measurement-service` on `:8081`
- `user-service` on `:8082`
- `common` for shared DTOs, units, and conversion helpers

## What lives where

- `measurement-service` handles quantity arithmetic and conversion.
- `user-service` stores users and conversion history.
- `api-gateway` is the single entry point for clients, including the Angular app later.
- `eureka-server` handles service discovery.

## Start order

1. Start `eureka-server`
2. Start `user-service`
3. Start `measurement-service`
4. Start `api-gateway`

## Main endpoints

Through the gateway:

- `POST /api/v1/measurements/add`
- `POST /api/v1/measurements/subtract`
- `POST /api/v1/measurements/divide`
- `POST /api/v1/measurements/convert`
- `POST /api/v1/measurements/compare`
- `GET /api/v1/measurements/history`
- `GET /api/v1/users/{userId}/history`

## Angular note

The gateway CORS configuration already allows `http://localhost:4200`, so your Angular frontend can call the API gateway directly once you wire it up in the other repo.

## Build

Run Maven from the repository root:

```bash
mvn clean install
```

If you want next steps, I can help you add Docker Compose, improve the user/history API contracts, or wire the Angular repo to these new routes.
