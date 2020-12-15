CREATE DATABASE  IF NOT EXISTS `db_colegio_2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_colegio_2`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: db_colegio_2
-- ------------------------------------------------------
-- Server version	5.7.26

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
-- Table structure for table `tbl_alumno`
--

DROP TABLE IF EXISTS `tbl_alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_alumno` (
  `id_alumno` int(11) NOT NULL AUTO_INCREMENT,
  `cod_alumno` varchar(10) DEFAULT NULL,
  `nombres_alumno` varchar(45) DEFAULT NULL,
  `apellidos_alumno` varchar(45) DEFAULT NULL,
  `grado` varchar(45) DEFAULT NULL,
  `seccion` varchar(45) DEFAULT NULL,
  `primsec` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_alumno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_alumno`
--

LOCK TABLES `tbl_alumno` WRITE;
/*!40000 ALTER TABLE `tbl_alumno` DISABLE KEYS */;
INSERT INTO `tbl_alumno` VALUES (2,'A155863','Diego Junior','Lopez Ramos','1','B','Primaria'),(3,'A358333','Carolina Angie','Altamirano Escobar','1','A','Secundaria'),(4,'A758015','Juan Jose','Jimenez James','1','A','Secundaria'),(5,'A718812','Rubi','Gomez','1','B','Primaria');
/*!40000 ALTER TABLE `tbl_alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_alumno_notas`
--

DROP TABLE IF EXISTS `tbl_alumno_notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_alumno_notas` (
  `id_alumno_notas` int(11) NOT NULL AUTO_INCREMENT,
  `cod_alumno` varchar(10) DEFAULT NULL,
  `id_curso` int(11) DEFAULT NULL,
  `nota1` int(11) DEFAULT NULL,
  `nota2` int(11) DEFAULT NULL,
  `nota3` int(11) DEFAULT NULL,
  `nota4` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_alumno_notas`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_alumno_notas`
--

LOCK TABLES `tbl_alumno_notas` WRITE;
/*!40000 ALTER TABLE `tbl_alumno_notas` DISABLE KEYS */;
INSERT INTO `tbl_alumno_notas` VALUES (1,'A758015',1,16,17,18,13),(2,'A758015',5,14,13,10,19);
/*!40000 ALTER TABLE `tbl_alumno_notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_curso`
--

DROP TABLE IF EXISTS `tbl_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_curso` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `curso` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_curso`
--

LOCK TABLES `tbl_curso` WRITE;
/*!40000 ALTER TABLE `tbl_curso` DISABLE KEYS */;
INSERT INTO `tbl_curso` VALUES (1,'Matemáticas'),(2,'Comunicación 2'),(3,'Ingles 2'),(4,'Educación Física'),(5,'Arte'),(8,'Religión');
/*!40000 ALTER TABLE `tbl_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_curso_grado_detalle`
--

DROP TABLE IF EXISTS `tbl_curso_grado_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_curso_grado_detalle` (
  `id_curso_grado_detalle` int(11) NOT NULL AUTO_INCREMENT,
  `id_curso_profesor` int(11) DEFAULT NULL,
  `id_grado_seccion` int(11) DEFAULT NULL,
  `horario_inicio` time DEFAULT NULL,
  `horario_fin` time DEFAULT NULL,
  PRIMARY KEY (`id_curso_grado_detalle`),
  KEY `id_curso_profesor_idx` (`id_curso_profesor`),
  KEY `id_grado_seccion_idx` (`id_grado_seccion`),
  CONSTRAINT `id_curso_profesor` FOREIGN KEY (`id_curso_profesor`) REFERENCES `tbl_curso_profesor` (`id_curso_profesor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_grado_seccion` FOREIGN KEY (`id_grado_seccion`) REFERENCES `tbl_grado_seccion` (`id_grado_seccion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_curso_grado_detalle`
--

LOCK TABLES `tbl_curso_grado_detalle` WRITE;
/*!40000 ALTER TABLE `tbl_curso_grado_detalle` DISABLE KEYS */;
INSERT INTO `tbl_curso_grado_detalle` VALUES (1,1,2,'09:00:00','10:00:00'),(2,2,19,'10:00:00','11:30:00'),(3,3,19,'11:30:00','12:45:00'),(4,5,2,'12:45:00','13:40:00'),(5,4,2,'13:40:00','14:25:00'),(6,5,19,'08:36:00','09:05:00'),(7,3,2,'14:25:00','15:00:00'),(8,1,19,'14:00:00','17:00:00');
/*!40000 ALTER TABLE `tbl_curso_grado_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_curso_profesor`
--

DROP TABLE IF EXISTS `tbl_curso_profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_curso_profesor` (
  `id_curso_profesor` int(11) NOT NULL AUTO_INCREMENT,
  `id_curso` int(11) DEFAULT NULL,
  `id_profesor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_curso_profesor`),
  KEY `id_curso_idx` (`id_curso`),
  KEY `id_profesor_idx` (`id_profesor`),
  CONSTRAINT `id_curso` FOREIGN KEY (`id_curso`) REFERENCES `tbl_curso` (`id_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_profesor` FOREIGN KEY (`id_profesor`) REFERENCES `tbl_profesor` (`id_profesor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_curso_profesor`
--

LOCK TABLES `tbl_curso_profesor` WRITE;
/*!40000 ALTER TABLE `tbl_curso_profesor` DISABLE KEYS */;
INSERT INTO `tbl_curso_profesor` VALUES (1,1,2),(2,4,3),(3,3,1),(4,2,5),(5,5,4);
/*!40000 ALTER TABLE `tbl_curso_profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_grado_seccion`
--

DROP TABLE IF EXISTS `tbl_grado_seccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_grado_seccion` (
  `id_grado_seccion` int(11) NOT NULL AUTO_INCREMENT,
  `grado` varchar(45) DEFAULT NULL,
  `seccion` varchar(45) DEFAULT NULL,
  `primsec` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_grado_seccion`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_grado_seccion`
--

LOCK TABLES `tbl_grado_seccion` WRITE;
/*!40000 ALTER TABLE `tbl_grado_seccion` DISABLE KEYS */;
INSERT INTO `tbl_grado_seccion` VALUES (1,'1','A','Primaria'),(2,'1','B','Primaria'),(3,'1','C','Primaria'),(4,'2','A','Primaria'),(5,'2','B','Primaria'),(6,'2','C','Primaria'),(7,'3','A','Primaria'),(8,'3','B','Primaria'),(9,'3','C','Primaria'),(10,'4','A','Primaria'),(11,'4','B','Primaria'),(12,'4','C','Primaria'),(13,'5','A','Primaria'),(14,'5','B','Primaria'),(15,'5','C','Primaria'),(16,'6','A','Primaria'),(17,'6','B','Primaria'),(18,'6','C','Primaria'),(19,'1','A','Secundaria'),(20,'1','B','Secundaria'),(21,'1','C','Secundaria'),(22,'2','A','Secundaria'),(23,'2','B','Secundaria'),(24,'2','C','Secundaria'),(25,'3','A','Secundaria'),(26,'3','B','Secundaria'),(27,'3','C','Secundaria'),(28,'4','A','Secundaria'),(29,'4','B','Secundaria'),(30,'4','C','Secundaria'),(31,'5','A','Secundaria'),(32,'5','B','Secundaria'),(33,'5','C','Secundaria');
/*!40000 ALTER TABLE `tbl_grado_seccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_habilitar_mensualidad`
--

DROP TABLE IF EXISTS `tbl_habilitar_mensualidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_habilitar_mensualidad` (
  `id_hab_mensualidad` int(11) NOT NULL AUTO_INCREMENT,
  `cod_mensualidad` varchar(10) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `vencimiento` date DEFAULT NULL,
  `codigo_reinscripcion` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_hab_mensualidad`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_habilitar_mensualidad`
--

LOCK TABLES `tbl_habilitar_mensualidad` WRITE;
/*!40000 ALTER TABLE `tbl_habilitar_mensualidad` DISABLE KEYS */;
INSERT INTO `tbl_habilitar_mensualidad` VALUES (3,'M0003','Mensualidad N° 3',250,'2019-05-15','R0001'),(4,'M0004','Mensualidad N° 4',250,'2019-06-15','R0001'),(5,'M0005','Mensualidad N° 5',250,'2019-07-15','R0001'),(6,'M0006','Mensualidad N° 6',250,'2019-08-15','R0001'),(7,'M0007','Mensualidad N° 7',250,'2019-09-15','R0001'),(8,'M0008','Mensualidad N° 8',250,'2019-10-15','R0001'),(9,'M0009','Mensualidad N° 9',250,'2019-11-15','R0001'),(10,'M0010','Mensualidad N° 10',250,'2019-12-15','R0001'),(11,'M0011','Mensualidad N° 1',450,'2020-03-25','R0002'),(12,'M0012','Mensualidad N° 2',450,'2020-04-25','R0002'),(13,'M0013','Mensualidad N° 3',450,'2020-05-25','R0002'),(14,'M0014','Mensualidad N° 4',450,'2020-06-25','R0002'),(15,'M0015','Mensualidad N° 5',450,'2020-07-25','R0002'),(16,'M0016','Mensualidad N° 6',450,'2020-08-25','R0002'),(17,'M0017','Mensualidad N° 7',450,'2020-09-25','R0002'),(18,'M0018','Mensualidad N° 8',450,'2020-10-25','R0002'),(19,'M0019','Mensualidad N° 9',450,'2020-11-25','R0002'),(20,'M0020','Mensualidad N° 10',450,'2020-12-25','R0002'),(21,'M0021','Mensualidad N° 1',259,'2019-03-25','R0003'),(22,'M0022','Mensualidad N° 2',259,'2019-04-25','R0003'),(23,'M0023','Mensualidad N° 3',259,'2019-05-25','R0003'),(24,'M0024','Mensualidad N° 4',259,'2019-06-25','R0003'),(25,'M0025','Mensualidad N° 5',259,'2019-07-25','R0003'),(26,'M0026','Mensualidad N° 6',259,'2019-08-25','R0003'),(27,'M0027','Mensualidad N° 7',259,'2019-09-25','R0003'),(28,'M0028','Mensualidad N° 8',259,'2019-10-25','R0003'),(29,'M0029','Mensualidad N° 9',259,'2019-11-25','R0003'),(30,'M0030','Mensualidad N° 10',259,'2019-12-25','R0003'),(31,'M0031','Mensualidad N° 1',990,'2019-03-03','R0003'),(32,'M0032','Mensualidad N° 2',990,'2019-04-03','R0003'),(33,'M0033','Mensualidad N° 3',990,'2019-05-03','R0003'),(34,'M0034','Mensualidad N° 4',990,'2019-06-03','R0003'),(35,'M0035','Mensualidad N° 5',990,'2019-07-03','R0003'),(36,'M0036','Mensualidad N° 6',990,'2019-08-03','R0003'),(37,'M0037','Mensualidad N° 7',990,'2019-09-03','R0003'),(38,'M0038','Mensualidad N° 8',990,'2019-10-03','R0003'),(39,'M0039','Mensualidad N° 9',990,'2019-11-03','R0003'),(40,'M0040','Mensualidad N° 10',990,'2019-12-03','R0003'),(41,'M0041','Mensualidad N° 1',990,'2019-03-03','R0003'),(42,'M0042','Mensualidad N° 2',990,'2019-04-03','R0003'),(43,'M0043','Mensualidad N° 3',990,'2019-05-03','R0003'),(44,'M0044','Mensualidad N° 4',990,'2019-06-03','R0003'),(45,'M0045','Mensualidad N° 5',990,'2019-07-03','R0003'),(46,'M0046','Mensualidad N° 6',990,'2019-08-03','R0003'),(47,'M0047','Mensualidad N° 7',990,'2019-09-03','R0003'),(48,'M0048','Mensualidad N° 8',990,'2019-10-03','R0003'),(49,'M0049','Mensualidad N° 9',990,'2019-11-03','R0003'),(50,'M0050','Mensualidad N° 10',990,'2019-12-03','R0003'),(61,'M0061','Mensualidad N° 1',123,'2019-03-09','R0003'),(62,'M0062','Mensualidad N° 2',123,'2019-04-09','R0003'),(63,'M0063','Mensualidad N° 3',123,'2019-05-09','R0003'),(64,'M0064','Mensualidad N° 4',123,'2019-06-09','R0003'),(65,'M0065','Mensualidad N° 5',123,'2019-07-09','R0003'),(66,'M0066','Mensualidad N° 6',123,'2019-08-09','R0003'),(67,'M0067','Mensualidad N° 7',123,'2019-09-09','R0003'),(68,'M0068','Mensualidad N° 8',123,'2019-10-09','R0003'),(69,'M0069','Mensualidad N° 9',123,'2019-11-09','R0003'),(70,'M0070','Mensualidad N° 10',12,'2019-12-02','R0003'),(71,'M0071','Mensualidad N° 1',999,'2019-03-10','R0004'),(72,'M0072','Mensualidad N° 2',999,'2019-04-10','R0004'),(73,'M0073','Mensualidad N° 3',999,'2019-05-10','R0004'),(74,'M0074','Mensualidad N° 4',999,'2019-06-10','R0004'),(75,'M0075','Mensualidad N° 5',999,'2019-07-10','R0004'),(76,'M0076','Mensualidad N° 6',999,'2019-08-10','R0004'),(77,'M0077','Mensualidad N° 7',999,'2019-09-10','R0004'),(78,'M0078','Mensualidad N° 8',999,'2019-10-10','R0004'),(79,'M0079','Mensualidad N° 9',999,'2019-11-10','R0004'),(80,'M0080','Mensualidad N° 10',999,'2019-12-10','R0004'),(81,'M0081','Mensualidad N° 1',3000,'2019-03-08','R0005'),(82,'M0082','Mensualidad N° 2',3000,'2019-04-08','R0005'),(83,'M0083','Mensualidad N° 3',3000,'2019-05-08','R0005'),(84,'M0084','Mensualidad N° 4',3000,'2019-06-08','R0005'),(85,'M0085','Mensualidad N° 5',3000,'2019-07-08','R0005'),(86,'M0086','Mensualidad N° 6',3000,'2019-08-08','R0005'),(87,'M0087','Mensualidad N° 7',3000,'2019-09-08','R0005'),(88,'M0088','Mensualidad N° 8',3000,'2019-10-08','R0005'),(89,'M0089','Mensualidad N° 9',3000,'2019-11-08','R0005'),(90,'M0090','Mensualidad N° 10',3000,'2019-12-08','R0005'),(91,'M0091','Mensualidad N° 1',3000,'2019-03-02','R0006'),(92,'M0092','Mensualidad N° 2',3000,'2019-04-02','R0006'),(93,'M0093','Mensualidad N° 3',3000,'2019-05-02','R0006'),(94,'M0094','Mensualidad N° 4',3000,'2019-06-02','R0006'),(95,'M0095','Mensualidad N° 5',3000,'2019-07-02','R0006'),(96,'M0096','Mensualidad N° 6',3000,'2019-08-02','R0006'),(97,'M0097','Mensualidad N° 7',3000,'2019-09-02','R0006'),(98,'M0098','Mensualidad N° 8',3000,'2019-10-02','R0006'),(99,'M0099','Mensualidad N° 9',3000,'2019-11-02','R0006'),(100,'M0100','Mensualidad N° 10',3000,'2019-12-02','R0006'),(101,'M0101','Mensualidad N° 1',3003,'2019-03-19','R0007'),(102,'M0102','Mensualidad N° 2',3003,'2019-04-19','R0007'),(103,'M0103','Mensualidad N° 3',3003,'2019-05-19','R0007'),(104,'M0104','Mensualidad N° 4',3003,'2019-06-19','R0007'),(105,'M0105','Mensualidad N° 5',3003,'2019-07-19','R0007'),(106,'M0106','Mensualidad N° 6',3003,'2019-08-19','R0007'),(107,'M0107','Mensualidad N° 7',3003,'2019-09-19','R0007'),(108,'M0108','Mensualidad N° 8',3003,'2019-10-19','R0007'),(109,'M0109','Mensualidad N° 9',3003,'2019-11-19','R0007'),(110,'M0110','Mensualidad N° 10',3003,'2019-12-19','R0007'),(111,'M0111','Mensualidad N° 1',1000,'2019-03-12','R0008'),(112,'M0112','Mensualidad N° 2',1000,'2019-04-12','R0008'),(113,'M0113','Mensualidad N° 3',1000,'2019-05-12','R0008'),(114,'M0114','Mensualidad N° 4',1000,'2019-06-12','R0008'),(115,'M0115','Mensualidad N° 5',1000,'2019-07-12','R0008'),(116,'M0116','Mensualidad N° 6',1000,'2019-08-12','R0008'),(117,'M0117','Mensualidad N° 7',1000,'2019-09-12','R0008'),(118,'M0118','Mensualidad N° 8',1000,'2019-10-12','R0008'),(119,'M0119','Mensualidad N° 9',1000,'2019-11-12','R0008'),(120,'M0120','Mensualidad N° 10',1000,'2019-12-12','R0008');
/*!40000 ALTER TABLE `tbl_habilitar_mensualidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_habilitar_reinscripcion`
--

DROP TABLE IF EXISTS `tbl_habilitar_reinscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_habilitar_reinscripcion` (
  `id_hab_reinscripcion` int(11) NOT NULL AUTO_INCREMENT,
  `cod_reinscripcion` varchar(10) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `vencimiento` date DEFAULT NULL,
  PRIMARY KEY (`id_hab_reinscripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_habilitar_reinscripcion`
--

LOCK TABLES `tbl_habilitar_reinscripcion` WRITE;
/*!40000 ALTER TABLE `tbl_habilitar_reinscripcion` DISABLE KEYS */;
INSERT INTO `tbl_habilitar_reinscripcion` VALUES (1,'R0001','Reincripcion Año 2019',200,'2019-02-25'),(3,'R0003','Reinscripcion Año 2020',300,'2020-03-19'),(4,'R0004','Reinscripcion Año 2021',100,'2021-01-01'),(5,'R0005','Rescripcion 2030',201,'2019-02-20'),(6,'R0006','Rescripcion 2050',2000,'2050-01-01'),(7,'R0007','Nueva Reinscripcion 2020',1200,'2020-01-01'),(8,'R0008','Año Nuevo Reinscripcion Prueba',2000,'2019-12-12');
/*!40000 ALTER TABLE `tbl_habilitar_reinscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_matricula`
--

DROP TABLE IF EXISTS `tbl_matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_matricula` (
  `id_matricula` int(11) NOT NULL AUTO_INCREMENT,
  `numero_matricula` varchar(10) DEFAULT NULL,
  `cod_alumno` varchar(7) DEFAULT NULL,
  `nombres_alumno` varchar(45) DEFAULT NULL,
  `apellidos_alumno` varchar(45) DEFAULT NULL,
  `fec_nacimiento` date DEFAULT NULL,
  `fec_registro` datetime DEFAULT NULL,
  `dni` char(8) DEFAULT NULL,
  `direccion` varchar(120) DEFAULT NULL,
  `telefono` char(7) DEFAULT NULL,
  `celular` char(9) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_matricula`),
  UNIQUE KEY `id_matricula_UNIQUE` (`id_matricula`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_matricula`
--

LOCK TABLES `tbl_matricula` WRITE;
/*!40000 ALTER TABLE `tbl_matricula` DISABLE KEYS */;
INSERT INTO `tbl_matricula` VALUES (2,'M0002','A155863','Diego Junior','Lopez Ramos','1998-12-10','2020-11-05 22:21:21','73092784','Calle 7 Jr.Arroz','2749678','935728643','M'),(3,'M0003','A358333','Carolina Angie','Altamirano Escobar','2000-10-05','2019-11-08 19:17:42','78239845','Mz B Calle Alvergas','7462322','947273625','F'),(4,'M0004','A758015','Juan Jose','Jimenez James','2019-11-16','2019-11-21 20:41:36','8989','Mz Z Lt10','8772232','909010288','M'),(5,'M0005','A718812','Rubi','Gomez','2010-10-10','2019-11-30 21:22:47','73122211','Calle Las Flores','8763542','992211228','F');
/*!40000 ALTER TABLE `tbl_matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pago_mensualidad`
--

DROP TABLE IF EXISTS `tbl_pago_mensualidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pago_mensualidad` (
  `id_pago_mensualidad` int(11) NOT NULL AUTO_INCREMENT,
  `cod_mensualidad` varchar(10) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `vencimiento` date DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `cod_reinscripcion` varchar(10) DEFAULT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `usuario` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`id_pago_mensualidad`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pago_mensualidad`
--

LOCK TABLES `tbl_pago_mensualidad` WRITE;
/*!40000 ALTER TABLE `tbl_pago_mensualidad` DISABLE KEYS */;
INSERT INTO `tbl_pago_mensualidad` VALUES (1,'M0004','Mensualidad N° 4',250,'2019-06-15','2019-11-05 22:37:08','R0001','Pagado','A849444'),(2,'M0009','Mensualidad N° 9',250,'2019-11-15','2019-11-05 22:37:15','R0001','Pagado','A849444'),(3,'M0008','Mensualidad N° 8',250,'2019-10-15','2019-11-05 22:37:22','R0001','Pagado','A849444'),(4,'M0008','Mensualidad N° 8',250,'2019-10-15','2019-11-05 22:38:01','R0001','Pagado','A155863'),(5,'M0018','Mensualidad N° 8',450,'2020-10-25','2019-11-05 22:44:57','R0002','Pagado','A849444'),(6,'M0019','Mensualidad N° 9',450,'2020-11-25','2019-11-05 22:45:04','R0002','Pagado','A849444'),(7,'M0020','Mensualidad N° 10',450,'2020-12-25','2019-11-05 22:45:11','R0002','Pagado','A849444'),(8,'M0011','Mensualidad N° 1',450,'2020-03-25','2019-11-13 14:32:20','R0002','Pagado','A849444'),(9,'M0071','Mensualidad N° 1',999,'2019-03-10','2019-11-25 21:19:35','R0004','Pagado','A849444'),(10,'M0080','Mensualidad N° 10',999,'2019-12-10','2019-11-25 21:34:12','R0004','Pagado','A849444'),(11,'M0077','Mensualidad N° 7',999,'2019-09-10','2019-11-25 21:34:40','R0004','Pagado','A849444'),(12,'M0071','Mensualidad N° 1',999,'2019-03-10','2019-11-25 22:07:33','R0004','Pagado','A758015'),(13,'M0081','Mensualidad N° 1',3000,'2019-03-08','2019-11-25 22:15:58','R0005','Pagado','A302166'),(14,'M0081','Mensualidad N° 1',3000,'2019-03-08','2019-11-26 19:36:39','R0005','Pagado','A849444'),(15,'M0081','Mensualidad N° 1',3000,'2019-03-08','2019-11-26 19:36:49','R0005','Pagado','A849444'),(16,'M0081','Mensualidad N° 1',3000,'2019-03-08','2019-11-26 19:37:02','R0005','Pagado','A849444'),(17,'M0088','Mensualidad N° 8',3000,'2019-10-08','2019-11-26 19:37:21','R0005','Pagado','A849444'),(18,'M0090','Mensualidad N° 10',3000,'2019-12-08','2019-11-26 19:38:25','R0005','Pagado','A302166'),(19,'M0082','Mensualidad N° 2',3000,'2019-04-08','2019-11-26 19:49:51','R0005','Pagado','A302166'),(20,'M0088','Mensualidad N° 8',3000,'2019-10-08','2019-11-26 19:56:44','R0005','Pagado','A302166'),(21,'M0087','Mensualidad N° 7',3000,'2019-09-08','2019-11-26 19:57:01','R0005','Pagado','A302166'),(22,'M0090','Mensualidad N° 10',3000,'2019-12-08','2019-11-26 20:09:29','R0005','Pagado','A849444'),(23,'M0081','Mensualidad N° 1',3000,'2019-03-08','2019-11-26 20:09:52','R0005','Pagado','A849444'),(24,'M0099','Mensualidad N° 9',3000,'2019-11-02','2019-11-26 20:18:10','R0006','Pagado','A849444'),(25,'M0100','Mensualidad N° 10',3000,'2019-12-02','2019-11-26 20:23:11','R0006','Pagado','A302166'),(26,'M0091','Mensualidad N° 1',3000,'2019-03-02','2019-11-26 20:23:32','R0006','Pagado','A302166'),(27,'M0094','Mensualidad N° 4',3000,'2019-06-02','2019-11-26 20:30:27','R0006','Pagado','A302166'),(28,'M0092','Mensualidad N° 2',3000,'2019-04-02','2019-11-26 20:31:02','R0006','Pagado','A302166'),(29,'M0099','Mensualidad N° 9',3000,'2019-11-02','2019-11-26 20:31:58','R0006','Pagado','A302166'),(30,'M0098','Mensualidad N° 8',3000,'2019-10-02','2019-11-26 20:41:05','R0006','Pagado','A302166'),(31,'M0100','Mensualidad N° 10',3000,'2019-12-02','2019-11-26 20:42:04','R0006','Pagado','A302166'),(32,'M0093','Mensualidad N° 3',3000,'2019-05-02','2019-11-26 20:43:16','R0006','Pagado','A302166'),(33,'M0100','Mensualidad N° 10',3000,'2019-12-02','2019-11-26 20:43:24','R0006','Pagado','A302166'),(34,'M0095','Mensualidad N° 5',3000,'2019-07-02','2019-11-26 20:43:33','R0006','Pagado','A302166'),(35,'M0096','Mensualidad N° 6',3000,'2019-08-02','2019-11-26 20:46:19','R0006','Pagado','A302166'),(36,'M0098','Mensualidad N° 8',3000,'2019-10-02','2019-11-26 20:51:31','R0006','Pagado','A302166'),(37,'M0098','Mensualidad N° 8',3000,'2019-10-02','2019-11-26 20:53:55','R0006','Pagado','A302166'),(38,'M0098','Mensualidad N° 8',3000,'2019-10-02','2019-11-26 20:55:21','R0006','Pagado','A302166'),(39,'M0099','Mensualidad N° 9',3000,'2019-11-02','2019-11-26 20:59:39','R0006','Pagado','A302166'),(40,'M0098','Mensualidad N° 8',3000,'2019-10-02','2019-11-26 21:11:07','R0006','Pagado','A302166'),(41,'M0098','Mensualidad N° 8',3000,'2019-10-02','2019-11-26 21:11:29','R0006','Pagado','A302166'),(42,'M0100','Mensualidad N° 10',3000,'2019-12-02','2019-11-26 21:12:55','R0006','Pagado','A302166'),(43,'M0100','Mensualidad N° 10',3000,'2019-12-02','2019-11-26 21:13:59','R0006','Pagado','A302166'),(44,'M0099','Mensualidad N° 9',3000,'2019-11-02','2019-11-26 21:18:58','R0006','Pagado','A302166'),(45,'M0098','Mensualidad N° 8',3000,'2019-10-02','2019-11-26 21:26:43','R0006','Pagado','A302166'),(46,'M0098','Mensualidad N° 8',3000,'2019-10-02','2019-11-26 21:29:08','R0006','Pagado','A302166'),(47,'M0100','Mensualidad N° 10',3000,'2019-12-02','2019-11-26 21:29:51','R0006','Pagado','A302166'),(48,'M0098','Mensualidad N° 8',3000,'2019-10-02','2019-11-26 21:33:30','R0006','Pagado','A302166'),(49,'M0098','Mensualidad N° 8',3000,'2019-10-02','2019-11-26 21:36:41','R0006','Pagado','A302166'),(50,'M0100','Mensualidad N° 10',3000,'2019-12-02','2019-11-27 00:10:03','R0006','Pagado','A302166'),(51,'M0099','Mensualidad N° 9',3000,'2019-11-02','2019-11-27 00:14:56','R0006','Pagado','A302166'),(52,'M0100','Mensualidad N° 10',3000,'2019-12-02','2019-11-27 00:17:03','R0006','Pagado','A302166'),(53,'M0100','Mensualidad N° 10',3000,'2019-12-02','2019-11-27 00:17:24','R0006','Pagado','A302166'),(54,'M0100','Mensualidad N° 10',3000,'2019-12-02','2019-12-01 12:54:42','R0006','Pagado','A849444'),(55,'M0094','Mensualidad N° 4',3000,'2019-06-02','2019-12-01 13:15:37','R0006','Pagado','A849444'),(56,'M0091','Mensualidad N° 1',3000,'2019-03-02','2019-12-02 00:02:49','R0006','Pagado','A849444'),(57,'M0091','Mensualidad N° 1',3000,'2019-03-02','2019-12-02 00:04:03','R0006','Pagado','A849444'),(58,'M0091','Mensualidad N° 1',3000,'2019-03-02','2019-12-02 00:12:57','R0006','Pagado','A849444'),(59,'M0100','Mensualidad N° 10',3000,'2019-12-02','2019-12-02 00:38:59','R0006','Pagado','A849444'),(60,'M0098','Mensualidad N° 8',3000,'2019-10-02','2019-12-02 00:42:47','R0006','Pagado','A849444'),(61,'M0094','Mensualidad N° 4',3000,'2019-06-02','2019-12-02 00:43:44','R0006','Pagado','A849444'),(62,'M0094','Mensualidad N° 4',3000,'2019-06-02','2019-12-02 00:47:36','R0006','Pagado','A849444'),(63,'M0094','Mensualidad N° 4',3000,'2019-06-02','2019-12-02 00:50:22','R0006','Pagado','A849444'),(64,'M0094','Mensualidad N° 4',3000,'2019-06-02','2019-12-02 00:53:25','R0006','Pagado','A849444'),(65,'M0098','Mensualidad N° 8',3000,'2019-10-02','2019-12-02 00:53:33','R0006','Pagado','A849444'),(66,'M0095','Mensualidad N° 5',3000,'2019-07-02','2019-12-02 00:56:52','R0006','Pagado','A849444'),(67,'M0091','Mensualidad N° 1',3000,'2019-03-02','2019-12-03 20:04:33','R0006','Pagado','A849444'),(68,'M0094','Mensualidad N° 4',3000,'2019-06-02','2019-12-03 20:14:44','R0006','Pagado','A849444'),(69,'M0093','Mensualidad N° 3',3000,'2019-05-02','2019-12-03 20:17:15','R0006','Pagado','A849444'),(70,'M0110','Mensualidad N° 10',3003,'2019-12-19','2019-12-03 22:10:04','R0007','Pagado','A849444'),(71,'M0101','Mensualidad N° 1',3003,'2019-03-19','2019-12-03 22:10:42','R0007','Pagado','A849444'),(72,'M0101','Mensualidad N° 1',3003,'2019-03-19','2019-12-03 22:12:41','R0007','Pagado','A718812'),(73,'M0106','Mensualidad N° 6',3003,'2019-08-19','2019-12-03 22:13:08','R0007','Pagado','A849444'),(74,'M0110','Mensualidad N° 10',3003,'2019-12-19','2019-12-04 15:41:11','R0007','Pagado','A358333'),(75,'M0102','Mensualidad N° 2',3003,'2019-04-19','2019-12-05 15:39:25','R0007','Pagado','A849444'),(76,'M0111','Mensualidad N° 1',1000,'2019-03-12','2019-12-16 13:22:15','R0008','Pagado','A849444'),(77,'M0120','Mensualidad N° 10',1000,'2019-12-12','2019-12-16 13:22:53','R0008','Pagado','A849444'),(78,'M0120','Mensualidad N° 10',1000,'2019-12-12','2019-12-16 13:23:56','R0008','Pagado','A758015'),(79,'M0111','Mensualidad N° 1',1000,'2019-03-12','2019-12-16 13:24:21','R0008','Pagado','A758015'),(80,'M0111','Mensualidad N° 1',1000,'2019-03-12','2019-12-16 13:32:53','R0008','Pagado','A155863'),(81,'M0112','Mensualidad N° 2',1000,'2019-04-12','2019-12-16 13:33:41','R0008','Pagado','A358333'),(82,'M0111','Mensualidad N° 1',1000,'2019-03-12','2019-12-16 14:17:01','R0008','Pagado','A302166'),(83,'M0112','Mensualidad N° 2',1000,'2019-04-12','2019-12-16 14:19:20','R0008','Pagado','A155863'),(84,'M0111','Mensualidad N° 1',1000,'2019-03-12','2019-12-16 14:20:08','R0008','Pagado','A358333'),(85,'M0119','Mensualidad N° 9',1000,'2019-11-12','2019-12-16 14:20:41','R0008','Pagado','A758015'),(86,'M0120','Mensualidad N° 10',1000,'2019-12-12','2019-12-16 14:22:09','R0008','Pagado','A718812'),(87,'M0113','Mensualidad N° 3',1000,'2019-05-12','2019-12-16 14:33:50','R0008','Pagado','A155863'),(88,'M0120','Mensualidad N° 10',1000,'2019-12-12','2019-12-16 14:34:25','R0008','Pagado','A358333'),(89,'M0118','Mensualidad N° 8',1000,'2019-10-12','2019-12-16 14:34:53','R0008','Pagado','A758015'),(90,'M0111','Mensualidad N° 1',1000,'2019-03-12','2019-12-16 14:35:22','R0008','Pagado','A718812'),(91,'M0119','Mensualidad N° 9',1000,'2019-11-12','2019-12-16 14:37:46','R0008','Pagado','A718812');
/*!40000 ALTER TABLE `tbl_pago_mensualidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pago_reinscripcion`
--

DROP TABLE IF EXISTS `tbl_pago_reinscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pago_reinscripcion` (
  `id_pago_reinscripcion` int(11) NOT NULL AUTO_INCREMENT,
  `cod_reinscripcion` varchar(10) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `vencimiento` date DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `usuario` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`id_pago_reinscripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pago_reinscripcion`
--

LOCK TABLES `tbl_pago_reinscripcion` WRITE;
/*!40000 ALTER TABLE `tbl_pago_reinscripcion` DISABLE KEYS */;
INSERT INTO `tbl_pago_reinscripcion` VALUES (3,'R0001','Reincripcion 2019',200,'2019-02-25','2019-11-05 22:25:28','Pagado','A849444'),(4,'R0002','Reinscripcion 2020',120,'2020-02-28','2019-11-05 22:41:24','Pagado','A155863'),(5,'R0002','Reinscripcion 2020',120,'2020-02-28','2019-11-08 19:17:42','Pagado','A358333'),(6,'R0002','Reinscripcion 2020',120,'2020-02-28','2019-11-13 13:06:56','Pagado','A849444'),(7,'R0002','Reinscripcion 2020',120,'2020-02-28','2019-11-13 14:12:56','Pagado','A358333'),(8,'R0002','Reinscripcion 2020',120,'2020-02-28','2019-11-13 14:14:22','Pagado','A358333'),(9,'R0002','Reinscripcion 2020',120,'2020-02-28','2019-11-16 15:28:38','Pagado','A758015'),(10,'R0004','Reinscripcion Año 2021',100,'2021-01-01','2019-11-21 20:41:36','Pagado','A302166'),(11,'R0004','Reinscripcion Año 2021',100,'2021-01-01','2019-11-25 22:02:18','Pagado','A849444'),(12,'R0004','Reinscripcion Año 2021',100,'2021-01-01','2020-11-25 22:08:04','Pagado','A758015'),(13,'R0005','Rescripcion 2030',201,'2019-02-20','2019-11-25 22:09:54','Pagado','A758015'),(14,'R0005','Rescripcion 2030',201,'2019-02-20','2019-11-25 22:10:04','Pagado','A758015'),(15,'R0005','Rescripcion 2030',201,'2019-02-20','2015-11-25 22:16:14','Pagado','A302166'),(16,'R0005','Rescripcion 2030',201,'2019-02-20','2015-11-26 19:31:47','Pagado','A849444'),(17,'R0005','Rescripcion 2030',201,'2019-02-20','2019-11-26 19:33:10','Pagado','A155863'),(18,'R0005','Rescripcion 2030',201,'2019-02-20','2017-11-26 19:33:14','Pagado','A155863'),(19,'R0006','Rescripcion 2050',2000,'2050-01-01','2019-11-26 20:30:19','Pagado','A302166'),(20,'R0006','Rescripcion 2050',2000,'2050-01-01','2019-11-30 21:22:47','Pagado','A718812'),(21,'R0006','Rescripcion 2050',2000,'2050-01-01','2019-12-01 12:55:16','Pagado','A849444'),(22,'R0007','Nueva Reinscripcion 2020',1200,'2020-01-01','2019-12-03 22:10:58','Pagado','A849444'),(23,'R0007','Nueva Reinscripcion 2020',1200,'2020-01-01','2019-12-03 22:12:33','Pagado','A718812'),(24,'R0007','Nueva Reinscripcion 2020',1200,'2020-01-01','2019-12-03 22:23:01','Pagado','A302166'),(25,'R0007','Nueva Reinscripcion 2020',1200,'2020-01-01','2019-12-03 22:25:16','Pagado','A155863'),(26,'R0007','Nueva Reinscripcion 2020',1200,'2020-01-01','2019-12-03 22:31:01','Pagado','A358333'),(27,'R0007','Nueva Reinscripcion 2020',1200,'2020-01-01','2019-12-04 16:07:28','Pagado','A758015'),(28,'R0008','Año Nuevo Reinscripcion Prueba',2000,'2019-12-12','2019-12-16 13:22:00','Pagado','A849444'),(29,'R0008','Año Nuevo Reinscripcion Prueba',2000,'2019-12-12','2019-12-16 13:23:47','Pagado','A758015'),(30,'R0008','Año Nuevo Reinscripcion Prueba',2000,'2019-12-12','2019-12-16 13:32:40','Pagado','A155863'),(31,'R0008','Año Nuevo Reinscripcion Prueba',2000,'2019-12-12','2019-12-16 13:33:33','Pagado','A358333'),(32,'R0008','Año Nuevo Reinscripcion Prueba',2000,'2019-12-12','2019-12-16 13:40:32','Pagado','A302166'),(33,'R0008','Año Nuevo Reinscripcion Prueba',2000,'2019-12-12','2019-12-16 14:21:56','Pagado','A718812');
/*!40000 ALTER TABLE `tbl_pago_reinscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_profesor`
--

DROP TABLE IF EXISTS `tbl_profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_profesor` (
  `id_profesor` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `fec_registro` datetime DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `direccion` varchar(120) DEFAULT NULL,
  `telefono` char(7) DEFAULT NULL,
  `celular` char(9) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_profesor`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_profesor`
--

LOCK TABLES `tbl_profesor` WRITE;
/*!40000 ALTER TABLE `tbl_profesor` DISABLE KEYS */;
INSERT INTO `tbl_profesor` VALUES (1,'Julio','Farias','2019-11-07 00:00:00','23874655','Mz L 135','7438264','979873584','M'),(2,'Luis','Ramos','2019-11-07 00:00:00','92347612','Jr. Naza 345','6351809','982378463','M'),(3,'Erick','Pedraza','2019-11-07 00:00:00','87352694','Calle Lopez.G 231','4628164','923236418','M'),(4,'Carlos','Espinoza','2019-11-07 00:00:00','90801264','Av. Durand 342','2039897','932472382','M'),(5,'Juan','Lara','2019-11-07 00:00:00','64387655','Mz F Lt 05','2143675','912064883','M'),(6,'Carlos Alonso','Gutierrez Ramos','2019-11-11 14:49:00','73262299','Maz A lt 09','8374265','902017869','M'),(7,'Carlos Alonso','Gutierrez Ramos','2019-11-11 22:17:04','73262799','Maz A lt 09','8374265','902017869','M'),(11,'Juana Almendra','Lopez Lopez','2019-11-12 10:21:43','83726611','Calle las Flores 765','8989733','998993763','F');
/*!40000 ALTER TABLE `tbl_profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `rol` varchar(50) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
INSERT INTO `tbl_usuario` VALUES (1,'admin','12345678','Administrador'),(2,'secret','123','Secretaria');
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario_alumno`
--

DROP TABLE IF EXISTS `tbl_usuario_alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_usuario_alumno` (
  `id_usuario_alumno` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(7) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_usuario_alumno`),
  KEY `usuario_idx` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario_alumno`
--

LOCK TABLES `tbl_usuario_alumno` WRITE;
/*!40000 ALTER TABLE `tbl_usuario_alumno` DISABLE KEYS */;
INSERT INTO `tbl_usuario_alumno` VALUES (2,'A155863','89511993'),(3,'A358333','280549'),(4,'A758015','14575'),(5,'A718812','6273355');
/*!40000 ALTER TABLE `tbl_usuario_alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_colegio_2'
--

--
-- Dumping routines for database 'db_colegio_2'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_agregarProfesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_agregarProfesor`(in nombres varchar(45), in apellidos varchar(45), in dni varchar(8), in direccion varchar(120), in telefono char(7), in celular char(9), in sexo char(1))
BEGIN

SET @VarFechaActual := (SELECT now());

INSERT INTO tbl_profesor(id_profesor, nombres, apellidos, fec_registro, dni, direccion, telefono, celular, sexo)
VALUE(NULL, nombres, apellidos, @VarFechaActual, dni, direccion, telefono, celular, sexo);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_cursoAlumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cursoAlumno`(IN usuario VARCHAR(10))
BEGIN

SET @VarGrado := (select grado from tbl_alumno where cod_alumno =  usuario);
SET @VarSeccion := (select seccion from tbl_alumno where cod_alumno =  usuario);
SET @VarPrimSec := (select primsec from tbl_alumno where cod_alumno = usuario);

select c.id_curso, c.curso
from tbl_curso_grado_detalle cgd
inner join tbl_curso_profesor cp on cp.id_curso_profesor = cgd.id_curso_profesor
inner join tbl_curso c on c.id_curso = cp.id_curso
inner join tbl_grado_seccion gs on gs.id_grado_seccion = cgd.id_grado_seccion
where gs.grado = @VarGrado
and gs.seccion = @VarSeccion
and gs.primsec = @VarPrimSec;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_datos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_datos`()
BEGIN
	SET @VarAlumM := (SELECT COUNT(SEXO) from TBL_MATRICULA WHERE SEXO='M');
	SET @VarAlumF := (SELECT COUNT(SEXO) from TBL_MATRICULA WHERE SEXO='F');

	SELECT @VarAlumM alumM, @VarAlumF alumF FROM DUAL;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_datosAlumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_datosAlumno`(IN usuario VARCHAR(10))
BEGIN

select cod_alumno, nombres_alumno, apellidos_alumno, grado, seccion, primsec from tbl_alumno
where cod_Alumno = usuario;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_datos_can_alumnosXgrado_Prim` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_datos_can_alumnosXgrado_Prim`()
BEGIN

SET @Primero := (SELECT COUNT(grado) from tbl_alumno WHERE primsec='Primaria' and grado='1');

SET @Segundo := (SELECT COUNT(grado) from tbl_alumno WHERE primsec='Primaria' and grado='2');

SET @Tercero := (SELECT COUNT(grado) from tbl_alumno WHERE primsec='Primaria' and grado='3');

SET @Cuarto := (SELECT COUNT(grado) from tbl_alumno WHERE primsec='Primaria' and grado='4');

SET @Quinto := (SELECT COUNT(grado) from tbl_alumno WHERE primsec='Primaria' and grado='5');

SET @Sexto := (SELECT COUNT(grado) from tbl_alumno WHERE primsec='Primaria' and grado='6');

SELECT @Primero PrimeroPrim, @Segundo SegundoPrim, @Tercero TerceroPrim, @Cuarto CuartoPrim, @Quinto QuintoPrim, @Sexto SextoPrim FROM DUAL;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_datos_can_alumnosXgrado_Secu` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_datos_can_alumnosXgrado_Secu`()
BEGIN

SET @Primero := (SELECT COUNT(grado) from tbl_alumno WHERE primsec='Secundaria' and grado='1');

SET @Segundo := (SELECT COUNT(grado) from tbl_alumno WHERE primsec='Secundaria' and grado='2');

SET @Tercero := (SELECT COUNT(grado) from tbl_alumno WHERE primsec='Secundaria' and grado='3');

SET @Cuarto := (SELECT COUNT(grado) from tbl_alumno WHERE primsec='Secundaria' and grado='4');

SET @Quinto := (SELECT COUNT(grado) from tbl_alumno WHERE primsec='Secundaria' and grado='5');


SELECT @Primero PrimeroSec, @Segundo SegundoSec, @Tercero TerceroSec, @Cuarto CuartoSec, @Quinto QuintoSec FROM DUAL;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_datos_can_matriculasXYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_datos_can_matriculasXYear`()
BEGIN

set @f2015 := (select count(*) from tbl_matricula where year(fec_registro) = '2015');

set @f2016 := (select count(*) from tbl_matricula where year(fec_registro) = '2016');

set @f2017 := (select count(*) from tbl_matricula where year(fec_registro) = '2017');

set @f2018 := (select count(*) from tbl_matricula where year(fec_registro) = '2018');

set @f2019 := (select count(*) from tbl_matricula where year(fec_registro) = '2019');

set @f2020 := (select count(*) from tbl_matricula where year(fec_registro) = '2020');

SELECT @f2015 f2015M, @f2016 f2016M, @f2017 f2017M, @f2018 f2018M, @f2019 f2019M, @f2020 f2020M FROM DUAL;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_datos_can_mensualidadXMes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_datos_can_mensualidadXMes`()
BEGIN

set @ene := (select count(*) from tbl_pago_mensualidad where month(fecha) = '01');

set @feb := (select count(*) from tbl_pago_mensualidad where month(fecha) = '02');

set @mar := (select count(*) from tbl_pago_mensualidad where month(fecha) = '03');

set @abr := (select count(*) from tbl_pago_mensualidad where month(fecha) = '04');

set @may := (select count(*) from tbl_pago_mensualidad where month(fecha) = '05');

set @jun := (select count(*) from tbl_pago_mensualidad where month(fecha) = '06');

set @jul := (select count(*) from tbl_pago_mensualidad where month(fecha) = '07');

set @ago := (select count(*) from tbl_pago_mensualidad where month(fecha) = '08');

set @sep := (select count(*) from tbl_pago_mensualidad where month(fecha) = '09');

set @oct := (select count(*) from tbl_pago_mensualidad where month(fecha) = '10');

set @nov := (select count(*) from tbl_pago_mensualidad where month(fecha) = '11');

set @dic := (select count(*) from tbl_pago_mensualidad where month(fecha) = '12');

SELECT @ene eneroMen, @feb febreroMen, @mar marzoMen, @abr abrilMen, @may mayoMen, @jun junioMen,

@jul julioMen, @ago agostoMen, @sep septiembreMen, @oct octubreMen, @nov noviembreMen, @dic diciembreMen FROM DUAL;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_datos_can_reinscripcionXYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_datos_can_reinscripcionXYear`()
BEGIN

set @f2015 := (select count(*) from tbl_pago_reinscripcion where year(fecha) = '2015');

set @f2016 := (select count(*) from tbl_pago_reinscripcion where year(fecha) = '2016');

set @f2017 := (select count(*) from tbl_pago_reinscripcion where year(fecha) = '2017');

set @f2018 := (select count(*) from tbl_pago_reinscripcion where year(fecha) = '2018');

set @f2019 := (select count(*) from tbl_pago_reinscripcion where year(fecha) = '2019');

set @f2020 := (select count(*) from tbl_pago_reinscripcion where year(fecha) = '2020');

SELECT @f2015 f2015R, @f2016 f2016R, @f2017 f2017R, @f2018 f2018R, @f2019 f2019R, @f2020 f2020R FROM DUAL;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_detalleCursosAlumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_detalleCursosAlumno`(in usuario varchar(45), in idcurso int)
BEGIN

SET @VarGrado := (select grado from tbl_alumno where cod_alumno =  usuario);
SET @VarSeccion := (select seccion from tbl_alumno where cod_alumno =  usuario);
SET @VarPrimSec := (select primsec from tbl_alumno where cod_alumno = usuario);

select c.id_curso, c.curso, p.nombres, p.apellidos, gs.grado, gs.seccion, gs.primsec, cgd.horario_inicio, cgd.horario_fin
from tbl_curso_grado_detalle cgd
inner join tbl_curso_profesor cp on cp.id_curso_profesor = cgd.id_curso_profesor
inner join tbl_profesor p on cp.id_profesor = p.id_profesor
inner join tbl_curso c on c.id_curso = cp.id_curso
inner join tbl_grado_seccion gs on gs.id_grado_seccion = cgd.id_grado_seccion
where gs.grado = @VarGrado
and gs.seccion = @VarSeccion
and gs.primsec = @VarPrimSec
and c.id_curso = idcurso;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_fechasMensualidad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_fechasMensualidad`(in user varchar(10))
BEGIN

SET @CodHab := (SELECT cod_reinscripcion FROM tbl_habilitar_reinscripcion ORDER by cod_reinscripcion DESC LIMIT 1);

SET @Var1 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad WHERE usuario = user ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var2 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad WHERE usuario = user AND cod_mensualidad != @Var1 ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var3 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var4 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var5 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var6 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
and cod_mensualidad != @Var4 and cod_mensualidad != @Var5
ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var7 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
and cod_mensualidad != @Var4 and cod_mensualidad != @Var5 and cod_mensualidad != @Var6
ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var8 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
and cod_mensualidad != @Var4 and cod_mensualidad != @Var5 and cod_mensualidad != @Var6 and cod_mensualidad != @Var7
ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var9 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
and cod_mensualidad != @Var4 and cod_mensualidad != @Var5 and cod_mensualidad != @Var6 and cod_mensualidad != @Var7
and cod_mensualidad != @Var8
ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var10 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
and cod_mensualidad != @Var4 and cod_mensualidad != @Var5 and cod_mensualidad != @Var6 and cod_mensualidad != @Var7
and cod_mensualidad != @Var8 and cod_mensualidad != @Var9
ORDER by cod_mensualidad ASC LIMIT 1);

IF @Var1 IS NULL THEN

SELECT * FROM(SELECT cod_mensualidad, vencimiento FROM tbl_habilitar_mensualidad ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;

END IF;

IF @Var10 is not null then 
SELECT * FROM(SELECT cod_mensualidad, vencimiento FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad != @Var5
and cod_mensualidad != @Var6
and cod_mensualidad != @Var7
and cod_mensualidad != @Var8
and cod_mensualidad != @Var9
and cod_mensualidad != @Var10
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var9 is not null then 
SELECT * FROM(SELECT cod_mensualidad, vencimiento FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad != @Var5
and cod_mensualidad != @Var6
and cod_mensualidad != @Var7
and cod_mensualidad != @Var8
and cod_mensualidad != @Var9
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var8 is not null then 
SELECT * FROM(SELECT cod_mensualidad, vencimiento FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad != @Var5
and cod_mensualidad != @Var6
and cod_mensualidad != @Var7
and cod_mensualidad != @Var8
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var7 is not null then 
SELECT * FROM(SELECT cod_mensualidad, vencimiento FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad != @Var5
and cod_mensualidad != @Var6
and cod_mensualidad != @Var7
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var6 is not null then 
SELECT * FROM(SELECT cod_mensualidad, vencimiento FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad != @Var5
and cod_mensualidad != @Var6
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var5 is not null then 
SELECT * FROM(SELECT cod_mensualidad, vencimiento FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad != @Var5
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var4 is not null then 
SELECT * FROM(SELECT cod_mensualidad, vencimiento FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var3 is not null then 
SELECT * FROM(SELECT cod_mensualidad, vencimiento FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var2 is not null then 
SELECT * FROM(SELECT cod_mensualidad, vencimiento FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var1 is not null then 
SELECT * FROM(SELECT cod_mensualidad, vencimiento FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;


end if;
end if;
end if;
end if;
end if;
end if;
end if;
end if;
end if;
end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_generarMatricula` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_generarMatricula`(IN nom_alumno VARCHAR(45),IN ape_alumno VARCHAR(45),
IN fec_nac DATE, IN dni CHAR(8), IN direccion VARCHAR(120), IN telefono CHAR(7), IN celular CHAR(9), IN sexo CHAR(1))
BEGIN

SET @VarIdMayor := (SELECT substring(max(numero_matricula),length(numero_matricula-3))+1 FROM tbl_matricula);
SET @VarFechaActual := (SELECT now());
	
	simple_loop: LOOP    
		SET @ramdom := (SELECT rand() FROM DUAL);
		SET @CodAlum := (SELECT substring((@ramdom),length(@ramdom)-5) FROM DUAL);
		SET @cod_alu := (SELECT substring(cod_alumno,2) FROM (SELECT * FROM tbl_matricula WHERE substring(cod_alumno,2)=@CodAlum) a);
         IF @cod_alu IS NULL THEN
            LEAVE simple_loop;
         END IF;
   END LOOP simple_loop;

IF @VarIdMayor IS NULL THEN 
	
SET @VarIdMayor := 1;
 
END IF;

IF @VarIdMayor <= 9999 THEN
SET @Ceros = '';
END IF;

IF @VarIdMayor <= 999 THEN
SET @Ceros = '0'; 
END IF;

IF @VarIdMayor <= 99 THEN
SET @Ceros = '00'; 
END IF;

IF @VarIdMayor <= 9 THEN
SET @Ceros = '000';
END IF;

INSERT INTO tbl_matricula(id_matricula, numero_matricula, cod_alumno, nombres_alumno, apellidos_alumno, fec_nacimiento, fec_registro, dni, direccion, telefono, celular, sexo)
VALUE(NULL, Concat('M',@Ceros, @VarIdMayor), concat('A', @CodAlum), nom_alumno, ape_alumno, fec_nac, @VarFechaActual, dni, direccion, telefono, celular, sexo);

SET @PassAle := (SELECT substring((SELECT rand()FROM DUAL),length(@ramdom)-5) FROM DUAL);

INSERT INTO tbl_usuario_alumno(id_usuario_alumno, usuario, pass)
VALUE(NULL, concat('A', @CodAlum), @PassAle);

CALL sp_pagoReinscripcion(concat('A', @CodAlum));

INSERT INTO tbl_alumno(id_alumno, cod_alumno, nombres_alumno, apellidos_alumno)
VALUE(NULL, concat('A', @CodAlum), nom_alumno, ape_alumno);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_habilitarMensualidad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_habilitarMensualidad`(IN mon DOUBLE, IN venci DATE )
BEGIN

SET @CodHab := (SELECT cod_reinscripcion FROM tbl_habilitar_reinscripcion ORDER by cod_reinscripcion DESC LIMIT 1);

SET @c = 1;

SET @a = 3;

SET @año = (select year(venci));

SET @dia = (select day(venci));

simple_loop: LOOP    

SET @VarIdMayor := (SELECT substring(max(cod_mensualidad),length(cod_mensualidad-3))+1  FROM tbl_habilitar_mensualidad);

IF @VarIdMayor IS NULL THEN 
	
SET @VarIdMayor := 1;

END IF;

IF @VarIdMayor <= 9999 THEN
SET @Ceros = '';
END IF;

IF @VarIdMayor <= 999 THEN
SET @Ceros = '0'; 
END IF;

IF @VarIdMayor <= 99 THEN
SET @Ceros = '00'; 
END IF;

IF @VarIdMayor <= 9 THEN
SET @Ceros = '000';
END IF;

	IF @a > 9 then
	set @cer = '';
	END IF;
	IF @a <= 9 then
	set @cer = '0';
	END IF;

	INSERT INTO tbl_habilitar_mensualidad(id_hab_mensualidad, cod_mensualidad, descripcion, monto, vencimiento, codigo_reinscripcion)
	VALUES(null, Concat('M', @Ceros,convert(@VarIdMayor, CHAR)), concat('Mensualidad N° ',convert(@c, CHAR)), mon, convert(concat(convert(@año,char),'-',convert(@cer,char),convert(@a,char),'-',convert(@dia, char)), DATE) , @CodHab);
	
	SET @c = @c+1;
	SET @a = @a+1;

         IF @c>10 OR @a>12 THEN
            LEAVE simple_loop;
         END IF;
   END LOOP simple_loop;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_habilitarReinscripcion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_habilitarReinscripcion`(IN des VARCHAR(45), IN mon DOUBLE, IN venc DATE)
BEGIN

SET @VarIdMayor := (SELECT substring(max(cod_reinscripcion),length(cod_reinscripcion-3))+1  FROM tbl_habilitar_reinscripcion);

IF @VarIdMayor IS NULL THEN 
	
SET @VarIdMayor := 1;

END IF;

IF @VarIdMayor <= 9999 THEN
SET @Ceros = '';
END IF;

IF @VarIdMayor <= 999 THEN
SET @Ceros = '0'; 
END IF;

IF @VarIdMayor <= 99 THEN
SET @Ceros = '00'; 
END IF;

IF @VarIdMayor <= 9 THEN
SET @Ceros = '000';
END IF;

INSERT INTO tbl_habilitar_reinscripcion(cod_reinscripcion, descripcion, monto, vencimiento)
VALUES(Concat('R', @Ceros,convert(@VarIdMayor, CHAR)), des, mon, venc);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_horarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_horarios`()
BEGIN

select cgd.id_curso_grado_detalle, c.curso, p.nombres, p.apellidos, gs.grado, gs.seccion, gs.primsec, cgd.horario_inicio, cgd.horario_fin
from tbl_curso_grado_detalle cgd
inner join tbl_curso_profesor cp on cp.id_curso_profesor = cgd.id_curso_profesor
inner join tbl_profesor p on cp.id_profesor = p.id_profesor
inner join tbl_curso c on c.id_curso = cp.id_curso
inner join tbl_grado_seccion gs on gs.id_grado_seccion = cgd.id_grado_seccion;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_mostrarMensualidad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrarMensualidad`( in codmen varchar(10), IN user VARCHAR(10))
BEGIN

-- --SET @VarUser := (SELECT cod_mensualidad FROM tbl_pago_mensualidad WHERE usuario = user);

-- -IF @VarUser IS NULL THEN

-- -SELECT * FROM(SELECT *, 'Pendiente' AS estado FROM tbl_habilitar_mensualidad ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;

-- -ELSE 
SET @CodHab := (SELECT cod_reinscripcion FROM tbl_habilitar_reinscripcion ORDER by cod_reinscripcion DESC LIMIT 1);

SET @Var1 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad WHERE usuario = user ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var2 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad WHERE usuario = user AND cod_mensualidad != @Var1 ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var3 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var4 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var5 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var6 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
and cod_mensualidad != @Var4 and cod_mensualidad != @Var5
ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var7 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
and cod_mensualidad != @Var4 and cod_mensualidad != @Var5 and cod_mensualidad != @Var6
ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var8 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
and cod_mensualidad != @Var4 and cod_mensualidad != @Var5 and cod_mensualidad != @Var6 and cod_mensualidad != @Var7
ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var9 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
and cod_mensualidad != @Var4 and cod_mensualidad != @Var5 and cod_mensualidad != @Var6 and cod_mensualidad != @Var7
and cod_mensualidad != @Var8
ORDER by cod_mensualidad ASC LIMIT 1);

SET @Var10 := (SELECT cod_mensualidad FROM tbl_pago_mensualidad 
WHERE usuario = user AND cod_mensualidad != @Var1 and cod_mensualidad != @Var2 and cod_mensualidad != @Var3
and cod_mensualidad != @Var4 and cod_mensualidad != @Var5 and cod_mensualidad != @Var6 and cod_mensualidad != @Var7
and cod_mensualidad != @Var8 and cod_mensualidad != @Var9
ORDER by cod_mensualidad ASC LIMIT 1);

IF @Var1 IS NULL THEN

SELECT * FROM(SELECT *, 'Pendiente' AS estado FROM tbl_habilitar_mensualidad where cod_mensualidad = codmen ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;

END IF;

IF @Var10 is not null then 
SELECT * FROM(SELECT *, 'Pendiente' AS estado FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad != @Var5
and cod_mensualidad != @Var6
and cod_mensualidad != @Var7
and cod_mensualidad != @Var8
and cod_mensualidad != @Var9
and cod_mensualidad != @Var10
and cod_mensualidad = codmen
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var9 is not null then 
SELECT * FROM(SELECT *, 'Pendiente' AS estado FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad != @Var5
and cod_mensualidad != @Var6
and cod_mensualidad != @Var7
and cod_mensualidad != @Var8
and cod_mensualidad != @Var9
and cod_mensualidad = codmen
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var8 is not null then 
SELECT * FROM(SELECT *, 'Pendiente' AS estado FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad != @Var5
and cod_mensualidad != @Var6
and cod_mensualidad != @Var7
and cod_mensualidad != @Var8
and cod_mensualidad = codmen
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var7 is not null then 
SELECT * FROM(SELECT *, 'Pendiente' AS estado FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad != @Var5
and cod_mensualidad != @Var6
and cod_mensualidad != @Var7
and cod_mensualidad = codmen
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var6 is not null then 
SELECT * FROM(SELECT *, 'Pendiente' AS estado FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad != @Var5
and cod_mensualidad != @Var6
and cod_mensualidad = codmen
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var5 is not null then 
SELECT * FROM(SELECT *, 'Pendiente' AS estado FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad != @Var5
and cod_mensualidad = codmen
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var4 is not null then 
SELECT * FROM(SELECT *, 'Pendiente' AS estado FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad != @Var4
and cod_mensualidad = codmen
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var3 is not null then 
SELECT * FROM(SELECT *, 'Pendiente' AS estado FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad != @Var3
and cod_mensualidad = codmen
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var2 is not null then 
SELECT * FROM(SELECT *, 'Pendiente' AS estado FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1  
and cod_mensualidad != @Var2
and cod_mensualidad = codmen
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;
else

IF @Var1 is not null then 
SELECT * FROM(SELECT *, 'Pendiente' AS estado FROM tbl_habilitar_mensualidad WHERE codigo_reinscripcion = @CodHab 
and cod_mensualidad != @Var1
and cod_mensualidad = codmen
ORDER by cod_mensualidad DESC LIMIT 10)a ORDER by cod_mensualidad ASC LIMIT 10;


end if;
end if;
end if;
end if;
end if;
end if;
end if;
end if;
end if;
end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_mostrarReinscripcion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrarReinscripcion`(IN user VARCHAR(7))
BEGIN

SET @CodHab := (SELECT cod_reinscripcion FROM tbl_habilitar_reinscripcion ORDER by cod_reinscripcion DESC LIMIT 1);
SET @User2 := (SELECT * FROM (SELECT usuario FROM tbl_pago_reinscripcion WHERE usuario = user AND cod_reinscripcion = @CodHab) a);
SET @CodRes := (SELECT * FROM (SELECT cod_reinscripcion FROM tbl_pago_reinscripcion WHERE usuario = user AND cod_reinscripcion = @CodHab) a);


IF @User2 IS NULL OR @CodRes != @CodHab THEN
SELECT cod_reinscripcion, descripcion, monto, vencimiento, 'Pendiente' AS estado FROM db_colegio_2.tbl_habilitar_reinscripcion 
where id_hab_reinscripcion = (select max(id_hab_reinscripcion)from tbl_habilitar_reinscripcion);

ELSE

SELECT cod_reinscripcion, descripcion, monto, vencimiento, estado FROM db_colegio_2.tbl_pago_reinscripcion
where cod_reinscripcion = @CodHab and usuario = user;

END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_notasCurso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_notasCurso`(in user varchar(10), in cod varchar(10))
BEGIN

select nota1, nota2, nota3, nota4 from tbl_alumno_notas 
where cod_alumno = user
and id_curso = cod;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_pagoMensualidad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pagoMensualidad`(IN cod VARCHAR(45), IN user VARCHAR(10))
BEGIN

SET @VarCod := (SELECT cod_mensualidad FROM db_colegio_2.tbl_habilitar_mensualidad
where cod_mensualidad = cod);

SET @VarDes := (SELECT descripcion FROM db_colegio_2.tbl_habilitar_mensualidad 
where cod_mensualidad = cod);

SET @VarMon := (SELECT monto FROM db_colegio_2.tbl_habilitar_mensualidad 
where cod_mensualidad = cod);

SET @VarVen := (SELECT vencimiento FROM db_colegio_2.tbl_habilitar_mensualidad 
where cod_mensualidad = cod);

SET @VarFechaActual := (SELECT now());

SET @CodRes := (SELECT codigo_reinscripcion FROM db_colegio_2.tbl_habilitar_mensualidad
where cod_mensualidad = cod);

INSERT INTO tbl_pago_mensualidad(id_pago_mensualidad, cod_mensualidad, descripcion, monto, vencimiento, fecha, cod_reinscripcion, estado, usuario) 
VALUES(null, @VarCod, @VarDes, @VarMon, @VarVen, @VarFechaActual, @CodRes, 'Pagado', user);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_pagoReinscripcion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pagoReinscripcion`(IN user VARCHAR(7))
BEGIN

SET @VarCod := (SELECT cod_reinscripcion FROM db_colegio_2.tbl_habilitar_reinscripcion 
where id_hab_reinscripcion = (select max(id_hab_reinscripcion)from tbl_habilitar_reinscripcion));

SET @VarDes := (SELECT descripcion FROM db_colegio_2.tbl_habilitar_reinscripcion 
where id_hab_reinscripcion = (select max(id_hab_reinscripcion)from tbl_habilitar_reinscripcion));

SET @VarMon := (SELECT monto FROM db_colegio_2.tbl_habilitar_reinscripcion 
where id_hab_reinscripcion = (select max(id_hab_reinscripcion)from tbl_habilitar_reinscripcion));

SET @VarVen := (SELECT vencimiento FROM db_colegio_2.tbl_habilitar_reinscripcion 
where id_hab_reinscripcion = (select max(id_hab_reinscripcion)from tbl_habilitar_reinscripcion));

SET @VarFechaActual := (SELECT now());

INSERT INTO tbl_pago_reinscripcion(id_pago_reinscripcion, cod_reinscripcion, descripcion, monto, vencimiento, fecha, estado, usuario) 
VALUES(null, @VarCod, @VarDes, @VarMon, @VarVen, @VarFechaActual, 'Pagado', user);

END ;;
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

-- Dump completed on 2019-12-16 14:47:30
