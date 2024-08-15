# User - Todo

## Response 回傳格式
```json
{
    "success":"Boolean",
    "data": "Object",
    "message": "String"
}
```

## User

### 新增 POST /api/users
- 檢查是否有登入
- 檢查是否有權限
- 檢查email是否已存在

### 修改 PUT /api/users/:id
- 檢查是否有登入
- 檢查是否有權限
- 檢查使用者是否存在

### 刪除 DELETE /api/users/:id
- 檢查是否有登入
- 檢查是否有權限
- 檢查使用者是否存在

### 使用者列表 GET /api/users

### 登入 POST /api/users/login
- 檢查帳號是否存在
- 檢查密碼是否正確
- 產生 JWT(access token)

### 登出 POST /api/users/logout
- 檢查是否有登入



## Todo

### 待辦事項列表 GET /api/todos
- 檢查是否有登入
- 只能看到自己的待辦事項

### 新增 POST /api/todos
- 檢查是否有登入

### 修改 PUT /api/todos/:id
- 檢查是否存在
- 檢查是否有登入
- 只能修改自己的待辦事項
- 管理員可以修改所有待辦事項

### 刪除 DELETE /api/todos/:id
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
