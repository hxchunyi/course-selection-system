CREATE DATABASE  IF NOT EXISTS `infor_student` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `infor_student`;
-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: infor_student
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acount`
--

DROP TABLE IF EXISTS `acount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acount` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `admin` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acount`
--

LOCK TABLES `acount` WRITE;
/*!40000 ALTER TABLE `acount` DISABLE KEYS */;
INSERT INTO `acount` VALUES (1,'2019218111','110359','管理员','18637666869'),(2,'10001','111111','老师','18637666869'),(3,'10002','111111','老师','18637666869'),(4,'10003','111111','老师','18637666869'),(5,'2015070011','123456','学生','18637666869'),(6,'2015070012','123456','学生','18637666869'),(7,'2015070013','123456','学生','18637666869'),(8,'2015070014','123456','学生','18637666869'),(9,'2015070021','123456','学生','18637666869'),(10,'2015070022','123456','学生','18637666869'),(11,'2015070023','123456','学生','18637666869'),(12,'2015070024','123456','学生','18637666869'),(39,'10013','111111','老师','18637666869'),(40,'09999','111111','老师','13613902856'),(41,'2019218999','123456','学生','13613902856');
/*!40000 ALTER TABLE `acount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` char(5) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `introduce` text,
  `courese_hour` int DEFAULT NULL,
  `credit` int DEFAULT NULL,
  `semester` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('07001','计算机应用基础','掌握计算机基本操作',32,4,'1'),('07002','计算机网络技术基础','掌握计算机网络应用',64,4,'1'),('07003','数据库技术基础','掌握数据库系统设计',64,4,'2'),('07004','移动应用开发','移动应用开发',32,4,'6'),('07005','计算机组成原理','计算机组成原理',64,4,'3'),('07006','协议分析','协议分析',64,4,'5'),('07007','面向对象程序设计','面向对象程序设计',32,4,'2'),('07008','编译原理','编译原理',64,4,'5'),('07009','通信原理','通信原理',64,4,'4'),('07010','数据库技术与应用','数据库技术与应用',32,2,'3'),('07011','数据库原理','数据库原理',32,2,'4'),('07012','计算机组网技术','计算机组网技术',32,2,'3'),('07013','大学英语','大学英语',32,2,'1'),('07014','软件工程','软件工程',32,2,'4'),('07020','Web程序设计','Web程序设计',64,3,'4'),('07021','Web前端开发','Web前端开发',64,3,'3'),('07022','网络安全','网络安全',64,3,'5'),('07023','高等数学','高等数学',64,3,'2'),('07024','软件测试','软件测试',64,3,'4'),('07061','线性代数','线性代数',32,4,'3'),('07062','离散数学','离散数学',64,4,'3'),('07063','网络编程','网络编程',64,4,'5'),('07071','UML建模','UML建模',32,4,'5'),('07072','马克思主义原理','马克思主义原理',64,4,'1'),('07073','形势与政策','形势与政策',64,4,'2'),('0999','大学生爱情兵法','恋爱',9,5,'2');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sc`
--

DROP TABLE IF EXISTS `sc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sc` (
  `sid` char(10) NOT NULL,
  `cid` char(5) NOT NULL,
  `score` int DEFAULT NULL,
  PRIMARY KEY (`sid`,`cid`),
  KEY `c` (`cid`),
  CONSTRAINT `c` FOREIGN KEY (`cid`) REFERENCES `course` (`id`),
  CONSTRAINT `s` FOREIGN KEY (`sid`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sc`
--

LOCK TABLES `sc` WRITE;
/*!40000 ALTER TABLE `sc` DISABLE KEYS */;
INSERT INTO `sc` VALUES ('2015070011','07001',1),('2015070011','07003',NULL),('2015070011','07006',NULL),('2015070013','07001',2),('2015070013','07002',83),('2015070013','07003',83),('2015070013','07004',NULL),('2015070013','07008',NULL),('2015070013','07010',84),('2015070013','07011',NULL),('2015070013','07014',NULL),('2015070013','07020',82),('2015070014','07001',3),('2015070014','07002',80),('2015070014','07003',80),('2015070014','07010',85),('2015070014','07020',81),('2015070021','07001',4),('2015070021','07002',81),('2015070021','07003',81),('2015070021','07010',80),('2015070022','07001',88),('2015070022','07002',79),('2015070022','07003',79),('2015070022','07010',76),('2015070022','07012',58),('2015070023','07001',83),('2015070023','07002',74),('2015070023','07003',74),('2015070023','07010',79),('2015070023','07020',73),('2015070024','07001',58),('2015070024','07002',90),('2015070024','07003',90),('2015070024','07010',94),('2015070024','07020',90),('2015070031','07001',68),('2015070031','07002',79),('2015070031','07003',72),('2015070031','07010',74),('2015070031','07020',72),('2015070032','07001',73),('2015070032','07002',81),('2015070032','07003',61),('2015070032','07010',65),('2015070033','07001',68),('2015070033','07002',66),('2015070033','07003',65),('2015070033','07010',80),('2015070034','07001',75),('2015070034','07002',73),('2015070034','07003',73),('2015070034','07010',73),('2018217910','07001',75),('2018217910','07002',63),('2018217910','07003',63),('2018217910','07010',69),('2018217910','07020',67),('2018217917','07001',69),('2018217917','07002',63),('2018217917','07003',63),('2018217917','07010',63),('2018217918','07001',79),('2018217918','07002',92),('2018217918','07003',92),('2018217918','07010',91),('2018217919','07001',72),('2018217919','07002',60),('2018217919','07003',60),('2018217919','07010',85),('2018217935','07001',67),('2018217935','07002',79),('2018217935','07003',79),('2018217935','07010',59),('2018217935','07020',57),('2018217937','07001',75),('2018217937','07002',65),('2018217937','07003',65),('2018217937','07010',13),('2018217938','07001',93),('2018217938','07002',78),('2018217938','07003',78),('2018217938','07010',71),('2018217939','07001',99),('2018217939','07002',99),('2018217939','07003',56),('2018217939','07010',54),('2019218999','07022',99),('2019218999','0999',NULL);
/*!40000 ALTER TABLE `sc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` char(10) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `native` varchar(10) DEFAULT NULL,
  `politic_status` varchar(8) DEFAULT NULL,
  `avatar` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('2015070011','张文静','女','1996-02-01','汉族','共青团员','static/images/girl-1.png'),('2015070012','赵文泽','女','1996-02-19','汉族','共青团员','static/images/girl-2.png'),('2015070013','张小闵','女','1996-07-01','汉族','共青团员','static/images/girl-3.png'),('2015070014','陈霞','女','1995-02-11','汉族','共青团员','static/images/girl-4.png'),('2015070021','刘海燕','女','1996-10-18','汉族','共青团员','static/images/girl-5.png'),('2015070022','李晓艳','女','1997-09-18','汉族','共青团员','static/images/girl-6.png'),('2015070023','辛春宇','女','1996-06-18','汉族','群众','static/images/girl-7.png'),('2015070024','刘海燕','女','1996-10-31','汉族','共青团员','static/images/girl-8.png'),('2015070031','宋志强','男','1996-05-23','汉族','中共党员','static/images/boy-1.png'),('2015070032','唐敏','女','1999-03-25','汉族','群众','static/images/girl-2.png'),('2015070033','刘得力','男','1996-04-23','回族','中共党员','static/images/girl-2.png'),('2015070034','宋文涛','男','1997-06-03','汉族','中青团员','static/images/girl-2.png'),('2018217910','王斌','男','2000-11-28','汉族','中共党员','static/images/girl-2.png'),('2018217917','卓一凡','男','2001-11-23','藏族','群众','static/images/boy-2.png'),('2018217918','于涛','男','2000-08-28','汉族','中共党员','static/images/girl-2.png'),('2018217919','李一仁','男','2000-10-12','回族','群众','static/images/girl-2.png'),('2018217935','王钊','男','2000-02-28','汉族','中青团员','static/images/girl-2.png'),('2018217937','王小明','男','2000-02-01','汉族','中青团员','static/images/girl-2.png'),('2018217938','马天宇','男','2001-12-28','维吾尔族','中青团员','static/images/girl-2.png'),('2018217939','春意','男','2000-05-21','汉族','中青团员','static/images/girl-2.png'),('2019218999','刘九九','女','2000-02-02','汉','共青团员','static/images/girl-4.png');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `tid` int NOT NULL,
  `cid` varchar(45) NOT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `tname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tid`,`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (9999,'07022','2019','九九'),(10001,'07001','2015','张老师'),(10001,'07002','2018','张老师'),(10002,'07003','2015','王老师'),(10003,'07002','2015','李老师'),(10004,'07003','2015','马老师'),(10005,'07004','2015','徐老师'),(10006,'07005','2015','马老师'),(10007,'07006','2015','聊老师'),(10008,'07007','2018','春老师'),(10009,'07008','2018','赵老师'),(10010,'07009','2018','毛老师'),(10011,'07010','2018','陈小生'),(10012,'07011','2018','张伟'),(10013,'07012','2018','李四'),(10014,'07013','2018','张三'),(10015,'07014','2015','李四'),(10086,'07004','2019','ä¸èå¸'),(10099,'07020','2019','ä¸èå¸'),(15151,'07005','2022','程老师'),(56151,'07004','2021','才学坤'),(151111,'07014','2021','张三'),(2019218,'07014','2019','春意');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-09 22:20:56
