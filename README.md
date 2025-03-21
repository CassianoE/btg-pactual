BTG Pactual Backend Challenge

This project is my solution for the BTG Pactual Backend Challenge from Build & Run. It implements a Spring Boot API for order management, integrated with RabbitMQ for asynchronous event processing and MongoDB for data persistence. The application is fully containerized using Docker and Docker Compose.

Project Overview

The application provides an API to list orders by customer with pagination support and calculates the total value of orders for a given customer. It consumes order creation events from a RabbitMQ queue and persists them in MongoDB, ensuring an efficient and scalable architecture.

Prerequisites

To run this project, ensure you have the following installed:

Java 17 (or compatible JDK)
Docker (latest version recommended)
Docker Compose (for multi-container setup)
Maven (optional, for building locally)
How to Install and Run

Follow these steps to set up and run the application:

Clone the repository:
git clone <repository-url>
cd <project-folder>
Build the project (optional, if not using pre-built JAR):
mvn clean package
Start the application with Docker Compose:
docker-compose up --build
This will launch:
Spring Boot API (port 8080)
MongoDB (port 27017)
RabbitMQ (ports 5672 and 15672 for management UI)
Access the API:
Base URL: http://localhost:8080
Example endpoint: http://localhost:8080/customers/1/orders?page=0&pageSize=10
Stop the application:
docker-compose down
API Usage

The API provides the following endpoint:

List Orders by Customer:
Method: GET
URL: http://localhost:8080/customers/{customerId}/orders?page={page}&pageSize={pageSize}
Query Parameters:
page: Page number (default: 0)
pageSize: Number of items per page (default: 10)
Response:
{
"summary": {
"totalOnOrders": 199.98
},
"data": [
{
"orderId": 1,
"customerId": 1,
"total": 99.99
}
],
"pagination": {
"page": 0,
"pageSize": 10,
"totalElements": 1,
"totalPages": 1
}
}
Event Processing

The application listens to the btg-pactual-order-created queue in RabbitMQ. When an order creation event is received, it is processed and saved to MongoDB. Example event payload:

{

"codigoPedido": 1,

"codigoCliente": 1,

"itens": [

{

"produto": "Sample Product",

"quantidade": 2,

"preco": 49.99

}

]

}

Technologies Used

Spring Boot: Core framework for the API
RabbitMQ: Asynchronous message processing
MongoDB: NoSQL database for order persistence
Docker & Docker Compose: Containerization and orchestration
Spring Data MongoDB: Simplified database interactions
Maven: Dependency management
Notes

RabbitMQ management UI is available at http://localhost:15672 (credentials: guest/guest).
MongoDB credentials: admin/123 (configured in docker-compose.yml).
Ensure ports 8080, 5672, 15672, and 27017 are free before running.
Docker should have at least 4GB of memory allocated for smooth operation.
Troubleshooting

If the API doesn't respond, check container logs: docker-compose logs
Verify that RabbitMQ and MongoDB containers are running: docker ps
If events aren't processed, ensure the queue btg-pactual-order-created is receiving messages.