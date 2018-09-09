/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.62-community 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user` (
	`id` int ,
	`name` varchar ,
	`age` int ,
	`pwd` varchar ,
	`createtime` timestamp ,
	`updatetime` date 
); 
insert into `user` (`id`, `name`, `age`, `pwd`, `createtime`, `updatetime`) values('1','吴永茂','27','root','2018-06-11 21:20:00',NULL);
