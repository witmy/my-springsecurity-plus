package com.codermy.myspringsecurityplus.admin.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/23
 */
@Mapper
public interface RoleDeptDao {

    /**
     * 通过id删除与部门关联
     * @param roleId
     * @return
     */
    @Delete("delete from my_role_dept where role_id = #{roleId}")
    int deleteRoleDept(Integer roleId);

    /**
     * 新建角色与部门的联系
     * @param id
     * @param deptIds
     */
    void save(@Param("roleId")Integer id, @Param("deptIds") List<Integer> deptIds);
}
