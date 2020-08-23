package com.codermy.myspringsecurityplus.admin.entity;

import lombok.Data;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Data
public class MyDept extends BaseEntity {
    private static final long serialVersionUID = 8925514045582235633L;

    private Integer parentId;

    private String ancestors;

    private String name;

    private Integer sort;

    private Integer status;

}
