package com.wzh.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DataSourceTest {
    @Test
    public void testDataSource() throws SQLException {
        ApplicationContext ios = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DataSource r = ios.getBean(DataSource.class);
        System.out.println(r.getConnection());
    }
}
