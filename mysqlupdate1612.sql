-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: booking
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `status` int NOT NULL,
  `total_price` int NOT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `buyer_id` bigint DEFAULT NULL,
  `session_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbosctmg0ob77isaf3410lxmpd` (`buyer_id`),
  KEY `FKa574211usplun3mowghegblyu` (`session_id`),
  CONSTRAINT `FKa574211usplun3mowghegblyu` FOREIGN KEY (`session_id`) REFERENCES `sessionr` (`id`),
  CONSTRAINT `FKbosctmg0ob77isaf3410lxmpd` FOREIGN KEY (`buyer_id`) REFERENCES `info_buyer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (16,'10','2020-12-12 21:48:55','10','2020-12-12 21:48:55',1,800000,'yet',15,1),(20,'10','2020-12-12 22:03:20','10','2020-12-12 22:03:20',1,800000,'yet',19,1),(37,'4','2020-12-14 13:10:50','4','2020-12-14 13:10:51',0,0,'yet',36,1),(40,'4','2020-12-14 13:11:24','4','2020-12-15 00:48:12',0,0,'done',39,1);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `car_number` varchar(255) DEFAULT NULL,
  `driver_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,NULL,NULL,NULL,NULL,'Car 1','51A17110','Thai Bao'),(2,NULL,NULL,NULL,NULL,'Car 2','51A17111','Phuong Mai'),(3,NULL,NULL,NULL,NULL,'Car 3','63B17119','Dinh Hai'),(4,NULL,NULL,NULL,NULL,'Car 4','63B19998','Truong An'),(5,NULL,NULL,NULL,NULL,'Car 5','52A17110','Van Huy'),(6,NULL,NULL,NULL,NULL,'Car 6','53A17110','Quoc Hung'),(7,NULL,NULL,NULL,NULL,'Car 7','53A17112','Thanh Trung'),(8,NULL,NULL,NULL,NULL,'Car 8','59A17110','Tran Thanh'),(9,NULL,NULL,NULL,NULL,'Car 9','63B19000','Viet Huong'),(10,NULL,NULL,NULL,NULL,'Car 10','63B17011','Hoai Linh');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (42);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info_buyer`
--

DROP TABLE IF EXISTS `info_buyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `info_buyer` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `number_phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info_buyer`
--

LOCK TABLES `info_buyer` WRITE;
/*!40000 ALTER TABLE `info_buyer` DISABLE KEYS */;
INSERT INTO `info_buyer` VALUES (15,'10','2020-12-12 21:48:55','10','2020-12-12 21:48:55','01 Vo Van Ngan','htthaibao@gmail.com','Thai bao','0328824053'),(19,'10','2020-12-12 22:03:20','10','2020-12-12 22:03:20','01 Vo Van Ngan','htthaibao@gmail.com','Thai bao','0328824053'),(23,'4','2020-12-14 13:00:44','4','2020-12-14 13:00:44','01 Vo Van Ngan','thaibao1998@gmail.com','Thai Bao','0338824053'),(25,'4','2020-12-14 13:00:53','4','2020-12-14 13:00:53','01 Vo Van Ngan','thaibao1998@gmail.com','Thai Bao','0338824053'),(27,'4','2020-12-14 13:02:43','4','2020-12-14 13:02:43','01 Vo Van Ngan','thaibao1998@gmail.com','Thai Bao','0338824053'),(30,'4','2020-12-14 13:04:35','4','2020-12-14 13:04:35','01 Vo Van Ngan','thaibao1998@gmail.com','Thai Bao','0338824053'),(33,'4','2020-12-14 13:06:33','4','2020-12-14 13:06:33','01 Vo Van Ngan','thaibao1998@gmail.com','Thai Bao','0338824053'),(36,'4','2020-12-14 13:10:50','4','2020-12-14 13:10:50','01 Vo Van Ngan','thaibao1998@gmail.com','Thai Bao','0338824053'),(39,'4','2020-12-14 13:11:24','4','2020-12-14 13:11:24','01 Vo Van Ngan','thaibao1998@gmail.com','Thai Bao','0338824053');
/*!40000 ALTER TABLE `info_buyer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,NULL,NULL,NULL,NULL,'Ha Noi'),(2,NULL,NULL,NULL,NULL,'Ho Chi Minh'),(3,NULL,NULL,NULL,NULL,'Tien Giang'),(4,NULL,NULL,NULL,NULL,'Da Lat'),(5,NULL,NULL,NULL,NULL,'Dong Nai'),(6,NULL,NULL,NULL,NULL,'Vung Tau'),(7,NULL,NULL,NULL,NULL,'Da Nang'),(8,NULL,NULL,NULL,NULL,'Hue'),(9,NULL,NULL,NULL,NULL,'Nha Trang'),(10,NULL,NULL,'4','2020-12-15 00:58:03','Can Tho');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,NULL,'2020-12-10 00:12:51',NULL,'2020-12-10 00:12:51','ROLE_ADMIN'),(2,NULL,'2020-12-10 00:12:51',NULL,'2020-12-10 00:12:51','ROLE_MANAGER'),(3,NULL,'2020-12-10 00:12:51',NULL,'2020-12-10 00:12:51','ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  `starting_point` varchar(255) DEFAULT NULL,
  `time_expecting` varchar(255) DEFAULT NULL,
  `time_starting` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,NULL,NULL,NULL,NULL,'Ha Noi',400000,'Nha Trang','05:30:00','21:00:00'),(2,NULL,NULL,NULL,NULL,'Da Nang',500000,'Ca Mau','06:00:00','19:00:00'),(3,NULL,NULL,NULL,NULL,'Ho Chi Minh',300000,'Can Tho','06:15:00','22:00:00'),(4,NULL,NULL,NULL,NULL,'Tien Giang',100000,'Long An','06:20:00','5:00:00'),(5,NULL,NULL,NULL,NULL,'Da Lat',250000,'Vung Tau','05:00:00','22:30:00'),(6,NULL,NULL,NULL,NULL,'Vung Tau',260000,'Da Lat','05:45:00','21:50:00'),(7,NULL,NULL,NULL,NULL,'Long An',120000,'Tien Giang','06:45:00','4:00:00'),(8,NULL,NULL,NULL,NULL,'Can Tho',600000,'Hue','05:15:00','20:15:00'),(9,NULL,NULL,NULL,NULL,'Hue',450000,'Can Tho','06:15:00','19:30:00'),(10,NULL,NULL,NULL,NULL,'Nha Trang',250000,'Ha Noi','06:20:00','19:45:00');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_cars`
--

DROP TABLE IF EXISTS `route_cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route_cars` (
  `route_id` bigint NOT NULL,
  `car_id` bigint NOT NULL,
  PRIMARY KEY (`route_id`,`car_id`),
  KEY `FKj845wdhjbf4ew3xkh4jjmejx3` (`car_id`),
  CONSTRAINT `FKj845wdhjbf4ew3xkh4jjmejx3` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
  CONSTRAINT `FKte0x7v138cxt5gbfp7gmvaju1` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_cars`
--

LOCK TABLES `route_cars` WRITE;
/*!40000 ALTER TABLE `route_cars` DISABLE KEYS */;
INSERT INTO `route_cars` VALUES (1,1),(1,2),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);
/*!40000 ALTER TABLE `route_cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `car_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqk1dnoiwxwch3jofiy8a50fu7` (`car_id`),
  CONSTRAINT `FKqk1dnoiwxwch3jofiy8a50fu7` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,NULL,NULL,NULL,NULL,'1A1',1),(2,NULL,NULL,NULL,NULL,'1A2',1),(3,NULL,NULL,NULL,NULL,'1A3',1),(4,NULL,NULL,NULL,NULL,'1A4',1),(5,NULL,NULL,NULL,NULL,'1A5',1),(6,NULL,NULL,NULL,NULL,'1A6',1),(7,NULL,NULL,NULL,NULL,'1A7',1),(8,NULL,NULL,NULL,NULL,'1A8',1),(9,NULL,NULL,NULL,NULL,'1A9',1),(10,NULL,NULL,NULL,NULL,'1A10',1),(11,NULL,NULL,NULL,NULL,'1A11',1),(12,NULL,NULL,NULL,NULL,'1A12',1),(13,NULL,NULL,NULL,NULL,'1A13',1),(14,NULL,NULL,NULL,NULL,'1A14',1),(15,NULL,NULL,NULL,NULL,'1A15',1),(16,NULL,NULL,NULL,NULL,'1A16',1),(17,NULL,NULL,NULL,NULL,'1A17',1),(18,NULL,NULL,NULL,NULL,'1A18',1),(19,NULL,NULL,NULL,NULL,'1A19',1),(20,NULL,NULL,NULL,NULL,'1A20',1),(21,NULL,NULL,NULL,NULL,'2A1',2),(22,NULL,NULL,NULL,NULL,'2A2',2),(23,NULL,NULL,NULL,NULL,'2A3',2),(24,NULL,NULL,NULL,NULL,'2A4',2),(25,NULL,NULL,NULL,NULL,'2A5',2),(26,NULL,NULL,NULL,NULL,'2A6',2),(27,NULL,NULL,NULL,NULL,'2A7',2),(28,NULL,NULL,NULL,NULL,'2A8',2),(29,NULL,NULL,NULL,NULL,'2A9',2),(30,NULL,NULL,NULL,NULL,'2A10',2),(31,NULL,NULL,NULL,NULL,'2A11',2),(32,NULL,NULL,NULL,NULL,'2A12',2),(33,NULL,NULL,NULL,NULL,'2A13',2),(34,NULL,NULL,NULL,NULL,'2A14',2),(35,NULL,NULL,NULL,NULL,'2A15',2),(36,NULL,NULL,NULL,NULL,'2A16',2),(37,NULL,NULL,NULL,NULL,'2A17',2),(38,NULL,NULL,NULL,NULL,'2A18',2),(39,NULL,NULL,NULL,NULL,'2A19',2),(40,NULL,NULL,NULL,NULL,'2A20',2),(41,NULL,NULL,NULL,NULL,'3A1',3),(42,NULL,NULL,NULL,NULL,'3A2',3),(43,NULL,NULL,NULL,NULL,'3A3',3),(44,NULL,NULL,NULL,NULL,'3A4',3),(45,NULL,NULL,NULL,NULL,'3A5',3),(46,NULL,NULL,NULL,NULL,'3A6',3),(47,NULL,NULL,NULL,NULL,'3A7',3),(48,NULL,NULL,NULL,NULL,'3A8',3),(49,NULL,NULL,NULL,NULL,'3A9',3),(50,NULL,NULL,NULL,NULL,'3A10',3),(51,NULL,NULL,NULL,NULL,'3A11',3),(52,NULL,NULL,NULL,NULL,'3A12',3),(53,NULL,NULL,NULL,NULL,'3A13',3),(54,NULL,NULL,NULL,NULL,'3A14',3),(55,NULL,NULL,NULL,NULL,'3A15',3),(56,NULL,NULL,NULL,NULL,'3A16',3),(57,NULL,NULL,NULL,NULL,'3A17',3),(58,NULL,NULL,NULL,NULL,'3A18',3),(59,NULL,NULL,NULL,NULL,'3A19',3),(60,NULL,NULL,NULL,NULL,'3A20',3),(61,NULL,NULL,NULL,NULL,'4A1',4),(62,NULL,NULL,NULL,NULL,'4A2',4),(63,NULL,NULL,NULL,NULL,'4A3',4),(64,NULL,NULL,NULL,NULL,'4A4',4),(65,NULL,NULL,NULL,NULL,'4A5',4),(66,NULL,NULL,NULL,NULL,'4A6',4),(67,NULL,NULL,NULL,NULL,'4A7',4),(68,NULL,NULL,NULL,NULL,'4A8',4),(69,NULL,NULL,NULL,NULL,'4A9',4),(70,NULL,NULL,NULL,NULL,'4A10',4),(71,NULL,NULL,NULL,NULL,'4A11',4),(72,NULL,NULL,NULL,NULL,'4A12',4),(73,NULL,NULL,NULL,NULL,'4A13',4),(74,NULL,NULL,NULL,NULL,'4A14',4),(75,NULL,NULL,NULL,NULL,'4A15',4),(76,NULL,NULL,NULL,NULL,'4A16',4),(77,NULL,NULL,NULL,NULL,'4A17',4),(78,NULL,NULL,NULL,NULL,'4A18',4),(79,NULL,NULL,NULL,NULL,'4A19',4),(80,NULL,NULL,NULL,NULL,'4A20',4),(81,NULL,NULL,NULL,NULL,'5A1',5),(82,NULL,NULL,NULL,NULL,'5A2',5),(83,NULL,NULL,NULL,NULL,'5A3',5),(84,NULL,NULL,NULL,NULL,'5A4',5),(85,NULL,NULL,NULL,NULL,'5A5',5),(86,NULL,NULL,NULL,NULL,'5A6',5),(87,NULL,NULL,NULL,NULL,'5A7',5),(88,NULL,NULL,NULL,NULL,'5A8',5),(89,NULL,NULL,NULL,NULL,'5A9',5),(90,NULL,NULL,NULL,NULL,'5A10',5),(91,NULL,NULL,NULL,NULL,'5A11',5),(92,NULL,NULL,NULL,NULL,'5A12',5),(93,NULL,NULL,NULL,NULL,'5A13',5),(94,NULL,NULL,NULL,NULL,'5A14',5),(95,NULL,NULL,NULL,NULL,'5A15',5),(96,NULL,NULL,NULL,NULL,'5A16',5),(97,NULL,NULL,NULL,NULL,'5A17',5),(98,NULL,NULL,NULL,NULL,'5A18',5),(99,NULL,NULL,NULL,NULL,'5A19',5),(100,NULL,NULL,NULL,NULL,'5A29',5),(101,NULL,NULL,NULL,NULL,'6A1',6),(102,NULL,NULL,NULL,NULL,'6A2',6),(103,NULL,NULL,NULL,NULL,'6A3',6),(104,NULL,NULL,NULL,NULL,'6A4',6),(105,NULL,NULL,NULL,NULL,'6A5',6),(106,NULL,NULL,NULL,NULL,'6A6',6),(107,NULL,NULL,NULL,NULL,'6A7',6),(108,NULL,NULL,NULL,NULL,'6A8',6),(109,NULL,NULL,NULL,NULL,'6A9',6),(110,NULL,NULL,NULL,NULL,'6A10',6),(111,NULL,NULL,NULL,NULL,'6A11',6),(112,NULL,NULL,NULL,NULL,'6A12',6),(113,NULL,NULL,NULL,NULL,'6A13',6),(114,NULL,NULL,NULL,NULL,'6A14',6),(115,NULL,NULL,NULL,NULL,'6A15',6),(116,NULL,NULL,NULL,NULL,'6A16',6),(117,NULL,NULL,NULL,NULL,'6A17',6),(118,NULL,NULL,NULL,NULL,'6A18',6),(119,NULL,NULL,NULL,NULL,'6A19',6),(120,NULL,NULL,NULL,NULL,'6A20',6),(121,NULL,NULL,NULL,NULL,'7A1',7),(122,NULL,NULL,NULL,NULL,'7A2',7),(123,NULL,NULL,NULL,NULL,'7A3',7),(124,NULL,NULL,NULL,NULL,'7A4',7),(125,NULL,NULL,NULL,NULL,'7A5',7),(126,NULL,NULL,NULL,NULL,'7A6',7),(127,NULL,NULL,NULL,NULL,'7A7',7),(128,NULL,NULL,NULL,NULL,'7A8',7),(129,NULL,NULL,NULL,NULL,'7A9',7),(130,NULL,NULL,NULL,NULL,'7A10',7),(131,NULL,NULL,NULL,NULL,'7A11',7),(132,NULL,NULL,NULL,NULL,'7A12',7),(133,NULL,NULL,NULL,NULL,'7A13',7),(134,NULL,NULL,NULL,NULL,'7A14',7),(135,NULL,NULL,NULL,NULL,'7A15',7),(136,NULL,NULL,NULL,NULL,'7A16',7),(137,NULL,NULL,NULL,NULL,'7A17',7),(138,NULL,NULL,NULL,NULL,'7A18',7),(139,NULL,NULL,NULL,NULL,'7A19',7),(140,NULL,NULL,NULL,NULL,'7A20',7),(141,NULL,NULL,NULL,NULL,'8A1',8),(142,NULL,NULL,NULL,NULL,'8A2',8),(143,NULL,NULL,NULL,NULL,'8A3',8),(144,NULL,NULL,NULL,NULL,'8A4',8),(145,NULL,NULL,NULL,NULL,'8A5',8),(146,NULL,NULL,NULL,NULL,'8A6',8),(147,NULL,NULL,NULL,NULL,'8A7',8),(148,NULL,NULL,NULL,NULL,'8A8',8),(149,NULL,NULL,NULL,NULL,'8A9',8),(150,NULL,NULL,NULL,NULL,'8A10',8),(151,NULL,NULL,NULL,NULL,'8A11',8),(152,NULL,NULL,NULL,NULL,'8A12',8),(153,NULL,NULL,NULL,NULL,'8A13',8),(154,NULL,NULL,NULL,NULL,'8A14',8),(155,NULL,NULL,NULL,NULL,'8A15',8),(156,NULL,NULL,NULL,NULL,'8A16',8),(157,NULL,NULL,NULL,NULL,'8A17',8),(158,NULL,NULL,NULL,NULL,'8A18',8),(159,NULL,NULL,NULL,NULL,'8A19',8),(160,NULL,NULL,NULL,NULL,'8A20',8),(161,NULL,NULL,NULL,NULL,'9A1',9),(162,NULL,NULL,NULL,NULL,'9A2',9),(163,NULL,NULL,NULL,NULL,'9A3',9),(164,NULL,NULL,NULL,NULL,'9A4',9),(165,NULL,NULL,NULL,NULL,'9A5',9),(166,NULL,NULL,NULL,NULL,'9A6',9),(167,NULL,NULL,NULL,NULL,'9A7',9),(168,NULL,NULL,NULL,NULL,'9A8',9),(169,NULL,NULL,NULL,NULL,'9A9',9),(170,NULL,NULL,NULL,NULL,'9A10',9),(171,NULL,NULL,NULL,NULL,'9A11',9),(172,NULL,NULL,NULL,NULL,'9A12',9),(173,NULL,NULL,NULL,NULL,'9A13',9),(174,NULL,NULL,NULL,NULL,'9A14',9),(175,NULL,NULL,NULL,NULL,'9A15',9),(176,NULL,NULL,NULL,NULL,'9A16',9),(177,NULL,NULL,NULL,NULL,'9A17',9),(178,NULL,NULL,NULL,NULL,'9A18',9),(179,NULL,NULL,NULL,NULL,'9A19',9),(180,NULL,NULL,NULL,NULL,'9A20',9),(181,NULL,NULL,NULL,NULL,'10A1',10),(182,NULL,NULL,NULL,NULL,'10A2',10),(183,NULL,NULL,NULL,NULL,'10A3',10),(184,NULL,NULL,NULL,NULL,'10A4',10),(185,NULL,NULL,NULL,NULL,'10A5',10),(186,NULL,NULL,NULL,NULL,'10A6',10),(187,NULL,NULL,NULL,NULL,'10A7',10),(188,NULL,NULL,NULL,NULL,'10A8',10),(189,NULL,NULL,NULL,NULL,'10A9',10),(190,NULL,NULL,NULL,NULL,'10A10',10),(191,NULL,NULL,NULL,NULL,'10A11',10),(192,NULL,NULL,NULL,NULL,'10A12',10),(193,NULL,NULL,NULL,NULL,'10A13',10),(194,NULL,NULL,NULL,NULL,'10A14',10),(195,NULL,NULL,NULL,NULL,'10A15',10),(196,NULL,NULL,NULL,NULL,'10A16',10),(197,NULL,NULL,NULL,NULL,'10A17',10),(198,NULL,NULL,NULL,NULL,'10A18',10),(199,NULL,NULL,NULL,NULL,'10A19',10),(200,NULL,NULL,NULL,NULL,'10A20',10);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessionr`
--

DROP TABLE IF EXISTS `sessionr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sessionr` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `depart_date` varchar(255) DEFAULT NULL,
  `route_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4916wxpcrkevowpgk7jkb1ees` (`route_id`),
  CONSTRAINT `FK4916wxpcrkevowpgk7jkb1ees` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessionr`
--

LOCK TABLES `sessionr` WRITE;
/*!40000 ALTER TABLE `sessionr` DISABLE KEYS */;
INSERT INTO `sessionr` VALUES (1,NULL,NULL,NULL,NULL,'19/12/2020',1),(2,NULL,NULL,NULL,NULL,'20/12/2020',2),(3,NULL,NULL,NULL,NULL,'21/12/2020',3),(4,NULL,NULL,NULL,NULL,'22/12/2020',4),(5,NULL,NULL,NULL,NULL,'23/12/2020',5),(6,NULL,NULL,NULL,NULL,'24/12/2020',6),(7,NULL,NULL,NULL,NULL,'25/12/2020',7),(8,NULL,NULL,NULL,NULL,'26/12/2020',8),(9,NULL,NULL,NULL,NULL,'27/12/2020',9),(10,NULL,NULL,NULL,NULL,'28/12/2020',10);
/*!40000 ALTER TABLE `sessionr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `bill_id` bigint DEFAULT NULL,
  `seat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf9rrxu78kmw44u3xfarqpaa2r` (`bill_id`),
  KEY `FKqahao9a85drt47ikjp0b8syvh` (`seat_id`),
  CONSTRAINT `FKf9rrxu78kmw44u3xfarqpaa2r` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`),
  CONSTRAINT `FKqahao9a85drt47ikjp0b8syvh` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (17,'10','2020-12-12 21:48:55','10','2020-12-12 21:48:55','Active',16,9),(18,'10','2020-12-12 21:48:55','10','2020-12-12 21:48:55','Active',16,10),(21,'10','2020-12-12 22:03:20','10','2020-12-12 22:03:20','Active',20,11),(22,'10','2020-12-12 22:03:20','10','2020-12-12 22:03:20','Active',20,12),(38,'4','2020-12-14 13:10:50','4','2020-12-14 13:10:50','Active',37,19),(41,'4','2020-12-14 13:11:24','4','2020-12-14 13:11:24','Active',40,20);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enable` bit(1) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,NULL,'2020-12-10 00:12:52',NULL,'2020-12-10 00:12:52',NULL,NULL,'thangpx@hcmute.edu.vn',_binary '','Thắng Phạm',NULL,'123456',NULL,'thangpx'),(10,'4','2020-12-12 19:34:58','10','2020-12-12 21:34:26','01 Vo Van Ngan',NULL,'htthaibao@gmail.com',_binary '','Thai bao',NULL,'123456','0328824053','thaibao');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (4,1),(4,2),(4,3),(10,3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'booking'
--
/*!50003 DROP PROCEDURE IF EXISTS `getAllInforCarChosen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllInforCarChosen`(in startingPoint varchar(255),in Destination varchar(255),in departDate varchar(255))
BEGIN
select sessionr.id as session_id, route_cars.route_id, route.price,route.time_starting,route.time_expecting,route_cars.car_id,count(seat.id) 
from seat, route, route_cars,sessionr  
where sessionr.depart_date=departDate and route_cars.route_id=route.id and seat.car_id=route_cars.car_id and route.starting_point=startingPoint and route.destination=Destination and seat.id not in (select ticket.seat_id from ticket)
group by route_cars.car_id,sessionr.id,route_cars.route_id;
 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSeatsWithChosenCar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSeatsWithChosenCar`(in carId long)
select seat.id, seat.name
from seat
where seat.car_id=carId and seat.id not in (select seat_id from ticket) ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-16  0:15:37
