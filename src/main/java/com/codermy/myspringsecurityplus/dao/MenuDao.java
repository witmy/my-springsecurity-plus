package com.codermy.myspringsecurityplus.dao;

import com.codermy.myspringsecurityplus.dto.MenuDto;
import com.codermy.myspringsecurityplus.dto.MenuIndexDto;
import com.codermy.myspringsecurityplus.entity.MyMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Mapper
public interface MenuDao {
    /**
     *
     * @param queryName 查询的表题
     * @param queryType 查询类型
     * @return
     */
    List<MyMenu> getFuzzyMenu(String queryName,Integer queryType);

    @Select("select t.id,t.parent_id,t.name,t.icon,t.url,t.permission,t.sort,t.type,t.create_time,t.update_time from my_menu t where t.id = #{id}")
    MyMenu getMenuById(Integer id);

    @Select("select t.id,t.parent_id,t.name from my_menu t")
    @Result(property = "title",column = "name")
    List<MenuDto> buildAll();

    int update(MyMenu menu);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into my_menu(parent_id, name, icon, url, permission, sort, type, create_time, update_time)values(#{parentId}, #{name}, #{icon}, #{url}, #{permission}, #{sort}, #{type}, now(), now())")
    int save(MyMenu menu);

    @Delete("delete from my_menu where id = #{id}")
    int deleteById(Integer id);

    @Delete("delete from my_menu where parent_id = #{parentId}")
    int deleteByParentId(Integer parentId);

    @Select("select p.id,p.parent_id,p.name from my_menu p inner join my_role_menu rp on p.id = rp.menu_id where rp.role_id = #{roleId}")
    @Result(property = "title",column = "name")
    List<MenuDto> listByRoleId(Integer roleId);

    @Select("SELECT DISTINCT sp.id,sp.parent_id,sp.name,sp.icon,sp.url,sp.type,sp.permission  " +
            "FROM my_role_user sru " +
            "INNER JOIN my_role_menu srp ON srp.role_id = sru.role_id " +
            "LEFT JOIN my_menu sp ON srp.menu_id = sp.id " +
            "WHERE " +
            "sru.user_id = #{userId}")
    @Result(property = "title",column = "name")
    @Result(property = "href",column = "url")
    List<MenuIndexDto> listByUserId(@Param("userId")Integer userId);
}
