# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the built Spring Boot jar file to the container
COPY target/starships-0.0.1-SNAPSHOT.jar /app/starships.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "starships.jar"]
