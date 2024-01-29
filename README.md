# **INFORMATICS ASSIGNMENT**

This project demonstrates a microservices' architecture using Spring Boot, Spring Cloud, and Docker.

**Table of Contents**

    Overview
    Project Setup
        Running Locally
        Building Docker Images
    Configuration
    API Documentation

## **Overview**

The project consists of several microservices:

    -: API Gateway (Spring Cloud Gateway): The API Gateway sits at the entry point of the system, routing incoming requests to the appropriate microservice based on the endpoint. It acts as a single entry point for clients to interact with the microservices architecture.
    -: Service Discovery (Eureka): Eureka is used as the service discovery mechanism in the microservices architecture. Each microservice registers itself with the Eureka server upon startup, allowing other microservices to discover and communicate with it dynamically.
    -: User Management Microservice: Handles user registration, login, and profile retrieval.
    -: Product Catalog Microservice: Manages product information and catalog.
    -: Order Processing Microservice: Deals with order placement, order history, and status updates.


Project Setup

Running Locally

     Clone the repository:
        git clone https://github.com/VishvaComiya/spring-boot-microservices.git

     Build the project:
        mvn clean install

     Run each microservice for the following order

        Discover-service
        Api-Gateway
        Order-Processing
        User-Management`

    **_Note : You must run the dicovery service first_**


    Before running the application, ensure you have the following installed

    Java 11 or higher
        Maven
        Docker
        Getting 


Building Docker Images

    To build Docker images for each microservice:

    docker build -t user-management-service .
    docker build -t product-catalog-service .
    docker build -t order-processing-service .
    docker build -t discovery-service .
    docker build -t api-gateway .

API Documentation

    User-Management

    http://localhost:8080/sign-up
    http://localhost:8080/authentication
    http://localhost:8080/validateToken
    http://localhost:8080/findAllProfile

    
    Product-Catalog
    http://localhost:8080/createProduct
    http://localhost:8080/getProductList
    http://localhost:8080/findProductById/4

    
    Order-Processing
    http://localhost:8080/createOrder
    http://localhost:8080/orderHistory
    http://localhost:8080/updateOrder
    http://localhost:8083/findAllProducts

    i have already attached the postman collection in GIT. please refer it for sending the requst

    
    Thankyou!








