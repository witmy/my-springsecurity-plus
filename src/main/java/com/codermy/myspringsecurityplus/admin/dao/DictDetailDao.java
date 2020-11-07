package com.codermy.myspringsecurityplus.admin.dao;

import com.codermy.myspringsecurityplus.admin.entity.MyDictDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author codermy
 * @since 2020-09-03
 */
@Mapper
public interface DictDetailDao {

    List<MyDictDetail> getDictDetail(Integer dictId);
    /**
     * 插入字典详情
     * @param myDictDetail
     * @return
     */
    @Insert("INSERT INTO my_dict_detail(dict_id,label,value, sort,create_time, update_time)values(#{dictId},#{label},#{value},#{sort}, now(), now())")
    int insertDictDetail(MyDictDetail myDictDetail);

    /**
     * 通过id获得字典详情信息
     * @param id
     * @return
     */
    @Select("select did.id,did.dict_id,did.label,did.sort,did.create_time,did.update_time from my_dict_detail did  where did.id = #{id}")
    MyDictDetail getDictDetailById(Integer id);

    /**
     * 修改保存字典详情信息
     *
     * @param myDictDetail 岗位信息
     * @return 结果
     */
    int updateDictDetail(MyDictDetail myDictDetail);

    /**
     * 批量删除字典详情
     *
     * @param dictDetailIds 需要删除的数据ID
     * @return 结果
     */
    int deleteDictDetailByIds(Integer[] dictDetailIds);
}
