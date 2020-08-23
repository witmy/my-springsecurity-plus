package com.codermy.myspringsecurityplus.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class MyRole extends BaseEntity{
    private static final long serialVersionUID = -6525908145032868837L;

    private String name;

    /** 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限） */
    private String dataScope;

    private String description;




}
