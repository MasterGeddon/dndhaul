CREATE DATABASE  IF NOT EXISTS `gruppe13` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `gruppe13`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gruppe13
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `abilityscores`
--

DROP TABLE IF EXISTS `abilityscores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abilityscores` (
  `absc_id` int(11) NOT NULL AUTO_INCREMENT,
  `absc_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`absc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abilityscores`
--

LOCK TABLES `abilityscores` WRITE;
/*!40000 ALTER TABLE `abilityscores` DISABLE KEYS */;
INSERT INTO `abilityscores` VALUES (1,'Strength'),(2,'Dexterity'),(3,'Constitution'),(4,'Intelligence'),(5,'Wisdom'),(6,'Charisma');
/*!40000 ALTER TABLE `abilityscores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accessrights`
--

DROP TABLE IF EXISTS `accessrights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accessrights` (
  `aces_id` int(11) NOT NULL,
  `aces_description` varchar(255) DEFAULT NULL,
  `aces_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aces_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessrights`
--

LOCK TABLES `accessrights` WRITE;
/*!40000 ALTER TABLE `accessrights` DISABLE KEYS */;
INSERT INTO `accessrights` VALUES (25,'Read Only','READ'),(666,'Read and Write','WRITE'),(999,'Read Write and Delete','DELETE'),(42069,'Admin rechte','ADMIN');
/*!40000 ALTER TABLE `accessrights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `armor`
--

DROP TABLE IF EXISTS `armor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `armor` (
  `armo_id` int(11) NOT NULL AUTO_INCREMENT,
  `armo_typ` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`armo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armor`
--

LOCK TABLES `armor` WRITE;
/*!40000 ALTER TABLE `armor` DISABLE KEYS */;
INSERT INTO `armor` VALUES (1,'Light Armor'),(2,'Medium Armor'),(3,'Heavy Armor'),(4,'Shield'),(9,'All'),(10,'None');
/*!40000 ALTER TABLE `armor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classe` (
  `clas_id` int(11) NOT NULL AUTO_INCREMENT,
  `clas_ability_strong` varchar(255) DEFAULT NULL,
  `clas_description` varchar(255) DEFAULT NULL,
  `clas_hitDie` int(11) NOT NULL,
  `clas_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`clas_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe`
--

LOCK TABLES `classe` WRITE;
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
INSERT INTO `classe` VALUES (1,'Strength','A fierce warrior of primitive background',12,'Babarian'),(2,'Charisma','An inspiring magician whose power',8,'Bard'),(3,'Wisdom','A priestly champion who wields divine',8,'Cleric'),(4,'Wisdom','A priest of the Old Faith, wielding the',8,'Druid'),(5,'Strength or Dexterity','A master of martial combat, skilled with',10,'Fighter'),(6,'Dexterity & Wisdom','An master of martial arts, harnessing',8,'Monk'),(7,'Strength & Charisma','A holy warrior bound to a sacred oath',10,'Paladin'),(8,'Dexterity & Wisdom','A warrior who uses martial prowess and',10,'Ranger'),(9,'Dexterity','A scoundrel who uses stealth and',8,'Rouge'),(10,'Charisma','A spellcaster who draws on inherent',6,'Sorcer'),(11,'Charisma','A wielder of magic that is derived from',8,'Warlock'),(12,'Intelligence','A scholarly magic-user capable of',6,'Wizard'),(9999,'Empty','Empty',0,'Empty');
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe_abilityscores`
--

DROP TABLE IF EXISTS `classe_abilityscores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classe_abilityscores` (
  `sato_clas_id` int(11) NOT NULL,
  `sato_absc_id` int(11) NOT NULL,
  PRIMARY KEY (`sato_clas_id`,`sato_absc_id`),
  KEY `FKtn7377ggwry52ywj7stunmk32` (`sato_absc_id`),
  CONSTRAINT `FK5ucsafwfnhj7np1n789hdk80y` FOREIGN KEY (`sato_clas_id`) REFERENCES `classe` (`clas_id`),
  CONSTRAINT `FKtn7377ggwry52ywj7stunmk32` FOREIGN KEY (`sato_absc_id`) REFERENCES `abilityscores` (`absc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_abilityscores`
--

LOCK TABLES `classe_abilityscores` WRITE;
/*!40000 ALTER TABLE `classe_abilityscores` DISABLE KEYS */;
INSERT INTO `classe_abilityscores` VALUES (1,1),(5,1),(6,1),(8,1),(2,2),(6,2),(8,2),(9,2),(1,3),(5,3),(10,3),(4,4),(9,4),(12,4),(3,5),(4,5),(7,5),(11,5),(12,5),(2,6),(3,6),(7,6),(10,6),(11,6);
/*!40000 ALTER TABLE `classe_abilityscores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe_armor`
--

DROP TABLE IF EXISTS `classe_armor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classe_armor` (
  `artc_clas_id` int(11) NOT NULL,
  `artc_armo_id` int(11) NOT NULL,
  PRIMARY KEY (`artc_clas_id`,`artc_armo_id`),
  KEY `FKsd75kds42mes0bd2janwg49p2` (`artc_armo_id`),
  CONSTRAINT `FK66eq4ilf9arqpuudb94k5tls6` FOREIGN KEY (`artc_clas_id`) REFERENCES `classe` (`clas_id`),
  CONSTRAINT `FKsd75kds42mes0bd2janwg49p2` FOREIGN KEY (`artc_armo_id`) REFERENCES `armor` (`armo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_armor`
--

LOCK TABLES `classe_armor` WRITE;
/*!40000 ALTER TABLE `classe_armor` DISABLE KEYS */;
INSERT INTO `classe_armor` VALUES (1,1),(2,1),(3,1),(4,1),(8,1),(9,1),(11,1),(1,2),(3,2),(4,2),(8,2),(1,4),(3,4),(4,4),(8,4),(5,9),(7,9),(6,10),(10,10),(12,10);
/*!40000 ALTER TABLE `classe_armor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe_weapon`
--

DROP TABLE IF EXISTS `classe_weapon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classe_weapon` (
  `wetc_clas_id` int(11) NOT NULL,
  `wetc_weap_id` int(11) NOT NULL,
  PRIMARY KEY (`wetc_clas_id`,`wetc_weap_id`),
  KEY `FK8o7nwny801spjw7n2qua71pis` (`wetc_weap_id`),
  CONSTRAINT `FK8o7nwny801spjw7n2qua71pis` FOREIGN KEY (`wetc_weap_id`) REFERENCES `weapon` (`weap_id`),
  CONSTRAINT `FKaaxrvds82ssislb1hn09b9lci` FOREIGN KEY (`wetc_clas_id`) REFERENCES `classe` (`clas_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_weapon`
--

LOCK TABLES `classe_weapon` WRITE;
/*!40000 ALTER TABLE `classe_weapon` DISABLE KEYS */;
INSERT INTO `classe_weapon` VALUES (2,1),(3,1),(4,1),(6,1),(9,1),(10,1),(11,1),(12,1),(2,2),(3,2),(6,2),(9,2),(10,2),(11,2),(12,2),(2,3),(6,3),(9,3),(1,9),(5,9),(7,9),(8,9);
/*!40000 ALTER TABLE `classe_weapon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1),(1),(1),(1),(1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playercharacter`
--

DROP TABLE IF EXISTS `playercharacter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playercharacter` (
  `char_id` int(11) NOT NULL AUTO_INCREMENT,
  `char_name` varchar(255) DEFAULT NULL,
  `char_clas_id` int(11) NOT NULL,
  `char_rasu_id` int(11) NOT NULL,
  `char_backstory` varchar(255) DEFAULT NULL,
  `char_cha` int(11) NOT NULL,
  `char_con` int(11) NOT NULL,
  `char_dex` int(11) NOT NULL,
  `char_int` int(11) NOT NULL,
  `char_str` int(11) NOT NULL,
  `char_wis` int(11) NOT NULL,
  `char_user_id` int(11) NOT NULL,
  PRIMARY KEY (`char_id`),
  KEY `FKrh0xcbrvd9jy8pib1of5usr43` (`char_clas_id`),
  KEY `FKovn7e39yms54p8y32umucl4jn` (`char_rasu_id`),
  KEY `FKamxyi161scx39uldotc13slt7` (`char_user_id`),
  CONSTRAINT `FKamxyi161scx39uldotc13slt7` FOREIGN KEY (`char_user_id`) REFERENCES `usercon` (`user_id`),
  CONSTRAINT `FKovn7e39yms54p8y32umucl4jn` FOREIGN KEY (`char_rasu_id`) REFERENCES `rassesub` (`rasu_id`),
  CONSTRAINT `FKrh0xcbrvd9jy8pib1of5usr43` FOREIGN KEY (`char_clas_id`) REFERENCES `classe` (`clas_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playercharacter`
--

LOCK TABLES `playercharacter` WRITE;
/*!40000 ALTER TABLE `playercharacter` DISABLE KEYS */;
INSERT INTO `playercharacter` VALUES (17,'Bernhard',9999,9999,'Pressslufthammmmer da be',17,17,5,10,10,8,6),(18,'Gregorio',9999,9999,'SuperDuper gregor',7,17,14,10,20,20,6),(19,'Bernhard',9999,9999,'Pressslufthammmmer da be',18,14,5,8,3,9,6),(20,'Gregorio',9999,9999,'SuperDuper gregor',13,14,1,5,11,10,6),(21,'Bernhard',9999,9999,'Pressslufthammmmer da be',6,15,5,11,8,1,6),(22,'Gregorio',9999,9999,'SuperDuper gregor',9,20,12,15,7,5,6);
/*!40000 ALTER TABLE `playercharacter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rasse`
--

DROP TABLE IF EXISTS `rasse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rasse` (
  `rasse_id` int(11) NOT NULL AUTO_INCREMENT,
  `rasse_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rasse_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rasse`
--

LOCK TABLES `rasse` WRITE;
/*!40000 ALTER TABLE `rasse` DISABLE KEYS */;
INSERT INTO `rasse` VALUES (1,'Dwarf'),(2,'Elf'),(3,'Halfling'),(4,'Human'),(5,'Dragonborn'),(6,'Gnome'),(7,'Half-Elf'),(8,'Half-Orc'),(9,'Tiefling'),(9999,'Empty');
/*!40000 ALTER TABLE `rasse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rasse_to_abilityscore`
--

DROP TABLE IF EXISTS `rasse_to_abilityscore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rasse_to_abilityscore` (
  `rtas_absc_id` int(11) NOT NULL,
  `rtas_rasu_id` int(11) NOT NULL,
  `rtas_improv_anz` int(11) NOT NULL,
  PRIMARY KEY (`rtas_absc_id`,`rtas_rasu_id`),
  KEY `FKdfnxqw96v2xihxo6lckl0srry` (`rtas_rasu_id`),
  CONSTRAINT `FKdfnxqw96v2xihxo6lckl0srry` FOREIGN KEY (`rtas_rasu_id`) REFERENCES `rassesub` (`rasu_id`),
  CONSTRAINT `FKn5kp0d4eidoth9cxpcs3x7mfi` FOREIGN KEY (`rtas_absc_id`) REFERENCES `abilityscores` (`absc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rasse_to_abilityscore`
--

LOCK TABLES `rasse_to_abilityscore` WRITE;
/*!40000 ALTER TABLE `rasse_to_abilityscore` DISABLE KEYS */;
INSERT INTO `rasse_to_abilityscore` VALUES (1,3,2),(1,11,1),(1,12,2),(1,17,2),(2,4,2),(2,8,2),(2,11,1),(2,14,1),(3,1,2),(3,10,1),(3,11,1),(3,15,1),(3,17,1),(4,5,1),(4,11,1),(4,13,2),(4,18,1),(5,2,1),(5,6,1),(5,11,1),(6,7,1),(6,9,1),(6,11,1),(6,12,1),(6,16,2),(6,18,2);
/*!40000 ALTER TABLE `rasse_to_abilityscore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rassesub`
--

DROP TABLE IF EXISTS `rassesub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rassesub` (
  `rasu_id` int(11) NOT NULL AUTO_INCREMENT,
  `rasu_age` int(11) NOT NULL,
  `rasu_name` varchar(255) DEFAULT NULL,
  `rasu_speed` int(11) NOT NULL,
  `rasu_rass_id` int(11) NOT NULL,
  `rasu_size_id` int(11) NOT NULL,
  PRIMARY KEY (`rasu_id`),
  KEY `FKqrkc80vetatf7lxrmc33ygfw` (`rasu_rass_id`),
  KEY `FKtf10vcsnqe4293w1g0o78nlpu` (`rasu_size_id`),
  CONSTRAINT `FKqrkc80vetatf7lxrmc33ygfw` FOREIGN KEY (`rasu_rass_id`) REFERENCES `rasse` (`rasse_id`),
  CONSTRAINT `FKtf10vcsnqe4293w1g0o78nlpu` FOREIGN KEY (`rasu_size_id`) REFERENCES `size` (`size_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rassesub`
--

LOCK TABLES `rassesub` WRITE;
/*!40000 ALTER TABLE `rassesub` DISABLE KEYS */;
INSERT INTO `rassesub` VALUES (1,350,'Classic',25,1,3),(2,400,'Hill',25,1,3),(3,350,'Mountain',25,1,3),(4,750,'Classic',30,2,3),(5,600,'High',30,2,3),(6,700,'Wood',30,2,3),(7,650,'Dark',30,2,3),(8,150,'Classic',25,3,2),(9,150,'Lightfoot',25,3,2),(10,150,'Stout',25,3,2),(11,100,'Classic',30,4,3),(12,80,'Classic',30,5,3),(13,500,'Classic',25,6,2),(14,500,'Forest',25,6,2),(15,600,'Rock',25,6,2),(16,180,'Classic',30,7,3),(17,75,'Classic',30,8,3),(18,110,'Classic',30,9,3),(9999,0,'Empty',0,9999,9999);
/*!40000 ALTER TABLE `rassesub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `size` (
  `size_id` int(11) NOT NULL AUTO_INCREMENT,
  `size_typ` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`size_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES (1,'Tiny'),(2,'Small'),(3,'Medium'),(4,'Large'),(5,'Huge'),(6,'Gargantuan'),(9999,'Empty');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usercon`
--

DROP TABLE IF EXISTS `usercon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usercon` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_max_char` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_pw` varchar(255) NOT NULL,
  `user_aces_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK5cwujxemodvm00tah1e3j9kn2` (`user_aces_id`),
  CONSTRAINT `FK5cwujxemodvm00tah1e3j9kn2` FOREIGN KEY (`user_aces_id`) REFERENCES `accessrights` (`aces_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercon`
--

LOCK TABLES `usercon` WRITE;
/*!40000 ALTER TABLE `usercon` DISABLE KEYS */;
INSERT INTO `usercon` VALUES (3,69420,'admin','admin',42069),(4,10,'admin2','B@b0fd744',42069),(5,10,'SuperUser','B@7d986d83',666),(6,10,'adminUser','Md8wGs39b6kTmQW2uWIqCg==',42069);
/*!40000 ALTER TABLE `usercon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weapon`
--

DROP TABLE IF EXISTS `weapon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weapon` (
  `weap_id` int(11) NOT NULL AUTO_INCREMENT,
  `weap_typ` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`weap_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weapon`
--

LOCK TABLES `weapon` WRITE;
/*!40000 ALTER TABLE `weapon` DISABLE KEYS */;
INSERT INTO `weapon` VALUES (1,'Simple Melee Weapon'),(2,'Simple Ranged Weapon'),(3,'Martial Melee Weapon'),(4,'Martial Ranged Weapon'),(9,'All'),(10,'None');
/*!40000 ALTER TABLE `weapon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-12 18:08:16
