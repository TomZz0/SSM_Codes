package com.wzh.mybatis.test;

import com.wzh.mybatis.mapper.EmpMapper;
import com.wzh.mybatis.pojo.Emp;
import com.wzh.mybatis.pojo.EmpExample;
import com.wzh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据主键id查询数据
//        Emp emp = mapper.selectByPrimaryKey(1);
//        System.out.println(emp);
//        查询所有数据
//        List<Emp> emps = mapper.selectByExample(null);
//        System.out.println(emps);
//        EmpExample empExample = new EmpExample();
//         empExample.createCriteria().andEmpNameLike("%路易%");
//        List<Emp> emps = mapper.selectByExample(empExample);
//        System.out.println(emps);
        Emp emp = new Emp(1,"孙策",null,"男");
//      注意下面两个方法 如果传入的emp中某个属性为null 比如age
//        updateByPrimaryKey会用null覆盖原来表中的字段
//        updateByPrimaryKeySelective方法则不会 即保留原来的值
        mapper.updateByPrimaryKey(emp);
        mapper.updateByPrimaryKeySelective(emp);

    }
}
