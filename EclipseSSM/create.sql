DROP DATABASE IF EXISTS `student_database`;
CREATE DATABASE `student_database`;
USE `student_database`;
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `age` INT NOT NULL,
    `gender` VARCHAR(5) NOT NULL,
    `telephone` VARCHAR(30) NOT NULL,
    `email` VARCHAR(30) NOT NULL,
    `classId` INT NOT NULL,
    `createDate` DATE NOT NULL
)ENGINE = INNODB DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
)ENGINE = INNODB DEFAULT CHARSET=UTF8;

ALTER TABLE `student` ADD  CONSTRAINT FOREIGN KEY (`classId`)  REFERENCES `classes`(`id`) ;

INSERT INTO `classes` VALUES
(DEFAULT,'高三一班'),
(DEFAULT,'高三二班'),
(DEFAULT,'高三三班'),
(DEFAULT,'高三四班'),
(DEFAULT,'高三五班'),
(DEFAULT,'高三六班');

INSERT INTO `student` VALUES
(DEFAULT,'张三',18,'男','17820738113','ada@163.com',1,'2012-12-12'),
(DEFAULT,'李四',20,'男','16820738112','test@163.com',2,'2012-12-12'),
(DEFAULT,'赵六',30,'男','12820738212','adalllla@163.com',3,'2012-12-12'),
(DEFAULT,'李兰花',23,'女','13820738113','ada@163.com',4,'2012-12-12'),
(DEFAULT,'李敏',18,'女','18820738113','lilanhua@163.com',5,'2012-12-12');