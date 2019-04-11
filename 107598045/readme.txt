程式執行環境:
  IDE使用: IntelliJ IDEA 2018.2.3 x64
  Project SDK： 1.8
  build tool 使用Maven
  DataBase使用： Mysql

設定DataBase：
  1. 新增一個 Database schema 名稱為 sacms
  2. 新增一個表格, 名稱為 course_purpose
     --- Create Course Table SQL：
     CREATE TABLE course_purpose (courseId int NOT NULL AUTO_INCREMENT, 
                                  courseName varchar(45) NOT NULL, 
                                  courseDetail varchar(45), 
                                  courseSuitPeople varchar(45), 
                                  coursePrice int(15), 
                                  courseNotes varchar(45), 
                                  courseRemark varchar(45), 
                                  PRIMARY KEY (courseId)
                                  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci;

開啟流程:
  1.開啟IntelliJ-> import project ->{homework-root-path}/107598045/hw1/  (hw1資料夾要展開)
  2.Import project from external model 選擇 Maven -> Next...
  3.finish後 IDE下方會跑讀取條，需等待一段下載時間
    
  4.在src/main/java/dbconn/Dbcon.java
         更改下面參數
         private final String SACMS= "sacms"; //您建立的schema名稱，
         private final String userName= "<您的Database 帳號>";
         private final String password = "<您的Database 密碼>";

  5.選擇位於IDE右方的 Maven Projects
  6.開啟路徑 Plugins -> tomcat7 -> tomcat7:run
  7.左鍵點擊兩下 tomcat7:run
  8.IDE下方會有一些訊息跑出，滑鼠滾輪往上找到 [INFO] Running war on http://localhost:8080/ 該ROW，點擊該鏈結
  9.瀏覽器上即有執行畫面
  

備註:
  ※ 若跑出http status 404 找不到分頁的訊息，則把瀏覽器url改成 http://localhost:8080/listAllCourses
  若專案無法開啟，請確認資料庫是否有正確建立
  Maven dependency： javax.servlet-api3.1.0、jstl1.2、mysql-connector-java8.0.11  、tomcat7-maven-plugin 2.2