FROM openjdk:17-alpine
LABEL authors="Roberto Carlos"
WORKDIR /app
COPY target/HackatonIpApp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]