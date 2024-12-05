# User - Todo

## Local
```bash
./mvnw clean install
./mvnw spring-boot:run
```

## Docker
```bash
docker-compose build --no-cache
docker-compose up -d
```

## test
```bash
docker run -it --rm user-todo-image bash
```

## Response 回傳格式
```json
{
    "success":"Boolean",
    "data": "Object",
    "message": "String"
}
```

## 更新內容
1. 使用者管理功能：
新增了使用者註冊、登入、登出及更新功能。
增加了對使用者電子郵件的唯一性檢查。
待辦事項管理功能：
新增了待辦事項的增刪改查功能。
增加了對待辦事項的擁有權檢查，確保用戶只能操作自己的待辦事項。
3. 錯誤處理：
增強了錯誤處理機制，提供更清晰的錯誤訊息。
新增了全局異常處理器，統一管理API錯誤回應。
4. 安全性：
實作了JWT存取令牌的生成與驗證，增強了API的安全性。
增加了對管理員權限的檢查，確保只有授權用戶可以執行特定操作。


## Feature

- User
  - 新增 POST /api/users
    - 檢查是否有登入
    - 檢查是否有權限
    - 檢查email是否已存在
  - 修改 PUT /api/users/:id
    - 檢查是否有登入
    - 檢查是否有權限
    - 檢查使用者是否存在
  - 刪除 DELETE /api/users/:id
    - 檢查是否有登入
    - 檢查是否有權限
    - 檢查使用者是否存在
  - 使用者列表 GET /api/users
  - 登入 POST /api/users/login
    - 檢查帳號是否存在
    - 檢查密碼是否正確
    - 產生 JWT(access token)
  - 登出 POST /api/users/logout
  - 檢查是否有登入
- Todo
  - 待辦事項列表 GET /api/todos
    - 檢查是否有登入
    - 只能看到自己的待辦事項
  - 新增 POST /api/todos
    - 檢查是否有登入
  - 修改 PUT /api/todos/:id
    - 檢查是否存在
    - 檢查是否有登入
    - 只能修改自己的待辦事項
    - 管理員可以修改所有待辦事項
  - 刪除 DELETE /api/todos/:id
    - 檢查是否存在
    - 檢查是否有登入
    - 只能刪除自己的待辦事項
    - 管理員可以刪除所有待辦事項


## 錯誤訊息
- 401: 未登入
- 403: 無權限
- 404: 資源不存在
- 409: 使用者已存在
- 400: 缺少必要欄位或資料類型錯誤

### 錯誤訊息代碼：
- MSG_INVALID_LOGIN: 登入無效
- MSG_USER_EXISTS: 使用者已存在
- MSG_USER_NOT_EXISTS: 使用者不存在
- MSG_INVALID_ACCESS_TOKEN: 無效的存取令牌
- MSG_PERMISSION_DENY: 權限不足
- MSG_MISSING_FIELD: 缺少必要欄位
- MSG_WRONG_DATA_TYPE: 資料類型錯誤
- MSG_TODO_NOT_EXISTS: 待辦事項不存在
