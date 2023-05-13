# Online Plant Nursery Application


## REST A.P.I
REST API for an Online Plant Nursery Platform that allows customers to view the list of plants, seeds, and planters. 
The application also includes user and admin validation and authentication.

## Tech Stack

- JAVA
- SPRING
- SPRINGBOOT
- HIBERNATE
- MAVEN
- MYSQL
- JPQL
- POSTMAN
- HTML
- CSS
- JAVASCRIPT

## Dependencies

- SPRING DATA JPA
- SPRING BOOT DEVTOOLS
- SPRING WEB
- HIBERNATE
- MYSQL DRIVER
- VALIDATION
- LOMBOK

## Setting & Installation 

Install the Spring Tools Suite 
```bash
https://spring.io/tools
```

Install MySQL Community Server

```bash
https://dev.mysql.com/downloads/mysql/
```

Clone the Repository

```bash
git clone https://github.com/shubhamyv13/miniature-mountain-3002.git
```

Open MySQL Server
```bash
Create a New Database in SQL: "plant" 
```
## Run Locally


Go to the Project Directory

```bas
Open the PlantAndPlanters Folder with S.T.S
```

Go to **src/main/resources > application.properties** & change your username and password (MySQL server username & password)

```bash
spring.datasource.username="username"
spring.datasource.password="password"
```

To change the **Server Port**

```bash
server.port=8888
```

Go to **com.masai package > PlantAndPlantersApplication.java**

```bash
Run as Spring Boot App
```
Open the following URL for Swagger-UI 
```bash
http://localhost:8888/swagger-ui/
```

## Acknowledgements

- [Masai School](https://www.masaischool.com/)
