package com.learn.calculator;

public class ProxyTest {
    public static void main(String[] args) {
        CaclulatorImpl caclulator=new CaclulatorImpl();//目标对象
        //代理对象 代替caclulator 调用 add decr multi div 方法
        //jdk 动态代理 必须使用接口接收代理对象
        Calculator proxyObject=(Calculator) JDKProxy.createProxyObject(caclulator);//创建代理对象
        //proxyObject.add(1,2);
        proxyObject.multi(3,4);

    }

}
