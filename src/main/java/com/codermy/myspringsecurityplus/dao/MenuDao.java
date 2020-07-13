package com.codermy.myspringsecurityplus.dao;

import com.codermy.myspringsecurityplus.dto.MenuDto;
import com.codermy.myspringsecurityplus.entity.MyMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Mapper
public interface MenuDao {
    @Select("select t.id,t.parent_id,t.name,t.icon,t.url,t.permission,t.sort,t.type,t.create_time,t.update_time from my_menu t")
    List<MyMenu> findAll();

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
}
