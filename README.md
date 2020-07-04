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

檢查 AP 狀態 : http://localhost:8080/apStatus
首頁 : http://localhost:8080/


- note: 以上的路徑以 dev 為主，如果需要切換不同環境，再自行換 port  
  
  
# FrontEnd
- thymeleaf

# BackEnd
- Mybatis

# DataBase
Relational database
- H2
  
  
# TODO
1. multiple datasource 設定

