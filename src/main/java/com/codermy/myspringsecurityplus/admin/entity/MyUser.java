package com.codermy.myspringsecurityplus.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class MyUser extends BaseEntity{
    private static final long serialVersionUID = -6525908145032868837L;

    private Integer userId;

    private Integer deptId;

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

    private Integer roleId;
    /** 岗位组 */
    private Integer[] jobIds;

    /**
     * 判断是否为admin用户
     * @return
     */
    public boolean isAdmin()
    {
        return isAdmin(this.getUserId());
    }

    public static boolean isAdmin(Integer userId)
    {
        return userId != null && 1L == userId;
    }

    public MyUser(Integer userId)
    {
        this.setUserId(userId);
    }
}
