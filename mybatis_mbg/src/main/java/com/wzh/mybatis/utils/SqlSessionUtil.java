package com.wzh.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    /**
     * 获取SqlSession的静态方法
     * @return SqlSession
     */
    public static SqlSession getSqlSession(){
        InputStream inputStream = null;
        try {
            //获取核心配置文件的输入流
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //获取SqlSessionBuilder对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            //获取sql的会话对象SqlSession 是Mybatis提供的操作数据库的对象
            return sqlSessionFactory.openSession(true);//设置自动提交
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭链接
     * @param sqlSession 要关闭连接的SqlSession对象
     */
    public static void closeSqlSession(SqlSession sqlSession){
        if (sqlSession!=null)
            sqlSession.close();
    }

}
