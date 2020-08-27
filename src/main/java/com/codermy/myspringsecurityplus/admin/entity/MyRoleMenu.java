package com.codermy.myspringsecurityplus.admin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Data
public class MyRoleMenu implements Serializable {

    private static final long serialVersionUID = 8925514045582235875L;

    private Integer roleId;

    private Integer permissionId;
}
