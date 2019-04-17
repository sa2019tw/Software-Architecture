程式執行環境:
  IDE使用: IntelliJ IDEA 2018.2.3 x64
  Project SDK： 1.8
  build tool 使用Maven
  DataBase使用： Mysql and Excel

設定DataBase：
  資料庫有MySQL與Excel兩種版本，為了方便老師檢查，目前使用Excel作為資料庫，無須任何設定。

開啟流程:
  1.開啟IntelliJ-> import project ->{homework-root-path}/107598038/HW2/  (HW2資料夾要展開)
  2.Import project from external model 選擇 Maven -> Next...
  3.finish後 IDE下方會跑讀取條，需等待一段下載時間
  (若HW2/src/main/src這個資料夾不是藍色的{非source資料夾}，
   請用快捷鍵shift+ctrl+alt+s左邊點modules，選擇該目錄點選上方source按鍵後apply
   若該目錄已經是source則跳過此步驟)
  4.先按右上角的槌子(build)過
  5.選擇位於IDE右方的 Maven Projects
  6.開啟路徑 Plugins -> tomcat7 -> tomcat7:run
  7.左鍵點擊兩下 tomcat7:run
  8.IDE下方會有一些訊息跑出，滑鼠滾輪往上找到 [INFO] Running war on http://localhost:8080/ 該ROW，點擊該鏈結
  9.瀏覽器上即有執行畫面
  
  # 若連不上請重新刪除target檔再build一次

備註:
  ※ 若跑出http status 404 找不到分頁的訊息，則把瀏覽器url改成 http://localhost:8080/CourseHome
  Maven dependency： 
	javax.servlet-api3.1.0、jstl1.2、
	mysql-connector-java8.0.11、
	tomcat7-maven-plugin2.2、
	commons-collections4.1、
	commons-compress1.18、
	poi4.0.1、
	poi-ooxml4.0.1、
	poi-ooxml-schemas4.0.1、
	xmlbean1.5.5
	