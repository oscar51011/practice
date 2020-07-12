# 客製化樣板

在製作網頁時，頁面有一些共通的東西 ex : header , footer , menu ...etc <br>
為了讓這些東西可以不用再多個頁面重複撰寫，達到可重用性的情況下 <br>
Thymeleaf 使用了  Layout Dialect <br>

gradle 除了要 import thymeleaf 套件之外，還要另外 import 套件 <br>
implementation 'nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:2.3.0' <br>

1. <br>
Java config 檔配置 Dialect ( ※細節需要再研究) <br>
檔案: WebMVCConfig.java

2. <br>
定義 樣板 以此專案來說為 template.html <br>
為了讓 html 認得這些 tag，html的標籤要加上 <br>
`xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" `<br>

3. <br>
為了讓 layout 的區塊可以自定義，在template.html 裡面使用 <br> 
tag : `<section layout:fragment="自定義名稱">`

此時，一個簡單的模板就建構完成了，接著我們要去其他html操作如何使用這個樣板

1. 以此專案為例，Home頁 : home.html <br>
     在 html 的 tag 底下新增， `<layout:deorate="~{template.html}>`
     做完該步驟，等同於已經套上了 template樣板
   
2. 接著撰寫一模一樣的 `<section layout:fragment="自定義名稱">` <br>
      此時，該頁的html頁面就會更改 樣板的行為，來達到自定義內容的效果
      
       ※ 切記 fragment 的 name 要與 template 一模一樣才會複寫內容 <br>
         不然則會呈現 template 的效果 ，可以利用 這兩個網頁的內容進行測試看看


Reference : <br>
 - [Working with Fragments in Thymeleaf - Baseldung](https://www.baeldung.com/spring-thymeleaf-fragments)
