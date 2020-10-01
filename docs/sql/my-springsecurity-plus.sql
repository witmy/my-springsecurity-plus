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

 Date: 01/10/2020 15:00:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for my_dept
-- ----------------------------
DROP TABLE IF EXISTS `my_dept`;
CREATE TABLE `my_dept`  (
  `dept_id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `parent_id` int(32) NULL DEFAULT NULL COMMENT '上级部门',
  `ancestors` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '祖级列表',
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `sort` int(5) NULL DEFAULT NULL COMMENT '排序',
  `status` bit(1) NOT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_dept
-- ----------------------------
INSERT INTO `my_dept` VALUES (1, 0, '0', '南京总公司', 1, b'1', '2020-08-19 11:01:09', '2020-09-08 18:21:26');
INSERT INTO `my_dept` VALUES (2, 1, '0,1', '研发部门', 1, b'1', '2020-08-19 11:01:28', '2020-08-19 11:01:30');
INSERT INTO `my_dept` VALUES (3, 1, '0,1', '市场部门', 2, b'1', '2020-08-19 11:01:47', '2020-08-19 11:01:48');
INSERT INTO `my_dept` VALUES (4, 1, '0,1', '运维部门', 3, b'1', '2020-08-19 11:02:01', '2020-08-19 11:02:04');
INSERT INTO `my_dept` VALUES (5, 0, '0', '苏州分公司', 2, b'1', '2020-08-19 11:07:36', '2020-08-27 14:18:48');
INSERT INTO `my_dept` VALUES (6, 5, '0,5', '营销部门', 1, b'1', '2020-08-19 11:08:40', '2020-08-21 20:32:40');
INSERT INTO `my_dept` VALUES (7, 5, '0,5', '运维部门', 2, b'1', '2020-08-19 11:08:56', '2020-09-08 18:03:56');

-- ----------------------------
-- Table structure for my_job
-- ----------------------------
DROP TABLE IF EXISTS `my_job`;
CREATE TABLE `my_job`  (
  `job_id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `job_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '岗位状态',
  `sort` int(5) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_job
-- ----------------------------
INSERT INTO `my_job` VALUES (1, '部门经理', 1, 1, '2020-08-19 11:14:55', '2020-08-19 11:14:57');
INSERT INTO `my_job` VALUES (2, '人事专员', 1, 2, '2020-08-19 11:15:30', '2020-08-19 11:15:33');
INSERT INTO `my_job` VALUES (3, '普通员工', 1, 3, '2020-08-19 11:16:19', '2020-09-02 10:48:34');

-- ----------------------------
-- Table structure for my_log
-- ----------------------------
DROP TABLE IF EXISTS `my_log`;
CREATE TABLE `my_log`  (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求ip',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述',
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数值',
  `browser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  `time` bigint(20) NULL DEFAULT NULL COMMENT '执行时间',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志类型',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行方法',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `exception_detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '异常详细信息',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2626 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_log
-- ----------------------------
INSERT INTO `my_log` VALUES (2626, 'admin', '127.0.0.1', '绘制部门树', '{ deptDto: DeptDto(id=null, parentId=null, checkArr=0, title=null) }', 'Chrome 8', 10, 'INFO', 'com.codermy.myspringsecurityplus.admin.controller.DeptController.buildDeptAll()', '2020-10-01 14:57:48', NULL);
INSERT INTO `my_log` VALUES (2627, 'admin', '127.0.0.1', '查询用户', '{ pageTableRequest: PageTableRequest(page=1, limit=10, offset=0) myUser: MyUser(userId=null, deptId=null, userName=null, password=null, nickName=null, phone=null, email=null, status=null, roleId=null, jobIds=null) }', 'Chrome 8', 13, 'INFO', 'com.codermy.myspringsecurityplus.admin.controller.UserController.userList()', '2020-10-01 14:57:48', NULL);
INSERT INTO `my_log` VALUES (2628, 'admin', '127.0.0.1', '查询岗位', '{ pageTableRequest: PageTableRequest(page=1, limit=10, offset=0) jobQueryDto: JobQueryDto(queryName=null, queryStatus=null) }', 'Chrome 8', 5, 'INFO', 'com.codermy.myspringsecurityplus.admin.controller.JobController.getJobAll()', '2020-10-01 14:58:46', NULL);

-- ----------------------------
-- Table structure for my_menu
-- ----------------------------
DROP TABLE IF EXISTS `my_menu`;
CREATE TABLE `my_menu`  (
  `menu_id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `parent_id` int(32) NOT NULL COMMENT '父级菜单id',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `sort` int(12) NULL DEFAULT NULL COMMENT '排序',
  `type` tinyint(1) NOT NULL COMMENT '类型',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_menu
-- ----------------------------
INSERT INTO `my_menu` VALUES (1, 0, '工作空间', 'layui-icon layui-icon-console', '', '', 1, 0, '2020-07-13 20:14:26', '2020-07-14 14:38:28');
INSERT INTO `my_menu` VALUES (2, 1, '控制后台', 'layui-icon layui-icon-console', '/api/console', '', 2, 1, '2020-07-13 20:19:02', '2020-07-13 20:19:08');
INSERT INTO `my_menu` VALUES (3, 0, '系统管理', 'layui-icon layui-icon-set-fill', '', '', 3, 0, '2020-07-10 09:33:00', '2020-07-12 21:03:22');
INSERT INTO `my_menu` VALUES (4, 3, '用户管理', 'layui-icon layui-icon-username', '/api/user/index', 'user:list', 4, 1, '2020-07-10 09:33:33', '2020-07-13 09:30:12');
INSERT INTO `my_menu` VALUES (5, 3, '角色管理', 'layui-icon layui-icon-user', '/api/role/index', 'role:list', 5, 1, '2020-07-10 09:34:17', '2020-07-10 09:34:20');
INSERT INTO `my_menu` VALUES (6, 3, '菜单管理', 'layui-icon layui-icon-vercode', '/api/menu/index', 'menu:list', 6, 1, '2020-07-10 09:34:50', '2020-07-10 09:34:53');
INSERT INTO `my_menu` VALUES (7, 0, '系统监控', 'layui-icon layui-icon-console', '', '', 7, 0, '2020-07-10 09:35:20', '2020-07-12 20:58:31');
INSERT INTO `my_menu` VALUES (8, 7, 'SQL监控', 'layui-icon layui-icon-chart', '/druid/login', '', 8, 1, '2020-07-10 09:35:50', '2020-07-10 09:35:53');
INSERT INTO `my_menu` VALUES (9, 7, '接口文档', 'layui-icon layui-icon-chart', '/swagger-ui.html', NULL, 9, 1, '2020-07-10 09:36:11', '2020-07-12 20:04:57');
INSERT INTO `my_menu` VALUES (10, 0, '错误页面', 'layui-icon layui-icon-auz', NULL, NULL, 10, 0, '2020-07-14 13:31:16', '2020-07-14 13:31:24');
INSERT INTO `my_menu` VALUES (11, 10, '403', 'layui-icon layui-icon layui-icon-face-cry', '/api/403', '', 11, 1, '2020-07-14 13:36:47', '2020-08-23 12:05:38');
INSERT INTO `my_menu` VALUES (12, 10, '404', 'layui-icon layui-icon-face-cry', '/api/404', NULL, 12, 1, '2020-07-14 13:37:22', '2020-07-14 13:37:25');
INSERT INTO `my_menu` VALUES (13, 10, '500', 'layui-icon layui-icon layui-icon layui-icon layui-icon layui-icon layui-icon-face-cry', '/api/500', '', 13, 1, '2020-07-14 13:38:09', '2020-08-27 14:59:07');
INSERT INTO `my_menu` VALUES (14, 4, '用户新增', NULL, NULL, 'user:add', 4, 2, '2020-07-10 09:36:41', '2020-07-10 09:36:44');
INSERT INTO `my_menu` VALUES (15, 4, '用户编辑', NULL, NULL, 'user:edit', 4, 2, '2020-07-10 09:37:16', '2020-07-10 09:37:18');
INSERT INTO `my_menu` VALUES (16, 4, '用户删除', NULL, NULL, 'user:del', 4, 2, '2020-07-10 09:37:38', '2020-07-10 09:37:40');
INSERT INTO `my_menu` VALUES (17, 5, '角色新增', NULL, NULL, 'role:add', 5, 2, '2020-07-10 09:38:02', '2020-07-10 09:38:05');
INSERT INTO `my_menu` VALUES (18, 5, '角色编辑', NULL, NULL, 'role:edit', 5, 2, '2020-07-10 09:38:30', '2020-07-10 09:38:32');
INSERT INTO `my_menu` VALUES (19, 5, '角色删除', NULL, NULL, 'role:del', 5, 2, '2020-07-10 09:38:51', '2020-07-10 09:38:54');
INSERT INTO `my_menu` VALUES (20, 6, '菜单新增', NULL, NULL, 'menu:add', 6, 2, '2020-07-10 09:39:16', '2020-07-10 09:39:21');
INSERT INTO `my_menu` VALUES (21, 6, '菜单修改', NULL, NULL, 'menu:edit', 6, 2, '2020-07-10 09:39:46', '2020-07-10 09:39:48');
INSERT INTO `my_menu` VALUES (22, 6, '菜单删除', NULL, NULL, 'menu:del', 6, 2, '2020-07-10 09:40:08', '2020-07-10 09:40:10');
INSERT INTO `my_menu` VALUES (35, 7, '操作日志', 'layui-icon-group', '/api/log/index', 'log:list', 7, 1, '2020-08-04 11:38:45', '2020-08-04 11:38:58');
INSERT INTO `my_menu` VALUES (36, 7, '异常日志', 'layui-icon-face-cry', '/api/log/error/index', 'errorLog:list', 7, 1, '2020-08-04 11:42:22', '2020-08-04 11:42:22');
INSERT INTO `my_menu` VALUES (66, 35, '日志删除', 'layui-icon ', '', 'log:del', 7, 2, '2020-08-09 15:16:03', '2020-08-09 15:16:03');
INSERT INTO `my_menu` VALUES (67, 36, '异常日志删除', 'layui-icon layui-icon layui-icon ', '', 'errorLog:del', 7, 2, '2020-08-09 15:16:30', '2020-08-09 15:16:59');
INSERT INTO `my_menu` VALUES (68, 3, '部门管理', 'layui-icon layui-icon layui-icon layui-icon-group', '/api/dept/index', 'dept:list', 7, 1, '2020-08-19 15:03:27', '2020-08-23 16:34:51');
INSERT INTO `my_menu` VALUES (69, 3, '岗位管理', 'layui-icon layui-icon layui-icon layui-icon-group', '/api/job/index', 'job:list', 8, 1, '2020-08-19 16:31:46', '2020-08-23 16:32:14');
INSERT INTO `my_menu` VALUES (70, 0, '系统工具', 'layui-icon layui-icon layui-icon-app', '', '', 8, 0, '2020-08-19 18:43:13', '2020-08-20 11:43:19');
INSERT INTO `my_menu` VALUES (71, 70, '定时任务', 'layui-icon layui-icon-play', '/api/quartz/index', '', 9, 1, '2020-08-21 09:17:54', '2020-08-21 09:20:37');
INSERT INTO `my_menu` VALUES (75, 69, '岗位新增', 'layui-icon ', '', 'job:add', 9, 2, '2020-08-23 16:32:59', '2020-08-23 16:32:59');
INSERT INTO `my_menu` VALUES (76, 69, '岗位修改', 'layui-icon ', '', 'job:edit', 10, 2, '2020-08-23 16:33:36', '2020-08-23 16:33:36');
INSERT INTO `my_menu` VALUES (77, 69, '岗位删除', 'layui-icon ', '', 'job:del', 10, 2, '2020-08-23 16:34:08', '2020-08-23 16:34:08');
INSERT INTO `my_menu` VALUES (78, 68, '部门新增', 'layui-icon ', '', 'dept:add', 8, 2, '2020-08-23 16:34:39', '2020-08-23 16:34:39');
INSERT INTO `my_menu` VALUES (79, 68, '部门修改', 'layui-icon ', '', 'dept:edit', 9, 2, '2020-08-23 16:35:18', '2020-08-23 16:35:18');
INSERT INTO `my_menu` VALUES (80, 68, '部门删除', 'layui-icon ', '', 'dept:del', 10, 2, '2020-08-23 16:35:41', '2020-08-23 16:35:41');
INSERT INTO `my_menu` VALUES (81, 7, '在线用户', 'layui-icon layui-icon layui-icon layui-icon-username', '/api/online/index', '', 7, 1, '2020-08-26 14:34:16', '2020-08-26 14:38:16');
INSERT INTO `my_menu` VALUES (82, 70, '代码生成', 'layui-icon layui-icon layui-icon-fonts-code', '/api/generator/index', '', 10, 1, '2020-08-26 14:35:10', '2020-08-26 14:37:56');
INSERT INTO `my_menu` VALUES (85, 70, '表单构建', 'layui-icon layui-icon-fire', '/api/form/build', '', 11, 1, '2020-10-01 13:20:34', '2020-10-01 13:20:45');

-- ----------------------------
-- Table structure for my_role
-- ----------------------------
DROP TABLE IF EXISTS `my_role`;
CREATE TABLE `my_role`  (
  `role_id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `data_scope` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_role
-- ----------------------------
INSERT INTO `my_role` VALUES (1, 'ADMIN', '超级管理员，拥有所有权限', '2020-07-10 09:40:35', '2020-10-01 14:52:39', '1');
INSERT INTO `my_role` VALUES (2, 'USER', '普通用户', '2020-07-10 09:40:56', '2020-08-27 14:00:13', '2');

-- ----------------------------
-- Table structure for my_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `my_role_dept`;
CREATE TABLE `my_role_dept`  (
  `role_id` int(32) NOT NULL COMMENT '角色id',
  `dept_id` int(32) NOT NULL COMMENT '部门id',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_role_dept
-- ----------------------------
INSERT INTO `my_role_dept` VALUES (2, 5);
INSERT INTO `my_role_dept` VALUES (2, 6);
INSERT INTO `my_role_dept` VALUES (2, 7);

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
INSERT INTO `my_role_menu` VALUES (1, 19);
INSERT INTO `my_role_menu` VALUES (1, 20);
INSERT INTO `my_role_menu` VALUES (1, 21);
INSERT INTO `my_role_menu` VALUES (1, 22);
INSERT INTO `my_role_menu` VALUES (1, 35);
INSERT INTO `my_role_menu` VALUES (1, 36);
INSERT INTO `my_role_menu` VALUES (1, 66);
INSERT INTO `my_role_menu` VALUES (1, 67);
INSERT INTO `my_role_menu` VALUES (1, 68);
INSERT INTO `my_role_menu` VALUES (1, 69);
INSERT INTO `my_role_menu` VALUES (1, 70);
INSERT INTO `my_role_menu` VALUES (1, 71);
INSERT INTO `my_role_menu` VALUES (1, 75);
INSERT INTO `my_role_menu` VALUES (1, 76);
INSERT INTO `my_role_menu` VALUES (1, 77);
INSERT INTO `my_role_menu` VALUES (1, 78);
INSERT INTO `my_role_menu` VALUES (1, 79);
INSERT INTO `my_role_menu` VALUES (1, 80);
INSERT INTO `my_role_menu` VALUES (1, 81);
INSERT INTO `my_role_menu` VALUES (1, 82);
INSERT INTO `my_role_menu` VALUES (1, 85);
INSERT INTO `my_role_menu` VALUES (2, 1);
INSERT INTO `my_role_menu` VALUES (2, 2);
INSERT INTO `my_role_menu` VALUES (2, 3);
INSERT INTO `my_role_menu` VALUES (2, 4);
INSERT INTO `my_role_menu` VALUES (2, 5);
INSERT INTO `my_role_menu` VALUES (2, 6);
INSERT INTO `my_role_menu` VALUES (2, 10);
INSERT INTO `my_role_menu` VALUES (2, 11);
INSERT INTO `my_role_menu` VALUES (2, 12);
INSERT INTO `my_role_menu` VALUES (2, 13);
INSERT INTO `my_role_menu` VALUES (2, 14);
INSERT INTO `my_role_menu` VALUES (2, 15);
INSERT INTO `my_role_menu` VALUES (2, 16);
INSERT INTO `my_role_menu` VALUES (2, 68);
INSERT INTO `my_role_menu` VALUES (2, 69);
INSERT INTO `my_role_menu` VALUES (2, 70);
INSERT INTO `my_role_menu` VALUES (2, 71);
INSERT INTO `my_role_menu` VALUES (2, 78);
INSERT INTO `my_role_menu` VALUES (2, 79);
INSERT INTO `my_role_menu` VALUES (2, 80);

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
  `user_id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `dept_id` int(32) NULL DEFAULT NULL COMMENT '部门id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(1) NOT NULL COMMENT '状态',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_user
-- ----------------------------
INSERT INTO `my_user` VALUES (1, 1, 'admin', '$2a$10$pAuzCLIe6Sl7kXfX6FEQ1uzM79V2njg.KtL9qawg9JkW7e1f417k2', '管理员', '13556336255', '1454564646@qq.com', 1, '2020-07-10 09:42:03', '2020-08-23 16:24:34');
INSERT INTO `my_user` VALUES (2, 2, 'test', '$2a$10$pAuzCLIe6Sl7kXfX6FEQ1uzM79V2njg.KtL9qawg9JkW7e1f417k2', '测试用户', '13556336256', '1454564646@163.com', 1, '2020-07-10 09:42:09', '2020-07-13 17:49:49');
INSERT INTO `my_user` VALUES (3, 2, 'test1', '$2a$10$exOfpFK2TNHnAdG/aaVTFeCDLihkg8JfD1qGWKjCOBdicxcQJax5W', '普通用户2', '13556336257', '1454564646@qq.com', 1, '2020-07-10 09:42:14', '2020-07-10 09:42:16');
INSERT INTO `my_user` VALUES (4, 2, 'test2', '$2a$10$RR665iMnfCuYGY0Af344U.Fy3XmGcgjkURENW/Zea/oAEhuiLyjO.', '普通用户3', '13556336258', '1454564646@qq.com', 1, '2020-07-10 09:42:19', '2020-07-10 09:42:21');
INSERT INTO `my_user` VALUES (5, 3, 'test3', '$2a$10$o0lZgmzReca24TP5viy/nOrPQty4jga1W.BG5SvgdeK9eprm.NoMa', '普通用户4', '13556336259', '1454564646@qq.com', 1, '2020-07-10 09:42:23', '2020-07-10 09:42:25');
INSERT INTO `my_user` VALUES (6, 3, 'test4', '$2a$10$jNU1gXN.wAPhq5vUmLrCoeyDJbF3ReSnYQ2IulJA99drcMs1w1Som', '封禁用户', '13556336250', '1454564646@qq.com', 0, '2020-07-10 09:42:27', '2020-07-13 17:54:11');
INSERT INTO `my_user` VALUES (7, 3, 'test5', '$2a$10$ADEBRX13Z9vvNxzdu/HiROaB1F7rYd5DHpE9UWeXtNOSbeB1tcWie', '封禁用户2', '13556336211', '1454564646@qq.com', 0, '2020-07-10 09:42:32', '2020-07-10 09:42:34');
INSERT INTO `my_user` VALUES (8, 6, 'test6', '$2a$10$2aLbMBdNottSq13J.tfIF.5IFgTcDlWwOQI7btckzsq3vl2KtWOV6', '测试修改', '13556336253', '1454564646@qq.com', 1, '2020-07-10 09:42:36', '2020-10-01 14:24:19');

-- ----------------------------
-- Table structure for my_user_job
-- ----------------------------
DROP TABLE IF EXISTS `my_user_job`;
CREATE TABLE `my_user_job`  (
  `user_id` int(32) NOT NULL COMMENT '岗位id',
  `job_id` int(32) NOT NULL COMMENT '工作id',
  PRIMARY KEY (`user_id`, `job_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_user_job
-- ----------------------------
INSERT INTO `my_user_job` VALUES (1, 1);
INSERT INTO `my_user_job` VALUES (2, 2);
INSERT INTO `my_user_job` VALUES (3, 3);
INSERT INTO `my_user_job` VALUES (4, 2);
INSERT INTO `my_user_job` VALUES (5, 1);
INSERT INTO `my_user_job` VALUES (6, 2);
INSERT INTO `my_user_job` VALUES (7, 3);
INSERT INTO `my_user_job` VALUES (8, 2);
INSERT INTO `my_user_job` VALUES (8, 3);

SET FOREIGN_KEY_CHECKS = 1;
