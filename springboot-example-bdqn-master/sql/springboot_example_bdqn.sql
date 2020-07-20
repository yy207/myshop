/*
 Navicat Premium Data Transfer

 Source Server         : MySQL本机
 Source Server Type    : MySQL
 Source Server Version : 50519
 Source Host           : localhost:3306
 Source Schema         : springboot_example_bdqn

 Target Server Type    : MySQL
 Target Server Version : 50519
 File Encoding         : 65001

 Date: 03/07/2020 11:18:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_delete` int(255) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '开发', 0, '2020-07-01 00:00:00', '2020-07-01 00:00:00');
INSERT INTO `role` VALUES (2, '测试', 0, '2020-01-02 00:00:00', '2020-01-02 00:00:00');
INSERT INTO `role` VALUES (3, '运维', 0, '2020-03-03 00:00:00', '2020-03-03 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_czech_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `gender` int(255) NULL DEFAULT NULL COMMENT '性别(0女；1男)',
  `is_delete` int(255) NULL DEFAULT NULL COMMENT '是否逻辑删除(0不删除；1删除)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username_unique`(`username`) USING BTREE COMMENT '用户名唯一约束'
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Admin', '123456', 1, 0, '2020-06-29 00:00:00', '2020-06-29 00:00:00');
INSERT INTO `user` VALUES (2, 'Bob', '123456', 0, 0, '2020-05-10 00:00:00', '2020-05-10 00:00:00');
INSERT INTO `user` VALUES (3, 'Tom', '123456', 1, 0, '2020-04-18 00:00:00', '2020-04-18 00:00:00');
INSERT INTO `user` VALUES (4, 'Lynn', '123456', 0, 0, '2020-02-20 00:00:00', '2020-02-20 00:00:00');
INSERT INTO `user` VALUES (5, 'Alan', '123456', 1, 0, '2020-01-10 00:00:00', '2020-01-10 00:00:00');
INSERT INTO `user` VALUES (6, 'Alice', '123456', 0, 0, '2020-06-06 00:00:00', '2020-06-06 00:00:00');
INSERT INTO `user` VALUES (8, 'A1dmin', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `int` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  `id_delete` int(255) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`int`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1, 0, '2020-01-01 00:00:00', '2020-01-01 00:00:00');
INSERT INTO `user_role` VALUES (2, 1, 2, 0, '2020-01-01 00:00:00', '2020-01-01 00:00:00');
INSERT INTO `user_role` VALUES (3, 1, 3, 0, '2020-01-01 00:00:00', '2020-01-01 00:00:00');
INSERT INTO `user_role` VALUES (4, 2, 2, 0, '2020-01-01 00:00:00', '2020-01-01 00:00:00');
INSERT INTO `user_role` VALUES (5, 3, 3, 0, '2020-01-01 00:00:00', '2020-01-01 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
