package com.codermy.myspringsecurityplus.service;

import com.codermy.myspringsecurityplus.dto.RoleDto;
import com.codermy.myspringsecurityplus.entity.MyRole;
import com.codermy.myspringsecurityplus.utils.Result;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
public interface RoleService {
    /**
     * 返回角色
     * @param startPosition
     * @param limit
     * @param queryName
     * @return
     */
    Result<MyRole> getFuzzyRolesByPage(Integer startPosition, Integer limit,String queryName);

    /**
     * 通过id获得角色信息
     * @param id
     * @return
     */
    MyRole getRoleById(Integer id);

    /**
     * 更新角色
     * @param roleDto
     * @return
     */
    Result update(RoleDto roleDto);

    /**
     * 新建角色
     * @param roleDto
     * @return
     */
    Result save(RoleDto roleDto);

    /**
     * 删除角色
     * @param id
     * @return
     */
    Result<MyRole> delete(Integer id);

    /**
     * 获取全部角色
     * @return
     */
    Result<MyRole> getAllRoles();
}
