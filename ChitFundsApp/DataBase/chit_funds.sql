/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.23 : Database - chit_funds
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`chit_funds` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `chit_funds`;

/*Table structure for table `admin_details` */

DROP TABLE IF EXISTS `admin_details`;

CREATE TABLE `admin_details` (
  `admin_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mobile_no` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `mobile_no` (`mobile_no`),
  UNIQUE KEY `email_id` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `admin_details` */

/*Table structure for table `chits_details` */

DROP TABLE IF EXISTS `chits_details`;

CREATE TABLE `chits_details` (
  `chit_id` bigint NOT NULL AUTO_INCREMENT,
  `admin_id` bigint DEFAULT NULL,
  `chit_number` int DEFAULT NULL,
  `chit_nick_name` varchar(50) DEFAULT NULL,
  `active_or_not` bit(1) DEFAULT b'1',
  `chit_started_month` varchar(6) DEFAULT NULL,
  `no_of_months` int DEFAULT NULL,
  `no_of_members` int DEFAULT NULL,
  PRIMARY KEY (`chit_id`),
  KEY `admin_id` (`admin_id`),
  CONSTRAINT `chits_details_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin_details` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `chits_details` */

/*Table structure for table `members_details` */

DROP TABLE IF EXISTS `members_details`;

CREATE TABLE `members_details` (
  `member_id` bigint NOT NULL AUTO_INCREMENT,
  `chit_id` bigint DEFAULT NULL,
  `member_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `mobile_no` varchar(10) DEFAULT NULL,
  `email_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  KEY `chit_id` (`chit_id`),
  CONSTRAINT `members_details_ibfk_1` FOREIGN KEY (`chit_id`) REFERENCES `chits_details` (`chit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `members_details` */

/*Table structure for table `months_lkp` */

DROP TABLE IF EXISTS `months_lkp`;

CREATE TABLE `months_lkp` (
  `month_id` int DEFAULT NULL,
  `month_year` varchar(6) DEFAULT NULL,
  UNIQUE KEY `month_id` (`month_id`),
  UNIQUE KEY `month_year` (`month_year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `months_lkp` */

insert  into `months_lkp`(`month_id`,`month_year`) values 
(1,'012021'),
(2,'022021'),
(3,'032021'),
(4,'042021'),
(5,'052021'),
(6,'062021'),
(7,'072021'),
(8,'082021'),
(9,'092021'),
(10,'102021'),
(11,'112021'),
(12,'122021'),
(13,'012022'),
(14,'022022'),
(15,'032022'),
(16,'042022'),
(17,'052022'),
(18,'062022'),
(19,'072022'),
(20,'082022'),
(21,'092022');

/*Table structure for table `payment_details` */

DROP TABLE IF EXISTS `payment_details`;

CREATE TABLE `payment_details` (
  `payment_id` bigint NOT NULL AUTO_INCREMENT,
  `member_id` bigint DEFAULT NULL,
  `month_id` int DEFAULT NULL,
  `month_year` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `amount_paid` bigint DEFAULT NULL,
  `chit_drawn_or_not` bit(1) DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `member_id` (`member_id`),
  KEY `month_id` (`month_id`),
  CONSTRAINT `payment_details_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `members_details` (`member_id`),
  CONSTRAINT `payment_details_ibfk_2` FOREIGN KEY (`month_id`) REFERENCES `months_lkp` (`month_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `payment_details` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
