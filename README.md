# practice

1. 練習 springboot 的相關技能
2. 目前 以 dev 為主線，要使用請切換 dev 環境以利執行

# change project enviroment

dev enviroment <br>

gradle task envDev

- note: starts on port '8080'

test enviroment <br>

gradle task envTest

- note: starts on port '8081'

Prod enviroment <br>

gradle task envProd

- note: starts on port '9000'

# Build the project 

  gradle clean build

# Run the project

  gradle bootRun
  
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

H2 (0 目前練習預設使用 )
MySQL

- note: <br>
  如果要使用 MySQL，請先安裝 MySQL 8.0.20 Local 版本 <br>
  使用 H2 啟動 Server後即可正常運作，datasource 選擇  <br>
  可在 enviroment/dev/application.properties 內調整 <br>
  ※ application.properties 做了任何調整 都要 重新 change project enviroment，環境才會一致 <br>
  
  
# TODO
1. multiple datasource 設定

