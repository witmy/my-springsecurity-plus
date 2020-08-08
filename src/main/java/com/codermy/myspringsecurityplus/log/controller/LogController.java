package com.codermy.myspringsecurityplus.log.controller;

import com.codermy.myspringsecurityplus.entity.MyUser;
import com.codermy.myspringsecurityplus.log.dto.ErrorLogDto;
import com.codermy.myspringsecurityplus.log.dto.LogDto;
import com.codermy.myspringsecurityplus.log.dto.LogQuery;
import com.codermy.myspringsecurityplus.log.service.MyErrorLogService;
import com.codermy.myspringsecurityplus.log.service.MyLogService;
import com.codermy.myspringsecurityplus.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author codermy
 * @createTime 2020/8/8
 */
@Controller
@RequestMapping("/api")
@Api(tags = "系统：用户管理")
public class LogController {
    @Autowired
    private MyLogService logService;
    @Autowired
    private MyErrorLogService errorLogService;
    @GetMapping("/log/index")
    public String logIndex(){
        return "system/log/log";
    }
    @GetMapping("/log")
    @ResponseBody
    @ApiOperation(value = "日志列表")
    @PreAuthorize("hasAnyAuthority('log:list')")
    public Result<LogDto> logList(PageTableRequest pageTableRequest, LogQuery logQuery){
        pageTableRequest.countOffset();
        return logService.getFuzzyInfoLogByPage(pageTableRequest.getOffset(),pageTableRequest.getLimit(),logQuery);
    }

    @GetMapping("/log/error/index")
    public String errorLogIndex(){
        return "system/log/errorLog";
    }

    @GetMapping("/error/log")
    @ResponseBody
    @ApiOperation(value = "用户列表")
    @PreAuthorize("hasAnyAuthority('log:list')")
    public Result<ErrorLogDto> errorLogList(PageTableRequest pageTableRequest, LogQuery logQuery){
        pageTableRequest.countOffset();
        return errorLogService.getFuzzyErrorLogByPage(pageTableRequest.getOffset(),pageTableRequest.getLimit(),logQuery);
    }


}
