package com.codermy.myspringsecurityplus.service.impl;

import com.codermy.myspringsecurityplus.dao.UserDao;
import com.codermy.myspringsecurityplus.entity.MyUser;
import com.codermy.myspringsecurityplus.service.UserService;
import com.codermy.myspringsecurityplus.utils.Result;
import com.codermy.myspringsecurityplus.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Result<MyUser> getAllUsersByPage(Integer startPosition, Integer limit) {

        return Result.ok().count(userDao.countAllUser().intValue()).data(userDao.getAllUserByPage(startPosition,limit)).code(ResultCode.TABLE_SUCCESS);
    }

    @Override
    public MyUser getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
