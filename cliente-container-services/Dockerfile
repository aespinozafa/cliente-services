FROM openjdk:22

# Copia y ejecuta la aplicación
COPY target/cliente-container-services-1.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]