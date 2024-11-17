# Store 商店

## Introduce

商店DEMO

## Feature

- [x] 結束程式
- [ ] 確認是否登入 check token
- [ ] 確認是否有權限
- is Boss
  - 使用者CURD
    - [x] 查詢
    - [x] 新增
    - [ ] 修改
    - [ ] 刪除
  - [x] 商品CURD
- is Customer
  - [ ] 購買商品
  - [ ] 購買歷史記錄
  - [ ] 購買Product
    - [ ] 購買歷史記錄
- [x] 登入/登出
- [x] 資訊查詢
  - [x] 列出所有商品列表
  - [x] 顯示目前活動優惠資訊
- Card 變成抽象
  - [ ] 子類是Apple Pay、LINE Pay，可以有不同折扣

## Controller

- UserController
- ProductController

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
