# 前情提要 : 如何在 window 安裝 Redis

通常 Redis 都是在 Linux 安裝 <br>
為了方便測試使用 springboot 連線 redis <br>
找了一個 window 支援的 版本 <br>

安裝完進入資料夾
1. 點擊 redis-server.exe 
2. 點擊 redis-cli.exe 下指令 測試 <br>

```
set key value : 就可把值塞入

get key       : 取出值
```

※ 在使用時，務必開著 redis 的 服務 ( cmd ) redis-server.exe

3. 可以下載 RedisDesktopManager ( 圖形介面觀察資料是否有寫入 )

[window安裝教學](https://www.itread01.com/content/1559804766.html)

# Spring Boot 使用 redis

使用 Redis connector 比較有名的有兩種
- Jedis
- Lettuce ( 在 starter 裡面就包含這種 )

實作:

1. 建立 redisConfig ( 初始化 bean )

2. 在 MaintainProduct 的 service 中，加入 redis 機制

3. RedisTemplate中定義了對5種資料結構操作 ( 目前使用了 opsForValue ) [Ref.4]

4. 實作的過程中，遇到了中文亂碼的問題，在初始  redisTemplate 中，要調整序列化的方式，使用UTF-8的編碼 [Ref.5]

5. 實作 controller & service，用 postMan 去打看看 是否符合機制

Postman範例:

```
Http Method: Post

URL : http://localhost:8080/maintainProduct/getProductSkuNumber

Headers :
Content-Type : application/json

RequestBody :

Body 選擇 raw & Json格式

{
	"skuNumber" : "test2"
}

```

預期結果:

第一次打的時候，會去跟 DB拿資料

第二次打的時候，因為已經把資料存進 redis中，因此直接取得 redis 的資料而不進DB查詢

此結果可以從 logger 印出的結果可以驗證


Code : 
[Service 實作](https://github.com/oscar51011/practice/blob/master/src/main/java/com/practice/productMaintain/service/MaintainProductService.java) <br>
[Config  配置](https://github.com/oscar51011/practice/blob/master/src/main/java/com/practice/config/RedisConfig.java)

<br>

Reference: <br>
1. [window 安裝教學](https://www.itread01.com/content/1559804766.html) <br>
2. [Spring Boot with Redis: HashOperations CRUD Functionality](https://stackabuse.com/spring-boot-with-redis-hashoperations-crud-functionality/)<br>
3. [SpringBoot框架中使用Redis缓存](https://blog.csdn.net/oGuiGui12345/article/details/89888495?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.channel_param)<br>
4. [通過spring 的redis template 操作redis (spring-data-redis)](https://www.itread01.com/content/1543281366.html)<br>
5. [5分钟学会Redis存值乱码问题解决方案](https://blog.csdn.net/qq_42175986/article/details/89711232?utm_medium=distribute.pc_relevant_download.none-task-blog-blogcommendfrombaidu-6.nonecase&depth_1-utm_source=distribute.pc_relevant_download.none-task-blog-blogcommendfrombaidu-6.nonecas)<br>
