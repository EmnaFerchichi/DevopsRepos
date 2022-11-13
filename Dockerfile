FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:nexus -o tpAchatProject-1.0.jar "http://192.168.56.2:8081/repository/devops_nexus/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar" -L
ENTRYPOINT java -jar /tpAchatProject-1.0.jar
EXPOSE 8089