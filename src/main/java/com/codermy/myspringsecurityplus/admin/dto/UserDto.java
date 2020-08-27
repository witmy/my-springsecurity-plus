package com.codermy.myspringsecurityplus.admin.dto;

import com.codermy.myspringsecurityplus.admin.entity.BaseEntity;
import lombok.Data;

/**
 * @author codermy
 * @createTime 2020/7/13
 */
@Data
public class UserDto extends BaseEntity {

    private Integer userId;

    private Integer deptId;

    private String userName;

    private String nickName;

    private String password;

    private String phone;

    private String email;

    private Integer status;

    private Integer roleId;

    /** 岗位组 */
    private Integer[] jobIds;

}
