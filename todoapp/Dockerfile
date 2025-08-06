# Use a minimal Java image
FROM eclipse-temurin:21-jdk-jammy

# Set working directory
WORKDIR /app

# Copy the jar file into the image
COPY target/*.jar app.jar

# Expose the port (optional)
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
