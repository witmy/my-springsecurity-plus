package com.codermy.myspringsecurityplus.admin.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.codermy.myspringsecurityplus.admin.annotation.DataPermission;
import com.codermy.myspringsecurityplus.admin.dao.DeptDao;
import com.codermy.myspringsecurityplus.admin.dto.DeptDto;
import com.codermy.myspringsecurityplus.admin.entity.MyDept;
import com.codermy.myspringsecurityplus.admin.service.DeptService;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.ResultCode;
import com.codermy.myspringsecurityplus.common.utils.TreeUtil;
import com.codermy.myspringsecurityplus.common.utils.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    @DataPermission(deptAlias = "d")
    public List<MyDept> getDeptAll(MyDept myDept) {
        return deptDao.getFuzzyDept(myDept);
    }

    @Override
    @DataPermission(deptAlias = "d")
    public List<DeptDto> buildDeptAll(DeptDto deptDto) {
        return deptDao.buildAll(deptDto);
    }

    @Override
    @DataPermission(deptAlias = "d")
    public List<DeptDto> roleDeptTreeData(Integer roleId) {
        List<DeptDto> selectRoleDeptTree = deptDao.selectRoleDeptTree(roleId);
        DeptDto deptDto = new DeptDto();
        List<DeptDto> buildAll = deptDao.buildAll(deptDto);
        List<DeptDto> tree = TreeUtil.deptTree(selectRoleDeptTree, buildAll);
        return tree;
    }

    @Override
    public int insertDept(MyDept dept) {
        MyDept info = deptDao.selectDeptById(dept.getParentId());
        if (UserConstants.DEPT_DISABLE.equals(info.getStatus().toString()))
        {
            throw new MyException(ResultCode.ERROR,"部门停用，不允许新增");
        }
        dept.setAncestors(info.getAncestors() + "," + dept.getParentId());
        return deptDao.insertDept(dept);
    }

    @Override
    public String checkDeptNameUnique(MyDept dept) {
        MyDept info = deptDao.checkDeptNameUnique(dept.getName(),dept.getParentId());
        if (ObjectUtil.isNotEmpty(info) && !info.getId().equals(dept.getId())){
            return UserConstants.DEPT_NAME_NOT_UNIQUE;
        }
        return UserConstants.DEPT_NAME_UNIQUE;

    }

    @Override
    public MyDept selectDeptById(Integer id) {
        return deptDao.selectDeptById(id);
    }

    @Override
    public MyDept getDeptById(Integer id) {
        return deptDao.getDeptById(id);
    }

    @Override
    public int updateDept(MyDept dept) {
        MyDept parentInfo = deptDao.selectDeptById(dept.getParentId());
        MyDept oldInfo = selectDeptById(dept.getId());
        if(ObjectUtil.isNotEmpty(parentInfo) &&ObjectUtil.isNotEmpty(oldInfo)){
            String newAncestors = parentInfo.getAncestors() + "," + parentInfo.getId();
            String oldAncestors = oldInfo.getAncestors();
            dept.setAncestors(newAncestors);
            updateDeptChildren(dept.getId(), newAncestors, oldAncestors);
        }
        int result =deptDao.updateDept(dept);
        if (UserConstants.DEPT_NORMAL.equals(dept.getStatus().toString()))
        {
            // 如果该部门是启用状态，则启用该部门的所有上级部门
            updateParentDeptStatus(dept);
        }
        return result;
    }

    @Override
    public int selectNormalChildrenDeptById(Integer id) {
        return deptDao.selectNormalChildrenDeptById(id);
    }

    @Override
    public int selectDeptCount(Integer parentId) {
        MyDept dept =new MyDept();
        dept.setParentId(parentId);
        return deptDao.selectDeptCount(dept);
    }

    @Override
    public boolean checkDeptExistUser(Integer id) {
        int result = deptDao.checkDeptExistUser(id);
        return result > 0 ? true : false;
    }

    /**
     * 修改子元素关系
     *
     * @param id 被修改的部门ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateDeptChildren(Integer id, String newAncestors, String oldAncestors)
    {
        List<MyDept> children = deptDao.selectChildrenDeptById(id);
        for (MyDept child : children)
        {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            deptDao.updateDeptChildren(children);
        }
    }

    /**
     * 修改该部门的父级部门状态
     *
     * @param dept 当前部门
     */
    private void updateParentDeptStatus(MyDept dept)
    {
        dept = deptDao.selectDeptById(dept.getId());;
        deptDao.updateDeptStatus(dept);
    }
}
