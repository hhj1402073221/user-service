/*
Navicat MySQL Data Transfer

Source Server         : Project
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : icode_msp_user

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-06-02 17:39:08
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `user` VALUES ('123456', '张三', 'e10adc3949ba59abbe56e057f20f883e', '763484619@qq.com', '15317946548', null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('admin', '李四', 'e10adc3949ba59abbe56e057f20f883e', '648134945@qq.com', '15346572541', null, null, null, '1', null, null, null);
