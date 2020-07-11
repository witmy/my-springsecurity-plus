package com.codermy.myspringsecurityplus.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author codermy
 * @createTime 2020/7/8
 */
@Controller
@Slf4j
@Api(tags = "前期测试后面会删")
public class HelloController {

    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/console/console1")
    @ApiOperation(value = "转发console1请求")
    public String console1(){
        return "console/console1";
    }

    @GetMapping(value = "/system/organization")
    public String organization(){
        return "system/organization";
    }

    @GetMapping(value = "/system/user")
    public String user(){
        return "system/user";
    }

    @GetMapping(value = "/system/role")
    public String role(){
        return "system/role";
    }

    @GetMapping(value = "/system/power")
    public String power(){
        return "system/power";
    }

    @GetMapping(value = "/page/comment")
    public String comment(){
        return "page/comment";
    }
}
