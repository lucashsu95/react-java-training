# Store 商店

## Introduce

商店DEMO

## How to Start ?

### 編譯
在`React-SpringBoot-training/Day9/src/`
```bash
javac -d out -encoding UTF-8 Main.java
```

### 執行

```bash
java -cp out Main
```

## Feature

- [x] 結束程式
- [x] 確認是否登入 check token
- [x] 確認是否有權限 check 
- is Boss
  - 使用者CURD
    - [x] 查詢
    - [x] 新增
    - [ ] 修改
    - [ ] 刪除
  - [x] 商品CURD
- is Customer
  - [x] 購買商品
  - [ ] 購買歷史記錄
- [x] 登入/登出
- [x] 資訊查詢
  - [x] 列出所有商品列表
  - [x] 顯示目前活動優惠資訊
- Card 變成抽象
  - [x] 子類是ApplePay、LINEPay，可以有不同折扣


## API

### 主選單
- `0`: 結束程式
- `1`: 登入
- `2`: 註冊帳號
- `3`: 資訊查詢
- `4`: 登出
- `5`: 管理商品
- `6`: 管理使用者
- `7`: 購買商品
- `8`: 查看購買記錄

### 資訊查詢
- `0`: 返回上一頁
- `1`: 列出所有商品列表
- `2`: 顯示目前活動優惠資訊

### 管理商品
- `0`: 返回上一頁
- `1`: 新增商品
- `2`: 修改商品
- `3`: 刪除商品

### 管理使用者
- `0`: 返回上一頁
- `1`: 列出所有使用者
- `2`: 新增使用者

### 購買商品
- `0`: 返回上一頁
- `1`: 購買商品

## Controller

- 處理邏輯

## Store

- 拿來存狀態的變數

## Seeder

1. 在**開始程式時**製造預設資料
2. 新增Seeder檔案後要在`MainSeeder.java`做登記

## Lib

### Const
- 存放常數

## Test

...


Store.java
AuthController.java
ProductController.java
UserController.java
User.java
Payment.java