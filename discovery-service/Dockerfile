FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=discovery-service/target/discovery-service-*.jar
COPY ${JAR_FILE} discovery-service.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod,native","discovery-service.jar"]