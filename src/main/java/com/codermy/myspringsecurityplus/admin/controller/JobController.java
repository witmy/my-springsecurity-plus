package com.codermy.myspringsecurityplus.admin.controller;

import com.codermy.myspringsecurityplus.admin.dto.JobQueryDto;
import com.codermy.myspringsecurityplus.admin.entity.MyJob;
import com.codermy.myspringsecurityplus.admin.service.JobService;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.ResultCode;
import com.codermy.myspringsecurityplus.common.utils.UserConstants;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Controller
@RequestMapping("/api/job")
@Api(tags = "系统：岗位管理")
public class JobController {

    @Autowired
    private JobService jobService;
    @GetMapping("index")
    @ApiOperation(value = "返回岗位页面")
    public String index(){
        return "system/job/job";
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "岗位列表")
    @PreAuthorize("hasAnyAuthority('job:list')")
    @MyLog("查询岗位")
    public Result getJobAll(PageTableRequest pageTableRequest, JobQueryDto jobQueryDto){
        pageTableRequest.countOffset();
        return jobService.getJobAll(pageTableRequest.getOffset(),pageTableRequest.getLimit(),jobQueryDto);
    }

    @GetMapping("/add")
    @ApiOperation(value = "添加岗位页面")
    @PreAuthorize("hasAnyAuthority('job:add')")
    public String addJob(Model model){
        model.addAttribute("MyJob",new MyJob());
        return "/system/job/job-add";
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "添加岗位")
    @PreAuthorize("hasAnyAuthority('job:add')")
    @MyLog("添加岗位")
    public Result saveJob(@RequestBody MyJob myJob){
        if (UserConstants.JOB_NAME_NOT_UNIQUE.equals(jobService.checkJobNameUnique(myJob))) {
            return Result.error().message("新增岗位'" + myJob.getJobName() + "'失败，岗位名称已存在");
        }
        return Result.judge(jobService.insertJob(myJob),"添加岗位");
    }

    @GetMapping(value = "/edit")
    @ApiOperation(value = "修改岗位页面")
    @PreAuthorize("hasAnyAuthority('job:edit')")
    public String editRole(Model model, MyJob job) {
        model.addAttribute("MyJob",jobService.getJobById(job.getJobId()));
        return "system/job/job-edit";
    }
    @PutMapping
    @ResponseBody
    @ApiOperation(value = "修改岗位")
    @PreAuthorize("hasAnyAuthority('job:edit')")
    @MyLog("修改岗位")
    public Result updateJob(@RequestBody MyJob myJob){
        if (UserConstants.JOB_NAME_NOT_UNIQUE.equals(jobService.checkJobNameUnique(myJob))) {
            return Result.error().message("修改岗位'" + myJob.getJobName() + "'失败，岗位名称已存在");
        }
        return Result.judge(jobService.updateJob(myJob),"修改岗位");
    }
    /**
     * 用户状态修改
     */
    @MyLog("修改岗位状态")
    @PutMapping("/changeStatus")
    @ResponseBody
    @ApiOperation(value = "修改岗位状态")
    @PreAuthorize("hasAnyAuthority('job:edit')")
    public Result changeStatus(@RequestBody MyJob myJob)
    {
        int i = jobService.changeStatus(myJob);
        return Result.judge(i,"修改");
    }

    @DeleteMapping
    @ResponseBody
    @ApiOperation(value = "删除岗位")
    @PreAuthorize("hasAnyAuthority('job:del')")
    public Result<MyJob> deleteRole(String ids) {
        try {
            jobService.deleteJobByIds(ids);
            return Result.ok().message("删除成功");
        }catch (MyException e){
            return Result.error().message(e.getMsg()).code(e.getCode());
        }
    }
}
