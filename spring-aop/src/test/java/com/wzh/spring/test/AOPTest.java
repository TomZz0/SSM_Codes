package com.wzh.spring.test;

import com.wzh.spring.aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void testBefore(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        bean.div(2,1);

    }
}
