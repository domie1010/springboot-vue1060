-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springboot9dxtvt01
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `springboot9dxtvt01`
--

/*!40000 DROP DATABASE IF EXISTS `springboot9dxtvt01`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `springboot9dxtvt01` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springboot9dxtvt01`;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  `url` varchar(500) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg',NULL),(2,'picture2','upload/picture2.jpg',NULL),(3,'picture3','upload/picture3.jpg',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exampaper`
--

DROP TABLE IF EXISTS `exampaper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exampaper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `name` varchar(200) NOT NULL COMMENT '题库名称',
  `time` int(11) NOT NULL COMMENT '答题时长(分钟)',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '题库状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='题库表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exampaper`
--

LOCK TABLES `exampaper` WRITE;
/*!40000 ALTER TABLE `exampaper` DISABLE KEYS */;
INSERT INTO `exampaper` VALUES (1,'2024-03-09 10:06:04','十万个为什么',60,1);
/*!40000 ALTER TABLE `exampaper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examquestion`
--

DROP TABLE IF EXISTS `examquestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examquestion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `paperid` bigint(20) NOT NULL COMMENT '所属题库id（外键）',
  `papername` varchar(200) NOT NULL COMMENT '题库名称',
  `questionname` varchar(200) NOT NULL COMMENT '题目名称',
  `options` longtext COMMENT '选项，json字符串',
  `score` bigint(20) DEFAULT '0' COMMENT '分值',
  `answer` varchar(200) DEFAULT NULL COMMENT '正确答案',
  `analysis` longtext COMMENT '答案解析',
  `type` bigint(20) DEFAULT '0' COMMENT '题目类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空）4:主观题',
  `sequence` bigint(20) DEFAULT '100' COMMENT '题目排序，值越大排越前面',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='题目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examquestion`
--

LOCK TABLES `examquestion` WRITE;
/*!40000 ALTER TABLE `examquestion` DISABLE KEYS */;
INSERT INTO `examquestion` VALUES (1,'2024-03-09 10:06:04',1,'十万个为什么','下面动物不属于昆虫的是（）。','[{\"text\":\"A.苍蝇\",\"code\":\"A\"},{\"text\":\"B.蜜蜂\",\"code\":\"B\"},{\"text\":\"C.蜂鸟\",\"code\":\"C\"}]',20,'C','蜂鸟',0,1),(2,'2024-03-09 10:06:04',1,'十万个为什么','油着火后可以用水扑灭。','[{\"text\":\"A.对\",\"code\":\"A\"},{\"text\":\"B.错\",\"code\":\"B\"}]',20,'B','油着火后不可以用水扑灭',2,2),(3,'2024-03-09 10:06:04',1,'十万个为什么','地球是个球体，中间是（ ）。','[]',30,'赤道','赤道',3,3),(4,'2024-03-09 10:06:04',1,'十万个为什么','下面动物中会流汗的有（ ）。','[{\"text\":\"A.马\",\"code\":\"A\"},{\"text\":\"B.猫\",\"code\":\"B\"},{\"text\":\"C.狗\",\"code\":\"C\"}]',30,'A,B','狗不会流汗',1,4),(5,'2024-03-09 10:06:04',1,'十万个为什么','世界上为什么不存在完美的圆？','[]',30,'','目前没有证据表明现实中存在完美的圆',4,5);
/*!40000 ALTER TABLE `examquestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examquestionbank`
--

DROP TABLE IF EXISTS `examquestionbank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examquestionbank` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `questionname` varchar(200) NOT NULL COMMENT '题目名称',
  `options` longtext COMMENT '选项，json字符串',
  `score` bigint(20) DEFAULT '0' COMMENT '分值',
  `answer` varchar(200) DEFAULT NULL COMMENT '正确答案',
  `analysis` longtext COMMENT '答案解析',
  `type` bigint(20) DEFAULT '0' COMMENT '题目类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空） 4:主观题',
  `sequence` bigint(20) DEFAULT '100' COMMENT '题目排序，值越大排越前面',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='题目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examquestionbank`
--

LOCK TABLES `examquestionbank` WRITE;
/*!40000 ALTER TABLE `examquestionbank` DISABLE KEYS */;
INSERT INTO `examquestionbank` VALUES (1,'2024-03-09 10:06:04','下面动物不属于昆虫的是（）。','[{\"text\":\"A.苍蝇\",\"code\":\"A\"},{\"text\":\"B.蜜蜂\",\"code\":\"B\"},{\"text\":\"C.蜂鸟\",\"code\":\"C\"}]',20,'C','蜂鸟',0,1),(2,'2024-03-09 10:06:04','油着火后可以用水扑灭。','[{\"text\":\"A.对\",\"code\":\"A\"},{\"text\":\"B.错\",\"code\":\"B\"}]',20,'B','油着火后不可以用水扑灭',2,2),(3,'2024-03-09 10:06:04','地球是个球体，中间是（ ）。','[]',30,'赤道','赤道',3,3),(4,'2024-03-09 10:06:04','下面动物中会流汗的有（ ）。','[{\"text\":\"A.马\",\"code\":\"A\"},{\"text\":\"B.猫\",\"code\":\"B\"},{\"text\":\"C.狗\",\"code\":\"C\"}]',30,'A,B','狗不会流汗',1,4),(5,'2024-03-09 10:06:04','世界上为什么不存在完美的圆？','[]',30,'','目前没有证据表明现实中存在完美的圆',4,5);
/*!40000 ALTER TABLE `examquestionbank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examrecord`
--

DROP TABLE IF EXISTS `examrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `paperid` bigint(20) NOT NULL COMMENT '题库id（外键）',
  `papername` varchar(200) NOT NULL COMMENT '题库名称',
  `questionid` bigint(20) NOT NULL COMMENT '题目id（外键）',
  `questionname` varchar(200) NOT NULL COMMENT '题目名称',
  `options` longtext COMMENT '选项，json字符串',
  `score` bigint(20) DEFAULT '0' COMMENT '分值',
  `answer` varchar(200) DEFAULT NULL COMMENT '正确答案',
  `analysis` longtext COMMENT '答案解析',
  `ismark` bigint(20) DEFAULT '0' COMMENT '是否批卷',
  `type` bigint(20) DEFAULT '0' COMMENT '题目类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空） 4:主观题',
  `myscore` bigint(20) NOT NULL DEFAULT '0' COMMENT '题目得分',
  `myanswer` varchar(200) DEFAULT NULL COMMENT '考生答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='答题记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examrecord`
--

LOCK TABLES `examrecord` WRITE;
/*!40000 ALTER TABLE `examrecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `examrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lianxijilu`
--

DROP TABLE IF EXISTS `lianxijilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lianxijilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jilubianhao` varchar(200) DEFAULT NULL COMMENT '记录编号',
  `zhanghao` varchar(200) NOT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `datishijian` datetime DEFAULT NULL COMMENT '答题时间',
  `daticishu` int(11) DEFAULT NULL COMMENT '答题次数',
  `cuoticishu` int(11) DEFAULT NULL COMMENT '错题次数',
  `cuotibaogao` longtext COMMENT '错题报告',
  `jianyi` longtext COMMENT '建议',
  PRIMARY KEY (`id`),
  UNIQUE KEY `jilubianhao` (`jilubianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='练习记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lianxijilu`
--

LOCK TABLES `lianxijilu` WRITE;
/*!40000 ALTER TABLE `lianxijilu` DISABLE KEYS */;
INSERT INTO `lianxijilu` VALUES (21,'2024-03-09 10:06:04','1111111111','账号1','姓名1','2024-03-09 18:06:04',1,1,'','建议1'),(22,'2024-03-09 10:06:04','2222222222','账号2','姓名2','2024-03-09 18:06:04',2,2,'','建议2'),(23,'2024-03-09 10:06:04','3333333333','账号3','姓名3','2024-03-09 18:06:04',3,3,'','建议3'),(24,'2024-03-09 10:06:04','4444444444','账号4','姓名4','2024-03-09 18:06:04',4,4,'','建议4'),(25,'2024-03-09 10:06:04','5555555555','账号5','姓名5','2024-03-09 18:06:04',5,5,'','建议5'),(26,'2024-03-09 10:06:04','6666666666','账号6','姓名6','2024-03-09 18:06:04',6,6,'','建议6'),(27,'2024-03-09 10:06:04','7777777777','账号7','姓名7','2024-03-09 18:06:04',7,7,'','建议7'),(28,'2024-03-09 10:06:04','8888888888','账号8','姓名8','2024-03-09 18:06:04',8,8,'','建议8');
/*!40000 ALTER TABLE `lianxijilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemnotice`
--

DROP TABLE IF EXISTS `systemnotice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemnotice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统公告';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemnotice`
--

LOCK TABLES `systemnotice` WRITE;
/*!40000 ALTER TABLE `systemnotice` DISABLE KEYS */;
INSERT INTO `systemnotice` VALUES (1,'2024-03-09 10:06:04','这是系统公告');
/*!40000 ALTER TABLE `systemnotice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `image` varchar(200) DEFAULT NULL COMMENT '头像',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','upload/image1.jpg','管理员','2024-03-09 10:06:04');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xuesheng`
--

DROP TABLE IF EXISTS `xuesheng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xuesheng` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhanghao` varchar(200) NOT NULL COMMENT '账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `youxiang` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `shoujihaoma` varchar(200) DEFAULT NULL COMMENT '手机号码',
  `touxiang` longtext COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhanghao` (`zhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='学生';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xuesheng`
--

LOCK TABLES `xuesheng` WRITE;
/*!40000 ALTER TABLE `xuesheng` DISABLE KEYS */;
INSERT INTO `xuesheng` VALUES (11,'2024-03-09 10:06:04','账号1','123456','姓名1','男','773890001@qq.com','13823888881','upload/xuesheng_touxiang1.jpg'),(12,'2024-03-09 10:06:04','账号2','123456','姓名2','男','773890002@qq.com','13823888882','upload/xuesheng_touxiang2.jpg'),(13,'2024-03-09 10:06:04','账号3','123456','姓名3','男','773890003@qq.com','13823888883','upload/xuesheng_touxiang3.jpg'),(14,'2024-03-09 10:06:04','账号4','123456','姓名4','男','773890004@qq.com','13823888884','upload/xuesheng_touxiang4.jpg'),(15,'2024-03-09 10:06:04','账号5','123456','姓名5','男','773890005@qq.com','13823888885','upload/xuesheng_touxiang5.jpg'),(16,'2024-03-09 10:06:04','账号6','123456','姓名6','男','773890006@qq.com','13823888886','upload/xuesheng_touxiang6.jpg'),(17,'2024-03-09 10:06:04','账号7','123456','姓名7','男','773890007@qq.com','13823888887','upload/xuesheng_touxiang7.jpg'),(18,'2024-03-09 10:06:04','账号8','123456','姓名8','男','773890008@qq.com','13823888888','upload/xuesheng_touxiang8.jpg');
/*!40000 ALTER TABLE `xuesheng` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-11 13:06:59
