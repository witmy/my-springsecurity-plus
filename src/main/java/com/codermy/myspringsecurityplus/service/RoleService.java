package com.codermy.myspringsecurityplus.service;

import com.codermy.myspringsecurityplus.dto.RoleDto;
import com.codermy.myspringsecurityplus.entity.MyRole;
import com.codermy.myspringsecurityplus.utils.Result;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
public interface RoleService {

    Result<MyRole> getFuzzyRolesByPage(Integer startPosition, Integer limit,String queryName);

    MyRole getRoleById(Integer id);

    Result update(RoleDto roleDto);

    Result save(RoleDto roleDto);

    Result<MyRole> delete(Integer id);

    Result<MyRole> getAllRoles();
}
