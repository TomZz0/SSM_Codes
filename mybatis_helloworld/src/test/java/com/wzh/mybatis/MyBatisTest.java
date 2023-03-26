package com.wzh.mybatis;

import com.wzh.mybatis.mapper.UserMapper;
import com.wzh.mybatis.pojo.User;
import com.wzh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    /**
     * 测试添加用户功能
     *
     * @throws IOException 抛出IO异常
     */
    @Test
    public void testInsert() throws IOException {
        //获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取UserMapper代理类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper中的方法 添加用户
        mapper.insertUser();
        //提交事务
        //sqlSession.commit();
        //关闭会话
        sqlSession.close();
    }

    /**
     * 测试修改用户功能
     */
    @Test
    public void testUpdate() {
        //获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取UserMapper代理类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法修改User
        mapper.updateUser();
        //关闭会话
        sqlSession.close();
    }

    /**
     * 测试删除用户功能
     */
    @Test
    public void testDelete() {
        //获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取UserMapper代理类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法修改User
        mapper.deleteUser();
        //关闭会话
        sqlSession.close();
    }

    /**
     * 通过ID获得User对象
     */
    @Test
    public void testGetUserById() {
        //获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取UserMapper代理类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法修改User
        User userById = mapper.getUserById();
        System.out.println(userById);
        //关闭会话
        sqlSession.close();
    }

    /**
     * 获取所有User对象 放置List中
     */
    @Test
    public void testGetUsers() {
        //获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //获取UserMapper代理类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法修改User
        List<User> users = mapper.getUsers();
        System.out.println(users);
        //关闭会话
        sqlSession.close();
    }
}
