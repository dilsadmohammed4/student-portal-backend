## Stage 1: Build the application
#FROM maven:3.9.0-eclipse-temurin-17 AS build
#WORKDIR /app
#COPY . .
#RUN mvn clean package -DskipTests
#
## Stage 2: Run the application
#FROM amazoncorretto:17-alpine-jdk
#LABEL maintainer="dilsadmohammed4"
#WORKDIR /app
#COPY --from=build /app/target/student-portal-backend-1.0.0.jar student-portal-backend-1.0.0.jar
#EXPOSE 9000
#ENTRYPOINT ["java", "-jar", "student-portal-backend-1.0.0.jar"]

## Stage 1: Run the application
FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
COPY target/student-portal-backend-1.0.0.jar student-portal-backend-1.0.0.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "student-portal-backend-1.0.0.jar"]
