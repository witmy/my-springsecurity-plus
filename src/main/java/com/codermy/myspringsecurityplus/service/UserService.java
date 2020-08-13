package com.codermy.myspringsecurityplus.service;

import com.codermy.myspringsecurityplus.dto.UserDto;
import com.codermy.myspringsecurityplus.dto.UserQueryDto;
import com.codermy.myspringsecurityplus.entity.MyUser;
import com.codermy.myspringsecurityplus.utils.Result;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
public interface UserService {
    /**
     * 返回用户列表
     * @param offectPosition
     * @param limit
     * @param userQueryDto
     * @return
     */
    Result<MyUser> getAllUsersByPage(Integer offectPosition, Integer limit, UserQueryDto userQueryDto);

    /**
     * 根据id返回用户信息
     * @param id
     * @return
     */
    MyUser getUserById(Integer id);

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
    MyUser getUser(String userName);
}
