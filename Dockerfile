# Use an official Maven image as a build image
FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

# Copy only the POM file to cache dependencies
COPY ./pom.xml ./pom.xml

# Download dependencies only
RUN mvn dependency:go-offline -B

# Copy the rest of the application code
COPY ./src ./src

# Build the application
RUN mvn package --no-transfer-progress

# Use a smaller image for the runtime environment
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR file from the build image
COPY --from=build /app/target/EmployeeManagementApplication./app.jar

# Expose the port that your application will run on
EXPOSE 8080

# Specify the command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]
