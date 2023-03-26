package com.wzh.spring.test;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.wzh.spring.pojo.BigStudent;
import com.wzh.spring.pojo.Clazz;
import com.wzh.spring.pojo.Person;
import com.wzh.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXmlTest {

    /**
     * 获取对象的三种方式
     * 1通过bean标签的id Student studentOne = (Student) ios.getBean("studentOne");
     * 2 Student bean = ios.getBean(Student.class); 注意有且仅有一个匹配的bean
     * 注意查看异常信息
     * 3 Student studentOne = ios.getBean("studentOne", Student.class);
     * 双重约束 使用id选择student对象的bean
     * 如果bean对象对应的组件类实现了接口 Person bean = ios.getBean(Person.class);
     * 可以通过接口类型得到bean对象 也可以通过继承的类的类型获得
     */
    @Test
    public void testIOC(){
        ApplicationContext ios = new ClassPathXmlApplicationContext("spring-ioc.xml");
       // Student studentOne = (Student) ios.getBean("studentOne");
       // Student bean = ios.getBean(Student.class);
      //  Student studentOne = ios.getBean("studentOne", Student.class);
        Student bean = (Student) ios.getBean(BigStudent.class);
        System.out.println(bean);
    }
    @Test
    public void testDI(){
        ApplicationContext ios = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student studentFive = ios.getBean("studentSeven", Student.class);
        System.out.println(studentFive);
    }

    @Test
    public void testOutInnerBean() {
        ApplicationContext ios = new ClassPathXmlApplicationContext("spring-ioc.xml");
//        Clazz clazzOne = ios.getBean("clazzOne", Clazz.class);
//        System.out.println(clazzOne);
//        Clazz clazzInner = ios.getBean("clazzInner", Clazz.class);
//        System.out.println(clazzInner);
    }
    @Test
    public void testArray() {
        ApplicationContext ios = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student studentEight = ios.getBean("studentEight", Student.class);
        System.out.println(studentEight);
    }
    @Test
    public void testList() {
        ApplicationContext ios = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Clazz r = ios.getBean("clazzOne", Clazz.class);
        System.out.println(r);
    }
    @Test
    public void testMap() {
        ApplicationContext ios = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student studentEight = ios.getBean("studentEight", Student.class);
        System.out.println(studentEight);
    }
    @Test
    public void testP() {
        ApplicationContext ios = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student studentNine = ios.getBean("studentNine", Student.class);
        System.out.println(studentNine);
    }
}
