package com.codermy.myspringsecurityplus.admin.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Mapper
public interface RoleMenuDao {
    /**
     * 通过id删除rolemenu
     * @param roleId
     * @return
     */
    @Delete("delete from my_role_menu where role_id = #{roleId}")
    int deleteRoleMenu(Integer roleId);

    /**
     * 新建角色与menu的联系
     * @param roleId
     * @param menuIds
     */
    void save(@Param("roleId")Integer roleId,@Param("menuIds") List<Integer> menuIds);

    /**
     * 通过role_id计算权限数量
     * @param id
     * @return
     */
    @Select("select count(*) from my_role_menu t where t.menu_id = #{menuId}")
    Integer countRoleMenuByRoleId(Integer id);
}
