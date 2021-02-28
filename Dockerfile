FROM openjdk:8
ADD target/docker-spring-boot.jar docker-springboot.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]
