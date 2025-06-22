# base image
FROM openjdk:17-jdk-slim

# info about maintainer
MAINTAINER muazwazir1

# copy jar file into image
COPY target/loan-service-0.0.1-SNAPSHOT.jar loan-service-0.0.1-SNAPSHOT.jar

# execute command to spawn container
ENTRYPOINT ["java", "-jar", "loan-service-0.0.1-SNAPSHOT.jar"]