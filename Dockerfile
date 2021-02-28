FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} sprint-boot-rest-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/sprint-boot-rest-api-0.0.1-SNAPSHOT.jar"]