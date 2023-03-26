package com.wzh.spring.factory;

import com.wzh.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean 用于工厂设计模式 配置后
 * 原本需要先获取工厂类 再由工厂类获得目标类对象
 * 现在不需要获得工厂类 可直接获得目标对象 传入泛型
 * 要在对应spring文件中配置bean
 */
public class UserFactoryBean implements FactoryBean<User> {
    public User getObject() throws Exception {
        return new User();
    }

    public Class<?> getObjectType() {
        return User.class;
    }
}
