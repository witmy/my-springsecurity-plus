package com.codermy.myspringsecurityplus.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MyRole extends BaseEntity<Integer>{
    private static final long serialVersionUID = -6525908145032868837L;

    private String name;
    private String description;
    private Integer status;

    @Override
    public String toString() {
        return "MyRole{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
