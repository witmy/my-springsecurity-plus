package com.codermy.myspringsecurityplus.log.service.impl;

import com.codermy.myspringsecurityplus.log.dao.ErrorLogDao;
import com.codermy.myspringsecurityplus.log.dto.ErrorLogDto;
import com.codermy.myspringsecurityplus.log.dto.LogQuery;
import com.codermy.myspringsecurityplus.log.entity.MyErrorLog;
import com.codermy.myspringsecurityplus.log.service.MyErrorLogService;
import com.codermy.myspringsecurityplus.utils.Result;
import com.codermy.myspringsecurityplus.utils.ResultCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/8
 */
@Service
public class MyErrorLogServiceImpl implements MyErrorLogService {
    @Autowired
    private ErrorLogDao errorLogDao;
    @Override
    public void save(String userName, String browser, String ip, ProceedingJoinPoint joinPoint, MyErrorLog log) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        com.codermy.myspringsecurityplus.log.aop.MyLog myLog = method.getAnnotation(com.codermy.myspringsecurityplus.log.aop.MyLog.class);
        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName()+"."+signature.getName()+"()";
        StringBuilder params = new StringBuilder("{");
        //参数值
        Object[] argValues = joinPoint.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        if(argValues != null){
            for (int i = 0; i < argValues.length; i++) {
                params.append(" ").append(argNames[i]).append(": ").append(argValues[i]);
            }
        }
        // 描述
        if (log != null) {
            log.setDescription(myLog.value());
        }
        assert log != null;
        log.setIp(ip);

        log.setMethod(methodName);
        log.setUserName(userName);
        log.setParams(params.toString() + " }");
        log.setBrowser(browser);
        errorLogDao.save(log);
    }

    @Override
    public Result<ErrorLogDto> getFuzzyErrorLogByPage(Integer startPosition, Integer limit, LogQuery logQuery) {
        List<ErrorLogDto> fuzzyLogByPage = errorLogDao.getFuzzyErrorLogByPage(startPosition, limit, logQuery);
        return Result.ok().count(fuzzyLogByPage.size()).data(fuzzyLogByPage).code(ResultCode.TABLE_SUCCESS);
    }
}
