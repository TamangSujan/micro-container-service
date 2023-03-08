FROM docker.io/openjdk:17-jdk
LABEL maintenance="devops"
ADD target/dataservice-0.0.1-SNAPSHOT.jar dataservice.jar
ENTRYPOINT ["java", "-jar", "dataservice.jar", "-Dspring.profiles.active=prod"]
