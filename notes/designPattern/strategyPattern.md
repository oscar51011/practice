#Strategy Pattern

在很多 case when or if 的情況下，就可以使用 這種設計模式 <br>

好處 :

- 擴展容易 <br>
- 可省去大量if else or case when <br>

壞處 :

- 會產生很多 strategy 的 class ( 因為每個策略要個別實作 )
- 需要指定要怎甚麼策略


舉例 :

流程如下 :
1. 根據不同的 CASE 取出 各自的資料
2. 將 所有CASE的人的 分數進行加總平均，並算出分數差異
3. 印出不同的 CASE 的人的 分數差異

沒有使用 strategy 的 流程 : PracticeServcieWithoutStrategy.java <br>

※ 拆解需要以下步驟 : <br>
 - 1. 定義 Enum 決定有多少的策略 ( PracticeEnum.java )
 - 2. 定義 strategy 的 interface ( plaerAction.java interface )
 - 3. 各自實作不同的 strategy ( playerAction.java package )
 - 4. 建立 context，給定實際的策略去進行流程 ( PlayerActionContext.java )
 - 5. 建立 factory，經由不同的參數產出需要執行的 實例
 
※ 如果需要新增策略需要怎麼做 ? 
 - 1. Enum 新增策略的 value
 - 3. 實作一個新的 strategy class
 - 5. factory 多一個 新產生的 實例
 - 修改流程2 (共同運算邏輯)
 
 這樣的做法就不會去大幅度異動到原本的流程 ( 擴展容易 )
 
使用 strategy 後 的流程 : PracticeServiceAddStrategy.java <br>

差異  : 消弭 流程 1 & 3 大幅度使用 case when 的情況 


Reference:
- [策略模式 Strategy Pattern](https://skyyen999.gitbooks.io/-study-design-pattern-in-java/content/strategy.html) <br>

- [策略模式](https://www.runoob.com/design-pattern/strategy-pattern.html) <br>

- [[ Day 3 ] 初探設計模式 - 策略模式 (Strategy Pattern)](https://ithelp.ithome.com.tw/articles/10202506) <br>