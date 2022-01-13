-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: polargame
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
-- Table structure for table `games_genres`
--

DROP TABLE IF EXISTS `games_genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games_genres` (
  `id_games_genres` int NOT NULL AUTO_INCREMENT,
  `id_game` int NOT NULL,
  `id_genre` int NOT NULL,
  PRIMARY KEY (`id_games_genres`),
  KEY `id_game` (`id_game`),
  KEY `id_genre` (`id_genre`),
  CONSTRAINT `games_genres_ibfk_1` FOREIGN KEY (`id_game`) REFERENCES `game` (`id_game`) ON DELETE CASCADE,
  CONSTRAINT `games_genres_ibfk_2` FOREIGN KEY (`id_genre`) REFERENCES `genres` (`id_genre`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games_genres`
--

LOCK TABLES `games_genres` WRITE;
/*!40000 ALTER TABLE `games_genres` DISABLE KEYS */;
INSERT INTO `games_genres` VALUES (1,1,1),(2,2,2),(3,3,3),(4,3,2),(5,4,4),(6,5,5),(7,5,2),(8,6,6),(9,6,7),(10,7,8),(11,8,8),(12,9,3),(13,9,5),(14,10,9),(15,11,2),(16,12,10),(17,12,11),(18,13,2),(19,14,2),(20,15,5),(21,15,9),(22,16,10),(23,16,11),(24,17,2),(25,17,3),(26,18,1),(27,19,6),(28,19,7),(29,20,5),(30,20,9),(31,21,2),(32,21,10),(33,21,11),(34,22,2),(35,22,10),(36,22,11),(37,23,2),(38,24,10),(39,24,12),(40,24,13),(41,24,14),(42,25,4),(43,25,9),(44,26,2),(45,26,10),(46,26,11),(47,27,2),(48,28,2),(49,29,10),(50,29,11),(51,29,15);
/*!40000 ALTER TABLE `games_genres` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-13 19:16:15
