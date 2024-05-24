# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY target/tmf666-api-0.0.1-SNAPSHOT app.jar

# Expose port 8080 (or any port your application uses)
EXPOSE 8085

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]