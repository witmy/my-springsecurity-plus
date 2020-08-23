package com.codermy.myspringsecurityplus.admin.controller;

import com.codermy.myspringsecurityplus.admin.entity.MyRoleUser;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import com.codermy.myspringsecurityplus.admin.service.RoleUserService;
import com.codermy.myspringsecurityplus.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/13
 */
@Controller
@RequestMapping("/api/roleuser")
@Api(tags = "系统：用户角色管理")
public class RoleUserController {
    @Autowired
    private RoleUserService roleUserService;

    @PostMapping()
    @ResponseBody
    @ApiOperation(value = "通过用户id返回用户角色")
    @PreAuthorize("hasAnyAuthority('user:list')")
    @MyLog("查询用户角色")
    public Result getRoleUserByUserId(Integer userId) {
        List<MyRoleUser> tbRoleUser =roleUserService.getMyRoleUserByUserId(userId);
        if(tbRoleUser != null){
            return Result.ok().data(tbRoleUser);
        }else{
            return Result.error();
        }
    }
}
