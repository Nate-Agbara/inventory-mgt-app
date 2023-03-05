# Table of Contents

- [Table of Contents](#table-of-contents)
- [Motivation](#motivation)
- [About The Project](#about-the-project)
    -   [Components](#components)
- [Development](#development)
- [Improvements](#improvements)
- [Contributing](#contributing)


# Motivation
Assessment.

# About The Project

Inventory management service written in Java spring boot on MySQL database.

The project uses [apache kafka](https://kafka.apache.org/) for messaging.

The project uses [flyway](https://flywaydb.org/documentation/usage/plugins/springboot) for migrations.

The project has a dockerfile for each of the service with the services defined in the docker-compose file.

The project also has openapi swagger integration.

## Components
The project is structured into three components, two microservices and a base-domain that contains common dtos between the microservices. Following are the service endpoints:

product-order-service: [swagger](a href="http://localhost:8080/swagger-ui/index.html")

    a. POST /product - adds a product
    b. GET /product - Gets all product
    c. GET /product/{id} - Get specific product
    d. PUT /product/{id} - update specific product
    e. PATCH /product/{id} - update specific product
    f. POST /order - place an order, (kafka producer)

report-service: [swagger](a href="http://localhost:8081/swagger-ui/index.html")

    a. GET /report - gets count and total cost of orders group by date.

# Development

Clone or download the repo to your machine.

For dev, you will need MySQL and Kafka installed.

The project uses docker, so won't need to install MySQL and Kafka on your localhost. 

Just install docker and run the docker-compose file in the root of the project to setup the database and message broker. Note, this may take a while for the first run.

##### Run the tests
``
mvn test
``
##### Build jar
``
mvn package -DskipTests
``
##### Run Docker compose to bring up the required containers
``
docker-compose up
``
##### view all running containers
``
docker ps
``
# Improvements

- user management for auditing. Using spring security
- more test to cover for edge-cases

# Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request