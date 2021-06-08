package com.learn.calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建代理对象(代理日志的人)
 */
public class JDKProxy {

    /**
     * 方法的作用:创建代理对象
     * @param target  目标对象(被代理的对象) 计算器的实现类
     * @return
     *
     *    public static Object newProxyInstance(ClassLoader loader,
     *                                           Class<?>[] interfaces,
     *                                           InvocationHandler h)
     *
     */
    public static Object createProxyObject(Object target){
        //ClassLoader 类加载器  作用: 加载(获取)当前被代理类的信息
        ClassLoader classLoader = target.getClass().getClassLoader();
        //获取目标对象对应的接口信息(方法信息)
        Class<?>[] interfaces = target.getClass().getInterfaces();
       return Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            //invoke() 方法是目标对象中所有方法执行的必经之路

            /**
             *
             * @param proxy  代理对象
             * @param method  目标对象中正在被调用的方法
             * @param args   目标方法中的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                LogUtil.logBefore(method.getName(),args);//计算前的日志记录
                Object result = method.invoke(target, args);//调用目标方法
                LogUtil.logAfter(method.getName(),result);
                return result;
            }
        });
    }

}
