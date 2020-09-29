# 搭配 mybatis 連接多數據源 datasource

該次測試數據源 使用 h2 database & mysql ， 因此要先下載 mysql driver

前置作業 : 

- 引入 mysql driver & druid 處理多數據源

```
implementation 'mysql:mysql-connector-java:8.0.21'
implementation 'com.alibaba:druid:1.1.24'

```

- 建立一個 table ，其 schema 如下:

```
CREATE TABLE PRODUCT(
	PRODUCT_ID int NOT NULL AUTO_INCREMENT,
	SKU_NUMBER VARCHAR(50) NOT null unique,
	SKU_NAME VARCHAR(50) NOT null,
	primary KEY(PRODUCT_ID)
);

insert into PRODUCT (SKU_NUMBER, SKU_NAME)VALUES('test4', '測試商品4');
insert into PRODUCT (SKU_NUMBER, SKU_NAME)VALUES('test5', '測試商品5');
insert into PRODUCT (SKU_NUMBER, SKU_NAME)VALUES('test6', '測試商品6');

```

- application-dev.properties 設定檔配置連線資訊 ( 本例 以 dev 環境為 demo 使用 )
   
    設定基本連線資訊 & 對應 driver
    
- Configuration 檔配置

```
1. 產生 datasource 實體
2. 產生 transaction 實體
3. 產生 sqlsessionFactory 實體

※ 要注意 mapper xml 的位置 & mapper package 的配置位置
```

- 測試

```
打 URL : http://localhost:8081/practiceMuitipleDatasouce/getProductName
※ 觀看 log，有印出不同的 datasource 所取出的資料
```

Reference:<br>
[Spring Boot + Mybatis + Druid for multi-data source management](https://www.programmersought.com/article/5738121630/)<br>
[Spring Boot 整合 Mybatis 实现 Druid 多数据源](https://netfilx.github.io/spring-boot/5.mybatis%E4%BD%BF%E7%94%A8%E5%A4%9A%E4%B8%AA%E6%95%B0%E6%8D%AE%E6%BA%90/muilt-data-source)

