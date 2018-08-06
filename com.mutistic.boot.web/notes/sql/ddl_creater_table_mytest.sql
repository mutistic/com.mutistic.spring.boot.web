/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50716
Source Host           : 127.0.0.1:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-07-31 11:23:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mytest
-- ----------------------------
DROP TABLE IF EXISTS `mytest`;
CREATE TABLE `mytest` (
  `id_` bigint(10) DEFAULT NULL COMMENT '学生ID',
  `name_` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '学生姓名'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mytest
-- ----------------------------
