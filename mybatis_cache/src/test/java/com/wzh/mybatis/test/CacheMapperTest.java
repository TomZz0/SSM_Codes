package com.wzh.mybatis.test;

import com.wzh.mybatis.mapper.CacheMapper;
import com.wzh.mybatis.pojo.Emp;
import com.wzh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

public class CacheMapperTest {
    /**
     * 测试二级缓存
     * 同一个SqlSessionFactory创建的SqlSession对象之间共享缓存 称为二级缓存
     * 二级缓存需要开启条件 再mybatis-config.xml文件配置或再mapper文件使用<cache/>
     * 二级缓存生效条件 头一个SqlSession对象必须提交或关闭后 且pojo类实现
     * 序列化接口才会生成缓存
     * 在两次查询操作之间执行增删改会使二级缓存失效
     */
    @Test
    public void test2RankCache(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = build.openSession(true);
            CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
            Emp empByEmpId = mapper.getEmpByEmpId(3);
            System.out.println(empByEmpId);
            sqlSession.close();
            SqlSession sqlSession1 = build.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            Emp r = mapper1.getEmpByEmpId(3);
            sqlSession1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testGetEmpByEmpId(){
/**        MyBatis的一级缓存默认开启 是SqlSession级别的 即同一个SqlSession对象
/        查询同样的内容不会再执行sql语句 而是从缓存中取
        如果不使用同一个SqlSession或者查询的内容不一致 缓存自然无效
        如果同一个SqlSession对象两次查询期间执行了增删改操作 则会清空缓存
        因为增删改操作可能会改变数据库内容导致缓存可能不再有效
        当然还可以手动清空缓存 调用sqlSession.clearCache()方法
 */
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empByEmpId = mapper.getEmpByEmpId(2);
        System.out.println(empByEmpId);
        sqlSession.clearCache();
        Emp empByEmpId2 = mapper.getEmpByEmpId(2);
        System.out.println(empByEmpId2);
    }
}
