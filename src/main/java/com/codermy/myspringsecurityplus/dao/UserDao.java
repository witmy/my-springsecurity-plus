package com.codermy.myspringsecurityplus.dao;

import com.codermy.myspringsecurityplus.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Mapper
public interface UserDao {

    //分页返回所有用户
    @Select("SELECT * FROM my_user t ORDER BY t.id LIMIT #{startPosition}, #{limit}")
    List<MyUser> getAllUserByPage(@Param("startPosition")Integer startPosition,@Param("limit")Integer limit);

    //计算所有用户数量
    @Select("select count(*) from My_user")
    Long countAllUser();
}
