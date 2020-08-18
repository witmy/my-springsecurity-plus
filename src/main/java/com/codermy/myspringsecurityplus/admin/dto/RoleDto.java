package com.codermy.myspringsecurityplus.admin.dto;

import com.codermy.myspringsecurityplus.admin.entity.MyRole;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/13
 */
public class RoleDto extends MyRole {
    private static final long serialVersionUID = -5784234789156935003L;

    private List<Integer> menuIds;

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

}
