BTG Pactual Backend Challenge

This project is a solution for the BTG Pactual Backend Challenge . It implements a Spring Boot API for order management, integrated with RabbitMQ for asynchronous message processing and MongoDB for data persistence. The application is fully containerized using Docker.

Project Overview

The application provides an API to handle orders, process them asynchronously via RabbitMQ, and store data in MongoDB. It is designed to be scalable, easy to deploy, and well-documented.

Prerequisites

To run this project, ensure you have the following installed:

Java 17 (or compatible JDK)
Docker (latest version recommended)
Docker Compose (if using docker-compose.yml)
Maven (for building the project locally, optional)
How to Install and Run

Follow these steps to get the application up and running:

Clone the repository:
git clone <repository-url>
cd <project-folder>
Build the project (optional, if not using pre-built JAR):
mvn clean package
Run with Docker Compose:
docker-compose up --build
This will start the Spring Boot application, RabbitMQ, and MongoDB containers.
Access the API:
The application will be available at: http://localhost:8080
Stop the application:
docker-compose down
API Usage


Technologies Used

Spring Boot: Backend framework
RabbitMQ: Message broker for async processing
MongoDB: NoSQL database
Docker: Containerization
Maven: Dependency management
Notes

Ensure Docker has enough memory allocated (at least 4GB recommended).
RabbitMQ management UI is available at http://localhost:15672 (default credentials: guest/guest).
MongoDB runs on default port 27017.
Troubleshooting

If the app doesn't start, check the Docker logs: docker-compose logs.
Ensure ports 8080, 5672 (RabbitMQ), and 27017 (MongoDB) are free.