# Projet d'Architecture Microservices avec Spring Cloud

Ce projet est une implémentation d'une architecture microservices complète basée sur l'écosystème Spring Boot et Spring Cloud. Il simule un système de gestion simple (potentiellement e-commerce) avec des services distincts pour les clients, les produits et la facturation.

## Architecture Globale
<img width="2216" height="1607" alt="image" src="https://github.com/user-attachments/assets/6b8069c5-dbae-4770-8e08-38f962635918" />
L'architecture est composée des services suivants :

- **Discovery-Service (Eureka)** : Un annuaire de services (Service Discovery) où tous les autres microservices s'enregistrent.
- **Config-Service** : Un service de configuration centralisée (Spring Cloud Config Server) pour gérer les propriétés de tous les services.
- **Customer-Service** : Service gérant les entités "Customer" (Clients).
- **Inventory-Service** : Service gérant les entités "Product" (Produits/Inventaire).
- **Billing-Service** : Service gérant la facturation, qui communique avec les autres services.
- **Gateway-Service (Spring Cloud Gateway)** : Un point d'entrée unique (API Gateway) qui sert de proxy et de routeur pour les services internes.

Chaque service est développé comme un module Spring Boot indépendant, communiquant via REST et s'enregistrant auprès du serveur Eureka pour la découverte dynamique. La configuration de chaque service est centralisée grâce à Spring Cloud Config Server, qui lit les propriétés depuis un dépôt Git local. Le Gateway-Service permet d'accéder à tous les microservices via un point d'entrée unique, avec un routage dynamique basé sur Eureka.

Les services métiers (Customer, Inventory, Billing) utilisent Spring Data JPA pour la persistance (base H2 en mémoire pour le développement) et exposent leurs API via Spring Data REST. Le Billing-Service consomme les API des autres services via OpenFeign pour illustrer la communication inter-service.

### Technologies principales

- Java 17
- Spring Boot 3.5.x
- Spring Cloud (Eureka, Config, Gateway, OpenFeign)
- Spring Data JPA & Spring Data REST
- H2 Database (développement)
- Lombok

### Points clés

- **Découverte de services** : Eureka permet à chaque microservice de s'enregistrer et d'être découvert dynamiquement.
- **Configuration centralisée** : Toutes les propriétés des services sont gérées dans un dépôt unique et servies par le Config-Service.
- **Routage dynamique** : Le Gateway-Service route automatiquement les requêtes vers les services internes selon leur nom d'enregistrement.
- **Communication inter-service** : OpenFeign facilite les appels REST entre microservices.
- **Développement rapide** : Spring Data REST expose rapidement des endpoints CRUD pour les entités métiers.

Ce projet sert de base pour explorer les concepts de microservices, la configuration centralisée, la découverte de services, le routage dynamique et la communication entre services dans l'écosystème Spring Cloud.
