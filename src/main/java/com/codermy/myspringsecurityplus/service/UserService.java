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
    Result<MyUser> getAllUsersByPage(Integer startPosition, Integer limit, UserQueryDto userQueryDto);

    MyUser getUserById(Integer id);

    MyUser getUserByPhone(String phone);

    Result<MyUser> updateUser(UserDto userDto, Integer roleId);

    Result<MyUser> save(UserDto userDto, Integer roleId);

    int deleteUser(Integer id);

    MyUser getUser(String userName);
}
