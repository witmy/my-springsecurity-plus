package com.codermy.myspringsecurityplus.controller;

import com.codermy.myspringsecurityplus.service.RoleService;
import com.codermy.myspringsecurityplus.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.utils.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Controller
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "分页返回角色列表")
    public Result list(PageTableRequest request) {
        request.countOffset();
        return roleService.getAllRolesByPage(request.getOffset(), request.getLimit());
    }
}
