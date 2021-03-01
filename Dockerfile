FROM openjdk:8-jdk-alpine
VOLUME  /tmp
#COPY ./builds/docker-spring-boot.jar /app.jar
ADD builds/docker-spring-boot.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]