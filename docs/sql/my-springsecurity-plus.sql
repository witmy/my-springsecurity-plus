/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : my-springsecurity-plus

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 10/07/2020 13:10:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for my_menu
-- ----------------------------
DROP TABLE IF EXISTS `my_menu`;
CREATE TABLE `my_menu`  (
  `id` int(32) NOT NULL COMMENT 'id值',
  `parent_id` int(32) NOT NULL COMMENT '父级菜单id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `sort` int(12) NULL DEFAULT NULL COMMENT '排序',
  `type` tinyint(1) NOT NULL COMMENT '类型',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_menu
-- ----------------------------
INSERT INTO `my_menu` VALUES (1, 0, '系统管理', NULL, NULL, NULL, 1, 1, '2020-07-10 09:33:00', '2020-07-10 09:33:03');
INSERT INTO `my_menu` VALUES (2, 1, '用户管理', NULL, '/api/getPage?pageName=system/user/user-list', 'user:list', 2, 1, '2020-07-10 09:33:33', '2020-07-10 09:33:35');
INSERT INTO `my_menu` VALUES (3, 1, '角色管理', NULL, '/api/getPage?pageName=system/role/role-list', 'role:list', 3, 1, '2020-07-10 09:34:17', '2020-07-10 09:34:20');
INSERT INTO `my_menu` VALUES (4, 1, '菜单管理', NULL, '/api/getPage?pageName=system/permission/permission-list', 'menu:list', 4, 1, '2020-07-10 09:34:50', '2020-07-10 09:34:53');
INSERT INTO `my_menu` VALUES (5, 0, '其他管理', NULL, NULL, NULL, 5, 1, '2020-07-10 09:35:20', '2020-07-10 09:35:22');
INSERT INTO `my_menu` VALUES (6, 5, 'SQL监控', NULL, 'http://localhost:8080/druid/login.html', NULL, 6, 1, '2020-07-10 09:35:50', '2020-07-10 09:35:53');
INSERT INTO `my_menu` VALUES (7, 5, 'Swagger文档', NULL, 'http://localhost:8080/swagger-ui.html', NULL, 7, 1, '2020-07-10 09:36:11', '2020-07-10 09:36:13');
INSERT INTO `my_menu` VALUES (8, 2, '用户新增', NULL, NULL, 'user:add', 2, 2, '2020-07-10 09:36:41', '2020-07-10 09:36:44');
INSERT INTO `my_menu` VALUES (9, 2, '用户编辑', NULL, NULL, 'user:edit', 2, 2, '2020-07-10 09:37:16', '2020-07-10 09:37:18');
INSERT INTO `my_menu` VALUES (10, 2, '用户删除', NULL, NULL, 'user:del', 2, 2, '2020-07-10 09:37:38', '2020-07-10 09:37:40');
INSERT INTO `my_menu` VALUES (11, 3, '角色新增', NULL, NULL, 'role:add', 3, 2, '2020-07-10 09:38:02', '2020-07-10 09:38:05');
INSERT INTO `my_menu` VALUES (12, 3, '角色编辑', NULL, NULL, 'role:edit', 3, 2, '2020-07-10 09:38:30', '2020-07-10 09:38:32');
INSERT INTO `my_menu` VALUES (13, 3, '角色删除', NULL, NULL, 'role:del', 3, 2, '2020-07-10 09:38:51', '2020-07-10 09:38:54');
INSERT INTO `my_menu` VALUES (14, 4, '菜单新增', NULL, NULL, 'meu:add', 4, 2, '2020-07-10 09:39:16', '2020-07-10 09:39:21');
INSERT INTO `my_menu` VALUES (15, 4, '菜单修改', NULL, NULL, 'menu:edit', 4, 2, '2020-07-10 09:39:46', '2020-07-10 09:39:48');
INSERT INTO `my_menu` VALUES (16, 4, '菜单删除', NULL, NULL, 'menu:del', 4, 2, '2020-07-10 09:40:08', '2020-07-10 09:40:10');

-- ----------------------------
-- Table structure for my_role
-- ----------------------------
DROP TABLE IF EXISTS `my_role`;
CREATE TABLE `my_role`  (
  `id` int(32) NOT NULL COMMENT 'id值',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_role
-- ----------------------------
INSERT INTO `my_role` VALUES (1, 'ADMIN', '超级管理员，拥有所有权限', '2020-07-10 09:40:35', '2020-07-10 09:40:37');
INSERT INTO `my_role` VALUES (2, 'USER', '普通用户', '2020-07-10 09:40:56', '2020-07-10 09:40:59');

-- ----------------------------
-- Table structure for my_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `my_role_menu`;
CREATE TABLE `my_role_menu`  (
  `role_id` int(32) NOT NULL COMMENT '角色id',
  `menu_id` int(32) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_role_menu
-- ----------------------------
INSERT INTO `my_role_menu` VALUES (1, 1);
INSERT INTO `my_role_menu` VALUES (1, 2);
INSERT INTO `my_role_menu` VALUES (1, 3);
INSERT INTO `my_role_menu` VALUES (1, 4);
INSERT INTO `my_role_menu` VALUES (1, 5);
INSERT INTO `my_role_menu` VALUES (1, 6);
INSERT INTO `my_role_menu` VALUES (1, 7);
INSERT INTO `my_role_menu` VALUES (1, 8);
INSERT INTO `my_role_menu` VALUES (1, 9);
INSERT INTO `my_role_menu` VALUES (1, 10);
INSERT INTO `my_role_menu` VALUES (1, 11);
INSERT INTO `my_role_menu` VALUES (1, 12);
INSERT INTO `my_role_menu` VALUES (1, 13);
INSERT INTO `my_role_menu` VALUES (1, 14);
INSERT INTO `my_role_menu` VALUES (1, 15);
INSERT INTO `my_role_menu` VALUES (1, 16);
INSERT INTO `my_role_menu` VALUES (2, 1);
INSERT INTO `my_role_menu` VALUES (2, 2);
INSERT INTO `my_role_menu` VALUES (2, 3);
INSERT INTO `my_role_menu` VALUES (2, 4);
INSERT INTO `my_role_menu` VALUES (2, 5);
INSERT INTO `my_role_menu` VALUES (2, 6);
INSERT INTO `my_role_menu` VALUES (2, 7);

-- ----------------------------
-- Table structure for my_role_user
-- ----------------------------
DROP TABLE IF EXISTS `my_role_user`;
CREATE TABLE `my_role_user`  (
  `user_id` int(32) NOT NULL COMMENT '用户id',
  `role_id` int(32) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_role_user
-- ----------------------------
INSERT INTO `my_role_user` VALUES (1, 1);
INSERT INTO `my_role_user` VALUES (2, 2);
INSERT INTO `my_role_user` VALUES (3, 2);
INSERT INTO `my_role_user` VALUES (4, 2);
INSERT INTO `my_role_user` VALUES (5, 2);
INSERT INTO `my_role_user` VALUES (6, 2);
INSERT INTO `my_role_user` VALUES (7, 2);
INSERT INTO `my_role_user` VALUES (8, 2);

-- ----------------------------
-- Table structure for my_user
-- ----------------------------
DROP TABLE IF EXISTS `my_user`;
CREATE TABLE `my_user`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(1) NOT NULL COMMENT '状态',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_user
-- ----------------------------
INSERT INTO `my_user` VALUES (1, 'admin', '$2a$10$pAuzCLIe6Sl7kXfX6FEQ1uzM79V2njg.KtL9qawg9JkW7e1f417k2', '管理员', '13556336255', '1454564646@qq.com', 1, '2020-07-10 09:42:03', '2020-07-10 09:42:07');
INSERT INTO `my_user` VALUES (2, 'test', '$2a$10$pAuzCLIe6Sl7kXfX6FEQ1uzM79V2njg.KtL9qawg9JkW7e1f417k2', '普通用户', '13556336255', '1454564646@163.com', 1, '2020-07-10 09:42:09', '2020-07-10 09:42:11');
INSERT INTO `my_user` VALUES (3, 'test1', '$2a$10$exOfpFK2TNHnAdG/aaVTFeCDLihkg8JfD1qGWKjCOBdicxcQJax5W', '普通用户2', '13556336255', '1454564646@qq.com', 1, '2020-07-10 09:42:14', '2020-07-10 09:42:16');
INSERT INTO `my_user` VALUES (4, 'test2', 'e3ceb5881a0a1fdaad01296d7554868d', '普通用户3', '13556336255', '1454564646@qq.com', 1, '2020-07-10 09:42:19', '2020-07-10 09:42:21');
INSERT INTO `my_user` VALUES (5, 'test3', '1a100d2c0dab19c4430e7d73762b3423', '普通用户4', '13556336255', '1454564646@qq.com', 1, '2020-07-10 09:42:23', '2020-07-10 09:42:25');
INSERT INTO `my_user` VALUES (6, 'test4', '$2a$10$jNU1gXN.wAPhq5vUmLrCoeyDJbF3ReSnYQ2IulJA99drcMs1w1Som', '封禁用户', '13556336255', '1454564646@qq.com', 0, '2020-07-10 09:42:27', '2020-07-10 09:42:29');
INSERT INTO `my_user` VALUES (7, 'test5', '5b1b68a9abf4d2cd155c81a9225fd158', '封禁用户2', '13556336255', '1454564646@qq.com', 0, '2020-07-10 09:42:32', '2020-07-10 09:42:34');
INSERT INTO `my_user` VALUES (8, 'test7', 'e10adc3949ba59abbe56e057f20f883e', '测试添加', '13556336255', '1454564646@qq.com', 1, '2020-07-10 09:42:36', '2020-07-10 09:42:40');

SET FOREIGN_KEY_CHECKS = 1;
