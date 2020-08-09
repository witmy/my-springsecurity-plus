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

 Date: 09/08/2020 20:33:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for my_log
-- ----------------------------
DROP TABLE IF EXISTS `my_log`;
CREATE TABLE `my_log`  (
  `id` int(21) NOT NULL AUTO_INCREMENT COMMENT 'id值',
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_log
-- ----------------------------
INSERT INTO `my_log` VALUES (64, 'admin', '0:0:0:0:0:0:0:1', '查询菜单', '{ queryName: null queryType: null }', 'Chrome 8', 1, 'ERROR', 'com.codermy.myspringsecurityplus.controller.MenuController.getMenuAll()', '2020-08-09 20:31:17', 'MyException(code=1111, msg=测试异常)\r\n	at com.codermy.myspringsecurityplus.controller.MenuController.getMenuAll(MenuController.java:45)\r\n	at com.codermy.myspringsecurityplus.controller.MenuController$$FastClassBySpringCGLIB$$c55efcfc.invoke(<generated>)\r\n	at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\r\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:771)\r\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\r\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\r\n	at org.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:62)\r\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)\r\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\r\n	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:88)\r\n	at com.codermy.myspringsecurityplus.log.aspect.LogAspect.saveSysLog(LogAspect.java:45)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n	at java.lang.reflect.Method.invoke(Method.java:498)\r\n	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:644)\r\n	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:633)\r\n	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:70)\r\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)\r\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\r\n	at org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor.invoke(MethodSecurityInterceptor.java:69)\r\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\r\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\r\n	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:95)\r\n	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\r\n	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)\r\n	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:691)\r\n	at com.codermy.myspringsecurityplus.controller.MenuController$$EnhancerBySpringCGLIB$$8957fd45.getMenuAll(<generated>)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n	at java.lang.reflect.Method.invoke(Method.java:498)\r\n	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\r\n	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\r\n	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:105)\r\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:879)\r\n	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\r\n	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\r\n	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\r\n	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\r\n	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\r\n	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\r\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:634)\r\n	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\r\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:741)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:113)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at com.codermy.myspringsecurityplus.security.filter.JwtAuthenticationTokenFilter.doFilterInternal(JwtAuthenticationTokenFilter.java:57)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:320)\r\n	at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.invoke(FilterSecurityInterceptor.java:126)\r\n	at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.doFilter(FilterSecurityInterceptor.java:90)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:118)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:137)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:111)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter.doFilter(RememberMeAuthenticationFilter.java:158)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:158)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.authentication.www.BasicAuthenticationFilter.doFilterInternal(BasicAuthenticationFilter.java:155)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:200)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at com.codermy.myspringsecurityplus.security.filter.VerifyCodeFilter.doFilterInternal(VerifyCodeFilter.java:44)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:116)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:92)\r\n	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:77)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:105)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:56)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)\r\n	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:215)\r\n	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:178)\r\n	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:358)\r\n	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:271)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\r\n	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\r\n	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541)\r\n	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\r\n	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\r\n	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\r\n	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\r\n	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:373)\r\n	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\r\n	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\r\n	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1590)\r\n	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\r\n	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\r\n	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\r\n	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\r\n	at java.lang.Thread.run(Thread.java:748)\r\n');
INSERT INTO `my_log` VALUES (66, 'admin', '0:0:0:0:0:0:0:1', '删除所有INFO日志', '{ }', 'Chrome 8', 68, 'INFO', 'com.codermy.myspringsecurityplus.controller.LogController.delAllByInfo()', '2020-08-09 20:32:27', NULL);
INSERT INTO `my_log` VALUES (67, 'admin', '0:0:0:0:0:0:0:1', '查询用户', '{ pageTableRequest: PageTableRequest(page=1, limit=10, offset=0) userQueryDto: UserQueryDto(nickName=null, userName=null) }', 'Chrome 8', 8, 'INFO', 'com.codermy.myspringsecurityplus.controller.UserController.userList()', '2020-08-09 20:32:40', NULL);
INSERT INTO `my_log` VALUES (68, 'admin', '0:0:0:0:0:0:0:1', '绘制菜单树', '{ }', 'Chrome 8', 7, 'INFO', 'com.codermy.myspringsecurityplus.controller.MenuController.buildMenuAll()', '2020-08-09 20:32:44', NULL);
INSERT INTO `my_log` VALUES (69, 'admin', '0:0:0:0:0:0:0:1', '通过id绘制菜单树', '{ roleId: 1 }', 'Chrome 8', 8, 'INFO', 'com.codermy.myspringsecurityplus.controller.MenuController.buildMenuAllByRoleId()', '2020-08-09 20:32:47', NULL);
INSERT INTO `my_log` VALUES (70, 'admin', '0:0:0:0:0:0:0:1', '修改角色', '{ roleDto: MyRole{name=\'ADMIN\', description=\'超级管理员，拥有所有权限\', status=null} }', 'Chrome 8', 46, 'INFO', 'com.codermy.myspringsecurityplus.controller.RoleController.updateRole()', '2020-08-09 20:32:48', NULL);
INSERT INTO `my_log` VALUES (71, 'admin', '0:0:0:0:0:0:0:1', '查询角色', '{ request: PageTableRequest(page=1, limit=10, offset=0) queryName: null }', 'Chrome 8', 6, 'INFO', 'com.codermy.myspringsecurityplus.controller.RoleController.roleList()', '2020-08-09 20:32:49', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `my_menu` VALUES (11, 10, '403', 'layui-icon layui-icon-face-cry', '/api/403', '', 11, 1, '2020-07-14 13:36:47', '2020-08-05 17:45:50');
INSERT INTO `my_menu` VALUES (12, 10, '404', 'layui-icon layui-icon-face-cry', '/api/404', NULL, 12, 1, '2020-07-14 13:37:22', '2020-07-14 13:37:25');
INSERT INTO `my_menu` VALUES (13, 10, '500', 'layui-icon layui-icon-face-cry', '/api/500', NULL, 13, 1, '2020-07-14 13:38:09', '2020-07-14 13:38:11');
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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_role
-- ----------------------------
INSERT INTO `my_role` VALUES (1, 'ADMIN', '超级管理员，拥有所有权限', 1, '2020-07-10 09:40:35', '2020-08-09 20:32:48');
INSERT INTO `my_role` VALUES (2, 'USER', '普通用户', 1, '2020-07-10 09:40:56', '2020-07-21 18:12:28');

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
INSERT INTO `my_role_menu` VALUES (2, 1);
INSERT INTO `my_role_menu` VALUES (2, 2);
INSERT INTO `my_role_menu` VALUES (2, 4);
INSERT INTO `my_role_menu` VALUES (2, 10);
INSERT INTO `my_role_menu` VALUES (2, 11);
INSERT INTO `my_role_menu` VALUES (2, 12);
INSERT INTO `my_role_menu` VALUES (2, 13);

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
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_user
-- ----------------------------
INSERT INTO `my_user` VALUES (1, 'admin', '$2a$10$pAuzCLIe6Sl7kXfX6FEQ1uzM79V2njg.KtL9qawg9JkW7e1f417k2', '管理员', '13556336255', '1454564646@qq.com', 1, '2020-07-10 09:42:03', '2020-07-10 09:42:07');
INSERT INTO `my_user` VALUES (2, 'test', '$2a$10$pAuzCLIe6Sl7kXfX6FEQ1uzM79V2njg.KtL9qawg9JkW7e1f417k2', '测试用户', '13556336256', '1454564646@163.com', 1, '2020-07-10 09:42:09', '2020-07-13 17:49:49');
INSERT INTO `my_user` VALUES (3, 'test1', '$2a$10$exOfpFK2TNHnAdG/aaVTFeCDLihkg8JfD1qGWKjCOBdicxcQJax5W', '普通用户2', '13556336257', '1454564646@qq.com', 1, '2020-07-10 09:42:14', '2020-07-10 09:42:16');
INSERT INTO `my_user` VALUES (4, 'test2', '$2a$10$RR665iMnfCuYGY0Af344U.Fy3XmGcgjkURENW/Zea/oAEhuiLyjO.', '普通用户3', '13556336258', '1454564646@qq.com', 1, '2020-07-10 09:42:19', '2020-07-10 09:42:21');
INSERT INTO `my_user` VALUES (5, 'test3', '$2a$10$o0lZgmzReca24TP5viy/nOrPQty4jga1W.BG5SvgdeK9eprm.NoMa', '普通用户4', '13556336259', '1454564646@qq.com', 1, '2020-07-10 09:42:23', '2020-07-10 09:42:25');
INSERT INTO `my_user` VALUES (6, 'test4', '$2a$10$jNU1gXN.wAPhq5vUmLrCoeyDJbF3ReSnYQ2IulJA99drcMs1w1Som', '封禁用户', '13556336250', '1454564646@qq.com', 0, '2020-07-10 09:42:27', '2020-07-13 17:54:11');
INSERT INTO `my_user` VALUES (7, 'test5', '$2a$10$ADEBRX13Z9vvNxzdu/HiROaB1F7rYd5DHpE9UWeXtNOSbeB1tcWie', '封禁用户2', '13556336211', '1454564646@qq.com', 0, '2020-07-10 09:42:32', '2020-07-10 09:42:34');
INSERT INTO `my_user` VALUES (8, 'test7', '$2a$10$2aLbMBdNottSq13J.tfIF.5IFgTcDlWwOQI7btckzsq3vl2KtWOV6', '测试修改', '13556336212', '1454564646@qq.com', 1, '2020-07-10 09:42:36', '2020-07-13 17:06:26');

SET FOREIGN_KEY_CHECKS = 1;
