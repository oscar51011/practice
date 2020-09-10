# How to use Swagger2

- 引入 gradle dependencies 

```
implementation 'io.springfox:springfox-swagger2:2.9.1'
implementation 'io.springfox:springfox-swagger-ui:2.9.1'

```

- 在 @EnableMvc 這個 config 底下，加入 sourceHandler

```
 @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    
    	... 原code
    
       // 加入 swagger2
       registry.addResourceHandler("swagger-ui.html")
       .addResourceLocations("classpath:/META-INF/resources/");
       registry.addResourceHandler("/webjars/**")
       .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
```

- 建立 Swagger Config


  1. ApiInfo ( 處理顯示於 UI的資訊 )
  2. apis 可以決定要顯示那些資料夾底下的 API
  3. paths 可以決定要顯示那些 url pattern 底下的 API，這裡是以 /api/** 為開頭的才顯示
  
  
  
- **Controller** 給 API添加詳細訊息

 
  1. @Api 給 Controller 新增註解 
  2. @ApiOperation 給 API 新增註解
  
  
- **DTO** 給 API Request/Response & Parameter 添加詳細訊息


  1. @ApiModel		   實體類描述
  2. @ApiModelProperty 屬性描述
  
  
  ※ swagger 頁面上有 Try it out ! 可以對它操作去實際打 API 的動作
  
   
   1. config 實作 globalOperationParameters，配合專案使用 JWT token
           頁面上會顯示 Authorization 可讓 user 輸入參數
  


顯示 swagger URL : [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Reference:<br>
[Setting Up Swagger 2 with a Spring REST API](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api) <br>
[在 Spring Boot 项目中使用 Swagger 文档](https://developer.ibm.com/zh/technologies/spring/articles/j-using-swagger-in-a-spring-boot-project/) <br>
[Swagger UI passing authentication token to API call in header](https://stackoverflow.com/questions/33435286/swagger-ui-passing-authentication-token-to-api-call-in-header)<br>

