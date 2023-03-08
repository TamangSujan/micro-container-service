# micro-container-service
This is a basic micro service project. Java is used as a programming language, Spring is used as a framework with Boot, Cloud and Podman is used as a container.  

Building Container: Go to project folder find See Dockerfile, On that location
Eureka: podman build -t eurekaserver:latest .
View: podman build -t viewservice:latest .
Login: podman build -t loginservice:latest .
Data: podman build -t dataservice:latest .

Running Container:
Eureka: podman run -p 8761:8761 eurekaserver
View: podman run -p 8000:8000 -e EUREKA_DEFAULT_ZONE=http://192.168.1.101:8761/eureka/ -e LOGIN_SERVICE=http://LOGINSERVICE -e DATA_SERVICE=http://DATASERVICE viewservi>
Login: podman run -p 8081:8081 -e EUREKA_DEFAULT_ZONE=http://192.168.1.101:8761/eureka -e PORT=8081 --net=host loginservice
Data: podman run -p 8082:8082 --net=host  -e EUREKA_DEFAULT_ZONE=http://192.168.1.101:8761/eureka -e PORT=8082 dataservice
