## Stage 1 : build with maven builder image with native capabilities
FROM quay.io/quarkus/centos-quarkus-maven:19.2.1 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
USER root
RUN chown -R quarkus /usr/src/app
USER quarkus
RUN mvn -f /usr/src/app/pom.xml -Dquarkus-profile=staging clean package


## Step 2: build the running container
FROM fabric8/java-alpine-openjdk8-jre
# ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0"
ENV AB_ENABLED=jmx_exporter

COPY --from=build /usr/src/app/target/lib/* /deployments/lib/
COPY --from=build /usr/src/app/target/*-runner.jar /deployments/app.jar

ENTRYPOINT [ "/deployments/run-java.sh" ]
