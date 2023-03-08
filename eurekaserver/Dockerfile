FROM docker.io/openjdk:17-jdk
LABEL maintenance="devops"
ADD target/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver.jar
ENTRYPOINT ["java", "-jar", "eurekaserver.jar", "-Dspring.profiles.active=prod"]
