package com.codermy.myspringsecurityplus.service;

import com.codermy.myspringsecurityplus.entity.MyMenu;
import com.codermy.myspringsecurityplus.utils.Result;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
public interface MenuService {

    List<MyMenu> getMenuAll();
}
