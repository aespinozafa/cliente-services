FROM openjdk:22-jdk-slim
WORKDIR /app
COPY ../cliente-container-services/target/cliente-container-services-1.0.0-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]