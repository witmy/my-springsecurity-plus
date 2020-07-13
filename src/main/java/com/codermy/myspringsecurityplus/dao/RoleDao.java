package com.codermy.myspringsecurityplus.dao;

import com.codermy.myspringsecurityplus.entity.MyRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Mapper
public interface RoleDao {
    //计算所有
    @Select("select count(*) from my_role t")
    Long countAllRoles();

    //分页查询权限
    @Select("select t.id,t.name,t.description,t.status,t.create_time,t.update_time from my_role t limit #{startPosition}, #{limit}")
    List<MyRole> getAllRolesByPage(@Param("startPosition")Integer startPosition, @Param("limit")Integer limit);

    @Select("select t.id,t.name,t.description,t.status,t.create_time,t.update_time from my_role t where t.id = #{id}")
    MyRole getRoleById(Integer id);
}
