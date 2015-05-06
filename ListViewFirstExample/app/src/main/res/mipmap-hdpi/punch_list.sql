# ************************************************************
# Sequel Pro SQL dump
# Versión 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.22)
# Base de datos: antelligence
# Tiempo de Generación: 2015-05-06 04:31:35 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Volcado de tabla punch_list
# ------------------------------------------------------------

DROP TABLE IF EXISTS `punch_list`;

CREATE TABLE `punch_list` (
  `id_reporte` int(11) NOT NULL,
  `id_concepto` int(11) NOT NULL,
  `reporte` enum('Bien','Si','Mal','No','No aplica') DEFAULT NULL,
  `comentarios` varchar(255) DEFAULT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `cantidad` varchar(5) DEFAULT NULL,
  `id_acceso` int(11) DEFAULT NULL,
  `creado` datetime NOT NULL,
  `modificado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_reporte`,`id_concepto`),
  KEY `fk_revisiones_conceptos1_idx` (`id_concepto`),
  KEY `fk_punch_list_catalogo_accesos1_idx` (`id_acceso`),
  CONSTRAINT `fk_punch_list_catalogo_accesos1` FOREIGN KEY (`id_acceso`) REFERENCES `catalogo_accesos` (`id_catalogo_acceso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_revisiones_conceptos1` FOREIGN KEY (`id_concepto`) REFERENCES `conceptos` (`id_concepto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_revisiones_reporte1` FOREIGN KEY (`id_reporte`) REFERENCES `reporte` (`id_reporte`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
