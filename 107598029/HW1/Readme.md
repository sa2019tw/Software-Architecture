# 條件
* IDE：IntlliJ IDEA 2018.3.5 x64
* DataBase：MySQL

# 注意事項

* 首先須於 MySQL 建立資料庫
* 接著此資料庫下建立此表格

* DataBase Schema
```
CREATE TABLE `coursesys` (
  `courseid` int(11) NOT NULL AUTO_INCREMENT,
  `coursename` varchar(45) NOT NULL,
  `courselevel` varchar(45) DEFAULT NULL,
  `courseprice` int(11) DEFAULT NULL,
  `coursedescription` varchar(45) DEFAULT NULL,
  `precautions` varchar(45) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`courseid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

```

* 接著在 Dbconn.java > 設定資料庫`名稱`以及`帳號與密碼`

# 如何使用

* IntelliJ > File > import > Software-Architecture/107598029/HW1

* Maven > Plugins > tomcat7 > `tomcat7:run`

* Open URL：http://localhost:8080