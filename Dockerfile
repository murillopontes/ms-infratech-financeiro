## Stage 1: build with the Java 25 LTS toolchain.
FROM maven:3.9.16-eclipse-temurin-25 AS build
WORKDIR /usr/src/app
COPY pom.xml .
COPY src ./src
RUN mvn -Dquarkus-profile=staging clean package

## Stage 2: run on the Java 25 LTS runtime.
FROM eclipse-temurin:25-jre
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0"
ENV AB_ENABLED=jmx_exporter

WORKDIR /deployments
COPY --from=build /usr/src/app/target/lib/ ./lib/
COPY --from=build /usr/src/app/target/*-runner.jar ./app.jar
USER 1001
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTIONS -jar /deployments/app.jar"]
