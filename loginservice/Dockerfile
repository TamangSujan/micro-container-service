FROM docker.io/openjdk:17-jdk
LABEL maintenance="devops"
ADD target/loginservice-0.0.1-SNAPSHOT.jar loginservice.jar
ENTRYPOINT ["java", "-jar", "loginservice.jar", "-Dspring.profiles.active=prod"]
