package com.wzh.ssm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzh.ssm.mapper.EmployeeMapper;
import com.wzh.ssm.pojo.Emp;
import com.wzh.ssm.service.EmployeeService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wzh
 * @date 2023年03月25日 21:23
 * Description:
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Emp> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Emp> getaEmployeePage(Integer curPage) {
        //在查询功能之前开启分页功能
        PageHelper.startPage(curPage, 4);
        //查询所有的员工信息
        List<Emp> list = employeeMapper.getAllEmployee();
        //获取分页数据 navigatePages表示导航个数为5 即 1 2 [3] 4 5
        return new PageInfo<>(list,5);
    }
}
