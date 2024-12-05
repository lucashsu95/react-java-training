FROM maven:3.9.6 AS build

WORKDIR /app

COPY pom.xml ./
COPY mvnw ./
COPY mvnw.cmd ./
COPY .mvn/ .mvn
COPY ./src/ ./src


RUN chmod +x mvnw

FROM openjdk:17

WORKDIR /app

COPY --from=build /app /app

COPY *.sh .

RUN chmod +x docker-entrypoint.sh

ENTRYPOINT ["/bin/sh", "docker-entrypoint.sh"]