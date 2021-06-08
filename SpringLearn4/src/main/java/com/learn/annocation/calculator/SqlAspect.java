package com.learn.annocation.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志的工具类
 * 被代理的内容
 * 在AOP中的术语
 * LogUtil 切面
 * 方法: 通知
 * 通知中的代码: 横切关注点
 *
 */
@Component  //让spring容器创建bean对象
@Aspect     //当前类是切面类
@Order(0)
public class SqlAspect {

    @Before("execution( * com.learn.annocation.calculator.CaclulatorImpl.*(..))")
     public static void logBefore(JoinPoint joinPoint){
         System.out.println("SQL前置通知:执行"+joinPoint.getSignature().getName()+"方法,参数:"+Arrays.asList(joinPoint.getArgs()));
     }






}
