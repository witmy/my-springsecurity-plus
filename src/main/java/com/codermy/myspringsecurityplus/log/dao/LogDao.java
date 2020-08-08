package com.codermy.myspringsecurityplus.log.dao;

import com.codermy.myspringsecurityplus.log.dto.LogDto;
import com.codermy.myspringsecurityplus.log.dto.LogQuery;
import com.codermy.myspringsecurityplus.log.entity.MyLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/8
 */
@Mapper
public interface LogDao {

    @Insert("insert into my_log(user_name,ip,description,params,browser,method,time,create_time)values(#{userName},#{ip},#{description},#{params},#{browser},#{method},#{time},now())")
    void save(MyLog log);

    //分页返回所有用户
    List<LogDto> getFuzzyLogByPage(@Param("startPosition")Integer startPosition, @Param("limit")Integer limit, @Param("logQuery") LogQuery logQuery);

}
