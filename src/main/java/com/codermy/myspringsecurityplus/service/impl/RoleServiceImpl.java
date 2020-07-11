package com.codermy.myspringsecurityplus.service.impl;

import com.codermy.myspringsecurityplus.dao.RoleDao;
import com.codermy.myspringsecurityplus.entity.MyRole;
import com.codermy.myspringsecurityplus.service.RoleService;
import com.codermy.myspringsecurityplus.utils.Result;
import com.codermy.myspringsecurityplus.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;;

    @Override
    public Result<MyRole> getAllRolesByPage(Integer startPosition, Integer limit) {
        return Result.ok().count(roleDao.countAllRoles().intValue()).data(roleDao.getAllRolesByPage(startPosition, limit)).code(ResultCode.TABLE_SUCCESS);
    }
}
