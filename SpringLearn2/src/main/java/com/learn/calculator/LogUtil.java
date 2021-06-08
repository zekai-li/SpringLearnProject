package com.learn.calculator;

import java.util.Arrays;

/**
 * 日志的工具类
 * 被代理的内容
 */
public class LogUtil {

    //在计算代码之前执行日志记录
     public static void logBefore(Object methodName,Object...args){
         System.out.println("执行"+methodName+"方法,参数:"+ Arrays.asList(args));

     }


    //在计算代码之后执行日志记录
    public static void logAfter(Object methodName,Object result){
        System.out.println("执行"+methodName+"方法,结果:"+ result);

    }
}
