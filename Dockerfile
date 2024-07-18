FROM openjdk:17
EXPOSE 9090
ADD target/self-service-prtal-0.0.1-SNAPSHOT.jar self-service-prtal.jar
ENTRYPOINT ["java", "-jar", "self-service-prtal.jar"]