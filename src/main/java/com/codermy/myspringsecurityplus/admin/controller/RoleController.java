package com.codermy.myspringsecurityplus.admin.controller;

import com.codermy.myspringsecurityplus.admin.dto.RoleDto;
import com.codermy.myspringsecurityplus.admin.entity.MyRole;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import com.codermy.myspringsecurityplus.admin.service.RoleService;
import com.codermy.myspringsecurityplus.common.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Controller
@RequestMapping("/api/role")
@Api(tags = "系统：角色管理")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/index")
    @PreAuthorize("hasAnyAuthority('role:list')")
    public String index(){
        return "system/role/role";
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "分页返回角色列表")
    @PreAuthorize("hasAnyAuthority('role:list')")
    @MyLog("查询角色")
    public Result roleList(PageTableRequest request,MyRole myRole) {
        request.countOffset();
        return roleService.getFuzzyRolesByPage(request.getOffset(), request.getLimit(),myRole);
    }

    @GetMapping(value = "/edit")
    @ApiOperation(value = "修改角色页面")
    @PreAuthorize("hasAnyAuthority('role:edit')")
    public String editRole(Model model, MyRole role) {
        model.addAttribute("MyRole",roleService.getRoleById(role.getRoleId()));
        return "system/role/role-edit";
    }

    @GetMapping(value = "/edit/dataScope")
    @ApiOperation(value = "修改角色页面")
    @PreAuthorize("hasAnyAuthority('role:edit')")
    public String editRoleDataScope(Model model, MyRole role) {
        model.addAttribute("MyRole",roleService.getRoleById(role.getRoleId()));
        return "system/role/role-dataScope";
    }

    @PutMapping
    @ResponseBody
    @ApiOperation(value = "修改角色")
    @PreAuthorize("hasAnyAuthority('role:edit')")
    @MyLog("修改角色")
    public Result updateRole(@RequestBody RoleDto roleDto) {

        return roleService.update(roleDto);
    }

    @PutMapping(value = "/authDataScope")
    @ResponseBody
    @ApiOperation(value = "修改角色数据权限")
    public Result updateauthDataScope(@RequestBody RoleDto roleDto) {

        return roleService.authDataScope(roleDto);
    }

    @GetMapping(value = "/add")
    @ApiOperation(value = "添加角色页面")
    @PreAuthorize("hasAnyAuthority('role:add')")
    public String addRole(Model model) {
        model.addAttribute("MyRole",new MyRole());
        return "/system/role/role-add";
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "添加角色")
    @PreAuthorize("hasAnyAuthority('role:add')")
    @MyLog("添加角色")
    public Result saveRole(@RequestBody RoleDto roleDto) {
        return roleService.save(roleDto);
    }

    @DeleteMapping
    @ResponseBody
    @ApiOperation(value = "删除角色")
    @PreAuthorize("hasAnyAuthority('role:del')")
    @MyLog("删除角色")
    public Result<MyRole> deleteRole(RoleDto roleDto) {
        return roleService.delete(roleDto.getRoleId());
    }

    @GetMapping("/all")
    @ResponseBody
    @ApiOperation(value = "角色列表")
    @PreAuthorize("hasAnyAuthority('user:list')")
    public Result<MyRole> getAll(){
        return roleService.getAllRoles();
    }
}
