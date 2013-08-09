/*
SQLyog Trial v11.01 (32 bit)
MySQL - 5.1.42-community : Database - taskhousekeeper
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`taskhousekeeper` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `taskhousekeeper`;

/*Table structure for table `userdata` */

DROP TABLE IF EXISTS `userdata`;

CREATE TABLE `userdata` (
  `uname` varchar(20) NOT NULL,
  `utime` varchar(20) NOT NULL,
  `udata` blob,
  PRIMARY KEY (`utime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userdata` */

insert  into `userdata`(`uname`,`utime`,`udata`) values ('xurong','2013-08-07','how are you?'),('copy1','2013-08-08','weixin ai feiji'),('xurong','2013-08-09','how are you?');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `uid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) NOT NULL,
  `upass` varchar(20) NOT NULL,
  PRIMARY KEY (`uid`,`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`uid`,`uname`,`upass`) values (0000000001,'xurong','123456'),(0000000002,'admin','admin'),(0000000003,'copy1','copy1'),(0000000004,'copy2','copy2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
