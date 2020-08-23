package com.codermy.myspringsecurityplus.admin.dao;

import com.codermy.myspringsecurityplus.admin.dto.UserDto;
import com.codermy.myspringsecurityplus.admin.dto.UserQueryDto;
import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Mapper
public interface UserDao {



    /**
     * 分页返回所有用户
     * @param myUser
     * @return
     */
     List<MyUser> getFuzzyUserByPage( MyUser myUser);

    //计算所有用户数量
    // @Select("select count(*) from My_user")
    // Long countAllUser();

    /**
     *
     * 通过id返回用户
     * @param id
     * @return
     */
    @Select("select u.id,u.dept_id,u.user_name,u.password,u.nick_name,u.phone,u.email,u.status,u.create_time,u.update_time from my_user u where u.id = #{id}")
    MyUser getUserById(Integer id);

    /**
     * 通过手机返回用户
     * @param phone
     * @return
     */
    @Select("select u.id,u.dept_id,u.user_name,u.password,u.nick_name,u.phone,u.email,u.status,u.create_time,u.update_time from my_user u where u.phone = #{phone}")
    MyUser getUserByPhone(String phone);

    /**
     * 更新用户
     * @param userDto
     * @return
     */
    int updateUser(UserDto userDto);



    /**
     * 插入用户
     * @param userDto
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into my_user(dept_id,user_name, password, nick_name, phone, email, status, create_time, update_time) values(#{deptId},#{userName}, #{password}, #{nickName}, #{phone}, #{email}, #{status}, now(), now())")
    int save(UserDto userDto);

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    @Delete("delete from my_user where id = #{userId}")
    int deleteUserById(Integer id);



    /**
     *  根据用户名查询用户
     * @param userName
     * @return
     */
    @Select("select * from my_user t where t.user_name = #{userName}")
    MyUser getUser(String userName);
}
