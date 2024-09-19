FROM openjdk:17
COPY target/spring-security-module-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]