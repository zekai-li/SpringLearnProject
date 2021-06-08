package com.learn.annocation.calculator;

import org.springframework.stereotype.Component;

/**
 * 计算结果并且进行日志记录
 */
@Component
public class CaclulatorImpl /*implements Calculator*/ {
    public int add(int i, int j) {
         int result=i+j;//核心业务
        System.out.println("执行目标方法add");
        return result;
    }

    public int decr(int i, int j) {
        int result=i-j;
        return result;
    }

    public int multi(int i, int j) {
        int result=i*j;
        return result;
    }

    public int div(int i, int j) {
        int result=i/j;
        return result;
    }
}
