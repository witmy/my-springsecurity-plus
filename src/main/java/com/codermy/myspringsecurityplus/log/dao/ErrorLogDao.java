package com.codermy.myspringsecurityplus.log.dao;

import com.codermy.myspringsecurityplus.log.dto.ErrorLogDto;
import com.codermy.myspringsecurityplus.log.dto.LogQuery;
import com.codermy.myspringsecurityplus.log.entity.MyErrorLog;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/8
 */
@Mapper
public interface ErrorLogDao {
    @Insert("insert into my_error_log(user_name,ip,params,detail,description,browser,method,create_time)values(#{userName},#{ip},#{params},#{detail},#{description},#{browser},#{method},now())")
    void save(MyErrorLog errorLog);

    List<ErrorLogDto> getFuzzyErrorLogByPage(Integer startPosition, Integer limit, LogQuery logQuery);
}
