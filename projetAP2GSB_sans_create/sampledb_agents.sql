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
-- Table structure for table `agents`
--

DROP TABLE IF EXISTS `agents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agents` (
  `ag_MATRICULE` int NOT NULL AUTO_INCREMENT,
  `ag_login` varchar(45) NOT NULL,
  `ag_password` varchar(128) NOT NULL,
  `ag_nom` varchar(45) NOT NULL,
  `ag_prenom` varchar(45) NOT NULL,
  `se_fk` int DEFAULT NULL,
  `ta_fk` int NOT NULL,
  PRIMARY KEY (`ag_MATRICULE`),
  KEY `fk_AGENTS_1_idx` (`se_fk`),
  KEY `fk_AGENTS_2_idx` (`ta_fk`),
  KEY `ag_nom` (`ag_nom`),
  KEY `ag_prenom` (`ag_prenom`),
  CONSTRAINT `fk_AGENTS_1` FOREIGN KEY (`se_fk`) REFERENCES `secteur` (`se_id`),
  CONSTRAINT `fk_AGENTS_2` FOREIGN KEY (`ta_fk`) REFERENCES `type_agent` (`ta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agents`
--

LOCK TABLES `agents` WRITE;
/*!40000 ALTER TABLE `agents` DISABLE KEYS */;
INSERT INTO `agents` VALUES (1,'laurent.dupont','lolo','DUPONT','Laurent',1,1),(2,'alain.renault','al','RENAULT','Alain',8,1),(3,'louise.martin','lou','MARTIN','Louise',5,1),(4,'jean.petit','jeanjean','PETIT','Jean',1,2),(5,'charlotte.dubois','charlotte','DUBOIS','Charlotte',8,2),(6,'elise.leroy','king','LEROY','Elise',5,2),(7,'axel.durand','axel','DURAND','Axel',3,1),(8,'pierre.richard','rich','RICHARD','Pierre',4,2),(9,'ines.denis','den','DENIS','Ines',7,1),(10,'eric.dumez','dumdum','DUMEZ','Eric',1,2);
/*!40000 ALTER TABLE `agents` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-17 14:55:26
