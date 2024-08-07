# Day6 - React + Spring Boot + MySQL - users 模組

`users.sql`檔 放在`/src/main/resources/static/files/`裡

## 清理並重建專案
有時候，清理專案並重新構建可以解決一些隱藏的問題。使用以下命令
```bash
.\mvnw clean install
```
然後再試著運行
```bash
.\mvnw spring-boot:run
```

## url(postman)

### add
http://localhost:8080/users (POST)

### all
http://localhost:8080/users (GET)

### put
http://localhost:8080/users/user_id (PUT)

### delete
http://localhost:8080/users/user_id (DELETE)

## 功能

- backend
  - 新增使用者
  - 列出所有使用者
  - 更新使用者
  - 刪除使用者
  - 搜尋使用者
  - 使用者登入
  - 使用者登出
  - 檢查權限
- frontend
  - 黑夜模式(Tailwindcss)
  - 

