package com.codermy.myspringsecurityplus.log.service;

import com.codermy.myspringsecurityplus.log.dto.ErrorLogDto;
import com.codermy.myspringsecurityplus.log.dto.LogQuery;
import com.codermy.myspringsecurityplus.log.entity.MyErrorLog;
import com.codermy.myspringsecurityplus.utils.Result;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author codermy
 * @createTime 2020/8/8
 */
public interface MyErrorLogService {

    void save(String userName, String browser, String ip, ProceedingJoinPoint joinPoint, MyErrorLog log);

    /**
     * 分页模糊查询用户日志
     * @param startPosition 起始页
     * @param limit 每页多少条数据
     * @param logQuery //查询条件
     * @return
     */
    Result<ErrorLogDto> getFuzzyErrorLogByPage(Integer startPosition, Integer limit, LogQuery logQuery);
}
