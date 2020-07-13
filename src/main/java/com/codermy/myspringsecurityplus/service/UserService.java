package com.codermy.myspringsecurityplus.service;

import com.codermy.myspringsecurityplus.entity.MyUser;
import com.codermy.myspringsecurityplus.utils.Result;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
public interface UserService {
    Result<MyUser> getAllUsersByPage(Integer startPosition, Integer limit);

    MyUser getUserById(Integer id);
}
