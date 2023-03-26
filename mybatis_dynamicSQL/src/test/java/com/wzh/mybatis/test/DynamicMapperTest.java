package com.wzh.mybatis.test;

import com.wzh.mybatis.mapper.DynamicSQLMapper;
import com.wzh.mybatis.pojo.Emp;
import com.wzh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DynamicMapperTest {
    @Test
    public void testGetEmpByCondition(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,"小美",20,"女");
        List<Emp> empByCondition = mapper.getEmpByCondition(emp);
        System.out.println(empByCondition);
    }

    @Test
    public void testGetEmpByChoose() {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "小美", 20, "女");
        List<Emp> empByCondition = mapper.getEmpByChoose(emp);
        System.out.println(empByCondition);
    }
    @Test
    public void testInsertEmps() {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        LinkedList<Emp> emps = new LinkedList<Emp>();
        for (int i = 10; i < 20; i++) {
            Emp emp = new Emp(null,"路易"+i+"世",i+10,"男");
            emps.add(emp);
        }
        mapper.insertEmps(emps);
    }
    @Test
    public void testDeleteEmps() {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[]arr = new Integer[4];
        Arrays.fill(arr, 15);
        mapper.deleteEmps(arr);
    }
}
