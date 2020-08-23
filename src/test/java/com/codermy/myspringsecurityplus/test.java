package com.codermy.myspringsecurityplus;

import com.codermy.myspringsecurityplus.admin.dao.DeptDao;
import com.codermy.myspringsecurityplus.admin.dto.DeptDto;
import com.codermy.myspringsecurityplus.common.utils.TreeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/22
 */
@SpringBootTest
public class test {
    @Autowired
    private DeptDao deptDao;


    @Test
    public void a(){
        List<DeptDto> selectRoleDeptTree = deptDao.selectRoleDeptTree(2);
        System.out.println(selectRoleDeptTree);
        DeptDto deptDto = new DeptDto();
        List<DeptDto> buildAll = deptDao.buildAll(deptDto);
        System.out.println(buildAll);
        List<DeptDto> tree = TreeUtil.deptTree(selectRoleDeptTree, buildAll);
        System.out.println(tree);
    }
}
