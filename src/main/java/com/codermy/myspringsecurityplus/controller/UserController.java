package com.codermy.myspringsecurityplus.controller;

import com.codermy.myspringsecurityplus.entity.MyUser;
import com.codermy.myspringsecurityplus.service.UserService;
import com.codermy.myspringsecurityplus.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.utils.Result;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // @GetMapping("index")
    // @ResponseBody
    // @ApiOperation(value = "用户列表")
    // public Result<MyUser> index(PageTableRequest pageTableRequest){
    //     pageTableRequest.countOffset();
    //     return userService.getAllUsersByPage(pageTableRequest.getOffset(),pageTableRequest.getLimit());
    // }
}
