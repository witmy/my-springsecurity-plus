package com.codermy.myspringsecurityplus.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MyUser extends BaseEntity<Integer>{
    private static final long serialVersionUID = -6525908145032868837L;
    private String userName;
    private String password;
    private String nickName;
    private String phone;
    private String email;
    private Integer status;
    public interface Status {
        int LOCKED = 0;
        int VALID = 1;
    }
}
