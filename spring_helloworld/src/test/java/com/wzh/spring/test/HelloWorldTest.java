package com.wzh.spring.test;

import com.wzh.spring.pojo.HelloSpring;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    @Test
    public void test(){
        //1获取IOC容器 java和resources最终会被加载到同一个文件中
        ApplicationContext ioc = new ClassPathXmlApplicationContext
                ("applicationContext.xml");
        //获取bean对象
        HelloSpring helloWorld = (HelloSpring)ioc.getBean("helloWorld");
        helloWorld.sayHello();
    }
}
