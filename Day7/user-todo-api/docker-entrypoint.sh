#!/bin/bash
set -e

run_migrations() {
    # java -jar app.jar
    echo "Running install"
    ./mvnw clean install

    echo "Running spring-boot run"
    ./mvnw spring-boot:run
}

./wait-for-it.sh user-todo-db:3306 -- echo "Database is up"

run_migrations

exec "$@"