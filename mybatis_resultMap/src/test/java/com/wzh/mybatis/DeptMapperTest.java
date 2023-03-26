package com.wzh.mybatis;

import com.wzh.mybatis.mapper.DeptMapper;
import com.wzh.mybatis.pojo.Dept;
import com.wzh.mybatis.pojo.Emp;
import com.wzh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class DeptMapperTest {
    /**
     * 测试 一对多分布查询 主表dept dept对象有emps属性 要在查询后的到dept对象同时设置部门下的员工emps
     */
    @Test
    public void testGetDeptAndEmpByDeptIdStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept empAndDeptByEmpIdStepTwo = mapper.getDeptAndEmpByDeptIdStepOne(2);
        System.out.println(empAndDeptByEmpIdStepTwo);
    }

    /**
     * 测试 一对多 设置collection查询
     */
    @Test
    public void testGetDeptAndEmpByDeptId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept empAndDeptByEmpId = mapper.getDeptAndEmpByDeptId(2);
        System.out.println(empAndDeptByEmpId);
    }
}
