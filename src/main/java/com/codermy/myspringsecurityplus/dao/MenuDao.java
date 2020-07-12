package com.codermy.myspringsecurityplus.dao;

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
}
