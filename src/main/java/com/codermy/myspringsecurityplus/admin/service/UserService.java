package com.codermy.myspringsecurityplus.admin.service;


import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.common.utils.Result;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
public interface UserService {
    /**
     * 返回用户列表
     * @param offectPosition
     * @param limit
     * @param myUser
     * @return
     */
    Result<MyUser> getAllUsersByPage(Integer offectPosition, Integer limit, MyUser myUser);

    /**
     * 根据id返回用户信息
     * @param id
     * @return
     */
    MyUser getUserById(Integer id);

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    public void checkUserAllowed(MyUser user);

    /**
     * 通过手机查询用户
     * @param user
     * @return
     */
    String checkPhoneUnique(MyUser user);

    /**
     * 通过用户名查询用户
     * @param user
     * @return
     */
    String checkUserNameUnique(MyUser user);

    /**
     * 更新用户
     * @param myUser
     * @param roleId
     * @return
     */
    Result<MyUser> updateUser(MyUser myUser, Integer roleId);

    /**
     * 用户状态修改
     *
     * @param user 用户信息
     * @return 结果
     */
    int changeStatus(MyUser user);

    /**
     * 新建用户
     * @param myUser
     * @param roleId
     * @return
     */
    Result<MyUser> save(MyUser myUser, Integer roleId);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteUser(Integer userId);
    /**
     *  根据用户名查询用户
     * @param userName
     * @return
     */
    MyUser getUserByName(String userName);
}
