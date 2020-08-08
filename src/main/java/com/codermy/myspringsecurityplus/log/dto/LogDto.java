package com.codermy.myspringsecurityplus.log.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author codermy
 * @createTime 2020/8/8
 */
@Data
public class LogDto implements Serializable {
    private String userName;

    private String ip;

    private String params;

    private String description;

    private String method;

    private Long time;

    private String browser;

    private Date createTime;
}
