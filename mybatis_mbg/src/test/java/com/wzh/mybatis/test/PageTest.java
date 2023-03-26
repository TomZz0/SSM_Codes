package com.wzh.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzh.mybatis.mapper.EmpMapper;
import com.wzh.mybatis.pojo.Emp;
import com.wzh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {
    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //开启分页功能
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> emps = mapper.selectByExample(null);
        //查询功能之后可以获取分页相关的所有数据
        //下边设置导航分页的长度 即 1 2 [3] 4 5 长度为5
        PageInfo<Emp> pageInfo = new PageInfo<Emp>(emps,5);
    }
}
