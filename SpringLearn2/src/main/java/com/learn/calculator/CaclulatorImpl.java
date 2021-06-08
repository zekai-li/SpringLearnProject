package com.learn.calculator;

/**
 * 计算结果并且进行日志记录
 */
public class CaclulatorImpl implements Calculator {
    public int add(int i, int j) {
         int result=i+j;
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
