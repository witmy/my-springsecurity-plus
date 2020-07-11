package com.codermy.myspringsecurityplus.service.impl;

import com.codermy.myspringsecurityplus.dao.MenuDao;
import com.codermy.myspringsecurityplus.entity.MyMenu;
import com.codermy.myspringsecurityplus.service.MenuService;
import com.codermy.myspringsecurityplus.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<MyMenu> getMenuAll() {
        return menuDao.findAll();
    }
}
