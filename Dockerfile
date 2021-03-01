FROM openjdk:8-jdk-alpine
COPY ./builds/docker-spring-boot.jar /app.jar
EXPOSE 8050
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]