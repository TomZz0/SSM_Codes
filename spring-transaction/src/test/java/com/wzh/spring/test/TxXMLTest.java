package com.wzh.spring.test;

import com.wzh.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 如果不手动获取ioc容器 可以整合junit
 *
 * 声明式事务的配置步骤
 * 1:在spring配置文件中配置事务管理器
 * 2:开启事务的注解驱动
 * 之后在需要被事务管理的方法上加上注解@Transactional即可(也可直接加在类上)
 *
 * 现在有了新的结账接口 结账服务的类中被事务管理 结账中调用了buyBook方法 而buyBook方法也被事务管理
 * 此时默认使用结账的事务 即若有一本书买不成 整个结账事务都会回滚
 * 而使用buyBook自己的事务的话 能买成的书就不会回滚 买不成才会回滚
 * propagation = Propagation.REQUIRED 默认使用调用者的事务
 * propagation = Propagation.REQUIRES_NEW 设置传播行为 使用当前方法的事务
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxXMLTest {

    @Autowired
    private BookController bookController;


    @Test
    public void testBuyBook() {
        bookController.buyBook(1, 1);
      //  bookController.checkOut(1,new Integer[]{1,2});
    }
}
