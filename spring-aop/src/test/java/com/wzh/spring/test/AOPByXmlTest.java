package com.wzh.spring.test;

import com.wzh.spring.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPByXmlTest {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(2,3);
    }
}
