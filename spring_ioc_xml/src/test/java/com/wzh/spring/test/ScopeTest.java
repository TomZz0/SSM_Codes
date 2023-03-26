package com.wzh.spring.test;

import com.wzh.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void testScope(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student bean1 = ioc.getBean(Student.class);
        Student bean2 = ioc.getBean(Student.class);
        System.out.println(bean1 == bean2);
    }
}
