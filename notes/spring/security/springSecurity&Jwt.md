# 利用 Security + Jwt 保護 Restful API

gradle 加入 dependencies
 - spring-boot-starter-security
 - jjwt
 
 利用 userName & password 取得 JWT的 Token <br>
 
 在呼叫 API 的時候 header 要帶入 token <br>
 
  - 呼叫 filter檢查 API參數是否帶有 token (實作 JwtFilter )
  - 解析 token 後檢查是否有相對應的 userName 
  - 驗證 token 是否吻合
  - 進到實際呼叫的 controller
  - 回傳值
  
  <br>
  
  在 SpringSecurityConfig 控制那些頁面需要認證，那些不用
  
  
 範例:
 
 ```
 1. 取得  token
 
 POST : http://localhost:8080/authenticate
 
 Response:
 
<AuthResponse>
    <token>當下token</token>
</AuthResponse>
 
 ```
 
 ```
 2. 呼叫待測目標
 
POST : http://localhost:8080/api/maintainProduct/getProductSkuNumber 

Header 加上
Authorization : Bearer [當下token]


※　如果沒有填入 Authorization

<Map>
    <timestamp>1599411350808</timestamp>
    <status>401</status>
    <error>Unauthorized</error>
    <message></message>
    <path>/api/maintainProduct/getProductSkuNumber</path>
</Map> 
 
 
 ```
 
 
 Reference:<br>
 [Spring Boot Security + JWT Hello World Example](https://www.javainuse.com/spring/boot-jwt) <br>
 [使用JWT保護你的SpringBoot應用-SpringSecurity實戰](https://segmentfault.com/a/1190000009231329) <br>
 [Youtube: Spring Boot - Spring Security + JWT Complete Tutorial With Example | javatechie](https://www.youtube.com/watch?v=rBNOc4ymd1E&ab_channel=JavaTechie)<br>