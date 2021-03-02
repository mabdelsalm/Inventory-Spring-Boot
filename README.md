# Inventory-Spring-Boot
A spring boot application that serves as REST api which represents a simple Inventory 

# Contributors:
> Mariam Abdelslam <mariam.abdelsalm@gmail.com>

# Requirements
-JDK 1.8 <br />
-Maven 3.6 <br />
-Spring boot 2.4.3 <br />
-h2 console database <br />

# Deploying the application locally
 You can run this command to run the application locally <br />
   ``` mvn spring-boot:run ```
   
# Deploying application on Docker
All you need to do in order to deploy on docker is to build the project and copy the compiled .jar to /build dierctory  <br />

``` mvnw package && java -jar builds/spring-boot-inventory.jar ```
 
 either you copy the build file and move it to docker image or you can you `commit` the change (newly built jar) and `push` the change to Github and it will  
 automatically trigger docker to build as continuous deployment on docker for this repository is on.
 
 # Testing API's
 You can also test the deployed API's through `swagger` [swagger-ui](http://localhost:8080//swagger-ui/)
 
 
