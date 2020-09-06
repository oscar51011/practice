# Spring Security UserDetailsService 用途

實現UserDetailsService會利用傳入的 username 取得使用者相關資訊　<br>

可以用幾種方式實現:
- 讀取 database 資料
- 讀取 propertiest 設定
- hardcode user 資訊

設定

- SpringSecurityConfig override configure(AuthenticationManagerBuilder auth) method
- 自定義撰寫 PracticeUserDetailsService 注入，實作取得使用者內容的方式 ( 本篇會取得 DB資料 )


Reference:<br>
[Spring Security UserDetailsService 用途 - 菜鳥工程師 肉豬](https://matthung0807.blogspot.com/2019/09/spring-security-userdetailsservice.html) <br>
[Spring security——基于数据库自定义UserDetailsService实现认证](https://blog.csdn.net/neweastsun/article/details/79360724)<br>
[https://www.javainuse.com/spring/boot-jwt-mysql](https://www.javainuse.com/spring/boot-jwt-mysql)<br>

