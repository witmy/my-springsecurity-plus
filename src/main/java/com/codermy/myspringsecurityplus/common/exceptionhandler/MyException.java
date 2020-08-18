package com.codermy.myspringsecurityplus.common.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author codermy
 * @createTime 2020/5/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends  RuntimeException {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String  msg;
}
