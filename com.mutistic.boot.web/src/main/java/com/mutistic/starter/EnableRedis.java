package com.mutistic.starter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * @program 开启 RedisConfiguration 配置类
 * @description 
 * @author mutisitic
 * @date 2018年7月31日
 */
//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Import(RedisConfiguration.class)
public @interface EnableRedis {

}
