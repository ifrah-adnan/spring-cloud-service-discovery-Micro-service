# Spring Cloud Microservices Project

Ce projet est une architecture microservices basée sur Spring Cloud, comprenant plusieurs services interconnectés via une API Gateway et utilisant Eureka pour la découverte de services.

## Architecture du Projet

## Technologies Utilisées

- Spring Boot 3.2.x
- Java 21
- Maven
- Eureka Server
- Spring Cloud Gateway
- Spring Web
- Spring Data JPA (pour les services)

## Configuration et Installation

### 1. Eureka Server (Service Discovery)

Le serveur Eureka est démarré sur le port 8761 et sert de registre pour tous les microservices.

### 2. API Gateway

La Gateway est configurée sur le port 8888 et route automatiquement les requêtes vers les services appropriés.

### 3. Services Métier
- Customer Service (port 8081)
- Inventory Service (port 8082)

## Comment démarrer

1. Démarrer Eureka Server
    - Accéder à http://localhost:8761

2. Démarrer Gateway Service
    - Accéder à http://localhost:8888

3. Démarrer les services métier
    - Customer Service: http://localhost:8081
    - Inventory Service: http://localhost:8082

## Accès aux Services via la Gateway

Pour accéder aux services via la gateway :

- Customer Service: `http://localhost:8888/customer-service/customers`
- Inventory Service: `http://localhost:8888/inventory-service/products`

## Configuration des Services

### Gateway Service (application.properties)
```properties
server.port=8888
spring.application.name=gateway-service
spring.cloud.gateway.discovery.locator.enabled=true
spring.cloud.gateway.discovery.locator.lower-case-service-id=true
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
...