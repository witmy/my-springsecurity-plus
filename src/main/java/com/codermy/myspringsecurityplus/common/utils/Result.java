package com.codermy.myspringsecurityplus.common.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 统一返回结果的类
 * @author codermy
 * @createTime 2020/5/15
 */
@Data
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String msg;

    @ApiModelProperty(value = "总数")
    private Long count;

    @ApiModelProperty(value = "返回数据")
    private List<T> data = new ArrayList<T>();

    @ApiModelProperty(value = "token数据")
    private String jwt;


    /**
     * 把构造方法私有
     */
    private Result() {}




    /**
     * 成功静态方法
     * @return
     */
    public static Result ok() {
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMsg("成功");
        return r;
    }


    /**
     * 失败静态方法
     * @return
     */
    public static Result error() {
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMsg("失败");
        return r;
    }

    public static Result judge(int n,String msg){
        return n > 0 ? ok().message(msg + "成功") : error().message(msg +"失败");
    }

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result message(String message){
        this.setMsg(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }


    public Result data(List<T> list){
        this.data.addAll(list);
        return this;
    }
    public Result count(Long count){
        this.count = count;
        return this;
    }
    public Result jwt(String jwt){
        this.jwt = jwt;
        return this;
    }
}

