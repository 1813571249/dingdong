/*
 Navicat Premium Data Transfer

 Source Server         : read
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : dingdong

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 14/09/2020 18:36:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for desk
-- ----------------------------
DROP TABLE IF EXISTS `desk`;
CREATE TABLE `desk`  (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` int(11) NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of desk
-- ----------------------------
INSERT INTO `desk` VALUES ('root', '江西', 1, 1, '已完成');
INSERT INTO `desk` VALUES ('root', '武汉', 2, 1, '配送中');

SET FOREIGN_KEY_CHECKS = 1;
