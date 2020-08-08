package com.codermy.myspringsecurityplus.controller;

import com.alibaba.fastjson.JSONArray;
import com.codermy.myspringsecurityplus.dto.MenuDto;
import com.codermy.myspringsecurityplus.dto.MenuIndexDto;
import com.codermy.myspringsecurityplus.entity.MyMenu;
import com.codermy.myspringsecurityplus.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import com.codermy.myspringsecurityplus.service.MenuService;
import com.codermy.myspringsecurityplus.utils.Result;
import com.codermy.myspringsecurityplus.utils.ResultCode;
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
 * @createTime 2020/7/10
 */
@Controller
@RequestMapping("/api/menu")
@Api(tags = "系统：菜单管理")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("index")
    @PreAuthorize("hasAnyAuthority('menu:list')")
    public String index(){
        return "system/menu/power";
    }
    @GetMapping
    @ResponseBody
    @ApiOperation(value = "菜单列表")
    @PreAuthorize("hasAnyAuthority('menu:list')")
    @MyLog("查询菜单")
    public Result getMenuAll(String queryName,Integer queryType){
        if (0 == 0){
            throw new MyException(1111,"测试异常");
        }
        return Result.ok().data(menuService.getMenuAll(queryName,queryType)).code(ResultCode.TABLE_SUCCESS);
    }

    @GetMapping("/build")
    @ResponseBody
    @ApiOperation(value = "绘制菜单树")
    @PreAuthorize("hasAnyAuthority('menu:add','menu:edit')")
    @MyLog("绘制菜单树")
    public Result buildMenuAll(){
        List<MenuDto> menuAll =menuService.buildMenuAll();
        return Result.ok().data(menuAll);
    }

    @GetMapping("/ebuild/{roleId}")
    @ResponseBody
    @ApiOperation(value = "通过id绘制菜单树")
    @PreAuthorize("hasAnyAuthority('role:add','role:edit')")
    @MyLog("通过id绘制菜单树")
    public Result buildMenuAllByRoleId(@PathVariable Integer roleId){
        List<MenuDto> menuAll =menuService.buildMenuAllByRoleId(roleId);
        return Result.ok().data(menuAll);
    }

    @GetMapping(value = "/edit")
    @ApiOperation(value = "修改菜单页面")
    @PreAuthorize("hasAnyAuthority('menu:edit')")
    public String editPermission(Model model, MyMenu myMenu) {
        model.addAttribute("myMenu",menuService.getMenuById(myMenu.getId()));
        return "system/menu/menu-edit";
    }

    @PutMapping
    @ResponseBody
    @ApiOperation(value = "修改菜单")
    @PreAuthorize("hasAnyAuthority('menu:edit')")
    @MyLog("修改菜单")
    public Result updateMenu(@RequestBody MyMenu menu) {
        return menuService.updateMenu(menu);
    }


    @GetMapping(value = "/add")
    @ApiOperation(value = "添加菜单页面")
    @PreAuthorize("hasAnyAuthority('menu:add')")
    public String addMenu(Model model) {
        model.addAttribute("myMenu",new MyMenu());
        return "system/menu/menu-add";
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "添加菜单")
    @PreAuthorize("hasAnyAuthority('menu:add')")
    @MyLog("添加菜单")
    public Result<MyMenu> savePermission(@RequestBody MyMenu myMenu) {
        return menuService.save(myMenu);
    }

    //todo 批量删除
    @DeleteMapping
    @ResponseBody
    @ApiOperation(value = "删除菜单")
    @PreAuthorize("hasAnyAuthority('menu:del')")
    @MyLog("删除菜单")
    public Result deleteMenu(Integer id) {
        return menuService.delete(id);
    }

}
