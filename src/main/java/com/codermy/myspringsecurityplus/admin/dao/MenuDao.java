package com.codermy.myspringsecurityplus.admin.dao;

import com.codermy.myspringsecurityplus.admin.dto.MenuDto;
import com.codermy.myspringsecurityplus.admin.dto.MenuIndexDto;
import com.codermy.myspringsecurityplus.admin.entity.MyMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@SuppressWarnings("ALL")
@Mapper
public interface MenuDao {
    /**
     * 模糊查询菜单
     * @param queryName 查询的表题
     * @param queryType 查询类型
     * @return
     */
    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    List<MyMenu> getFuzzyMenu(String queryName,Integer queryType);

    /**
     * 通过id查询菜单
     * @param id
     * @return
     */
    @Select("select m.id,m.parent_id,m.name,m.icon,m.url,m.permission,m.sort,m.type,m.create_time,m.update_time from my_menu m where m.id = #{id}")
    MyMenu getMenuById(Integer id);

    /**
     * 菜单树
     * @return
     */
    @Select("select m.id,m.parent_id,m.name from my_menu m")
    @Result(property = "title",column = "name")
    List<MenuDto> buildAll();

    /**
     * 更新菜单
     * @param menu
     * @return
     */
    int update(MyMenu menu);

    /**
     * 新建菜单
     * @param menu
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into my_menu(parent_id, name, icon, url, permission, sort, type, create_time, update_time)values(#{parentId}, #{name}, #{icon}, #{url}, #{permission}, #{sort}, #{type}, now(), now())")
    int save(MyMenu menu);

    /**
     * 通过id删除菜单
     * @param id
     * @return
     */
    @Delete("delete from my_menu where id = #{id}")
    int deleteById(Integer id);

    /**
     * 通过父节点删除子菜单
     * @param parentId
     * @return
     */
    @Delete("delete from my_menu where parent_id = #{parentId}")
    int deleteByParentId(Integer parentId);

    /**
     * 通过父节点返回字节点
     * @param parentId
     * @return
     */
    @Select("select m.id from my_menu m where parent_id = #{parentId}")
    List<Integer> selectByParentId(Integer parentId);

    /**
     * 通过角色id返回菜单
     * @param roleId
     * @return
     */
    @Select("select m.id,m.parent_id,m.name from my_menu m inner join my_role_menu rm on m.id = rm.menu_id where rm.role_id = #{roleId}")
    @Result(property = "title",column = "name")
    List<MenuDto> listByRoleId(Integer roleId);

    /**
     * 通过用户id返回菜单
     * @param userId
     * @return
     */
    @Select("SELECT DISTINCT m.id,m.parent_id,m.name,m.icon,m.url,m.type,m.permission  " +
            "FROM my_role_user ru " +
            "INNER JOIN my_role_menu rm ON rm.role_id = ru.role_id " +
            "LEFT JOIN my_menu m ON rm.menu_id = m.id " +
            "WHERE " +
            "ru.user_id = #{userId}")
    @Result(property = "title",column = "name")
    @Result(property = "href",column = "url")
    List<MenuIndexDto> listByUserId(@Param("userId")Integer userId);
}
