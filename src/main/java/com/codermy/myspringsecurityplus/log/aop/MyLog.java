package com.codermy.myspringsecurityplus.log.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author codermy
 * @createTime 2020/8/4
 */
@Target(ElementType.METHOD)//注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME)//注解在哪个阶段执行
public @interface MyLog {
    String value() default "";
}

