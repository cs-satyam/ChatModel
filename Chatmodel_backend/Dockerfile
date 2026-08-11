# Stage 1: Build the application using Maven and Eclipse Temurin JDK 21 Alpine
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copy pom.xml to pre-download project dependencies (leverages Docker cache layers)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source files and package the jar
COPY src ./src
RUN mvn clean package -DskipTests -B

# Stage 2: Prepare the lightweight runtime environment using Eclipse Temurin JRE 21 Alpine
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy build artifact from stage 1
COPY --from=build /app/target/*.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
