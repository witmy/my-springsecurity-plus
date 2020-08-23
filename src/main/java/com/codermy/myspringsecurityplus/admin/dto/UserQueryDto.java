package com.codermy.myspringsecurityplus.admin.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author codermy
 * @createTime 2020/7/14
 */
@Data
public class UserQueryDto implements Serializable {

    private String nickName;

    private String userName;

    private Integer deptId;
}
