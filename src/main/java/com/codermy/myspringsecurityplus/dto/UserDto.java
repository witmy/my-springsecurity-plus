package com.codermy.myspringsecurityplus.dto;

import com.codermy.myspringsecurityplus.entity.BaseEntity;
import com.codermy.myspringsecurityplus.entity.MyUser;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;

/**
 * @author codermy
 * @createTime 2020/7/13
 */
@Data
public class UserDto extends BaseEntity<Integer> {
    private String userName;
    private String nickName;
    private String password;
    private String phone;
    private String email;
    private Integer status;
    private Integer roleId;
}
