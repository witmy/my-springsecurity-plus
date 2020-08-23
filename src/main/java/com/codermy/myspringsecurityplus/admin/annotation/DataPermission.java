package com.codermy.myspringsecurityplus.admin.annotation;

import java.lang.annotation.*;

/**
 * 数据权限过滤注解
 * @author codermy
 * @createTime 2020/8/22
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataPermission {
    /**
     * 部门表的别名
     */
    public String deptAlias() default "";

    /**
     * 用户表的别名
     */
    public String userAlias() default "";
}
