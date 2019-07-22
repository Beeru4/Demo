package com.example.demo.logger;


import java.lang.annotation.*;

/**
 * @Author Beerus
 * @Description 自定义日志注解类
 * @Date 2019-07-01
 **/
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AddLogger {

    /**描述*/
    String describe() default "";

    /**内容*/
    String context() default "";
}
