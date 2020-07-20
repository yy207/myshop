package cn.cps.springbootexample.bdqn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @Author: Cai Peishen
 * @Date: 2020/6/29 11:07
 * @Description: 自定义注解Token
 */
@Target(value = { ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Token {

}