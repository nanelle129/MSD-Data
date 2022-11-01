FROM gradle:4.7.0-jdk8-alpine as builder
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle -b mcc-auth-api-template/build.gradle bootJar

FROM openjdk:8-jdk-alpine
EXPOSE 8080
VOLUME /tmp
ARG LIBS=app/build/libs
COPY --from=builder ${LIBS}/ /app/lib
ENTRYPOINT ["java","-jar","./app/lib/mcc-data-service-0.0.1-SNAPSHOT.jar"]
