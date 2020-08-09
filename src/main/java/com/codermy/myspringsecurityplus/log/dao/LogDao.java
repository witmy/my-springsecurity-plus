package com.codermy.myspringsecurityplus.log.dao;

import com.codermy.myspringsecurityplus.log.dto.ErrorLogDto;
import com.codermy.myspringsecurityplus.log.dto.LogDto;
import com.codermy.myspringsecurityplus.log.dto.LogQuery;
import com.codermy.myspringsecurityplus.log.entity.MyLog;
import org.apache.ibatis.annotations.Delete;
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

    @Insert("insert into my_log(user_name,ip,description,params,type,exception_detail,browser,method,time,create_time)values(#{userName},#{ip},#{description},#{params},#{type},#{exceptionDetail},#{browser},#{method},#{time},now())")
    void save(MyLog log);

    //分页返回所有用户日志
    List<LogDto> getFuzzyLogByPage( @Param("logQuery") LogQuery logQuery);

    //分页返回所有错误日志
    List<ErrorLogDto> getFuzzyErrorLogByPage(@Param("logQuery") LogQuery logQuery);


    @Delete("delete from my_log where type = #{type}")
    void delAllByInfo(String type);
}
