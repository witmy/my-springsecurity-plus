package com.codermy.myspringsecurityplus.admin.controller;

import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author codermy
 * @createTime 2020/7/19
 */
@Controller
@Api(tags = "系统：验证码")
public class CaptchaController {

    @RequestMapping("/captcha")
    @ApiOperation(value = "验证码")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(120, 45, 4, request, response);
    }

}
