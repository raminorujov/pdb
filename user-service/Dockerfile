FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=user-service/target/user-service-*.jar
COPY ${JAR_FILE} user-service.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","user-service.jar"]