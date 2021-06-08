package com.learn.service;

import com.learn.bean.Book;
import com.learn.bean.User;
import com.learn.dao.BookDao;
import com.learn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserBookService {
     @Autowired
     private UserDao userDao;
     @Autowired
     private BookDao bookDao;


    /**
     * @Transactional   updateUserBook方法具备了事务特性  方法中的所有的子方法中的事务不会起作用了,全部使用当前方法的总事务
     *
     * 1.
     *     Class<? extends Throwable>[] rollbackFor() default {};
     *
     *     String[] rollbackForClassName() default {};
     *
     *     Class<? extends Throwable>[] noRollbackFor() default {};
     *
     *     String[] noRollbackForClassName() default {};
     *
     *
     *     rollbackFor|rollbackForClassName  异常回滚
     *     rollbackFor={ArithmeticException.class,NullPointerException.class}
     *     rollbackForClassName={"ArithmeticException","NullPointerException"}
     *     noRollbackFor={ArithmeticException.class}
     *     noRollbackForClassName={"ArithmeticException"}
     *
     * 2.
     * readOnly  事务是否只读
     *   readOnly = false  默认值(不是只读的) 对增删改提供支持
     *  查询: readOnly =true  提高查询效率
     *
     * 3.
     * int timeout() default -1;  事务的超时时间  默认值 -1 永不超时
     *
     * 4.
     *     Propagation propagation() default Propagation.REQUIRED;
     *     事务的传播行为(特性)default Propagation.REQUIRED; 默认值
     *         保证当前方法必须运行在事务中(如果当前的方法有事务,就是用该事务,如果没有事务自动开启新的事务)
     *
     * 5.
     * Isolation isolation() default Isolation.DEFAULT; 默认值
     *  事务的隔离等级
     *     1   读未提交                       脏数据
     *     2   读已提交  oracle sqlserver     不可重复读(在一个事务中查询多次,结果不同)
     *     4   可重复读  mysql                 幻读
     *     8   串行化                          效率低
     *
     */
    @Transactional(
              readOnly = false,
               timeout = 2,
               propagation = Propagation.REQUIRED

    )
    public void updateUserBook(){

        userDao.updateUser(new User(1,"zhangsan",600));//单独支持事务特性的(小事务)
//          System.out.println(1/0);
        bookDao.updateBook(new Book(1,null,98));//单独支持事务特性(小事务)

       /*   try {
               Thread.sleep(3000);
              userDao.updateUser(new User(1,"zhangsan",600));//单独支持事务特性的(小事务)
              //  System.out.println(1/0);
              bookDao.updateBook(new Book(1,null,98));//单独支持事务特性(小事务)
          }catch (Exception e){
              e.printStackTrace();
          }*/


    }

}
