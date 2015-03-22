-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: product
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `cl_login`
--

DROP TABLE IF EXISTS `cl_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cl_login` (
  `id` varchar(50) NOT NULL,
  `login_name` varchar(100) NOT NULL,
  `login_password` varchar(30) NOT NULL,
  `email` varchar(700) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `organization` varchar(50) DEFAULT NULL,
  `role` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cl_login`
--

LOCK TABLES `cl_login` WRITE;
/*!40000 ALTER TABLE `cl_login` DISABLE KEYS */;
INSERT INTO `cl_login` VALUES ('4','raju','reddy','raju@gmail.com','988767654','Raju','reddy','CTS',NULL),('c8b7bcd2-4fd0-45cb-a50a-d6f752e498ab','nivi','gouru','rnivi@gmail.com','12345','hello','ebus','Novum',NULL),('1','hema','latha','hemalatha@gmail.com','12343245','hema','latha','XYZ',NULL);
/*!40000 ALTER TABLE `cl_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cl_operations`
--

DROP TABLE IF EXISTS `cl_operations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cl_operations` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cl_operations`
--

LOCK TABLES `cl_operations` WRITE;
/*!40000 ALTER TABLE `cl_operations` DISABLE KEYS */;
INSERT INTO `cl_operations` VALUES ('3','view workflow','allows to view workflow'),('2','system manager','allows to system manager'),('4','manage entitied','allows to manage entities'),('6','view reports','allows to view entities'),('7','manage reports','allows to manage reports');
/*!40000 ALTER TABLE `cl_operations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cl_organization`
--

DROP TABLE IF EXISTS `cl_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cl_organization` (
  `id` varchar(50) NOT NULL,
  `name` varchar(500) NOT NULL,
  `email` varchar(700) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  `country` varchar(3) DEFAULT NULL,
  `street` varchar(700) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cl_organization`
--

LOCK TABLES `cl_organization` WRITE;
/*!40000 ALTER TABLE `cl_organization` DISABLE KEYS */;
INSERT INTO `cl_organization` VALUES ('1','novum','supraja@horoppa.com','9550058252','hyderabad','Telangana',500049,'IND','madhapur'),('2','horoppa','supriya@horoppa.com','9775547634','californina','nw',1234,'USA','sant jose');
/*!40000 ALTER TABLE `cl_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cl_role`
--

DROP TABLE IF EXISTS `cl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cl_role` (
  `id` varchar(50) NOT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cl_role`
--

LOCK TABLES `cl_role` WRITE;
/*!40000 ALTER TABLE `cl_role` DISABLE KEYS */;
INSERT INTO `cl_role` VALUES ('1','admin','admin','active'),('2','operator','operatur','active'),('3','orgadmin','orgadmin','active'),('4','subadmin','subadmin','active');
/*!40000 ALTER TABLE `cl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cl_role_operations`
--

DROP TABLE IF EXISTS `cl_role_operations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cl_role_operations` (
  `role_id` varchar(30) DEFAULT NULL,
  `operation_id` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cl_role_operations`
--

LOCK TABLES `cl_role_operations` WRITE;
/*!40000 ALTER TABLE `cl_role_operations` DISABLE KEYS */;
INSERT INTO `cl_role_operations` VALUES ('2','3'),('2','4'),('2','7');
/*!40000 ALTER TABLE `cl_role_operations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-22 10:20:17
