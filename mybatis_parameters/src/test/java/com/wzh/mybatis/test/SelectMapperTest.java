package com.wzh.mybatis.test;

import com.wzh.mybatis.mapper.SelectMapper;
import com.wzh.mybatis.pojo.User;
import com.wzh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    /**
     * 通过id查询user对象
     */
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User userById = mapper.getUserById(4);
        System.out.println(userById);
    }
    /**
     * 通过id查询user对象
     */
    @Test
    public void testGetUsers(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.getUsers();
        System.out.println(users);
    }

    /**
     * 获取记录总数
     */
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }
    /**
     * 通过id查询User返回 map
     *
     */
    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdToMap = mapper.getUserByIdToMap(4);
        System.out.println(userByIdToMap);

    }
    /**
     * 查询所有User 储存在map中 多个map放在list中
     *
     */
    @Test
    public void testGetUsersToMap_List(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> usersToMap = mapper.getUsersToMap_List();
        System.out.println(usersToMap);
    }
    /**
     * 使用注解@MapKey
     * 查询所有User 储存在map中 多个map放在Map中
     */
    @Test
    public void testGetUsersToMap_Map(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<Integer,Map<String, Object>> usersToMap = mapper.getUsersToMap_Map();
        System.out.println(usersToMap);

    }
}
