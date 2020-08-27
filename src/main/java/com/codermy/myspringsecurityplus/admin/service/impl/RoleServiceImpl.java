package com.codermy.myspringsecurityplus.admin.service.impl;

import com.codermy.myspringsecurityplus.admin.annotation.DataPermission;
import com.codermy.myspringsecurityplus.admin.dao.RoleDao;
import com.codermy.myspringsecurityplus.admin.dao.RoleDeptDao;
import com.codermy.myspringsecurityplus.admin.dao.RoleMenuDao;
import com.codermy.myspringsecurityplus.admin.dao.RoleUserDao;
import com.codermy.myspringsecurityplus.admin.dto.RoleDto;
import com.codermy.myspringsecurityplus.admin.entity.MyRole;
import com.codermy.myspringsecurityplus.admin.entity.MyRoleUser;
import com.codermy.myspringsecurityplus.admin.service.RoleService;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.ResultCode;
import com.codermy.myspringsecurityplus.common.utils.UserConstants;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private RoleUserDao roleUserDao;
    @Autowired
    private RoleDeptDao roleDeptDao;

    @Override
    @DataPermission(deptAlias = "d")
    public Result<MyRole> getFuzzyRolesByPage(Integer offectPosition, Integer limit,MyRole myRole) {
        Page page = PageHelper.offsetPage(offectPosition,limit);
        List<MyRole> fuzzyRolesByPage = roleDao.getFuzzyRolesByPage(myRole);
        return Result.ok().count(page.getTotal()).data(fuzzyRolesByPage).code(ResultCode.TABLE_SUCCESS);
    }

    @Override
    public MyRole getRoleById(Integer id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public Result update(RoleDto roleDto) {
        List<Integer> menuIds = roleDto.getMenuIds();
        menuIds.remove(0L);
        //1、更新角色权限之前要删除该角色之前的所有权限
        roleMenuDao.deleteRoleMenu(roleDto.getRoleId());
        //2、判断该角色是否有赋予权限值，有就添加"
        if (!CollectionUtils.isEmpty(menuIds)) {
            roleMenuDao.save(roleDto.getRoleId(), menuIds);
        }
        //3、更新角色表
        int countData = roleDao.update(roleDto);
        if(countData > 0){
            return Result.ok().message("更新成功");
        }else{
            return Result.error().message("更新失败");
        }
    }

    @Override
    public Result authDataScope(RoleDto roleDto) {
        if (roleDto.getDataScope().equals(UserConstants.DATA_SCOPE_CUSTOM)){
            List<Integer> deptIds = roleDto.getDeptIds();
            deptIds.remove(0L);
            roleDeptDao.deleteRoleDept(roleDto.getRoleId());
            if (!CollectionUtils.isEmpty(deptIds)) {
                roleDeptDao.save(roleDto.getRoleId(), deptIds);
            }
            roleDao.update(roleDto);
        }else {
            roleDao.update(roleDto);
            roleDeptDao.deleteRoleDept(roleDto.getRoleId());
        }
        return Result.ok().message("更新成功");
    }

    @Override
    public Result save(RoleDto roleDto) {
        roleDto.setDataScope("1");
        //1、先保存角色"
        roleDao.saveRole(roleDto);
        List<Integer> menuIds = roleDto.getMenuIds();
        //移除0,permission id是从1开始
        //2、保存角色对应的所有权限
        if (!CollectionUtils.isEmpty(menuIds)) {
            roleMenuDao.save(roleDto.getRoleId(), menuIds);
        }
        return Result.ok().message("插入成功");
    }

    @Override
    public Result<MyRole> delete(Integer id) {
        List<MyRoleUser> tbRoleUsers = roleUserDao.listAllRoleUserByRoleId(id);
        if(tbRoleUsers.size() <= 0){
            roleMenuDao.deleteRoleMenu(id);
            roleDao.delete(id);
            roleDeptDao.deleteRoleDept(id);
            return Result.ok().message("删除成功");
        }
        return Result.error().message("该角色已经关联,无法删除");
    }

    @Override
    public Result<MyRole> getAllRoles() {
        return Result.ok().data(roleDao.getAllRoles());
    }
}
