# Filmland_service
A REST API service for Filmland user and content management.

This is a MVP application and more feature can be built on top of this.

**Development frameworks:**

* Java 11
* Springboot
* Gradle
* h2-DB
* OpenAPI

**How to run the API:**

* **Starting the application will automatically boot up the DB.**

* **Using IDE (ex: IntelliJ)**

Import the project to your IDE. Right-click on the project and click on 'Build module film-land-service'.

Once the project is successfully built, right-click on 'FilmLandServiceApplication.java' file. And click on "Run FilmLandServiceApplication.main()".

This will start the REST API to run on localhost with port 8080.

Now you can use the Postman or any other REST API testing tool to hit the endpoints.

**Features of the application:**

* The application is a Filmland backed REST API developed using Java 11 and Spring boot 2.7.7
* Gradle has been used as the build framework and h2-DB as SQL database for its in-built properties.
* The REST API has been documented using OPEN-API and can be viewed at below url when the app is running http://localhost:8080/swagger-ui/index.html
* Lombok java library has been used to reduce the boilerplate code.
* Actuator endpoints have been enabled for app monitoring.
* Env profiling has been done for specific environments to ease the release cycle and production readiness.
* schema.sql and data.swl files have been used to pre-populate the DB on startup.
* Ab additional endpoint to add user has been implemented.
* The h2-DB can be accessed via UI using the below url, when the app is running http://localhost:8080/h2-console
