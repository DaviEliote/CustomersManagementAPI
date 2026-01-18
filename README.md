🚀 CRM Customer API
This API, developed with Spring Boot 3, manages clients, controls their status, and performs logical deletion. The project utilizes best development practices, including pagination, automated documentation with Swagger, and unit testing.

🛠  Technologies used
Java 21 

Spring Boot 3.0

Spring Data JPA (Data persistence)

PostgreSQL (Data base)

SpringDoc OpenAPI (Swagger UI)

JUnit 5 & Mockito (Tests)

Maven (Dependency manager)


Features

[x] Customer Registration: Name, Email, and Status.

[x] Paginated Listing: Efficient search with page size control and sorting.

[x] Dynamic Filters: Filtering by active or logically deleted customers.

[x] Full Update (PUT): Data update via ID in the URL.

[x] Automatic Documentation: Interactive interface for testing via Swagger.


How to Run the Project: Clone the repository:

Bash

git clone https://github.com/DaviEliote/CustomersManagementAPI

How to install dependencies

Bash 
 mvn clean install

Run the Application 
 mvn spring-boot:run

API Documentation (Swagger)
With the application running, access the Swagger interface to view all endpoints and test them:

🔗 http://localhost:8080/swagger-ui/index.html


Endpoint Methods Description

GET /customers Lists customers (Supports page, items, sortBy and deleted).

POST /customers Creates a new customer.

PUT /customers/{id} Updates an existing customer.

DELETE /customers/{id} Removes a customer (Logical deletion).

And I'm also inviting you, Developer to contribute to my project by improving features and adding new ones ;) 👽👽
