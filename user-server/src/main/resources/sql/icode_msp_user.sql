/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : icode_usermanage_sevice

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-11-20 17:31:12
*/

SET FOREIGN_KEY_CHECKS=0;


create database icode_msp_user;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `account` varchar(50) NOT NULL COMMENT '账号',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `tel` varchar(11) DEFAULT NULL COMMENT '电话',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `head_portrait` varchar(255) DEFAULT NULL COMMENT '头像路径',
  `level` smallint(6) DEFAULT NULL COMMENT '类似于游戏等级',
  `state` tinyint(4) DEFAULT NULL COMMENT '账号状态（0-正常，1-封号）',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别（0-男，1-女，2-其他）',
  `remark` text COMMENT '备注（保留字段）',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近登陆时间',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123456', 'Abc', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('1234561', 'Almare', '123456', '1362574001@qq.com', '13101303532', '2018-11-15 22:25:33', 'https://www.baidu.com/asdfasdf.jpg', '100', '0', '0', null, '2018-11-30 22:25:47');

