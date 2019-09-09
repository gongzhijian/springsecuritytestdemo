/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : alpha

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2019-09-09 20:58:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL COMMENT '权限名',
  `description` varchar(255) default NULL COMMENT '描述',
  `url` varchar(255) default NULL COMMENT '地址',
  `pid` int(11) default NULL COMMENT '父级权限',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'ROLE_HOME', 'home', '/', null);
INSERT INTO `sys_permission` VALUES ('2', 'ROLE_ADMIN', 'ABel', '/admin', null);
INSERT INTO `sys_permission` VALUES ('3', 'PRODUCT_ADD', 'product_add', null, null);
