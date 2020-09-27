# practice project

1. 練習 springboot & 特定主題 的相關技能
2. 目前 以 dev 為主線，要使用請切換 dev 環境以利執行

# Build the project 

  `gradle clean build`

# Run the project ( dev , test , prod )

- 使用 Gradle 指令啟動

  `gradle bootRun --args='--spring.profiles.active=dev'`
  
  dev   : [http://localhost:8080/](http://localhost:8080/)  <br>
  test  : [http://localhost:8081/](http://localhost:8081/)  <br>
  prod  : [http://localhost:8082/](http://localhost:8082/)  <br>
  
- 如果使用 IDE 啟動
  
  Run As >> Run Configuration >> Java Application ( 啟動 啟動類 `com.practice.PracticeApplication` )
  
  ` 下參數 Program Arguments : --spring.profiles.active=dev `
  

# 練習主題 
## Design Pattern
- [strategy pattern 練習](https://github.com/oscar51011/practice/blob/master/notes/designPattern/strategyPattern.md)

## API
- [Line Notify 練習](https://github.com/oscar51011/practice/blob/master/notes/lineNotify/lineNotify.md)

## Cache 機制
- [Caffeine Cache 練習](https://github.com/oscar51011/practice/blob/master/notes/cache/SpringCache_caffeineCache.md)

## Redis
- [window 安裝 redis & 初體驗](https://github.com/oscar51011/practice/blob/master/notes/redis/GettingStarted.md)

## Swagger2
- [利用Swagger2 撰寫 API 規格](https://github.com/oscar51011/practice/blob/master/notes/swagger/swagger2.md)

## Security 
- [SpringSecurity + JWT 保護 API](https://github.com/oscar51011/practice/blob/master/notes/spring/security/springSecurity%26Jwt.md)

```
TODO :
前後端分離，
JWT 在 API 用 Request Header : Authorization : Bearer [當下token]
JWT 在 WebPage 跳轉時， 可以前端存在 HttpOnly Cookies 解決

Q1 : 還沒想到怎麼整合 這兩種方式 
Q2 : Token 過期怎麼處理
```
查到的資源，先註記: <br>
[Spring Boot Authentication with VueJS + JWT + Http Only Cookie](https://medium.com/@altunkan/spring-boot-authentication-with-vuejs-jwt-http-only-cookie-4d8cfe7e4f0f)
  
# Home Page

檢查 AP 狀態 : http://localhost:8080/apStatus <br>
  
# FrontEnd
- thymeleaf

# BackEnd
- Mybatis

# DataBase
Relational database

H2 ( 目前練習預設使用 ) <br>

# Unit Test
Jacoco 觀察測試覆蓋率套件 <br>
測試報告 經由 gradle build 後 可以在 {自定義workspace}\practice\build\reports\jacoco\test\html 底下找到

