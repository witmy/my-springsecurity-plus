package com.codermy.myspringsecurityplus.service;

import com.codermy.myspringsecurityplus.entity.MyRole;
import com.codermy.myspringsecurityplus.utils.Result;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
public interface RoleService {

    Result<MyRole> getAllRolesByPage(Integer startPosition, Integer limit);

    MyRole getRoleById(Integer id);
}
