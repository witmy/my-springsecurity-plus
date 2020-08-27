package com.codermy.myspringsecurityplus.admin.service.impl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.codermy.myspringsecurityplus.admin.annotation.DataPermission;
import com.codermy.myspringsecurityplus.admin.dao.RoleUserDao;
import com.codermy.myspringsecurityplus.admin.dao.UserDao;
import com.codermy.myspringsecurityplus.admin.dao.UserJobDao;
import com.codermy.myspringsecurityplus.admin.dto.UserDto;
import com.codermy.myspringsecurityplus.admin.dto.UserQueryDto;
import com.codermy.myspringsecurityplus.admin.entity.MyRoleUser;
import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.admin.entity.MyUserJob;
import com.codermy.myspringsecurityplus.admin.service.UserService;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.ResultCode;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.thymeleaf.util.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleUserDao roleUserDao;

    @Autowired
    private UserJobDao userJobDao;

    @Override
    @DataPermission(deptAlias = "d", userAlias = "u")
    public Result<MyUser> getAllUsersByPage(Integer offectPosition, Integer limit, MyUser myUser) {
        Page page = PageHelper.offsetPage(offectPosition,limit);
        List<MyUser> fuzzyUserByPage = userDao.getFuzzyUserByPage(myUser);
        return Result.ok().count(page.getTotal()).data(fuzzyUserByPage).code(ResultCode.TABLE_SUCCESS);
    }

    @Override
    public MyUser getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public void checkUserAllowed(MyUser user) {
        if (!StringUtils.isEmpty(user.getUserId()) && user.isAdmin())
        {
            throw new MyException(ResultCode.ERROR,"不允许操作超级管理员用户");
        }
    }

    @Override
    public MyUser getUserByPhone(String phone) {
        return userDao.getUserByPhone(phone);
    }

    @Override
    public Result<MyUser> updateUser(UserDto userDto, Integer roleId) {
        if (roleId!=null){
            userDao.updateUser(userDto);
            MyRoleUser myRoleUser = new MyRoleUser();
            myRoleUser.setUserId(userDto.getUserId());
            myRoleUser.setRoleId(roleId);
            if(roleUserDao.getRoleUserByUserId(userDto.getUserId())!=null){
                roleUserDao.updateMyRoleUser(myRoleUser);
            }else {
                roleUserDao.save(myRoleUser);
            }
            userJobDao.deleteUserJobByUserId(userDto.getUserId());
            insertUserPost(userDto);
            return Result.ok().message("更新成功");
        }else {
            return Result.error().message("更新失败");
        }
    }

    @Override
    public Result<MyUser> save(UserDto userDto, Integer roleId) {
        if(roleId!= null){
            userDao.save(userDto);
            MyRoleUser myRoleUser = new MyRoleUser();
            myRoleUser.setRoleId(roleId);
            myRoleUser.setUserId(userDto.getUserId().intValue());
            roleUserDao.save(myRoleUser);
            insertUserPost(userDto);
            return Result.ok().message("添加成功，初始密码123456");
        }

        return Result.error().message("添加失败");
    }

    @Override
    public int deleteUser(Integer userId) {
        checkUserAllowed(new MyUser(userId));
        roleUserDao.deleteRoleUserByUserId(userId);
        userJobDao.deleteUserJobByUserId(userId);
        return userDao.deleteUserById(userId);
    }

    @Override
    public MyUser getUserByName(String userName) {
        return userDao.getUser(userName);
    }


    /**
     * 新增用户岗位信息
     *
     * @param user 用户对象
     */
    public void insertUserPost(UserDto user)
    {
        Integer[] jobs = user.getJobIds();

        if (ArrayUtil.isNotEmpty(jobs))
        {
            // 新增用户与岗位管理
            List<MyUserJob> list = new ArrayList<MyUserJob>();
            for (Integer jobId : jobs)
            {
                MyUserJob up = new MyUserJob();
                up.setUserId(user.getUserId());
                up.setJobId(jobId);
                list.add(up);
            }
            if (list.size() > 0)
            {
                userJobDao.batchUserJob(list);
            }
        }
        return;
    }
}
