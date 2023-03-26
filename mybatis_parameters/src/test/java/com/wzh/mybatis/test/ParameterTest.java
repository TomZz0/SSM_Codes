package com.wzh.mybatis.test;

import com.wzh.mybatis.mapper.UserMapper;
import com.wzh.mybatis.pojo.User;
import com.wzh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ParameterTest {
    /**
     * 测试通过用户名获得user对象方法
     */
    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User admin = mapper.getUserByUsername("李广");
        System.out.println(admin);
    }

    /**
     * 测试 验证用户登录方法
     */
    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("张飞","1232");
        System.out.println(user);
    }

    /**
     * 测试 验证用户登录方法 通过自定义map
     */
    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("username","张飞");
        map.put("password","1232");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    /**
     * 测试 验证用户登录方法 通过自定义map
     */
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,23,"李广","liguang",'男',"liguang@qq.com");
        mapper.insertUser(user);
    }
    /**
     * 测试 @Param注解设置map的key值 验证登录
     */
    @Test
    public void testCheckUserByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkUserByParam("李广","liguang");
        System.out.println(user);
    }
}
