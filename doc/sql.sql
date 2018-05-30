/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.17-log : Database - lingshi_fitnessroom
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lingshi_fitnessroom` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lingshi_fitnessroom`;

/*Table structure for table `courses` */

DROP TABLE IF EXISTS `courses`;

CREATE TABLE `courses` (
  `courseId` varchar(20) NOT NULL COMMENT '课程编号',
  `courseName` varchar(20) NOT NULL DEFAULT '' COMMENT '课程名称',
  `courseContent` varchar(100) NOT NULL DEFAULT '' COMMENT '课程内容',
  `courseTotalTime` float NOT NULL DEFAULT '0' COMMENT '课程总课时',
  `courseTime` float NOT NULL DEFAULT '0' COMMENT '课程平均课时',
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `courses` */

insert  into `courses`(`courseId`,`courseName`,`courseContent`,`courseTotalTime`,`courseTime`) values ('C17513355979913','体育','语文老师也能教体育哦',150,1),('C29113354441812','无氧运动','111',0,0),('C56713344168710','瑜伽','对没错，我就是瑜伽',0,0),('C61713362070814','动感单车','111',0,0),('C88913352281011','有氧运动','33',0,0);

/*Table structure for table `equipments` */

DROP TABLE IF EXISTS `equipments`;

CREATE TABLE `equipments` (
  `equipmentId` varchar(20) NOT NULL COMMENT '设备编号',
  `equipmentName` varchar(20) NOT NULL DEFAULT '' COMMENT '设备名称',
  `equipmentContent` varchar(100) NOT NULL DEFAULT '' COMMENT '设备描述',
  `equipmentCount` int(11) NOT NULL DEFAULT '1' COMMENT '设备数量',
  PRIMARY KEY (`equipmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `equipments` */

insert  into `equipments`(`equipmentId`,`equipmentName`,`equipmentContent`,`equipmentCount`) values ('E20311282598812','跑步机','啦啦啦，摔死你~~',3),('E57711290013213','不知道什么鬼','没有去健身，我哪知道还有什么设备',1),('E64811280866311','瑜伽球','我是个球',1),('E88011292031514','哑铃','我有两个球哦',1);

/*Table structure for table `expectcourse` */

DROP TABLE IF EXISTS `expectcourse`;

CREATE TABLE `expectcourse` (
  `expectCourseId` varchar(50) NOT NULL COMMENT '主键',
  `userId` varchar(50) NOT NULL COMMENT '用户编号',
  `courseId` varchar(50) NOT NULL COMMENT '课程编号',
  `note` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`expectCourseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `expectcourse` */

insert  into `expectcourse`(`expectCourseId`,`userId`,`courseId`,`note`) values ('E96716560973310','U87116060112117','C29113354441812','周五下午才有空'),('U74022374534210','U74022374534210','C29113354441812','');

/*Table structure for table `expectfoods` */

DROP TABLE IF EXISTS `expectfoods`;

CREATE TABLE `expectfoods` (
  `expectFoodId` varchar(50) NOT NULL COMMENT '主键',
  `userId` varchar(50) NOT NULL COMMENT '预约用户编号',
  `foodId` varchar(50) NOT NULL COMMENT '预约食品',
  `expectFoodTime` datetime NOT NULL DEFAULT '2014-01-01 00:00:00' COMMENT '预约时间',
  `note` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`expectFoodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `expectfoods` */

insert  into `expectfoods`(`expectFoodId`,`userId`,`foodId`,`expectFoodTime`,`note`) values ('LG15714270798110','U87116060112117','LG19310293459818','2018-05-30 14:27:01','下午就要'),('LG19213350822413','U87116060112117','LG19310293459818','2018-05-29 00:00:00','拉拉'),('LG45213364687114','U87116060112117','LG83510292535017','2018-05-31 00:00:00','我预约了2分量'),('LG47113341617312','U87116060112117','LG83510292535017','2018-05-31 13:34:13','拉拉');

/*Table structure for table `foods` */

DROP TABLE IF EXISTS `foods`;

CREATE TABLE `foods` (
  `foodId` varchar(50) NOT NULL COMMENT '主键',
  `foodName` varchar(50) NOT NULL DEFAULT '' COMMENT '健身餐名称',
  `foodContent` varchar(200) NOT NULL DEFAULT '' COMMENT '健身餐描述',
  `foodImgUrl` varchar(200) NOT NULL DEFAULT '' COMMENT '健身餐预览图',
  `foodPrice` float NOT NULL DEFAULT '0' COMMENT '健身餐价格',
  PRIMARY KEY (`foodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `foods` */

insert  into `foods`(`foodId`,`foodName`,`foodContent`,`foodImgUrl`,`foodPrice`) values ('LG19310293459818','色拉2','我是色拉2','',20),('LG83510292535017','色拉1','我是色拉','',10);

/*Table structure for table `notices` */

DROP TABLE IF EXISTS `notices`;

CREATE TABLE `notices` (
  `noticeId` varchar(50) NOT NULL COMMENT '编号',
  `noticeTitle` varchar(100) NOT NULL DEFAULT '' COMMENT '标题',
  `noticeContent` text NOT NULL COMMENT '内容',
  `noticeTime` datetime NOT NULL DEFAULT '2014-01-01 00:00:00' COMMENT '通知时间',
  PRIMARY KEY (`noticeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `notices` */

insert  into `notices`(`noticeId`,`noticeTitle`,`noticeContent`,`noticeTime`) values ('N64617414265011','测试通知','123<img src=\"http://localhost:8091/WebContent/Contents/lib/layui/images/face/0.gif\" alt=\"[微笑]\">','2018-05-10 17:41:43');

/*Table structure for table `teacherevaluates` */

DROP TABLE IF EXISTS `teacherevaluates`;

CREATE TABLE `teacherevaluates` (
  `teacherevaluateId` varchar(50) NOT NULL COMMENT '编号',
  `teacherId` varchar(50) NOT NULL COMMENT '教师编号',
  `userId` varchar(50) NOT NULL COMMENT '用户编号',
  `teacherScore` int(11) NOT NULL DEFAULT '0' COMMENT '教师评分 -1差评 1一般 2满意',
  `teacherevaluateTime` datetime NOT NULL COMMENT '评价时间',
  PRIMARY KEY (`teacherevaluateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacherevaluates` */

insert  into `teacherevaluates`(`teacherevaluateId`,`teacherId`,`userId`,`teacherScore`,`teacherevaluateTime`) values ('LG17615122567211','U13219594622111','U87116060112117',2,'2018-05-10 15:12:26'),('LG38615123421912','U43520002528213','U87116060112117',1,'2018-05-10 15:12:34'),('LG68315123996313','U95220011637215','U87116060112117',1,'2018-05-10 15:12:40');

/*Table structure for table `teachers` */

DROP TABLE IF EXISTS `teachers`;

CREATE TABLE `teachers` (
  `teacherId` varchar(20) NOT NULL COMMENT '教练编号',
  `teacherName` varchar(20) NOT NULL COMMENT '教练名称',
  `teacherSex` int(11) NOT NULL DEFAULT '0' COMMENT '教练性别',
  `teacherBirthday` date NOT NULL DEFAULT '2014-01-01' COMMENT '教练生日',
  `teacherHeadUrl` varchar(100) NOT NULL COMMENT '教练头像',
  `teacherContent` varchar(100) NOT NULL DEFAULT '' COMMENT '教练描述',
  `teacherPhone` varchar(20) NOT NULL DEFAULT '' COMMENT '联系方式',
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teachers` */

insert  into `teachers`(`teacherId`,`teacherName`,`teacherSex`,`teacherBirthday`,`teacherHeadUrl`,`teacherContent`,`teacherPhone`) values ('U13219594622111','火腿肠',1,'2018-02-24','/Uploadfile/teacherheads/LG62815555072310.png','我是火腿肠教练，擅长打人','123456'),('U43520002528213','大香肠',1,'2018-02-24','/Uploadfile/teacherheads/LG32215555986011.png','我是大香肠教练，我擅长踢人，火腿肠是我弟弟','123456'),('U95220011637215','开花肠',0,'2018-02-24','/Uploadfile/teacherheads/LG64415560743112.png','我是开花肠，我会卖萌','123456');

/*Table structure for table `usercourses` */

DROP TABLE IF EXISTS `usercourses`;

CREATE TABLE `usercourses` (
  `userCourseId` varchar(20) NOT NULL COMMENT '用户课程编号',
  `courseId` varchar(20) NOT NULL DEFAULT '' COMMENT '课程编号',
  `userId` varchar(20) NOT NULL DEFAULT '' COMMENT '用户编号',
  `teacherId` varchar(20) NOT NULL DEFAULT '' COMMENT '教师编号',
  `equipmentId` varchar(20) NOT NULL DEFAULT '' COMMENT '设备编号',
  `userCoursePoints` varchar(1000) NOT NULL DEFAULT '' COMMENT '课程安排',
  `userCourseEndTime` date NOT NULL COMMENT '课程结束时间',
  `userCourseBeginTime` date NOT NULL COMMENT '课程开始时间',
  PRIMARY KEY (`userCourseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usercourses` */

insert  into `usercourses`(`userCourseId`,`courseId`,`userId`,`teacherId`,`equipmentId`,`userCoursePoints`,`userCourseEndTime`,`userCourseBeginTime`) values ('U11416065559029','C56713344168710','U87116060112117','','','[3,4]','2019-02-26','2018-02-26'),('U11616065559023','C17513355979913','U87116060112117','','','[0,1]','2019-02-26','2018-02-26'),('U33116065559027','C29113354441812','U87116060112117','','','[2,3]','2019-02-26','2018-02-26'),('U37216065559030','C17513355979913','U87116060112117','','','[3,6]','2019-02-26','2018-02-26'),('U51216065559024','C61713362070814','U87116060112117','','','[1,2]','2019-02-26','2018-02-26'),('U54816065559025','C56713344168710','U87116060112117','','','[1,6]','2019-02-26','2018-02-26'),('U60816065559028','C29113354441812','U87116060112117','','','[2,5]','2019-02-26','2018-02-26'),('U85416065559026','C88913352281011','U87116060112117','','','[2,0]','2019-02-26','2018-02-26'),('U95516065559031','C88913352281011','U87116060112117','','','[4,1]','2019-02-26','2018-02-26'),('U97715592306711','C88913352281011','U74022374534210','','','[1,1]','2018-06-08','2018-05-08');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userId` varchar(20) NOT NULL COMMENT '用户编号',
  `userName` varchar(20) NOT NULL COMMENT '用户名',
  `headImgUrl` varchar(100) NOT NULL DEFAULT '' COMMENT '用户头像',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `sex` int(11) NOT NULL DEFAULT '0' COMMENT '性别 0女 1男',
  `realName` varchar(20) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `birthday` date NOT NULL DEFAULT '2014-01-01' COMMENT '生日',
  `userType` int(11) NOT NULL DEFAULT '1' COMMENT '-1管理员 1会员',
  `createTime` datetime NOT NULL DEFAULT '2014-01-01 00:00:00' COMMENT '创建时间',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '联系方式',
  `note` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`userId`,`userName`,`headImgUrl`,`password`,`sex`,`realName`,`birthday`,`userType`,`createTime`,`phone`,`note`) values ('U00001','admin','/Uploadfile/userheads/LG56015561606213.png','C4CA4238A0B923820DCC509A6F75849B',1,'管理员','2013-11-01',-1,'2014-01-01 00:00:00','17605036258',''),('U74022374534210','123457','','202CB962AC59075B964B07152D234B70',0,'蔡蔡','2018-04-27',1,'2018-04-27 22:37:45','123',''),('U87116060112117','123456','','202CB962AC59075B964B07152D234B70',1,'小菜','2018-02-23',1,'2018-02-23 16:06:01','123456','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
