package com.codermy.myspringsecurityplus.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author codermy
 * @createTime 2020/6/21
 */

@Data
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 8925514045582235838L;
    private ID id;
    private Date createTime = new Date();
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    private Date updateTime = new Date();

}
