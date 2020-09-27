#SpringCacahe 搭配 Caffeine Cache

import gradle

```
	implementation 'org.springframework.boot:spring-boot-starter-cache:2.3.1.RELEASE'
	implementation 'com.github.ben-manes.caffeine:caffeine:2.8.1'

```

- 1. 配置 設定檔

	- @EnableCaching 告訴 Spring 有啟動 Cache 機制
	- 針對 Spring Cache的 CacheManager 介面  => [ CaffeineCacheManager 來實作 ]
	- 設定檔 定義 cache 的參數設定
	
	※  還不了解 CacheLoader 的用法是甚麼
	
- 2-1. 在需要 Cache的 method 上加上 @Cachable 並定義參數

	- 定義 cacheNames ( 跟 value 同意義 )
	- 定義 key : 參數前面要加上 # ，如果是特定靜態字串 要加上 單引號 ex: 'myKey'

- 2-2. 如何清 Cache ? 在清Cache的 method 上 加上 @CacheEvict

	- cacheNames 要與 存 Cache的 Name 一致
	- 參數 allEntries 預設為 false ( 該參數用意是 Cache全數清除 )

- 2-3. 針對 class level & method level 定義 cache
	
	- cacheNames 除了針對每個 method 可以個別定義外，也可以針對整個 class 進行定義 ( @CacheConfig )
	※  有下 class level @CacheConfig 後，整個 class 都是對該 cacheNames 進行 cache 處理
	

- 測試

	※ http://localhost:8081 Port 要看 環境的 properties 可能有所異動，以下以 dev 環境為舉例
	
	- 取得 [ 商品名稱  ] URL ( 用 Console 觀察資料是從 H2 database拿的還是 cache )
	Example : ( 重複打 URL 即可看出差異 )
	
	http://localhost:8081/getPracticeCacheProductName?skuNumber=test1
	http://localhost:8081/getPracticeCacheProductName?skuNumber=test2
	
	- 清除  [ 商品名稱 Cache ] URL
	
	http://localhost:8081/clearProductBySkuNumberCache 
	
- 備註

	- Cache 如同 Transaction 機制一樣，是由AOP接管的，因此要避免是 method內去呼叫 該 cache 方法，會失效	

Reference: <br>
[spring-boot-caffeine-cache - Baeldung](https://www.baeldung.com/spring-boot-caffeine-cache) <br>
[Spring Boot缓存之Caffeine](http://zhuhengwei.com/2018/12/01/Spring%20Boot%E7%BC%93%E5%AD%98%E4%B9%8BCaffeine/)<br>
[詳解Spring快取註解@Cacheable,@CachePut , @CacheEvict使用](https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/309384/)<br>