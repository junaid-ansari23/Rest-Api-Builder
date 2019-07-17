FROM openjdk:alpine
ADD target/api-builder.jar api-builder.jar
ENTRYPOINT ["java", "-jar", "/api-builder.jar"]
EXPOSE 8080