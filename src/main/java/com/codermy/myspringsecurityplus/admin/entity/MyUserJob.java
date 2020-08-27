package com.codermy.myspringsecurityplus.admin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author codermy
 * @createTime 2020/8/21
 */
@Data
public class MyUserJob implements Serializable {

    private static final long serialVersionUID = 8925514045582235321L;

    private Integer userId;

    private Integer jobId;
}
