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
     * 计算所有
     * @return
     */
    @Select("select count(*) from my_role t")
    Long countAllRoles();



    /**
     * 分页模糊查询权限
     * @param queryName
     * @return
     */
    List<MyRole> getFuzzyRolesByPage(@Param("queryName") String queryName);

    /**
     * 通过id查询角色
     * @param id
     * @return
     */
    @Select("select t.id,t.name,t.description,t.create_time,t.update_time from my_role t where t.id = #{id}")
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
    @Select("select t.id,t.name,t.description from my_role t")
    List<MyRole> getAllRoles();
}
