FROM eclipse-temurin:17.0.12_7-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} fightsapi-1.jar
ENTRYPOINT ["java","-jar","/flightsapi-1.jar"]