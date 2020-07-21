package com.codermy.myspringsecurityplus.exceptionhandler;

import com.codermy.myspringsecurityplus.utils.Result;
import com.codermy.myspringsecurityplus.utils.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author codermy
 * @createTime 2020/5/8
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //指定处理什么异常
    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.error().message("执行了全局异常");
    }
    //自定义异常
    @ExceptionHandler(MyException.class)
    public Result error(MyException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.error().code(e.getCode()).message(e.getMsg());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Result handleAuthorizationException(AccessDeniedException e)
    {
        log.error(e.getMessage());
        return Result.error().code(ResultCode.FORBIDDEN).message("没有权限，请联系管理员授权");
    }
    @ExceptionHandler(AuthenticationServiceException.class)
    public Result handleAuthenticationServiceException(AuthenticationServiceException e){
        return Result.error().message("验证码错误");
    }

}
