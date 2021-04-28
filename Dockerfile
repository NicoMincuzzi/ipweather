FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} ipwather-0.1.0.jar
ENTRYPOINT ["java","-jar","/ipwather-0.1.0.jar"]