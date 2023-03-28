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
-- Table structure for table `autresfrais`
--

DROP TABLE IF EXISTS `autresfrais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autresfrais` (
  `id_autresfrais` int NOT NULL AUTO_INCREMENT,
  `fk_fiche` int DEFAULT NULL,
  `af_date` varchar(45) DEFAULT NULL,
  `af_libellé` varchar(45) DEFAULT NULL,
  `af_montant` int DEFAULT NULL,
  `date_ajout` varchar(45) DEFAULT NULL,
  `fk_eaf` int DEFAULT NULL,
  PRIMARY KEY (`id_autresfrais`),
  KEY `fk_EAF_idx` (`fk_eaf`),
  KEY `fk_FICHE_idx` (`fk_fiche`),
  CONSTRAINT `fk_EAF` FOREIGN KEY (`fk_eaf`) REFERENCES `etat_af` (`id_eaf`),
  CONSTRAINT `fk_FICHE` FOREIGN KEY (`fk_fiche`) REFERENCES `fiche` (`id_fiche`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autresfrais`
--

LOCK TABLES `autresfrais` WRITE;
/*!40000 ALTER TABLE `autresfrais` DISABLE KEYS */;
INSERT INTO `autresfrais` VALUES (61,66,'2022/03/10','Repas patron',24,'2022/04',1),(62,66,'2022/03/31','Encas station service',25,'2022/04',1),(63,66,'2022/03/30','Parc d\'attraction',26,'2022/04',2),(64,6,'2022/03/11','Motif valable',120,'2022/04',0),(65,6,'2022/03/18','Motif non valable ',710,'2022/04',0),(66,6,'2022/03/21','Motif valable',45,'2022/04',0),(73,16,'2022/04/12','valable',150,'2022/04',2),(74,16,'2022/04/14','pas valable',2000,'2022/04',1),(75,16,'2022/04/24','valable',800,'2022/04',2),(76,77,'2022/04/01','valable',120,'2022/05',2),(77,77,'2022/04/12','valable',250,'2022/05',2),(78,77,'2022/04/22','pas valable',3000,'2022/05',2),(79,78,'2022/04/01','valable',300,'2022/05',1),(80,78,'2022/04/12','pas valable',2500,'2022/05',1),(81,78,'2022/04/27','valable',50,'2022/05',1),(82,79,'2022/04/02','pas valable',250,'2022/05',1),(83,79,'2022/04/18','valable',290,'2022/05',1),(84,79,'2022/04/22','pas valable',1300,'2022/05',1),(85,80,'2022/04/12','valabel',120,'2022/05',1),(86,80,'2022/04/14','valable',1770,'2022/05',1),(87,80,'2022/04/29','pas valable',30,'2022/05',2),(88,77,'2022/05/06','paris',150,'2022/05',0),(89,77,'toto','paris',150,'2022/05',0),(90,77,'toto','paris',150,'2022/05',0);
/*!40000 ALTER TABLE `autresfrais` ENABLE KEYS */;
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
