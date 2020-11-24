FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=gateway-service/target/gateway-service-*.jar
COPY ${JAR_FILE} gateway-service.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","gateway-service.jar"]