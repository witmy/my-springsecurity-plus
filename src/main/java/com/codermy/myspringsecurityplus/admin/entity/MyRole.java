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
public class MyRole extends BaseEntity<Integer>{
    private static final long serialVersionUID = -6525908145032868837L;

    private String name;
    private String description;


}
