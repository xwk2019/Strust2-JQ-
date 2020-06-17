/*
SQLyog Enterprise v12.08 (32 bit)
MySQL - 5.6.41-log : Database - jq
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jq` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jq`;

/*Table structure for table `food` */

DROP TABLE IF EXISTS `food`;

CREATE TABLE `food` (
  `FoodNumber` char(30) DEFAULT NULL,
  `FoodName` char(30) DEFAULT NULL,
  `FoodPurchasePrice` char(30) DEFAULT NULL,
  `FoodSellingprice` char(30) DEFAULT NULL,
  `FoodPicture` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `food` */

insert  into `food`(`FoodNumber`,`FoodName`,`FoodPurchasePrice`,`FoodSellingprice`,`FoodPicture`) values ('1002','友臣蛋黄酥','10	','20','	img/food/food2.jpg'),('1003','百草味芒果干','15','30','img/food/food5.jpg'),('1004','蒙牛纯牛奶','20','40','img/food/food1.jpg'),('1005','六味丹','100','200','img/food/food4.jpg'),('1001','友臣肉松饼','12','15','	img/food/food3.jpg');

/*Table structure for table `inputfood` */

DROP TABLE IF EXISTS `inputfood`;

CREATE TABLE `inputfood` (
  `FoodEntryNum` char(30) DEFAULT NULL,
  `FoodNumber` char(30) DEFAULT NULL,
  `FoodName` char(30) DEFAULT NULL,
  `FoodPurchasePrice` char(30) DEFAULT NULL,
  `InNumber` char(30) DEFAULT NULL,
  `Cost` char(30) DEFAULT NULL,
  `Supplier` char(30) DEFAULT NULL,
  `Alltotal` char(30) DEFAULT NULL,
  `InDate` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `inputfood` */

insert  into `inputfood`(`FoodEntryNum`,`FoodNumber`,`FoodName`,`FoodPurchasePrice`,`InNumber`,`Cost`,`Supplier`,`Alltotal`,`InDate`) values ('I000001','1001','友臣肉松饼','12',NULL,'1200','友臣旗舰店','100','2019-05-28'),('I000002','1002','友臣蛋黄酥','10',NULL,'1500','友臣旗舰店','150','2019-05-28');

/*Table structure for table `outputfood` */

DROP TABLE IF EXISTS `outputfood`;

CREATE TABLE `outputfood` (
  `FoodEntryNum` char(30) DEFAULT NULL,
  `FoodNumber` char(30) DEFAULT NULL,
  `FoodName` char(30) DEFAULT NULL,
  `FoodPurchasePrice` char(30) DEFAULT NULL,
  `FoodSellingPrice` char(30) DEFAULT NULL,
  `OutNumber` char(30) DEFAULT NULL,
  `Profit` char(30) DEFAULT NULL,
  `Customer` char(30) DEFAULT NULL,
  `AllTotal` char(30) DEFAULT NULL,
  `OutDate` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `outputfood` */

insert  into `outputfood`(`FoodEntryNum`,`FoodNumber`,`FoodName`,`FoodPurchasePrice`,`FoodSellingPrice`,`OutNumber`,`Profit`,`Customer`,`AllTotal`,`OutDate`) values ('I000001','1001','友臣肉松饼','12','15',NULL,NULL,'李云零食店','100','2019-10-26'),('I000002','1002','友臣蛋黄酥','10','20',NULL,NULL,'李云零食店','150','2019-10-26');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` char(30) DEFAULT NULL,
  `userPass` char(30) DEFAULT NULL,
  `email` char(30) DEFAULT NULL,
  `role` char(30) DEFAULT NULL,
  `picture` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userId`,`userPass`,`email`,`role`,`picture`) values ('admin','123456','123@qq.com','admin','img/user/user2.jpg'),('abc','123456','123@qq.com','work','img/user/user2.jpg'),('123','123456','asd@qq.com',NULL,NULL),('asd','123456','123@qq.com',NULL,NULL),('12345','123456','asdas@qq.com','work',NULL),('123456','123456','asd@qq.com','work',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
