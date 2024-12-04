#!/bin/bash
set -e
# run_db_lang() {
    # echo "Running db_lang"
    # -- 修改數據庫字符集
    # ALTER DATABASE mydatabase CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

    # -- 修改表的字符集
    # ALTER TABLE todos CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

    # -- 修改特定列的字符集
    # ALTER TABLE todos MODIFY content VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
# }

run_migrations() {
    echo "Running migrations"
    java -jar app.jar
}

./wait-for-it.sh user-todo-db:3306 -- echo "Database is up"

run_migrations

exec "$@"