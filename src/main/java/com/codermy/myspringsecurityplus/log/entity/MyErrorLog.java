package com.codermy.myspringsecurityplus.log.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author codermy
 * @createTime 2020/8/8
 */
@Data
public class MyErrorLog implements Serializable {
    private Long id;

    /** 操作用户 */
    private String userName;

    /** 描述 */
    private String description;

    /** 异常详细  */
    private String detail;
    /** 方法名 */
    private String method;

    /** 请求ip */
    private String ip;

    // /** 地址 */
    // private String ipAddress;
    /** 参数*/
    private String params;

    /** 浏览器  */
    private String browser;

    /** 创建日期 */
    private Date createTime = new Date();

}
