# Build stage using Gradle (no wrapper detected)
FROM gradle:8.6-jdk17 AS builder

# Set workdir and copy project
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . .

# Build the Spring Boot fat jar (uses bootJar task)
RUN gradle --no-daemon clean bootJar

# Runtime stage
FROM eclipse-temurin:17-jre

ARG JAR_FILE=build/libs/*.jar
WORKDIR /app

# Copy jar from builder stage
COPY --from=builder /home/gradle/project/${JAR_FILE} app.jar

# Expose default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
