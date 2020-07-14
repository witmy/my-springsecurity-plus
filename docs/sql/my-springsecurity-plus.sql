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

 Date: 14/07/2020 17:25:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for my_menu
-- ----------------------------
DROP TABLE IF EXISTS `my_menu`;
CREATE TABLE `my_menu`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id值',
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
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_menu
-- ----------------------------
INSERT INTO `my_menu` VALUES (1, 0, '工作空间', 'layui-icon-console', '', '', 1, 1, '2020-07-13 20:14:26', '2020-07-14 14:38:28');
INSERT INTO `my_menu` VALUES (2, 1, '控制后台', 'layui-icon layui-icon-console', 'console/console1', NULL, 2, 1, '2020-07-13 20:19:02', '2020-07-13 20:19:08');
INSERT INTO `my_menu` VALUES (3, 0, '系统管理', 'layui-icon layui-icon-set-fill', '', '', 3, 1, '2020-07-10 09:33:00', '2020-07-12 21:03:22');
INSERT INTO `my_menu` VALUES (4, 3, '用户管理', 'layui-icon layui-icon-username', '/api/user/index', 'user:list', 4, 1, '2020-07-10 09:33:33', '2020-07-13 09:30:12');
INSERT INTO `my_menu` VALUES (5, 3, '角色管理', 'layui-icon layui-icon-user', '/api/role/index', 'role:list', 5, 1, '2020-07-10 09:34:17', '2020-07-10 09:34:20');
INSERT INTO `my_menu` VALUES (6, 3, '菜单管理', 'layui-icon layui-icon-vercode', '/api/menu/index', 'menu:list', 6, 1, '2020-07-10 09:34:50', '2020-07-10 09:34:53');
INSERT INTO `my_menu` VALUES (7, 0, '系统监控', 'layui-icon layui-icon-console', '', '', 7, 1, '2020-07-10 09:35:20', '2020-07-12 20:58:31');
INSERT INTO `my_menu` VALUES (8, 7, 'SQL监控', 'layui-icon layui-icon-chart', '/durid/login', NULL, 8, 1, '2020-07-10 09:35:50', '2020-07-10 09:35:53');
INSERT INTO `my_menu` VALUES (9, 7, '接口文档', 'layui-icon layui-icon-chart', '/swagger/index', NULL, 9, 1, '2020-07-10 09:36:11', '2020-07-12 20:04:57');
INSERT INTO `my_menu` VALUES (10, 0, '错误页面', 'layui-icon layui-icon-auz', NULL, NULL, 10, 1, '2020-07-14 13:31:16', '2020-07-14 13:31:24');
INSERT INTO `my_menu` VALUES (11, 10, '403', 'layui-icon layui-icon-face-smile', 'api/error/403', NULL, 11, 1, '2020-07-14 13:36:47', '2020-07-14 13:36:52');
INSERT INTO `my_menu` VALUES (12, 10, '404', 'layui-icon layui-icon-face-cry', 'api/error/404', NULL, 12, 1, '2020-07-14 13:37:22', '2020-07-14 13:37:25');
INSERT INTO `my_menu` VALUES (13, 10, '500', 'layui-icon layui-icon-face-cry', 'api/error/500', NULL, 13, 1, '2020-07-14 13:38:09', '2020-07-14 13:38:11');
INSERT INTO `my_menu` VALUES (14, 4, '用户新增', NULL, NULL, 'user:add', 4, 2, '2020-07-10 09:36:41', '2020-07-10 09:36:44');
INSERT INTO `my_menu` VALUES (15, 4, '用户编辑', NULL, NULL, 'user:edit', 4, 2, '2020-07-10 09:37:16', '2020-07-10 09:37:18');
INSERT INTO `my_menu` VALUES (16, 4, '用户删除', NULL, NULL, 'user:del', 4, 2, '2020-07-10 09:37:38', '2020-07-10 09:37:40');
INSERT INTO `my_menu` VALUES (17, 5, '角色新增', NULL, NULL, 'role:add', 5, 2, '2020-07-10 09:38:02', '2020-07-10 09:38:05');
INSERT INTO `my_menu` VALUES (18, 5, '角色编辑', NULL, NULL, 'role:edit', 5, 2, '2020-07-10 09:38:30', '2020-07-10 09:38:32');
INSERT INTO `my_menu` VALUES (19, 5, '角色删除', NULL, NULL, 'role:del', 5, 2, '2020-07-10 09:38:51', '2020-07-10 09:38:54');
INSERT INTO `my_menu` VALUES (20, 6, '菜单新增', NULL, NULL, 'meu:add', 6, 2, '2020-07-10 09:39:16', '2020-07-10 09:39:21');
INSERT INTO `my_menu` VALUES (21, 6, '菜单修改', NULL, NULL, 'menu:edit', 6, 2, '2020-07-10 09:39:46', '2020-07-10 09:39:48');
INSERT INTO `my_menu` VALUES (22, 6, '菜单删除', NULL, NULL, 'menu:del', 6, 2, '2020-07-10 09:40:08', '2020-07-10 09:40:10');

-- ----------------------------
-- Table structure for my_role
-- ----------------------------
DROP TABLE IF EXISTS `my_role`;
CREATE TABLE `my_role`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `status` int(1) NOT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_role
-- ----------------------------
INSERT INTO `my_role` VALUES (1, 'ADMIN', '超级管理员，拥有所有权限', 1, '2020-07-10 09:40:35', '2020-07-13 12:36:32');
INSERT INTO `my_role` VALUES (2, 'USER', '普通用户', 1, '2020-07-10 09:40:56', '2020-07-13 20:34:27');

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
INSERT INTO `my_role_menu` VALUES (1, 17);
INSERT INTO `my_role_menu` VALUES (1, 18);
INSERT INTO `my_role_menu` VALUES (2, 1);
INSERT INTO `my_role_menu` VALUES (2, 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_user
-- ----------------------------
INSERT INTO `my_user` VALUES (1, 'admin', '$2a$10$pAuzCLIe6Sl7kXfX6FEQ1uzM79V2njg.KtL9qawg9JkW7e1f417k2', '管理员', '13556336255', '1454564646@qq.com', 1, '2020-07-10 09:42:03', '2020-07-10 09:42:07');
INSERT INTO `my_user` VALUES (2, 'test', '$2a$10$pAuzCLIe6Sl7kXfX6FEQ1uzM79V2njg.KtL9qawg9JkW7e1f417k2', '测试用户', '13556336256', '1454564646@163.com', 1, '2020-07-10 09:42:09', '2020-07-13 17:49:49');
INSERT INTO `my_user` VALUES (3, 'test1', '$2a$10$exOfpFK2TNHnAdG/aaVTFeCDLihkg8JfD1qGWKjCOBdicxcQJax5W', '普通用户2', '13556336257', '1454564646@qq.com', 1, '2020-07-10 09:42:14', '2020-07-10 09:42:16');
INSERT INTO `my_user` VALUES (4, 'test2', 'e3ceb5881a0a1fdaad01296d7554868d', '普通用户3', '13556336258', '1454564646@qq.com', 1, '2020-07-10 09:42:19', '2020-07-10 09:42:21');
INSERT INTO `my_user` VALUES (5, 'test3', '1a100d2c0dab19c4430e7d73762b3423', '普通用户4', '13556336259', '1454564646@qq.com', 1, '2020-07-10 09:42:23', '2020-07-10 09:42:25');
INSERT INTO `my_user` VALUES (6, 'test4', '$2a$10$jNU1gXN.wAPhq5vUmLrCoeyDJbF3ReSnYQ2IulJA99drcMs1w1Som', '封禁用户', '13556336250', '1454564646@qq.com', 0, '2020-07-10 09:42:27', '2020-07-13 17:54:11');
INSERT INTO `my_user` VALUES (7, 'test5', '5b1b68a9abf4d2cd155c81a9225fd158', '封禁用户2', '13556336211', '1454564646@qq.com', 0, '2020-07-10 09:42:32', '2020-07-10 09:42:34');
INSERT INTO `my_user` VALUES (8, 'test7', 'e10adc3949ba59abbe56e057f20f883e', '测试修改', '13556336212', '1454564646@qq.com', 1, '2020-07-10 09:42:36', '2020-07-13 17:06:26');

SET FOREIGN_KEY_CHECKS = 1;
