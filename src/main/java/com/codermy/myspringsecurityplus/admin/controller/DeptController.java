package com.codermy.myspringsecurityplus.admin.controller;

import com.codermy.myspringsecurityplus.admin.dto.DeptDto;
import com.codermy.myspringsecurityplus.admin.entity.MyDept;
import com.codermy.myspringsecurityplus.admin.service.DeptService;
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

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Controller
@RequestMapping("/api/dept")
@Api(tags = "系统：部门管理")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("index")
    @ApiOperation(value = "返回部门页面")
    public String index(){
        return "system/dept/dept";
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "部门列表")
    @PreAuthorize("hasAnyAuthority('dept:edit')")
    @MyLog("查询部门")
    public Result getDeptAll(MyDept myDept){
        return Result.ok().data(deptService.getDeptAll(myDept)).code(ResultCode.TABLE_SUCCESS);
    }


    @GetMapping("build")
    @ResponseBody
    @ApiOperation(value = "绘制部门树")
    @PreAuthorize("hasAnyAuthority('dept:add','dept:edit')")
    @MyLog("绘制部门树")
    public Result buildDeptAll(DeptDto deptDto){
        List<DeptDto> deptAll =deptService.buildDeptAll(deptDto);
        return Result.ok().data(deptAll);
    }

    @GetMapping("/add")
    @ApiOperation(value = "添加部门页面")
    @PreAuthorize("hasAnyAuthority('dept:add')")
    public String addJob(Model model){
        model.addAttribute("myDept",new MyDept());
        return "/system/dept/dept-add";
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "添加部门")
    @PreAuthorize("hasAnyAuthority('dept:add')")
    @MyLog("添加部门")
    public Result<MyDept> savePermission(@RequestBody MyDept dept) {

        if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals( deptService.checkDeptNameUnique(dept))) {
            return Result.error().message("新增岗位'" + dept.getDeptName() + "'失败，岗位名称已存在");
        }
        int i = deptService.insertDept(dept);
        return Result.judge(i,"添加");
    }

    @GetMapping(value = "/edit")
    @ApiOperation(value = "修改部门页面")
    @PreAuthorize("hasAnyAuthority('dept:edit')")
    public String editPermission(Model model, MyDept dept) {
        model.addAttribute("myDept",deptService.getDeptById(dept.getDeptId()));
        return "system/dept/dept-edit";
    }

    @PutMapping
    @ResponseBody
    @ApiOperation(value = "修改部门")
    @PreAuthorize("hasAnyAuthority('dept:edit')")
    @MyLog("修改部门")
    public Result updateMenu(@RequestBody MyDept dept) {
        if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals( deptService.checkDeptNameUnique(dept))) {
            return Result.error().message("更新岗位'" + dept.getDeptName() + "'失败，岗位名称已存在");
        } else if (dept.getParentId().equals(dept.getDeptId()))
        {
            return Result.error().message("修改部门'" + dept.getDeptName() + "'失败，上级部门不能是自己");
        }else if (dept.getStatus().toString().equals(UserConstants.DEPT_DISABLE)
                && deptService.selectNormalChildrenDeptById(dept.getDeptId()) > 0)
        {
            return Result.error().message("该部门包含未停用的子部门！");
        }
        int i = deptService.updateDept(dept);
        return Result.judge(i,"修改");
    }

    /**
     * 用户状态修改
     */
    @MyLog("修改部门状态")
    @PutMapping("/changeStatus")
    @ResponseBody
    @ApiOperation(value = "修改部门状态")
    @PreAuthorize("hasAnyAuthority('dept:edit')")
    public Result changeStatus(@RequestBody MyDept myDept)
    {

        return Result.judge(deptService.changeStatus(myDept),"修改");
    }
    @DeleteMapping
    @ResponseBody
    @ApiOperation(value = "删除部门")
    @PreAuthorize("hasAnyAuthority('dept:del')")
    @MyLog("删除部门")
    public Result<MyDept> deleteRole(Integer deptId) {
        if (deptService.selectDeptCount(deptId) > 0){
            return Result.error().message("存在下级部门,不允许删除");
        }
        if (deptService.checkDeptExistUser(deptId))
        {
            return Result.error().message("部门存在用户,不允许删除");
        }
        int i = deptService.deleteDeptById(deptId);
        return Result.judge(i,"删除");
    }

    /**
     * 加载角色部门（数据权限）列表树
     */
    @GetMapping("/ebuild/{roleId}")
    @ResponseBody
    @ApiOperation(value = "通过id绘制部门树")
    @PreAuthorize("hasAnyAuthority('role:add','role:edit')")
    @MyLog("通过id绘制部门树")
    public Result deptTreeData(@PathVariable Integer roleId)
    {
        List<DeptDto> deptDtos = deptService.roleDeptTreeData(roleId);
        return Result.ok().data(deptDtos);
    }


}
