package com.codermy.myspringsecurityplus.log.aspect;

import com.codermy.myspringsecurityplus.log.entity.MyLog;
import com.codermy.myspringsecurityplus.log.service.MyLogService;
import com.codermy.myspringsecurityplus.log.utils.LogUtils;
import com.codermy.myspringsecurityplus.log.utils.RequestHolder;
import com.codermy.myspringsecurityplus.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author codermy
 * @createTime 2020/8/4
 */
@Component
@Aspect
@Slf4j
public class LogAspect {
    @Autowired
    private MyLogService logService;

    ThreadLocal<Long> currentTime = new ThreadLocal<>();
    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.codermy.myspringsecurityplus.log.aop.MyLog)")
    public void logPoinCut() {
    }

    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     *
     * @param joinPoint join point for advice
     */
    @Around("logPoinCut()")
    public Object saveSysLog(ProceedingJoinPoint joinPoint)throws Throwable{
        Object result;
        //记录方法的执行时间
        currentTime.set(System.currentTimeMillis());
        result = joinPoint.proceed();
        //定义日志类型
        MyLog log = new MyLog("INFO",System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        logService.save(SecurityUtils.getCurrentUsername(), LogUtils.getBrowser(request), LogUtils.getIp(request),joinPoint, log);
        return result;
    }

    /**
     * 配置异常通知
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "logPoinCut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        MyLog log = new MyLog("ERROR",System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        log.setExceptionDetail(LogUtils.getStackTrace(e));
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        logService.save(SecurityUtils.getCurrentUsername(), LogUtils.getBrowser(request), LogUtils.getIp(request), (ProceedingJoinPoint)joinPoint, log);
    }
}
