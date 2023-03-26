package com.wzh.mybatis.test;

import com.wzh.mybatis.mapper.SpecialSQLMapper;
import com.wzh.mybatis.pojo.User;
import com.wzh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSQLTest {
    /**
     * 通过模糊查询查询user 使用List<User>接收
     */
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> likeUsers = mapper.getUserByLike("刘");
        System.out.println(likeUsers);
    }

    /**
     * 批量删除
     */
    @Test
    public void testDeleteMoreUsers(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteMoreUsers("5,7,8");
    }

    /**
     * 动态设置表名 查询user对象
     */
    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> vipUser = mapper.getUserList("t_vipUser");
        System.out.println(vipUser);
    }

    /**
     * 测试插入用户方法 并获取自增主键
     */
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null, 20, "太史慈"
                , "tsc666", '男', "tsc@qq.com");
        mapper.insertUser(user);
        System.out.println(user.getId());
    }
}
