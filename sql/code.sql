/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50515
 Source Host           : localhost:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 50515
 File Encoding         : 65001

 Date: 07/08/2020 14:21:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for code
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `titles` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `explains` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `contents` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of code
-- ----------------------------
INSERT INTO `code` VALUES ('18', '哈哈哈', '不知道', '不知道', '001', '男', '柳州');
INSERT INTO `code` VALUES ('19', '不知道', '不知道', '不知道', '002', '男', '柳州');
INSERT INTO `code` VALUES ('21', '管理员', '管理员', '管理员', '004', '女', '柳州');
INSERT INTO `code` VALUES ('22', '管理员', '管理员', '管理员', '005', '女', '玉林');
INSERT INTO `code` VALUES ('24', '管理员', '管理员', '管理员', '007', '女', '桂林');
INSERT INTO `code` VALUES ('25', '员工', '员工', '员工', '008', '男', '桂林');
INSERT INTO `code` VALUES ('26', '员工', '员工', '员工', '009', '男', '桂林');
INSERT INTO `code` VALUES ('27', '员工', '员工', '员工', '010', '女', '桂林');
INSERT INTO `code` VALUES ('28', '员工', '员工', '员工', '011', '女', '桂林');
INSERT INTO `code` VALUES ('29', '员工', '员工', '员工', '012', '女', '玉林');
INSERT INTO `code` VALUES ('30', '超级管理员', '超级管理员', '超级管理员', 'admin', '女', '玉林');
INSERT INTO `code` VALUES ('33', '员工', '员工', '员工', '013', '男', '桂林');
INSERT INTO `code` VALUES ('34', '员工', '员工', '员工', '014', '女', '桂林');

SET FOREIGN_KEY_CHECKS = 1;
