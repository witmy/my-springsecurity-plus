package com.codermy.myspringsecurityplus.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author codermy
 * @createTime 2020/6/21
 */

@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 8925514045582235838L;

    private Date createTime = new Date();
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    private Date updateTime = new Date();

    /** 请求参数 */
    private Map<String, Object> params;
    public Map<String, Object> getParams()
    {
        if (params == null)
        {
            params = new HashMap<>();
        }
        return params;
    }

    public Map<String, Object> get1Params() {
        return params;
    }


}
