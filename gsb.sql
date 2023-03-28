CREATE TABLE `secteur` (
  `se_id` int NOT NULL,
  `se_libelle` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`se_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `type_agent` (
  `ta_id` int NOT NULL,
  `ta_libelle` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
  CONSTRAINT `fk_AGENTS_1` FOREIGN KEY (`se_fk`) REFERENCES `secteur` (`se_id`),
  CONSTRAINT `fk_AGENTS_2` FOREIGN KEY (`ta_fk`) REFERENCES `type_agent` (`ta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SELECT * from agents;
INSERT INTO `agents` VALUES (1,'laurent.dupont','lolo','DUPONT','Laurent',1,1),(2,'alain.renault','al','RENAULT','Alain',8,1),(3,'louise.martin','lou','MARTIN','Louise',5,1),(4,'jean.petit','jeanjean','PETIT','Jean',1,2),(5,'charlotte.dubois','charlotte','DUBOIS','Charlotte',8,2),(6,'elise.leroy','king','LEROY','Elise',5,2);

INSERT INTO `secteur` VALUES (1,'Hauts-de-France'),(2,'Ile-de-France'),(3,'Grand Est'),(4,'Centre-Val de Loire'),(5,'Bretagne'),(6,'Auvergne-Rhône-Alpes'),(7,'Bourgogne-Franche-Comté'),(8,'Corse'),(9,'Normandie'),(10,'Nouvelle-Aquitaine'),(11,'Occitanie'),(12,'Pays de la Loire'),(13,'Provence-Alpes-Côte d’Azur');

INSERT INTO `type_agent` VALUES (1,'visiteur'),(2,'comptable');

