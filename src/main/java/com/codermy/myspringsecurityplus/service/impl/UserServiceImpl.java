package com.codermy.myspringsecurityplus.service.impl;

import com.codermy.myspringsecurityplus.dao.RoleUserDao;
import com.codermy.myspringsecurityplus.dao.UserDao;
import com.codermy.myspringsecurityplus.dto.UserDto;
import com.codermy.myspringsecurityplus.dto.UserQueryDto;
import com.codermy.myspringsecurityplus.entity.MyRoleUser;
import com.codermy.myspringsecurityplus.entity.MyUser;
import com.codermy.myspringsecurityplus.service.UserService;
import com.codermy.myspringsecurityplus.utils.Result;
import com.codermy.myspringsecurityplus.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public Result<MyUser> getAllUsersByPage(Integer startPosition, Integer limit, UserQueryDto userQueryDto) {
        List<MyUser> fuzzyUserByPage = userDao.getFuzzyUserByPage(startPosition, limit, userQueryDto);
        return Result.ok().count(fuzzyUserByPage.size()).data(fuzzyUserByPage).code(ResultCode.TABLE_SUCCESS);
    }


    @Override
    public MyUser getUserById(Integer id) {
        return userDao.getUserById(id);
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
            myRoleUser.setUserId(userDto.getId());
            myRoleUser.setRoleId(roleId);
            if(roleUserDao.getRoleUserByUserId(userDto.getId())!=null){
                roleUserDao.updateMyRoleUser(myRoleUser);
            }else {
                roleUserDao.save(myRoleUser);
            }
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
            myRoleUser.setUserId(userDto.getId().intValue());
            roleUserDao.save(myRoleUser);
            return Result.ok().message("添加成功，初始密码123456");
        }
        return Result.error().message("添加失败");
    }

    @Override
    public int deleteUser(Integer id) {
        roleUserDao.deleteRoleUserByUserId(id);
        return userDao.deleteUserById(id);
    }

    @Override
    public MyUser getUser(String userName) {
        return userDao.getUser(userName);
    }
}
