package com.codermy.myspringsecurityplus.admin.service.impl;

import com.codermy.myspringsecurityplus.admin.dao.MenuDao;
import com.codermy.myspringsecurityplus.admin.dao.RoleMenuDao;
import com.codermy.myspringsecurityplus.admin.dto.MenuDto;
import com.codermy.myspringsecurityplus.admin.dto.MenuIndexDto;
import com.codermy.myspringsecurityplus.admin.entity.MyMenu;
import com.codermy.myspringsecurityplus.admin.service.MenuService;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private RoleMenuDao roleMenuDao;
    @Override
    public List<MyMenu> getMenuAll(String queryName,Integer queryType) {

        return menuDao.getFuzzyMenu(queryName,queryType);
    }

    @Override
    public MyMenu getMenuById(Integer id) {
        return menuDao.getMenuById(id);
    }

    @Override
    public List<MenuDto> buildMenuAll() {
        return menuDao.buildAll();
    }

    @Override
    public Result updateMenu(MyMenu menu) {
        menu.setIcon("layui-icon "+menu.getIcon());
        return (menuDao.update(menu) > 0) ? Result.ok().message("修改成功") : Result.error().message("修改失败");

    }

    @Override
    public Result<MyMenu> save(MyMenu menu) {
        menu.setIcon("layui-icon "+menu.getIcon());
        return (menuDao.save(menu) > 0) ? Result.ok().message("添加成功") : Result.error().message("添加失败");

    }



    /**
     * 如果这里删除了菜单树的父节点，把它的子节点一并删除
     * @param id
     * @return
     */
    @Override
    public Result delete(Integer id) {
        Integer count = roleMenuDao.countRoleMenuByRoleId(id);
        if (count == 0){
            menuDao.deleteById(id);
            List<Integer> list = menuDao.selectByParentId(id);
            if(list.size()>0){
                for (Integer parentId: list){
                    menuDao.deleteByParentId(parentId);
                }
                menuDao.deleteByParentId(id);
            }
            return Result.ok().message("删除成功");
        }
        else {
            return Result.error().message("已经有角色分配该菜单，无法删除");
        }

    }

    @Override
    public List<MenuDto> buildMenuAllByRoleId(Integer roleId) {
        List<MenuDto> listByRoleId = menuDao.listByRoleId(roleId);
        List<MenuDto> permissionDtos = menuDao.buildAll();
        List<MenuDto> tree = TreeUtil.menutree(listByRoleId, permissionDtos);
        return tree;
    }

    @Override
    public List<MenuIndexDto> getMenu(Integer userId) {
        List<MenuIndexDto> list = menuDao.listByUserId(userId);
        List<MenuIndexDto> result = TreeUtil.parseMenuTree(list);
        return result;
    }
}
