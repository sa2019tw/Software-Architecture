# 如何使用

* IDE：IntlliJ IDEA 2018.3.5 x64
* Tomcat：`Tomcat9.0.12`
* DataBase：MySQL

* IntelliJ > File > open > {homework path} > 107598029/HW1
* Defult URL：Edit Conigurations > URL > http://localhost:8080/list

# 注意事項

首先須於 MySQL 建立 名為：sa 的資料庫
接著在資料庫下建立此表格

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