CREATE DATABASE  IF NOT EXISTS `sampledb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sampledb`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sampledb
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `fiche`
--

DROP TABLE IF EXISTS `fiche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fiche` (
  `id_fiche` int NOT NULL AUTO_INCREMENT,
  `fk_matricule` int DEFAULT NULL,
  `qu_nuitee` int DEFAULT NULL,
  `qu_repas` int DEFAULT NULL,
  `qu_km` int DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `fk_etat` int DEFAULT NULL,
  PRIMARY KEY (`id_fiche`),
  KEY `fk_MATRICULE_idx` (`fk_matricule`),
  KEY `fk_ETAT_idx` (`fk_etat`),
  CONSTRAINT `fk_ETAT` FOREIGN KEY (`fk_etat`) REFERENCES `etat` (`id`),
  CONSTRAINT `fk_MATRICULE` FOREIGN KEY (`fk_matricule`) REFERENCES `agents` (`ag_MATRICULE`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fiche`
--

LOCK TABLES `fiche` WRITE;
/*!40000 ALTER TABLE `fiche` DISABLE KEYS */;
INSERT INTO `fiche` VALUES (1,1,12,21,480,'2022/01',0),(2,1,13,6,800,'2022/02',0),(4,2,15,5,800,'2022/01',0),(5,2,18,14,900,'2022/02',0),(6,2,14,15,16,'2022/04',1),(16,3,60,90,1300,'2022/04',0),(66,1,1,2,3,'2022/04',2),(77,1,15,15,15,'2022/05',2),(78,2,15,18,350,'2022/05',2),(79,3,13,22,800,'2022/05',2),(80,9,15,23,1900,'2022/05',2);
/*!40000 ALTER TABLE `fiche` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-17 14:55:10
