package com.codermy.myspringsecurityplus.admin.service;

import com.codermy.myspringsecurityplus.admin.dto.MenuDto;
import com.codermy.myspringsecurityplus.admin.dto.MenuIndexDto;
import com.codermy.myspringsecurityplus.admin.entity.MyMenu;
import com.codermy.myspringsecurityplus.common.utils.Result;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
public interface MenuService {
    /**
     * 返回菜单
     * @param queryName 用户名
     * @param queryType 类型
     * @return
     */
    List<MyMenu> getMenuAll(String queryName,Integer queryType);

    /**
     * 获取菜单信息
     * @param id
     * @return
     */
    MyMenu getMenuById(Integer id);

    /**
     * 菜单树
     * @return
     */
    List<MenuDto> buildMenuAll();

    /**
     * 跟新菜单
     * @param menu
     * @return
     */
    Result updateMenu(MyMenu menu);

    /**
     * 保存菜单
     * @param menu
     * @return
     */
    Result<MyMenu> save(MyMenu menu);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    Result delete(Integer id);

    /**
     * 通过权限id绘制菜单树
     * @param roleId
     * @return
     */
    List<MenuDto> buildMenuAllByRoleId(Integer roleId);

    /**
     * 通过用户id获取菜单
     * @param userId
     * @return
     */
    List<MenuIndexDto> getMenu(Integer userId);
}
