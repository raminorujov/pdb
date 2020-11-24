FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=user-stock-service/target/user-stock-service-*.jar
COPY ${JAR_FILE} user-stock-service.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","user-stock-service.jar"]