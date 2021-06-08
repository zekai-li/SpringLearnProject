package com.learn.bean;

/**
 * 单例： 不是使用当前 Singleton多少次 都是同一个对象(只有一个地址)
 *      1.懒汉式2.饿汉式
 *
 *
 * 多例: 每次创建对象 都会在内存中开辟一个新的地址(空间)
 */
public class Singleton {
    private Singleton() {
    }

    /**
     * 懒汉式
     *  优点: 有效的利用内存资源
     *  缺点: 有线程安全问题
     *   解决方案: 在方法上  synchronized   缺点: 效率降低
     *
     *   volatile: 作用和 synchronized 作用一样
     *   volatile： 让singleton对象具备原子性(透明性,公开性)
     *
     */
/*    private static volatile Singleton singleton=null;
    public  static Singleton getInstance(){
        if(singleton==null){
            synchronized(Singleton.class) {
                if(singleton==null){
                    singleton = new Singleton();
                 }

            }
        }
        return singleton;
    }*/
            //饿汉  优点: 线程安全  缺点: 浪费空间
    private static  Singleton singleton=new Singleton();

    public  static Singleton getInstance(){
        if(singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }
    public static void main(String[] args) {
      /*  Singleton singleton1=new Singleton();
        Singleton singleton2=new Singleton();
        System.out.println(singleton1);
        System.out.println(singleton2);*/
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
