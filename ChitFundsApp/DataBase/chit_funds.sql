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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `admin_details` */

insert  into `admin_details`(`admin_id`,`name`,`mobile_no`,`email_id`,`password`) values 
(23,'Naani','1111','abcd','abcd'),
(24,'Anand','2222','xyz','123'),
(25,'Chinnii','3333','qwer','234'),
(26,'Jimpak','8897876456','2345','abc'),
(27,'ananddddd','9939393948','aaccfff','qqqewe');

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `chits_details` */

insert  into `chits_details`(`chit_id`,`admin_id`,`chit_number`,`chit_nick_name`,`active_or_not`,`chit_started_month`,`no_of_months`,`no_of_members`) values 
(19,23,1,'naani','','012021',21,21),
(20,23,2,'chinni','','022021',21,21),
(21,23,3,'testtttt','','092020',20,21),
(22,23,3,'testtttt','','092020',20,21);

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `members_details` */

insert  into `members_details`(`member_id`,`chit_id`,`member_name`,`mobile_no`,`email_id`) values 
(6,19,'Jimak','9929292929','aaaa'),
(11,19,'Anand','9959626359','aaa'),
(12,19,'PawanKalyna','9959626359','pspk');

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
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `payment_details` */

insert  into `payment_details`(`payment_id`,`member_id`,`month_id`,`month_year`,`amount_paid`,`chit_drawn_or_not`) values 
(87,6,1,'012021',0,'\0'),
(88,6,2,'022021',0,'\0'),
(89,6,3,'032021',0,'\0'),
(90,6,4,'042021',0,'\0'),
(91,6,5,'052021',0,'\0'),
(92,6,6,'062021',0,'\0'),
(93,6,7,'072021',0,'\0'),
(94,6,8,'082021',0,'\0'),
(95,6,9,'092021',0,'\0'),
(96,6,10,'102021',0,'\0'),
(97,6,11,'112021',0,'\0'),
(98,6,12,'122021',0,'\0'),
(99,6,13,'012022',0,'\0'),
(100,6,14,'022022',0,'\0'),
(101,6,15,'032022',0,'\0'),
(102,6,16,'042022',0,'\0'),
(103,6,17,'052022',0,'\0'),
(104,6,18,'062022',5000,''),
(105,6,19,'072022',0,'\0'),
(106,6,20,'082022',0,'\0'),
(107,6,21,'092022',0,'\0'),
(108,11,1,'012021',0,'\0'),
(109,11,2,'022021',0,'\0'),
(110,11,3,'032021',0,'\0'),
(111,11,4,'042021',0,'\0'),
(112,11,5,'052021',0,'\0'),
(113,11,6,'062021',0,'\0'),
(114,11,7,'072021',0,'\0'),
(115,11,8,'082021',0,'\0'),
(116,11,9,'092021',0,'\0'),
(117,11,10,'102021',0,'\0'),
(118,11,11,'112021',0,'\0'),
(119,11,12,'122021',0,'\0'),
(120,11,13,'012022',0,'\0'),
(121,11,14,'022022',0,'\0'),
(122,11,15,'032022',0,'\0'),
(123,11,16,'042022',0,'\0'),
(124,11,17,'052022',0,'\0'),
(125,11,18,'062022',0,'\0'),
(126,11,19,'072022',0,'\0'),
(127,11,20,'082022',0,'\0'),
(128,11,21,'092022',0,'\0'),
(129,12,1,'012021',0,'\0'),
(130,12,2,'022021',0,'\0'),
(131,12,3,'032021',0,'\0'),
(132,12,4,'042021',0,'\0'),
(133,12,5,'052021',0,'\0'),
(134,12,6,'062021',0,'\0'),
(135,12,7,'072021',0,'\0'),
(136,12,8,'082021',0,'\0'),
(137,12,9,'092021',0,'\0'),
(138,12,10,'102021',0,'\0'),
(139,12,11,'112021',0,'\0'),
(140,12,12,'122021',0,'\0'),
(141,12,13,'012022',0,'\0'),
(142,12,14,'022022',5000,''),
(143,12,15,'032022',0,'\0'),
(144,12,16,'042022',0,'\0'),
(145,12,17,'052022',0,'\0'),
(146,12,18,'062022',0,'\0'),
(147,12,19,'072022',0,'\0'),
(148,12,20,'082022',0,'\0'),
(149,12,21,'092022',0,'\0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
