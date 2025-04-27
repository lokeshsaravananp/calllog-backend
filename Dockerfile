# Use OpenJDK 8 as base image
FROM openjdk:8-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the target jar into container
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
