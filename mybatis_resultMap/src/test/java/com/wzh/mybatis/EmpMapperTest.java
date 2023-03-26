package com.wzh.mybatis;

import com.wzh.mybatis.mapper.DeptMapper;
import com.wzh.mybatis.mapper.EmpMapper;
import com.wzh.mybatis.pojo.Dept;
import com.wzh.mybatis.pojo.Emp;
import com.wzh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class EmpMapperTest {

    /**
     * 测试 通过EmpId获得Emp对象
     */
    @Test
    public void testGetEmpByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empByEmpId = mapper.getEmpByEmpId(2);
        System.out.println(empByEmpId);
    }
    /**
     * 测试 通过EmpId获得Emp对象
     */
    @Test
    public void testGetEmpByEmpIdOld(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empByEmpId = mapper.getEmpByEmpIdOld(2);
        System.out.println(empByEmpId);
    }
    /**
     * 测试 通过EmpId获得Emp对象 连表 Emp中有Dept对象
     */
    @Test
    public void testGetEmpAndDeptByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDeptByEmpId = mapper.getEmpAndDeptByEmpIdStepOne(6);
        System.out.println(empAndDeptByEmpId.getEmpName());
    }
    /**
     * 测试 通过EmpId获得Emp对象 连表 Emp中有Dept对象
     */
    @Test
    public void testGetDeptAndEmpByDeptId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept empAndDeptByEmpIdStepTwo = mapper.getDeptAndEmpByDeptIdStepOne(2);
        System.out.println(empAndDeptByEmpIdStepTwo);
    }
}
