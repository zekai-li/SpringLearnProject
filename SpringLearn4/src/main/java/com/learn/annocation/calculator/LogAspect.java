package com.learn.annocation.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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
@Order(1)
public class LogAspect {
     //切入点复用
     @Pointcut("execution(public int com.learn.annocation.calculator.CaclulatorImpl.*(int,int))")
     public void pointcut(){}



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
   /* @Before("execution(public int com.atguigu.annocation.calculator.CaclulatorImpl.add(..))")*/
   /* @Before("execution(public int com..CaclulatorImpl.add(..))")*/
   /* @Before("execution( * *.*(..))")*/
    @Before("execution( * com.learn.annocation.calculator.CaclulatorImpl.*(..))")
     public static void logBefore(JoinPoint joinPoint){
         System.out.println("前置通知:执行"+joinPoint.getSignature().getName()+"方法,参数:"+Arrays.asList(joinPoint.getArgs()));
     }


    /**
     * 在计算代码之后执行日志记录 方法
     *  @After() 后置通知  （最终通知） 如果有异常当前通知也会执行
     */
    @After("pointcut()")
    public static void logAfter(JoinPoint joinPoint){
        System.out.println("后置通知[最终通知]：执行"+joinPoint.getSignature().getName()+"方法");
    }


    /**
     * @AfterReturning 后置返回通知    可以获取目标方法的返回值
     */
    @AfterReturning(value = "pointcut()",returning ="res" )
    public void afterReturning(JoinPoint joinPoint,Integer res){
        System.out.println("后置返回通知:方法:"+joinPoint.getSignature().getName()+",结果:"+res);

    }

    /**
     * @AfterThrowing 后置异常通知   获取目标方法产生的异常信息
     */
    @AfterThrowing(value = "pointcut()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        System.out.println("后置异常通知:"+joinPoint.getSignature().getName()+",异常信息:"+e.getMessage());
    }

   @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint)  {
       Object res=null;
       try {
             System.out.println("环绕前置通知:执行方法:"+proceedingJoinPoint.getSignature().getName()+",参数:"+Arrays.asList(proceedingJoinPoint.getArgs()));
              res = proceedingJoinPoint.proceed();//调用目标对象中的方法(等价于method.invoke())
             System.out.println("环绕后置返回通知:执行方法:"+proceedingJoinPoint.getSignature().getName()+",结果:"+res);
         }catch (Throwable t){
             System.out.println("环绕后置异常通知"+proceedingJoinPoint.getSignature().getName()+",异常信息:"+t.getMessage());
         }finally {
             System.out.println("环绕最终通知"+proceedingJoinPoint.getSignature().getName());
         }

        return res;
   }



}
