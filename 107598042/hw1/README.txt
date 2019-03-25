程式執行環境:
    1. IDE使用intellj
    2. build tool 使用Maven
       dependency:
         1. junit
         2. jmock
         3. jdbc-mysql-connector
    3. Database 使用mysql
    
如何執行:
1. import project使用Maven

2. 設定Database:
      1. 新增一個 Database 名稱為 CourseDemo
      2. 新增一個表格, 名稱為Course
         新增Course Sql: 
      3. 建立資料庫帳戶
      4. 在src/main/java/Gateway/PersistenceCourseBase.java
         更改下面參數
         dbUrl = "jdbc:mysql://localhost:3306/CourseDemo";
         private final String account = <Database 帳號>;
         private final String password = <Database 密碼>;
         private final String tableName = "Course";

3. 在src/main/java/com.company/Main執行程式


切換DB跟Inmemory DAO:
   在src/main/java/com.company/Main
   initializePresenter可以更改 PersistenceCourseBase為InMemoryCourseBase
   可以不使用資料庫, 也可以執行程式, 但是結果因為是存在記憶體, 關掉就會不見。
