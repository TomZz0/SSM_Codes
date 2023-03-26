package com.wzh.spring.test;

import com.wzh.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.Transient;
import java.util.List;

//指定当前类在Spring测试环境中执行 此时就可以通过注入的方式注解获取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JDBCTemplateTest {

    //自动装配 为属性赋值 测试增删改查操作
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert(){
        String sql = "insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql,"吴彦祖","wyz666","40","男","wyz@qq.com");
    }
    @Test
    public void testSelectObj(){
        String sql = "select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 4);
        System.out.println(user);
    }
    @Test
    public void testSelectAll(){
        String sql = "select * from t_user";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(query);
    }
    @Test
    public void testSelectCount(){
        String sql = "select count(*) from t_user";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }
}
