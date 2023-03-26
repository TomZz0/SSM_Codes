package com.wzh.spring.test;

import com.wzh.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    /**
     * 1 实例化
     * 2 依赖注入 使用到set方法
     * 3 init初始化 要使用标签中的属性init-method="initMethod"
     * 4 销毁 当ioc容器关闭时执行 使用到标签属性 destroy-method="destroyMethod"
     * 如果是单例模式 创建ioc容器时就会执行1 2 3步 因为每次获得的对象都是同一个
     * 多例则模式则会在获取bean的时候执行 每次都是新的对象
     */
    @Test
    public void testLifeCycle(){
        //ConfigurableApplicationContext时ApplicationContext的自接口
        //其中扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User bean = ioc.getBean(User.class);
        System.out.println(bean);

    }
}
