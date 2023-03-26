package com.wzh.ssm.service;


import com.github.pagehelper.PageInfo;
import com.wzh.ssm.pojo.Emp;

import java.util.List;

public interface EmployeeService {
    /**
     * 查询所有的员工信息
     * @return
     */
    List<Emp> getAllEmployee();

    /**
     * 获取员工的分页信息
     * @param curPage
     * @return
     */
    PageInfo<Emp> getaEmployeePage(Integer curPage);
}
