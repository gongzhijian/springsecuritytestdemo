/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : alpha

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2019-09-09 20:57:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL COMMENT '用户名',
  `password` varchar(255) default NULL COMMENT '密码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin');
INSERT INTO `sys_user` VALUES ('2', 'abel', 'abel');
