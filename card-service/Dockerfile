# base image
FROM openjdk:17-jdk-slim

# info about maintainer
MAINTAINER muazwazir1

# copy jar file into image
COPY target/card-service-0.0.1-SNAPSHOT.jar card-service-0.0.1-SNAPSHOT.jar

# execute command to spawn container
ENTRYPOINT ["java", "-jar", "card-service-0.0.1-SNAPSHOT.jar"]