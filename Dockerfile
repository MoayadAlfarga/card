# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/card-0.0.1-SNAPSHOT.jar app.jar

# Expose the configured port from application.yaml
EXPOSE 8091

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]