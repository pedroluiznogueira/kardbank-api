FROM openjdk:8-jdk-alpine
MAINTAINER pedroluiznogueira
COPY target/kardbank-api-0.0.1.jar kardbank-api-0.0.1.jar
ENTRYPOINT ["java","-jar","/kardbank-api-0.0.1.jar"]