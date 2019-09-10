/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : dev

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-09-10 17:55:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `series` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `last_used` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('1', 'admin', 'aUdno3XMT3xrhHUJGVexbg==', 'WfnaoAKf2DXVb4Gnp0Kq6w==', '2019-09-10 17:36:43');
INSERT INTO `persistent_logins` VALUES ('2', 'admin', 'qIDSgDfVStoIxRMYnGdOLw==', 'HppQ1HEvOvL2w4jx6ssgUg==', '2019-09-10 17:44:56');
