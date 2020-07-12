/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : highsec_microservices_db

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for datainfo
-- ----------------------------
DROP TABLE IF EXISTS `datainfo`;
CREATE TABLE `datainfo`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `data_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据名称',
  `data_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据类型',
  `data_owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据所有者',
  `data_location` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据位置',
  `data_size` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据大小',
  `upload_time` datetime(0) NOT NULL COMMENT '数据上传时间',
  `data_level` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据级别',
  `data_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
