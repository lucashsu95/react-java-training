#!/bin/bash
set -e

run_migrations() {
    echo "Running migrations"
    java -jar app.jar
}

./wait-for-it.sh user-todo-db:3306 -- echo "Database is up"

run_migrations

exec "$@"