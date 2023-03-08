FROM docker.io/openjdk:17-jdk
LABEL maintenance="devops"
ADD target/viewservice-0.0.1-SNAPSHOT.jar viewservice.jar
ENTRYPOINT ["java", "-jar", "viewservice.jar", "-Dspring.profiles.active=prod"]
