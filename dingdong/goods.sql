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

 Date: 14/09/2020 18:37:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL,
  `price` double(255, 2) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  `m10` int(11) NULL DEFAULT NULL,
  `m13` int(11) NULL DEFAULT NULL,
  `m16` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 50.00, '叮咚礼盒50G', 10, 3, 3, 4);
INSERT INTO `goods` VALUES (2, 49.00, '叮咚巧克力', 10, 3, 3, 4);
INSERT INTO `goods` VALUES (3, 48.00, '叮咚苹果', 10, 3, 3, 4);

SET FOREIGN_KEY_CHECKS = 1;
