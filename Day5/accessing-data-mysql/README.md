# Day5 Spring Boot - 訪問 MySQL

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
`http://localhost:8080/demo/add`
```json
{
    "name": "test",
    "email": "test@web.tw"
}
```

### all
`http://localhost:8080/demo/all`

