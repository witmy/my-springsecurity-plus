package com.codermy.myspringsecurityplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author codermy
 * @createTime 2020/7/8
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/console/console1")
    public String console1(){
        return "console/console1";
    }

    @RequestMapping(value = "/system/organization")
    public String organization(){
        return "system/organization";
    }

    @RequestMapping(value = "/system/user")
    public String user(){
        return "system/user";
    }

    @RequestMapping(value = "/system/role")
    public String role(){
        return "system/role";
    }

    @RequestMapping(value = "/system/power")
    public String power(){
        return "system/power";
    }

    @RequestMapping(value = "/page/comment")
    public String comment(){
        return "page/comment";
    }
}
