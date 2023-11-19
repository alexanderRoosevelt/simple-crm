# Use official OpenJDK 17 image as base image
FROM openjdk:17-jdk-alpine

# Expose the port that the application will run on
EXPOSE 8081

# Copy the compiled JAR file into the container
ADD target/building-company.jar building-company.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "/building-company.jar"]
