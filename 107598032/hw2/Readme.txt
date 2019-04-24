使用IDE:IntelliJ IDEA 2018.2.4 x64
資料庫:
  1.使用mysql資料庫
  2.用SQL輸入以下語法
  CREATE DATABASE `course` DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
  CREATE TABLE `course_system` (
  	`id` int(10) NOT NULL AUTO_INCREMENT,
  	`name` varchar(30) NOT NULL,
  	`content` varchar(30) NOT NULL,
  	`member` varchar(30) NOT NULL,
  	`price` int(10) NOT NULL,
  	`notice` varchar(30) NOT NULL,
  	`remark` varchar(30) NOT NULL,
   	PRIMARY KEY (`id`)
  )
  3.再於classSystem/src/main/java/dbconn/DbConn.java更改帳號密碼
開啟流程:
  1.開啟IntelliJ->import project->{homework-root-path}/107598032/hw2/classSystem
  2.選擇使用maven開啟
    dependency:jstl1.2、mysql-connector-java6.0.6、javax.servlet-api3.1.0
  3.點選右邊maven頁籤->Plugins->tomcat7->tomcat7:run
  4.開啟網頁輸入localhost:8080/List