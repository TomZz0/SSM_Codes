package com.wzh.spring.test;

import com.wzh.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryTest {
    @Test
    public void testFactory(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User bean = ioc.getBean(User.class);
        System.out.println(bean);
    }
}
