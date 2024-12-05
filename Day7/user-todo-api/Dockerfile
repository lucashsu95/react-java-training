FROM openjdk:17-jdk-slim

RUN mkdir -p /app

WORKDIR /app

VOLUME [ "/app" ]

COPY ./target/user-todo-api-0.0.1-SNAPSHOT.jar app.jar
COPY *.sh .

# RUN sed -i -e 's/\r$//' /app/*.sh
RUN chmod +x docker-entrypoint.sh

ENTRYPOINT ["/bin/sh", "docker-entrypoint.sh"]