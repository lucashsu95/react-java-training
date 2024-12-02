# 使用 OpenJDK 官方鏡像
FROM openjdk:17-jdk-slim

# 設定工作目錄
WORKDIR /app

# 複製專案的 Jar 文件到容器
COPY target/todolist-application.jar app.jar

# 暴露應用程序的預設端口
EXPOSE 8080

# 啟動應用
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
