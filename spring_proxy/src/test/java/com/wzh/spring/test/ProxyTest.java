package com.wzh.spring.test;

import com.wzh.spring.proxy.Calculator;
import com.wzh.spring.proxy.CalculatorImpl;
import com.wzh.spring.proxy.CalculatorStaticProxy;
import com.wzh.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {
    /**
     * 动态代理有两种
     * 1:jdk动态代理 要求必须有接口 最终生成的代理类和目标类实现相同的接口 在com.sun.proxy包下 类名为$proxy+数字
     * 2:cglib动态代理 最终生成的类会继承目标类 并和目标类在相同的包下
     */
    @Test
    public void testProxy1(){
        CalculatorStaticProxy c = new CalculatorStaticProxy(new CalculatorImpl());
        int add = c.add(1, 7);
    }
    @Test
    public void testProxy2(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator r = (Calculator) proxyFactory.getProxy();
        r.div(3,0);
    }
}
