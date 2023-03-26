package com.wzh.ssm.mapper;

import com.wzh.ssm.pojo.Emp;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 获取所有员工信息
     * @return
     */
    List<Emp> getAllEmployee();
}
