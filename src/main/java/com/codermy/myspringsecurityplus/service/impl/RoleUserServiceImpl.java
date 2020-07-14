package com.codermy.myspringsecurityplus.service.impl;

import com.codermy.myspringsecurityplus.dao.RoleUserDao;
import com.codermy.myspringsecurityplus.entity.MyRoleUser;
import com.codermy.myspringsecurityplus.service.RoleUserService;
import com.codermy.myspringsecurityplus.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Service
public class RoleUserServiceImpl implements RoleUserService {
    @Autowired
    private RoleUserDao roleUserDao;
    @Override
    public Result getMyRoleUserByUserId(Integer userId) {
        List<MyRoleUser> tbRoleUser = roleUserDao.getMyRoleUserByUserId(userId);
        if(tbRoleUser != null){
            return Result.ok().data(tbRoleUser);
        }else{
            return Result.error();
        }
    }
}
