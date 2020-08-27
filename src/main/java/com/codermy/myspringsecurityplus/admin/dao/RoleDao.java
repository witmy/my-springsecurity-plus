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
     * @param id
     * @return
     */
    @Select("select r.id,r.name,r.data_scope,r.description,r.create_time,r.update_time from my_role r where r.id = #{id}")
    MyRole getRoleById(Integer id);

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
     * @param id
     * @return
     */
    @Delete("delete from my_role where id = #{id}")
    int delete(Integer id);

    /**
     * 返回所有角色
     * @return
     */
    @Select("select r.id,r.name,r.description from my_role r")
    List<MyRole> getAllRoles();
}
