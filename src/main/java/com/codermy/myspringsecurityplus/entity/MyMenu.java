package com.codermy.myspringsecurityplus.entity;

import lombok.Data;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Data
public class MyMenu extends BaseEntity<Integer>{
    private static final long serialVersionUID = -6525908145032868815L;
    private Integer parentId;
    private String name;
    private String icon;
    private Integer type;
    private String url;
    private String permission;
    private Integer sort;

    @Override
    public String toString() {
        return "MyMenu{" +
                "parentId=" + parentId +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", sort=" + sort +
                '}';
    }
}
