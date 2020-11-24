FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=config-server/target/config-server-*.jar
COPY ${JAR_FILE} config-server.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod,native","config-server.jar"]