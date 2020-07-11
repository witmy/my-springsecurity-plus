package com.codermy.myspringsecurityplus.controller;

import com.codermy.myspringsecurityplus.service.MenuService;
import com.codermy.myspringsecurityplus.utils.Result;
import com.codermy.myspringsecurityplus.utils.ResultCode;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "菜单列表")
    public Result getMenuAll(){
        return Result.ok().data(menuService.getMenuAll()).code(ResultCode.TABLE_SUCCESS);
    }
}
