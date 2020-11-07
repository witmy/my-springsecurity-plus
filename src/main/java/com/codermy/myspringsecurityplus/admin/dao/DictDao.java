package com.codermy.myspringsecurityplus.admin.dao;


import com.codermy.myspringsecurityplus.admin.entity.MyDict;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author codermy
 * @since 2020-09-03
 */
@Mapper
public interface DictDao {

    /**
     * 模糊查询字典
     * @param myDict 状态查询
     * @return
     */
    List<MyDict> getFuzzyDictByPage(MyDict myDict);

    /**
     * 通过字典名称获取字典信息
     * @param dictName
     * @return
     */
    MyDict getDictByName(String dictName);

    /**
     * 插入字典
     * @param myDict
     * @return
     */
    @Insert("INSERT INTO my_dict(dict_id,dict_name,description, sort,create_time, update_time)values(#{dictId},#{dictName},#{description},#{sort}, now(), now())")
    int insertDict(MyDict myDict);

    /**
     * 通过id获得字典信息
     * @param dictId
     * @return
     */
    @Select("select di.dict_id,di.dict_name,di.description,di.sort,di.create_time,di.update_time from my_dict di  where di.dict_id = #{dictId}")
    MyDict getDictById(Integer dictId);

    /**
     * 修改保存字典信息
     *
     * @param myDict 岗位信息
     * @return 结果
     */
    int updateDict(MyDict myDict);

    /**
     * 批量删除岗位信息
     *
     * @param dictIds 需要删除的数据ID
     * @return 结果
     */
    int deleteDictByIds(Integer[] dictIds);
}
