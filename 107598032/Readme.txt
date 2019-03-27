使用IDE:IntelliJ IDEA 2018.2.4 x64
開啟流程:
  1.開啟IntelliJ->import project->{homework-root-path}/107598032/hw1/classSystem
  2.選擇使用maven開啟
    dependency:jstl1.2、mysql-connector-java6.0.6、javax.servlet-api3.1.0
  3.設定Run/Debug Configurations，新增Tomcat Server
  4.Url設定為http://localhost:8080/Main
  5.點選右下角fix選擇classSystem:war exploded
  6.將Application context內容改為'/'
  7.點選Apply->OK
  8.執行

備註:
1.tomcat使用9.0.12版
2.初始畫面為localhost:8080/Main