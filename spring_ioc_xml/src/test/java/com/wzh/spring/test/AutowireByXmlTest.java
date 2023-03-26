package com.wzh.spring.test;

import com.wzh.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByXmlTest {
    @Test
    public void testByXml(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController bean = ioc.getBean(UserController.class);
        bean.saveUser();
    }
}
