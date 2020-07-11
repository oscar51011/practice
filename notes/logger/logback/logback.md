# Logback 筆記

在 Springboot starter預設的情況底下 ，就使用 Logback 來記錄日誌行為 <br>
※ [Springboot starter 包含 spring-boot-starter-logging ](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-starters) <br>
※ [Springboot-starter logging 使用 logback ](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-logging/2.3.1.RELEASE)

在 application.properties 可以定義 logging設定檔，此專案我們設定的讀取位置 <br>
classpath:practice/properties/logback.xml

Appender 種類: [What is the Appender?](http://logback.qos.ch/manual/appenders.html) <br>

- ConsoleAppender : 將log印到控制台 <br>
- FileAppdender : 將log印到檔案 <br>
- RollingFileAppender : 繼承至 FileAppender，依照一些策略，可以將檔案切分多個不同檔案 ( ex : 時間 or 大小 )<br>

使用的 tag : 

`<file>` : 檔案寫入位置 <br>
`<encoder>` 包含  `<pattern>`  : log 撰寫格式<br>
`<filter>` : 可以針對特定條件進行輸出 ( ex : 針對 level 為 error 級別的才印出 )<br> 
`<rollingPolicy>` : 針對特定策略產檔，可以針對 每天 or 每小時切一個檔，會比較好追蹤<br>

Reference: <br>

- [LOGBack Home](http://logback.qos.ch/) <br>

- [A Guide To Logback - Baeldung](https://www.baeldung.com/logback) <br>

- [ 最全的Logback快速实践 ](https://juejin.im/post/5c62858f51882562e8762d29#heading-3) <br>
※ 可查看 `<encoder>` 中 `<pattern>` 常用的屬性