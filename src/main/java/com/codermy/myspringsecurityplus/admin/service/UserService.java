package com.codermy.myspringsecurityplus.admin.service;

import com.codermy.myspringsecurityplus.admin.dto.UserDto;
import com.codermy.myspringsecurityplus.admin.dto.UserQueryDto;
import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.common.utils.Result;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
public interface UserService {
    /**
     * 返回用户列表
     * @param offectPosition
     * @param limit
     * @param myUser
     * @return
     */
    Result<MyUser> getAllUsersByPage(Integer offectPosition, Integer limit, MyUser myUser);

    /**
     * 根据id返回用户信息
     * @param id
     * @return
     */
    MyUser getUserById(Integer id);

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    public void checkUserAllowed(MyUser user);

    /**
     * 通过手机查询用户
     * @param phone
     * @return
     */
    MyUser getUserByPhone(String phone);

    /**
     * 更新用户
     * @param userDto
     * @param roleId
     * @return
     */
    Result<MyUser> updateUser(UserDto userDto, Integer roleId);

    /**
     * 新建用户
     * @param userDto
     * @param roleId
     * @return
     */
    Result<MyUser> save(UserDto userDto, Integer roleId);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(Integer id);
    /**
     *  根据用户名查询用户
     * @param userName
     * @return
     */
    MyUser getUserByName(String userName);
}
