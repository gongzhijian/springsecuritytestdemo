/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : alpha

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2019-09-09 20:58:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_role`;
CREATE TABLE `sys_permission_role` (
  `id` int(11) NOT NULL auto_increment,
  `role_id` int(11) default NULL,
  `permission_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission_role
-- ----------------------------
INSERT INTO `sys_permission_role` VALUES ('1', '1', '1');
INSERT INTO `sys_permission_role` VALUES ('2', '1', '2');
INSERT INTO `sys_permission_role` VALUES ('3', '2', '1');
INSERT INTO `sys_permission_role` VALUES ('4', '1', '3');
