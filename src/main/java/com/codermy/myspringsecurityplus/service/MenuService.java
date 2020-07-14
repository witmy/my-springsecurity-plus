package com.codermy.myspringsecurityplus.service;

import com.codermy.myspringsecurityplus.dto.MenuDto;
import com.codermy.myspringsecurityplus.entity.MyMenu;
import com.codermy.myspringsecurityplus.utils.Result;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
public interface MenuService {

    List<MyMenu> getMenuAll(String queryName,Integer queryType);

    MyMenu getMenuById(Integer id);

    List<MenuDto> buildMenuAll();

    Result updateMenu(MyMenu menu);

    Result<MyMenu> save(MyMenu menu);

    Result delete(Integer id);

    List<MenuDto> buildMenuAllByRoleId(Integer roleId);
}
