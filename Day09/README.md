# 嘗試CA架構

## docker
```bash
docker run -it --rm -v ".:/app" openjdk:17-jdk-slim bash
```

## Build
```bash
javac -d out -encoding UTF-8 ex/Main.java
```

## Run
```bash
java -cp out ex.Main
```
