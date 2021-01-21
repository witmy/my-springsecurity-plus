<div align="center">
  <h1 align="center">
    my-springsecurity-plus
  </h1>
  <p align="center">
    <a href="https://www.codermy.cn">
      <img src="https://img.shields.io/badge/actor-codermy-brightgreen" alt="actor">
    </a>
    <a href="https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html">
      <img src="https://img.shields.io/badge/jdk-1.8-yellowgreen" alt="jdk">
    </a>
    <a href="https://www.mit-license.org/">
          <img src="https://img.shields.io/badge/License-MIT-brightgreen" alt="License">
        </a>
  </p>
</div>

推荐国内用户使用[gitee](https://gitee.com/witmy/my-springsecurity-plus)  
项目相关的技术问题、缺陷报告、建议等信息请通过 [Issue](https://gitee.com/witmy/my-springsecurity-plus/issues/new) 发布  

### 前言
由于我在学习SpringSecurity时，并没有找到一个完整的整合相关技术的博文或者视频，都是零散的知识或着收费挺高，所以本项目就诞生了。  

这是一款基于SpringBoot+SpringSecurity的RBAC权限管理系统。原本只想着做成基于SpringSecurity的权限管理系统，但随着功能的增加感觉有些刹不住车了，之后可能会往后台管理系统方向发展。无任何重度依赖，非常适合新手练习上手,项目文档从零开始，十分详细。  

**希望各位小伙伴能够多多star支持，您的点赞就是我维护的动力**

### 说明

将会在四月初恢复更新✊

还有就是本项目目前只适合作为一个学习项目，不建议大家用于开发，因为一开始我也只是将其作为对自己学习的检测与巩固，并没有经过系列的测试，肯定存在着不少的bug，但是我认为仅仅是作为一个SpringSecurity的入门项目她是足够了。
### 系统功能
- 用户管理：提供用户的相关配置
- 角色管理：对权限与菜单进行分配
- 菜单管理：已实现菜单动态路由
- 系统日志：记录用户操作日志与异常日志
- SQL监控：采用druid 监控数据库访问性能
- 接口管理：方便统一查看管理接口
- 部门管理：配置系统用户所属部门组织
- 岗位管理：配置系统用户所属担任职务
- 字典管理：配置维护系统中较为固定的数据

### 技术选型
1、SpringBoot  
2、MyBatis    
3、SpringSecurity  
4、MySql  
5、Druid   
6、Swagger    
8、Redis  
9、JWT  
10、[Pear Admin Layui](https://gitee.com/pear-admin/Pear-Admin-Layui)

### 系列文章
1、[SpringSecurity权限管理系统实战—一、项目简介和开发环境准备](https://blog.csdn.net/HYDCS/article/details/107282166)  
2、[SpringSecurity权限管理系统实战—二、日志、接口文档等实现](https://blog.csdn.net/HYDCS/article/details/107284901)  
3、[SpringSecurity权限管理系统实战—三、主要页面及接口实现](https://blog.csdn.net/HYDCS/article/details/107342644)    
4、[SpringSecurity权限管理系统实战—四、整合SpringSecurity（上）](https://blog.csdn.net/HYDCS/article/details/107367064)  
5、[SpringSecurity权限管理系统实战—五、整合SpringSecurity（下）](https://blog.csdn.net/HYDCS/article/details/107510905)  
6、[SpringSecurity权限管理系统实战—六、SpringSecurity整合jwt](https://blog.csdn.net/HYDCS/article/details/107732916)  
7、[SpringSecurity权限管理系统实战—七、处理一些问题](https://blog.csdn.net/HYDCS/article/details/107765898)  
8、[SpringSecurity权限管理系统实战—八、AOP记录用户、异常日志](https://blog.csdn.net/HYDCS/article/details/107965522)  
9、[SpringSecurity权限管理系统实战—九、数据权限的配置](https://blog.csdn.net/HYDCS/article/details/108185976)  

### 快速使用
- 下载项目
- 导入idea
- 导入docs文件夹下sql文件到数据库
- 修改数据库配置文件的路径，用户名等信息
- 运行

### 项目中初始用户和密码

- **后台登录：** 用户：admin和test，密码：123456。其余的，若用户名是test1(2)，则密码是六个1(2)，依次类推
- **Druid：** 用户：admin，密码：admin

### 将来要做的事
- [x] 部门管理  
- [x] 岗位管理
- [x] 字典管理
- [ ] 定时任务
- [ ] 在线用户
- [ ] 服务监控

### 交流群

<img src="https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/qun.jpg" width="200" />

### 相关截图
|                        Admin端                         |                                                       |
| :----------------------------------------------------: | :---------------------------------------------------: |
|      ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/login.PNG)     |    ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/index.PNG)       |
|     ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/user.PNG)         |    ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/useredit.PNG)       |
|     ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/user2.PNG)         |    ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/role.PNG)       |
|      ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/roleedit.PNG)        |    ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/roleedit2.PNG)        |
|     ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/menu.PNG)         |    ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/menuedit.PNG)        |
|     ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/dept.PNG)         |    ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/deptedit.PNG)        |
|     ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/job.PNG)         |    ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/jobedit.PNG)        |
|      ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/dict.PNG)         |    ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/dictDetail.PNG)       |
|      ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/druid.PNG)         |    ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/swagger.PNG)       |
|      ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/log.PNG)         |    ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/logdetail.PNG)       |
|      ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/errorlog.PNG)         |    ![image text](https://gitee.com/witmy/my-springsecurity-plus/raw/master/docs/images/errorlogdetail.PNG)       |
### 赞赏
请作者喝杯咖啡

| 支付宝 | 微信 |
| ------ | ---- |
|    <img src="docs/images/支付宝.jpg" width="200px" />    |  <img src="./docs/images/wechat.png" width="200px" />    |
    

 

