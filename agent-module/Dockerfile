# Start from an OpenJDK image
FROM eclipse-temurin:21-jdk

# Set workdir
WORKDIR /app

# Copy the jar file (make sure to build jar before pushing to GitHub)
COPY target/agent-module-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
