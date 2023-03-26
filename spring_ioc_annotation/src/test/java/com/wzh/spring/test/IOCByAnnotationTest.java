package com.wzh.spring.test;

import com.wzh.spring.controller.UserController;
import com.wzh.spring.dao.UserDao;
import com.wzh.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {

    /**
     * @Component：将类标识为普通组件
     * @Controller：将类标识为控制层组件
     * @Service：将类标识为业务层组件
     * @Repository：将类标识为持久层组件
     * 注解本质上都是@Component 只不过为了开发人员方便 起了标识
     * 注意要在spring配置文件中扫描组件
     *
     * 通过注解+扫描配置的bean的id默认值为设置注解的类名的小驼峰
     * 可以在相关注解后边传值自定义id  @Controller("controller")
     *
     * 自动装配注解 @Autowired
     * 1使用位置
     * a> 直接使用在成员变量上
     * b> 使用在成员变量的set方法上
     * c> 使用在含成员变量的有参构造上
     * 2原理
     * a>默认使用byType方式 在IOC容器中通过类型匹配某个bean 为属性赋值
     * b>如果有多个匹配的bean byTyp将不再适用 这时使用byName匹配 前提是bean的id要和属性名一致
     * c> 如果有多个bean且没有id和属性名一致的bean 就会报错
     * d> 两种方式都不行 可以在属性上添加注解@Qualifier("service")
     * 指定一个id,用这个bean为属性赋值
     * 如果为controller类中的属性设置了自动装配注解 但是在service类中没加注解 ioc容器中也没有
     * 匹配controller类中属性的bean 就会抛出异常NoSuchBeanDefinitionException
     * 在@Autowired注解中有个属性required 默认为true 要求必须完成自动装配
     * 可以设置成false 允许使用默认值 就不会报NoSuchBeanDefinitionException
     */
    @Test
    public void test(){
        ApplicationContext ios = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController bean = ios.getBean("userController",UserController.class);
        bean.saveUser();
//        System.out.println(bean);
//        UserService bean1 = ios.getBean("userServiceImpl",UserService.class);
//        System.out.println(bean1);
//        UserDao bean2 = ios.getBean("userDaoImpl",UserDao.class);
//        System.out.println(bean2);
    }
}
