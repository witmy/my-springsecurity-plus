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
     * @param deptDto
     * @return
     */
    List<DeptDto> buildDeptAll(DeptDto deptDto);


    /**
     * 根据角色ID查询菜单
     *
     * @param roleId 角色对象
     * @return 菜单列表
     */
    List<DeptDto> roleDeptTreeData(Integer roleId);

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
     * @param deptId 部门ID
     * @return 部门信息
     */
    public MyDept selectDeptById(Integer deptId);

    /**
     * 通过id查询部门信息
     * @param deptId
     * @return
     */
    MyDept getDeptById(Integer deptId);

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
     * @param deptId 部门ID
     * @return 子部门数
     */
    int selectNormalChildrenDeptById(Integer deptId);

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
     * @param deptId 部门ID
     * @return 结果 true 存在 false 不存在
     */
     boolean checkDeptExistUser(Integer deptId);

    /**
     * 删除部门管理信息
     *
     * @param deptId 部门ID
     * @return 结果
     */
     int deleteDeptById(Integer deptId);
    /**
     * 修改部门状态
     * @param myDept
     * @return
     */
     int changeStatus(MyDept myDept);
}
