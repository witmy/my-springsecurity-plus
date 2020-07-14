package com.codermy.myspringsecurityplus.service;

import com.codermy.myspringsecurityplus.utils.Result;

/**
 * @author codermy
 * @createTime 2020/7/13
 */
public interface RoleUserService {
    Result getMyRoleUserByUserId(Integer userId);
}
