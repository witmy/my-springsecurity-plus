package com.codermy.myspringsecurityplus.admin.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author codermy
 * @createTime 2020/7/12
 */
@Data
public class MenuDto implements Serializable {

    private Integer id;

    private Integer parentId;

    private String checkArr = "0";

    private String title;
}
