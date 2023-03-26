package com.wzh.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Proxy工厂
 * getProxy()方法会生成并返回属性target类的代理类
 */
public class ProxyFactory {
    public Object target;

    /**
     * 构造器 赋值target
     * @param target
     */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 返回target类的代理类
     * @return
     */
    public Object getProxy() {
        //因为要生成代理类 所以需要类加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        //代理类要保证和目标类的功能一致 所以要实现目标类实现的接口
        final Class<?>[] interfaces = target.getClass().getInterfaces();
        //设置代理类中如何重写抽象方法
        InvocationHandler h = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = null;
                try {
                    //proxy表示代理对象 method表示要执行的方法 args表示参数列表
                    System.out.println("日志,方法:" + method.getName() + ",参数:" + Arrays.toString(args));
                    invoke = method.invoke(target, args);
                    System.out.println("日志,方法:" + method.getName() + ",结果:" + invoke);

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("日志,异常:"+e);
                } finally {
                    System.out.println("执行完毕,资源关闭");
                }
                return invoke;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, h);
    }
}
