package com.codermy.myspringsecurityplus.admin.service;

import com.codermy.myspringsecurityplus.admin.entity.MyDict;
import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.Result;

import java.util.List;

public interface DictService {

    /**
     * 分页返回字典
     * @return
     */
    Result<MyDict> getDictPage(Integer offectPosition, Integer limit, MyDict myDict);

    /**
     * 通过字典名获取字典
     * @param dictName
     * @return
     */
    MyDict getDictByName(String dictName);

    /**
     * 校验字典名称
     *
     * @param myDict 岗位信息
     * @return 结果
     */
    String checkDictNameUnique(MyDict myDict);

    /**
     * 新增字典信息
     * @param myDict 岗位信息
     * @return 结果
     */
    int insertDict(MyDict myDict);

    /**
     * 通过id获得字典信息
     * @param dictId
     * @return
     */
    MyDict getDictById(Integer dictId);

    /**
     * 修改保存自带你信息
     *
     * @param myDict 岗位信息
     * @return 结果
     */
    int updateDict(MyDict myDict);

    /**
     * 批量删除岗位信息
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws MyException 异常
     */
    int deleteDictByIds(String ids)throws MyException;
}
