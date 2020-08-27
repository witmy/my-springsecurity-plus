package com.codermy.myspringsecurityplus.admin.dao;

import com.codermy.myspringsecurityplus.admin.dto.RoleDto;
import com.codermy.myspringsecurityplus.admin.entity.MyRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Mapper
public interface RoleDao {



    /**
     * 分页模糊查询角色
     * @param role
     * @return
     */
    List<MyRole> getFuzzyRolesByPage(MyRole role);

    /**
     * 通过id查询角色
     * @param roleId
     * @return
     */
    @Select("select r.role_id,r.role_name,r.data_scope,r.description,r.create_time,r.update_time from my_role r where r.role_id = #{roleId}")
    MyRole getRoleById(Integer roleId);

    /**
     * 更新角色
     * @param roleDto
     * @return
     */
    int update(RoleDto roleDto);

    /**
     * 新建角色
     * @param roleDto
     * @return
     */
    int saveRole(RoleDto roleDto);

    /**
     * 通过id删除角色
     * @param roleId
     * @return
     */
    @Delete("delete from my_role where role_id = #{roleId}")
    int delete(Integer roleId);

    /**
     * 返回所有角色
     * @return
     */
    @Select("select r.role_id,r.role_name,r.description from my_role r")
    List<MyRole> getAllRoles();
}
