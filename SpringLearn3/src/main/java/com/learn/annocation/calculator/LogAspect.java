package com.learn.annocation.calculator;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

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
public class LogAspect {


    /**
     * 在计算代码之前执行日志记录的方法
     *
     *
     * @Before 前置通知
     * execution： 切入点表达式
     *
     *   切入点表达式中的常用通配符
     *
     *    . 代表目录等级
     *
     *    .. 多层的目录等级
     *    .. 多个参数多种类型
     *
     *
     *    *  代表当前的返回值类型
     *    *   代表所有方法
     *    * 代表所有的类
     *    * 代表一层路径
     *
     *
     *   public 可以省略
     *
     */
   /* @Before("execution(public int com.learn.annocation.calculator.CaclulatorImpl.add(..))")*/
   /* @Before("execution(public int com..CaclulatorImpl.add(..))")*/
   /* @Before("execution( * *.*(..))")*/
    @Before("execution( * com.learn.annocation.calculator.CaclulatorImpl.*(..))")
     public static void logBefore(){
         System.out.println("前置通知:执行"+"方法,参数:");
     }


    /**
     * 在计算代码之后执行日志记录 方法
     *  @After() 后置通知  （最终通知）
     */
    @After("execution(public int com.learn.annocation.calculator.CaclulatorImpl.add(int,int))")
    public static void logAfter(){
        System.out.println("后置通知：执行"+"方法,结果:");
    }


    /**
     * @AfterReturning 后置返回通知    可以获取目标方法的返回值
     */
    @AfterReturning("execution(public int com.learn.annocation.calculator.CaclulatorImpl.add(int,int))")
    public void afterReturning(){
        System.out.println("后置返回通知:");

    }

    /**
     * @AfterThrowing 后置异常通知   获取目标方法产生的异常信息
     */
    @AfterThrowing("execution(public int com.learn.annocation.calculator.CaclulatorImpl.*(int,int))")
    public void afterThrowing(){
        System.out.println("后置异常通知:");
    }



}
