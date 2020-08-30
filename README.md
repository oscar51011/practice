# practice

1. 練習 springboot & 特定主題 的相關技能
2. 目前 以 dev 為主線，要使用請切換 dev 環境以利執行

# 練習主題 
## Design Pattern
- [strategy pattern 練習](https://github.com/oscar51011/practice/blob/master/notes/designPattern/strategyPattern.md)

## API
- [Line Notify 練習](https://github.com/oscar51011/practice/blob/master/notes/lineNotify/lineNotify.md)


# change project enviroment

dev enviroment <br>

`gradle task envDev`

- note: starts on port '8080'

test enviroment <br>

`gradle task envTest`

- note: starts on port '8081'

Prod enviroment <br>

`gradle task envProd`

- note: starts on port '9000'

# Build the project 

  `gradle clean build`

# Run the project

  `gradle bootRun`
  
# Home Page

檢查 AP 狀態 : http://localhost:8080/apStatus <br>
首頁 : http://localhost:8080/ <br>


- note: 以上的路徑以 dev 為主，如果需要切換不同環境，再自行換 port  
  
  
# FrontEnd
- thymeleaf

# BackEnd
- Mybatis

# DataBase
Relational database

H2 ( 目前練習預設使用 ) <br>
MySQL <br> 

- note: <br>
  如果要使用 MySQL，請先安裝 MySQL 8.0.20 Local 版本 & url 需要調整 <br>
  
  ```
  dev enviroment :
  schema : dev 
  username : root 
  password : admin 
  ```
  使用 H2 啟動 Server後即可正常運作 <br>
  
  datasource 選擇　可在 enviroment/dev/application.properties 內調整 <br>
  ※ application.properties 做了任何調整 都要 重新 change project enviroment，環境才會一致 <br>

# Unit Test
Jacoco 觀察測試覆蓋率套件 <br>
測試報告 經由 gradle build 後 可以在 {自定義workspace}\practice\build\reports\jacoco\test\html 底下找到
  
# TODO
1. multiple datasource 設定

