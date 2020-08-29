package com.codermy.myspringsecurityplus.admin.dao;

import com.codermy.myspringsecurityplus.admin.dto.DeptDto;
import com.codermy.myspringsecurityplus.admin.entity.MyDept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Mapper
public interface DeptDao {
    /**
     * 模糊查询部门
     * @param myDept 查询的名称
     * @return
     */
    List<MyDept> getFuzzyDept(MyDept myDept);


    /**
     * 部门树
     * @param deptDto
     * @return
     */
    List<DeptDto> buildAll(DeptDto deptDto);

    /**
     * 校验部门名称
     * @param deptName 岗位名称
     * @param parentId
     * @return
     */
    MyDept checkDeptNameUnique(@Param("deptName")String deptName,@Param("parentId") Integer parentId);


    /**
     * 新增部门信息
     * @param dept 岗位信息
     * @return 结果
     */
    @Insert("INSERT INTO my_dept(parent_id,ancestors,dept_name,sort,status, create_time, update_time) values(#{parentId},#{ancestors},#{deptName},#{sort},#{status}, now(), now())")
    int insertDept(MyDept dept);
    /**
     * 根据部门ID查询信息
     * @param deptId 部门ID
     * @return 部门信息
     */
    MyDept selectDeptById(Integer deptId);

    /**
     * 通过id查询部门信息
     * @param deptId
     * @return
     */
    @Select("select d.dept_id,d.parent_id,d.ancestors,d.dept_name,d.sort,d.status,d.create_time,d.update_time from my_dept d where d.dept_id = #{deptId}")
    MyDept getDeptById(Integer deptId);


    /**
     * 根据ID查询所有子部门
     *
     * @param id 部门ID
     * @return 部门列表
     */
     List<MyDept> selectChildrenDeptById(Integer id);


    /**
     * 根据角色ID查询部门
     *
     * @param id 角色ID
     * @return 部门列表
     */
     List<DeptDto> selectRoleDeptTree(Integer id);
    /**
     * 修改子元素关系
     *
     * @param depts 子元素
     * @return 结果
     */
    int updateDeptChildren(@Param("depts")List<MyDept> depts);

    /**
     * 修改部门信息
     *
     * @param dept 部门信息
     * @return 结果
     */
    int updateDept(MyDept dept);

    /**
     * 修改所在部门的父级部门状态
     *
     * @param dept 部门
     */
     void updateDeptStatus(MyDept dept);

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
     * @param dept 部门信息
     * @return 结果
     */
    int selectDeptCount(MyDept dept);

    /**
     * 查询部门是否存在用户
     *
     * @param deptId 部门ID
     * @return 结果
     */
    int checkDeptExistUser(Integer deptId);

    /**
     * 删除部门管理信息
     *
     * @param deptId 部门ID
     * @return 结果
     */
    int deleteDeptById(Integer deptId);
}
