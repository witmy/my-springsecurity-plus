package com.codermy.myspringsecurityplus.common.utils;

/**
 * @author codermy
 * @createTime 2020/5/15
 * 状态码
 */
public interface ResultCode {
    /**
     * 请求t成功
     */
    public static final Integer SUCCESS = 200;
    /**
     * 请求table成功
     */
    public static final Integer TABLE_SUCCESS = 0;
    /**
     * 请求失败
     */
    public static final Integer ERROR = 201;

    /**
     * 请求已经被接受
     */
    public static final Integer ACCEPTED = 202;

    /**
     * 操作已经执行成功，但是没有返回数据
     */
    public static final Integer NO_CONTENT = 204;

    /**
     * 资源已被移除
     */
    public static final Integer MOVED_PERM = 301;

    /**
     * 重定向
     */
    public static final Integer SEE_OTHER = 303;

    /**
     * 资源没有被修改
     */
    public static final Integer NOT_MODIFIED = 304;

    /**
     * 参数列表错误（缺少，格式不匹配）
     */
    public static final Integer BAD_REQUEST = 400;

    /**
     * 未授权
     */
    public static final Integer UNAUTHORIZED = 401;

    /**
     * 访问受限，授权过期
     */
    public static final Integer FORBIDDEN = 403;

    /**
     * 资源，服务未找到
     */
    public static final Integer NOT_FOUND = 404;

    /**
     * 不允许的http方法
     */
    public static final Integer BAD_METHOD = 405;

    /**
     * 资源冲突，或者资源被锁
     */
    public static final Integer CONFLICT = 409;

    /**
     * 不支持的数据，媒体类型
     */
    public static final Integer UNSUPPORTED_TYPE = 415;

    /**
     * 接口未实现
     */
    public static final Integer NOT_IMPLEMENTED = 501;
}

