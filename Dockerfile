FROM openjdk:13-jdk-alpine
COPY target/rabbitmq-0.0.2-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]