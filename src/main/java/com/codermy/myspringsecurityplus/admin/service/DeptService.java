package com.codermy.myspringsecurityplus.admin.service;

import com.codermy.myspringsecurityplus.admin.dto.DeptDto;
import com.codermy.myspringsecurityplus.admin.entity.MyDept;
import com.codermy.myspringsecurityplus.common.utils.Result;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
public interface DeptService {
    /**
     * 返回部门
     * @param myDept 名称
     * @return
     */
    List<MyDept> getDeptAll(MyDept myDept);

    /**
     * 部门树
     * @return
     */
    List<DeptDto> buildDeptAll(DeptDto deptDto);


    /**
     * 根据角色ID查询菜单
     *
     * @param id 角色对象
     * @return 菜单列表
     */
    List<DeptDto> roleDeptTreeData(Integer id);

    /**
     * 新增部门信息
     * @param myDept 岗位信息
     * @return 结果
     */
    int insertDept(MyDept myDept);

    /**
     * 校验部门名称是否唯一
     *
     * @param dept 部门信息
     * @return 结果
     */
    String checkDeptNameUnique(MyDept dept);

    /**
     * 根据部门ID查询信息
     *
     * @param id 部门ID
     * @return 部门信息
     */
    public MyDept selectDeptById(Integer id);

    /**
     * 通过id查询部门信息
     * @param id
     * @return
     */
    MyDept getDeptById(Integer id);

    /**
     * 修改保存部门信息
     *
     * @param dept 部门信息
     * @return 结果
     */
    int updateDept(MyDept dept);

    /**
     * 根据ID查询所有子部门（正常状态）
     *
     * @param id 部门ID
     * @return 子部门数
     */
    int selectNormalChildrenDeptById(Integer id);

    /**
     * 查询部门人数
     *
     * @param parentId 父部门ID
     * @return 结果
     */
    int selectDeptCount(Integer parentId);;
    /**
     * 查询部门是否存在用户
     *
     * @param id 部门ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkDeptExistUser(Integer id);
}
