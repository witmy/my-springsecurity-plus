package com.codermy.myspringsecurityplus.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Mapper
public interface RoleMenuDao {
    @Delete("delete from my_role_menu where role_id = #{roleId}")
    int deleteRoleMenu(Integer id);

    void save(@Param("roleId")Integer id,@Param("menuIds") List<Integer> menuIds);

    @Select("select count(*) from my_role_menu t where t.menu_id = #{menuId}")
    Integer countRoleMenuByRoleId(Integer id);
}
