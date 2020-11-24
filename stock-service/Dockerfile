FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=stock-service/target/stock-service-*.jar
COPY ${JAR_FILE} stock-service.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","stock-service.jar"]