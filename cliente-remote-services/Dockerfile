# Dockerfile

FROM openjdk:22-jdk-slim
VOLUME /tmp
COPY ./target/cliente-remote-services-1.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
